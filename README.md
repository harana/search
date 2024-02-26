<h3 align="center">
Search everything, instantly.
</h3>

<p align="center">
  <img width="600" src="docs/assets/screenshot.png" alt="Screenshot">
</p>

<p align="center">
  <a href="https://github.com/harana/search/releases/download/untagged-806f7b25229d606ff129/harana-darwin-aarch64.dmg">macOS Apple</a> ·
  <a href="https://github.com/harana/search/releases/download/untagged-806f7b25229d606ff129/harana-darwin-x86_64.dmg">macOS Intel</a> ·
  Windows ·
  Linux
  <br />
  <b>Alpha Release</b>. Expect bugs and crashes.
</p>


<br/>
## Features

<b>Fast and Minimal</b>
* Search your desktop and the cloud in < 10ms.
* CPU usage and temperature aware.
* Offline - ideal for travellers and VPN users.

<br />

<b>Elegant Interface</b>
* 700+ file types recognised and categorised.
* Navigable entirely from keyboard.
* Information cards for showing thumbnail, file information and more.
* Instant preview for 15+ file types with more being added.


<br />

<b>Powerful Indexing</b>
* 100s of file types with custom indexing and thumbnail generation.
* PDF and Image OCR using Google Tesseract. 
* Text summarisation using Google Bert.
* Speech to text indexing for movies, podcasts etc using OpenAI Whisper.
* Video and image object detection using YOLO.
* Fallback to macOS Quicklook when needed. 

<br/>
## Privacy

* We do not track your behaviour or capture any telemetry or user analytics.
* All searches and file indexing is done locally and never shared.
* For cloud searches e.g. Notion we do build a searchable index on our servers. But it is encrypted and only readable by you. 
* We do use Sentry for crash reporting however this can be disabled.

<br/>
## Roadmap

* Developer search e.g. Crates, NPM, Maven. 
* Windows and Linux support.
* WebAssembly plugin SDK for indexing, thumbnail generation etc.
* AdaptiveCard support to allow publishing cards into Teams, Windows Feed etc.

<br/>
## Developer Guide

Please refer to the [contributing guide](CONTRIBUTING.md) for how to install and contribute.

<br/>
## Security Policy

Please refer to the [security policy](SECURITY.md) for information on how to responsibly report a security vulnerability or issue.

<br/>
## Related Repositories

* [Search Engine](http://github.com/harana/search-engine) - Rust search core e.g. indexing, search, thumbnails
* [SBT Plugin](http://github.com/harana/sbt-plugin) - Scala SBT plugin abstracting common configuration
* [SDK](http://github.com/harana/sdk) - Scala SDK for the UI
* [Web](http://github.com/harana/web) - Scala.js related components
