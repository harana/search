package com.harana.search.client.viewers

import com.harana.web.components.when
import com.harana.web.external.certificates_viewer.CertificatesViewer
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object Epub {

  case class Props(documentContent: Option[String])

  val component = FunctionalComponent[Props] { props =>

    when(props.documentContent.nonEmpty)(
      CertificatesViewer(props.documentContent.get)
    )
  }
}