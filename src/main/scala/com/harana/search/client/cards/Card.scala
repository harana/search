package com.harana.search.client.cards

import com.harana.search.client.cards.demo._
import com.harana.search.client.cards.demo.building.DemoBuildingThumbnailCard
import com.harana.search.client.cards.demo.customer._
import com.harana.search.client.cards.demo.finance.DemoFinanceStockPriceCard
import com.harana.search.client.cards.demo.hr.DemoHrPersonCard
import com.harana.search.client.cards.demo.marketing.DemoMarketingFunnelCard
import com.harana.search.client.cards.demo.sales.DemoSalesBarCard
import com.harana.search.client.cards.demo.software.DemoSoftwareTableCard
import com.harana.search.client.cards.general._
import com.harana.search.client.cards.orders._
import com.harana.search.client.cards.person._
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement

trait Card {
  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement
  def title: Option[String] = None
  def showBorder: Boolean = false
}

object Card {
    def apply(name: String) =
    Map(
      "address"                           -> AddressCard,
      "analytics_bar"                     -> BarCard,
      "analytics_boxplot"                 -> DemoFinanceStockPriceCard,
      "analytics_chord"                   -> ChordCard,
      "analytics_funnel"                  -> DemoMarketingFunnelCard,
      "analytics_heatmap"                 -> HeatMapCard,
      "analytics_pie"                     -> DemoCustomerSpendCard,
      "analytics_sankey"                  -> SankeyCard,
      "analytics_sunburst"                -> SunburstCard,
      "audio_play"                        -> AudioPlayCard,
      "camera"                            -> CameraCard,
      "checklist"                         -> CheckListCard,
      "code"                              -> CodeCard,
      "conversation"                      -> ConversationCard,
      "data_schema"                       -> DataSchemaCard,
      "default"                           -> DefaultCard,
      "demo_building_thumbnail"           -> DemoBuildingThumbnailCard,
      "demo_customer_info"                -> DemoCustomerInfoCard,
      "demo_customer_lastorder"           -> DemoCustomerLastOrderCard,
      "demo_customer_notes"               -> DemoCustomerNotesCard,
      "demo_customer_spend"               -> DemoCustomerSpendCard,
      "demo_customer_timeline"            -> DemoCustomerTimelineCard,
      "demo_finance_stockprice"           -> DemoFinanceStockPriceCard,
      "demo_hr_person"                    -> DemoHrPersonCard,
      "demo_marketing_funnel"             -> DemoMarketingFunnelCard,
      "demo_sales_bar"                    -> DemoSalesBarCard,
      "demo_software_table"               -> DemoSoftwareTableCard,
      "empty"                             -> EmptyCard,
      "feed"                              -> DemoCustomerTimelineCard,
      "file_info"                         -> FileInfoCard,
      "map"                               -> MapCard,
      "metadata"                          -> MetadataCard,
      "notes"                             -> NotesCard,
      "orders_fraud_analysis"             -> FraudAnalysisCard,
      "orders_products"                   -> ProductsCard,
      "page"                              -> PageCard,
      "person_conversion"                 -> ConversationCard,
      "person"                            -> PersonCard,
      "person_relationships"              -> RelationshipsCard,
      "product"                           -> ProductCard,
      "sample"                            -> SampleCard,
      "table"                             -> TableCard,
      "thumbnail"                         -> ThumbnailCard,
      "time_range"                        -> TimeRangeCard,
      "video_play"                        -> VideoPlayCard
    ).getOrElse(name, EmptyCard)
}