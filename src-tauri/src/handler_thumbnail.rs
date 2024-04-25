use std::path::Path;

use harana_common::{base64_simd, tauri};
use harana_common::anyhow::Result;
use harana_common::file_format::FileFormat;
use harana_common::log::debug;
use harana_database::files_get_document_id::files_get_document_id;
use harana_document::document::Document;
use harana_search_extensions::extensions::Extensions;
use harana_search_tantivy::document::TantivyDocument;
use harana_thumbnailer_core::image::Image;
use harana_thumbnailer_core::image::ImageType;

use crate::globals::INDEX_MANAGER;
use crate::handlers::database_files;
use crate::THUMBNAILS_PATH;

#[tauri::command]
pub async fn get_document(document_id: String) -> Result<(Document, String), String> {
    let u64_id = document_id.parse::<u64>().unwrap();
    let file = database_files(move |c| { files_get_document_id(c, u64_id.clone() )}).await.map_err(|e| e.to_string())?;
    let format = FileFormat::from_file(file.path.clone()).ok();
    let extension = Path::new(file.path.as_str()).extension().and_then(|e| e.to_str()).unwrap_or_default();
    let index_name = Extensions::category(format, extension).index();
    let index = INDEX_MANAGER.get().unwrap().get_index(index_name);
    let document_hit = index.get_document(u64_id.clone()).await.map_err(|e| e.to_string())?;
    let document = TantivyDocument::from_hit(document_hit);
    let thumbnailer = Extensions::thumbnailer(None, extension).await.get_name().replace("Thumbnailer", "");
    Ok((document, thumbnailer))
}

#[tauri::command]
pub fn has_thumbnail(document_id: String) -> String {
    debug!("Command: thumbnail->has_thumbnail");
    let thumbnails_path = THUMBNAILS_PATH.get().expect("Failed to get thumbnails path");
    let thumbnail = thumbnails_path.join(format!("{}.png", document_id.clone()));
    thumbnail.exists().to_string()
}

#[tauri::command]
pub async fn save_thumbnail(document_id: String, data: String) -> Result<(), String> {
    debug!("Command: thumbnail->save_thumbnail");
    let base64 = base64_simd::STANDARD;

    let image_data = base64.decode_to_vec(data).map_err(|e| e.to_string())?;
    let thumbnails_path = THUMBNAILS_PATH.get().expect("Failed to get thumbnails path");
    let mut thumbnail_path = thumbnails_path.as_path().join(document_id);
    thumbnail_path.set_extension("png");

    let image = Image::new(image_data, true, ImageType::Png, None).map_err(|e| e.to_string());
    image?.crop(400, 400, thumbnail_path.as_path(), false).map_err(|e| e.to_string())
}