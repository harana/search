package com.harana.search.client

import com.harana.search.client.auth.{AuthHandler, AuthStore}
import com.harana.search.client.cards.{CardHandler, CardStore}
import com.harana.search.client.checkout.{CheckoutHandler, CheckoutStore}
import com.harana.search.client.integrations.{IntegrationsHandler, IntegrationsStore}
import com.harana.search.client.login.{LoginHandler, LoginStore}
import com.harana.search.client.main.{MainHandler, MainStore}
import com.harana.search.client.preview.{PreviewHandler, PreviewStore}
import com.harana.search.client.search.{SearchHandler, SearchKeyHandler, SearchMenuHandler, SearchScrollHandler, SearchStore}
import com.harana.search.client.settings.ai.{AiHandler, AiStore}
import com.harana.search.client.settings.billing.{BillingHandler, BillingStore}
import com.harana.search.client.settings.categories.{CategoriesHandler, CategoriesStore}
import com.harana.search.client.settings.developer.{DeveloperHandler, DeveloperStore}
import com.harana.search.client.settings.folders.{FoldersHandler, FoldersStore}
import com.harana.search.client.settings.general.{GeneralHandler, GeneralStore}
import com.harana.search.client.settings.indexing.{IndexingHandler, IndexingStore}
import com.harana.search.client.settings.rules.{RulesHandler, RulesStore}
import com.harana.search.client.settings.{SettingsHandler, SettingsStore}
import com.harana.search.client.share.{ShareHandler, ShareKeyHandler, ShareStore}
import com.harana.search.client.support.{SupportHandler, SupportStore}
import com.harana.search.client.system.{SystemHandler, SystemStore}
import com.harana.search.client.thumbnail.{ThumbnailHandler, ThumbnailStore}
import com.harana.search.client.welcome.{WelcomeHandler, WelcomeStore}
import com.harana.web.base.BaseCircuit

case class State(aiState: AiStore.State,
                 authState: AuthStore.State,
                 billingState: BillingStore.State,
                 cardState: CardStore.State,
                 categoriesState: CategoriesStore.State,
                 checkoutState: CheckoutStore.State,
                 developerState: DeveloperStore.State,
                 foldersState: FoldersStore.State,
                 generalState: GeneralStore.State,
                 indexingState: IndexingStore.State,
                 integrationsState: IntegrationsStore.State,
                 loginState: LoginStore.State,
                 mainState: MainStore.State,
                 previewState: PreviewStore.State,
                 rulesState: RulesStore.State,
                 searchState: SearchStore.State,
                 settingsState: SettingsStore.State,
                 shareState: ShareStore.State,
                 supportState: SupportStore.State,
                 systemState: SystemStore.State,
                 thumbnailState: ThumbnailStore.State,
                 welcomeState: WelcomeStore.State)

object Circuit extends BaseCircuit[State] {

  lazy val initialModel =
    State(
      AiStore.initialState,
      AuthStore.initialState,
      BillingStore.initialState,
      CardStore.initialState,
      CategoriesStore.initialState,
      CheckoutStore.initialState,
      DeveloperStore.initialState,
      FoldersStore.initialState,
      GeneralStore.initialState,
      IndexingStore.initialState,
      IntegrationsStore.initialState,
      LoginStore.initialState,
      MainStore.initialState,
      PreviewStore.initialState,
      RulesStore.initialState,
      SearchStore.initialState,
      SettingsStore.initialState,
      ShareStore.initialState,
      SupportStore.initialState,
      SystemStore.initialState,
      ThumbnailStore.initialState,
      WelcomeStore.initialState
    )

  lazy val handlers =
    List(
      new AiHandler,
      new AuthHandler,
      new BillingHandler,
      new CardHandler,
      new CategoriesHandler,
      new CheckoutHandler,
      new DeveloperHandler,
      new FoldersHandler,
      new GeneralHandler,
      new IndexingHandler,
      new IntegrationsHandler,
      new LoginHandler,
      new MainHandler,
      new PreviewHandler,
      new RulesHandler,
      new SearchHandler,
      new SearchKeyHandler,
      new SearchMenuHandler,
      new SearchScrollHandler,
      new SettingsHandler,
      new ShareHandler,
      new ShareKeyHandler,
      new SupportHandler,
      new SystemHandler,
      new ThumbnailHandler,
      new WelcomeHandler
    )
}