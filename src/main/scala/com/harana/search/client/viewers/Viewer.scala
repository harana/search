package com.harana.search.client.viewers

import com.harana.search.client.models.Document
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html.div

@react object Viewer {

  case class Props(document: Option[Document],
                   documentContent: Option[String],
                   viewer: Option[String])

  val component = FunctionalComponent[Props] { props =>

    props.viewer match {
      case Some("Bim")            => Bim()
      case Some("Calendar")       => Calendar()
      case Some("Certificate")    => Certificate(props.documentContent)
      case Some("Code")           => Code(props.document, props.documentContent)
      case Some("Comic")          => Comic()
      case Some("Cornerstone")    => Cornerstone()
      case Some("Docx")           => Docx(props.documentContent)
      case Some("Epub")           => Epub(props.documentContent)
      case Some("Font")           => Font()
      case Some("Image")          => Image()
      case Some("Ipynb")          => Ipynb(props.documentContent)
      case Some("Json")           => Json(props.documentContent)
      case Some("Leaflet")        => Leaflet()
      case Some("Md")             => Markdown(props.documentContent)
      case Some("Niivue")         => Niivue()
      case Some("Pdf")            => Pdf()
      case Some("Rtf")            => Rtf()
      case Some("SeqViz")         => SeqViz()
      case Some("SheetJS")        => SheetJS()
      case Some("Svg")            => Svg()
      case Some("Tex")            => Latex(props.documentContent)
      case Some("Txt")            => Text(props.documentContent)
      case Some("Three")          => Three()
      case Some("Video")          => Video()
      case _                      => div()
    }
  }
}