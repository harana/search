package com.harana.search.client.cards.demo.finance

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp.{BoxPlot, Color, Margin}
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object DemoFinanceStockPriceCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "justify-center")(
      BoxPlot(
        width = 310,
        height = 280,
        minValue = 40,
        maxValue = 85,
        margin = new Margin {
          override val top = 15
          override val bottom = 25
          override val left = 40
          override val right = 20
        },
        subGroupBy = "subgroup",
        borderRadius = 2,
        borderWidth = 0.50,
        borderColor  = new Color {
          override val from = "color"
          override val modifiers = js.Array(js.Array("darker", 0.3))
        },
        medianColor = new Color {
          override val from = "color"
          override val modifiers = js.Array(js.Array("darker", 0.3))
        },
        whiskerWidth = 0.50,
        whiskerColor = new Color {
          override val from = "color"
          override val modifiers = js.Array(js.Array("darker", 0.3))
        },
        data = js.Array(
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 60.46178419983051
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 46.78136245571628
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 46.630835201235294
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 48.25927096828595
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 40.67529668484687
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 43.94239711636088
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.19090966285628
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 41.7301878387817
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 35.179201407202365
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 48.35645267790403
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 42.930616827868215
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 56.41911115505976
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 50.17602423033516
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 44.693785665576895
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 40.92104138006883
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 49.4719062980196
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 60.56925972503768
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.39827383580669
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 53.12281416560337
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 34.71553174433005
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 55.93158227464787
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 66.904313597670955
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.55752845658521
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 63.2895306129781
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 59.36590118070711
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 65.812315407403545
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 56.91253817365167
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 64.42352594550138
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 59.01222708173604
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.98480890329679
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 68.04109998871291
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 72.364426775873305
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 53.7863540932821
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 58.60775254215348
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 78.96061599093055
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 59.30547337072911
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 58.17271239210731
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 55.319327513153205
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 62.487756199521955
          ),
          js.Dictionary(
            "group" -> "Q1",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 73.42017723214214
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 59.68332994038822
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 80.13472046187823
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 80.405297008539295
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 90.30857910432621
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 86.82948352540372
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 77.910841540290985
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 72.48087372495615
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 74.79376467492356
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 80.7332263173536
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 96.66483555876514
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 66.99210687737546
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 82.390408599705
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 69.91971154486508
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 80.54425002328088
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 50.86407669874708
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 57.711071959935465
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 77.50794745225645
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 79.17948098791565
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 67.91693550526713
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "A",
            "mu" -> 80,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 80.172183121542876
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 66.91858390152474
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 61.67813829079676
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 80.78082715514327
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 72.84661224042259
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 66.98322695826454
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 75.654355551818675
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 78.70573915742188
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 69.31840205035481
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 79.46692629547502
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 75.43373986852654
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 79.85609912577753
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 57.85148885952726
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 64.65807364813715
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 84.29798392660146
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 75.30527016578261
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 68.08411642458117
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 58.76231356346194
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 81.41123859008413
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 64.73208468395567
          ),
          js.Dictionary(
            "group" -> "Q2",
            "subgroup" -> "B",
            "mu" -> 75.0,
            "sd" -> 140,
            "n" -> 20,
            "value" -> 66.97005372534571
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 39.863189604838167
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 41.6859908037955
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.73976280660415
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 40.58098129181904
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 46.18452130194547
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 55.9775548352073
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 37.058196501912226
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 48.80900718065879
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 51.75020964858212
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 51.43151127522592
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 40.942924918235
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 64.00448551821043
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 51.38983429186811
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 42.3218110825654
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 50.45942407308424
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 41.86992817146969
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 47.64930881657828
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 51.15463430471833
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 40.60589519271758
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 57.22434884243553
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 77.680813240685636
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 69.31405529332353
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 61.01931203672757
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 48.49192686549771
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 36.170212948443097
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 66.155417757942
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 69.80813887085253
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 76.87289155045262
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 84.30221629662348
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 56.58747621072238
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 50.654922456304625
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 64.22648245503966
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 62.93920736963543
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 68.92028473572175
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 83.91908350685075
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 49.58845001511589
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 65.68486696401511
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 55.13525092742652
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 60.81772283163678
          ),
          js.Dictionary(
            "group" -> "Q3",
            "subgroup" -> "B",
            "mu" -> 72,
            "sd" -> 180,
            "n" -> 20,
            "value" -> 78.41358004483571
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 44.23241058517098
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 46.43754337824357
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 53.44863666103531
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 47.94339549450803
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 61.32384749730952
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 47.92087166412402
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 48.66273341579995
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 50.06888957283815
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 40.75170966803209
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 51.17072613931535
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 52.699227241520195
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 59.23986526708671
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 59.43705935600112
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 49.04398769590004
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 71.02924835237309
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 36.684453449313645
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 50.45938989881135
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.15966349964426
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 45.20067424686268
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "A",
            "mu" -> 50,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 35.97844000780558
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 63.36711945832897
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 56.20530962869863
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 60.47307702088883
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 54.714400543655035
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 56.625830310559255
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 24.08495859354152
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 56.258664206952185
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 50.371014419867866
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 57.22000487081137
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 47.57111645207754
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 67.73946760006261
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 77.87394590314987
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 51.31793465668262
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 59.54942595168188
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 97.28574283896826
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 58.19273918913817
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 65.85960448689141
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 65.05825889639561
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 61.754567773522595
          ),
          js.Dictionary(
            "group" -> "Q4",
            "subgroup" -> "B",
            "mu" -> 60,
            "sd" -> 100,
            "n" -> 20,
            "value" -> 44.58370794894664
          )
        )
      )
  )

  override val title = Some("Quarter 2024")
}