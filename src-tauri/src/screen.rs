#![cfg(target_os = "macos")]

use std::{sync::mpsc::{sync_channel, SyncSender}};
use std::cell::OnceCell;
use std::sync::mpsc::Receiver;
use objc_foundation::INSData;
use screencapturekit::cm_sample_buffer::CMSampleBuffer;
use screencapturekit::sc_content_filter::{InitParams, SCContentFilter};
use screencapturekit::sc_error_handler::StreamErrorHandler;
use screencapturekit::sc_output_handler::{SCStreamOutputType, StreamOutput};
use screencapturekit::sc_shareable_content::SCShareableContent;
use screencapturekit::sc_stream::SCStream;
use screencapturekit::sc_stream_configuration::SCStreamConfiguration;
use screencapturekit_sys::cv_image_buffer_ref::ImageFormat;

use screencapturekit_sys::sc_stream_frame_info::SCFrameStatus;

struct StoreImageHandler {
    tx: SyncSender<CMSampleBuffer>,
}

struct ErrorHandler;

impl StreamErrorHandler for ErrorHandler {
    fn on_error(&self) {
        println!("ERROR!")
    }
}

impl StreamOutput for StoreImageHandler {
    fn did_output_sample_buffer(&self, sample: CMSampleBuffer, _of_type: SCStreamOutputType) {
        if let SCFrameStatus::Complete = sample.frame_status {
            self.tx.send(sample).ok();
        }
    }
}

pub static mut STREAM: OnceCell<SCStream> = OnceCell::new();
pub static mut RX: OnceCell<Receiver<CMSampleBuffer>> = OnceCell::new();

pub unsafe fn init_stream() {
    let content = SCShareableContent::current();
    let display = content
        .displays
        .first()
        .unwrap();
    let width = display.width;
    let height = display.height;
    let filter = SCContentFilter::new(InitParams::Display(display.clone()));
    let (tx, rx) = sync_channel(2);

    let config = SCStreamConfiguration {
        width,
        height,
        ..Default::default()
    };

    let mut stream = SCStream::new(filter, config, ErrorHandler);

    stream.add_output(StoreImageHandler { tx }, SCStreamOutputType::Screen);

    let _ = RX.set(rx);
    let _ = STREAM.set(stream);
}

pub unsafe fn screen() {
    let _ = STREAM.get().unwrap().start_capture();

    let sample_buf = RX.get().unwrap().recv().unwrap();
    let _ = STREAM.get().unwrap().stop_capture();
    let jpeg_data = sample_buf.image_buf_ref.unwrap().get_data(ImageFormat::JPEG);
    let jpeg_bytes = jpeg_data.bytes();
    // let raw_bytes = JpegDecoder::new(jpeg_bytes).decode().unwrap();


    // let mut buffer = File::create("picture.jpg").unwrap();
    //
    // buffer.write_all(jpeg.bytes()).unwrap();
    // Command::new("open")
    //     .args(["picture.jpg"])
    //     .output()
    //     .expect("failed to execute process");
}