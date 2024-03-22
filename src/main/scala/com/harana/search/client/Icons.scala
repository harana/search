package com.harana.search.client

import com.harana.web.external.tailwind.OutlineIcons.{ArchiveBoxOutlineIcon, _}
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.facade.ReactElement
import slinky.web.html.{className, img, s, src}

import scala.scalajs.js.JSConverters._

object Icons {

  def integration(name: String, cls: Option[String] = None): ReactElement =
      name match {
        case "local-application"              => CalculatorOutlineIcon(cls.orUndefined)
        case "local-archive"                  => ArchiveBoxOutlineIcon(cls.orUndefined)
        case "local-audio"                    => MusicalNoteOutlineIcon(cls.orUndefined)
        case "local-book"                     => BookOpenOutlineIcon(cls.orUndefined)
        case "local-calendar"                 => CalendarDaysOutlineIcon(cls.orUndefined)
        case "local-certificate"              => KeyOutlineIcon(cls.orUndefined)
        case "local-code"                     => CodeBracketOutlineIcon(cls.orUndefined)
        case "local-codeartifact"             => CodeBracketSquareOutlineIcon(cls.orUndefined)
        case "local-contact"                  => IdentificationOutlineIcon(cls.orUndefined)
        case "local-data"                     => TableCellsOutlineIcon(cls.orUndefined)
        case "local-database"                 => CircleStackOutlineIcon(cls.orUndefined)
        case "local-diskimage"                => ArchiveBoxOutlineIcon(cls.orUndefined)
        case "local-document"                 => DocumentTextOutlineIcon(cls.orUndefined)
        case "local-email"                    => EnvelopeOutlineIcon(cls.orUndefined)
        case "local-folder"                   => FolderOpenOutlineIcon(cls.orUndefined)
        case "local-font"                     => LanguageOutlineIcon(cls.orUndefined)
        case "local-game"                     => PuzzlePieceOutlineIcon(cls.orUndefined)
        case "local-graphics"                 => CubeOutlineIcon(cls.orUndefined)
        case "local-hardware"                 => WrenchOutlineIcon(cls.orUndefined)
        case "local-image"                    => PhotoOutlineIcon(cls.orUndefined)
        case "local-map"                      => MapOutlineIcon(cls.orUndefined)
        case "local-other"                    => DocumentOutlineIcon(cls.orUndefined)
        case "local-science"                  => BeakerOutlineIcon(cls.orUndefined)
        case "local-screenshot"               => WindowOutlineIcon(cls.orUndefined)
        case "local-video"                    => FilmOutlineIcon(cls.orUndefined)
        case "virtual-emr-customers"          => UserOutlineIcon(cls.orUndefined)
        case "virtual-emr-orders"             => ShoppingBagOutlineIcon(cls.orUndefined)
        case "virtual-emr-prospects"          => UserPlusOutlineIcon(cls.orUndefined)
        case "virtual-emr-support-tickets"    => TicketOutlineIcon(cls.orUndefined)
        case _                                => img(className := cls.getOrElse(""), src := convertFileSrc(s"assets/icons/connectors/remote-$name.svg"))
      }
}