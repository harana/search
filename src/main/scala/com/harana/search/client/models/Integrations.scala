package com.harana.search.client.models

import com.harana.search.client.icons.developer.{AlcatrazIcon, BowerIcon, CargoIcon, CarthageIcon, CocoapodsIcon, CondaIcon, CpanIcon, CranIcon, DevIcon, DubIcon, ElmIcon, GoIcon, HackageIcon, HaskellIcon, HaxelibIcon, HexIcon, HomebrewIcon, InqludeIcon, JuliaIcon, MavenIcon, MeteorIcon, NimbleIcon, NpmIcon, NugetIcon, PackagistIcon, PubIcon, PuppetIcon, PurescriptIcon, PythonIcon, RacketIcon, RubygemsIcon, SwiftIcon}
import com.harana.web.external.tailwind.OutlineIcons._

object Integrations {

  val list = List(
    Integration(
      id = "activecampaign",
      title = "ActiveCampaign",
      category = "Marketing",
      description = Some("Customer experience automation platform that offers email marketing, automation, sales automation, and CRM functionalities, enabling businesses to connect and engage with their customers."),
      openUrl = Some("https://$account.activehosted.com/admin/campaigns/edit?id=$campaign_id")
    ),
    Integration(
      id = "adjust",
      title = "Adjust",
      category = "Product",
      description = Some("End-to-end solution for every stage of the app marketing journey."),
      openUrl = Some("https://app.adjust.com/$entity-type/$entity-id")
    ),
    Integration(
      id = "aha",
      title = "Aha!",
      category = "Product",
      description = Some("Product roadmap software that helps businesses define their strategy, create visual roadmaps, and manage releases and ideas, emphasizing on alignment with company goals."),
      openUrl = Some("https://$domain.aha.io/$feature-type/$id")
    ),
    Integration(
      id = "aircall",
      title = "Aircall",
      category = "Customer",
      description = Some("Cloud-based phone system designed for teams like Customer Success or sales, providing seamless integration with various CRM and helpdesk tools."),
      openUrl = Some("https://app.aircall.io/calls/$id")
    ),
    Integration(
      id = "airtable",
      title = "Airtable",
      category = "Productivity",
      description = Some("Cloud collaboration service that functions like a spreadsheet but gives the power of a database, enabling teams to organize work and share information easily."),
      openUrl = Some("https://airtable.com/$base/$table/$record")
    ),
    Integration(
      id = "alloydb",
      title = "AllowDB",
      category = "Engineering",
      description = Some("Fully managed PostgreSQL-compatible database service for your most demanding enterprise database workloads."),
      openUrl = Some("https://app.alloydb.com/$id")
    ),
    Integration(
      id = "alpha-vantage",
      title = "Alpha Vantage",
      category = "Finance",
      description = Some("APIs for real-time and historical data on stocks, physical currencies, digital/crypto currencies, and technical indicators, catering to various developers and investors."),
      openUrl = Some("https://www.alphavantage.co/$symbol")
    ),
    Integration(
      id = "amazon-ads",
      title = "Amazon Ads",
      category = "Marketing",
      description = Some("Suite of advertising products by Amazon that allow vendors, sellers, and authors to promote their products and brands on Amazon's platforms, enhancing visibility and sales."),
      openUrl = Some("https://ads.amazon.com/adgroups/$id")
    ),
    Integration(
      id = "amazon-seller-partner",
      title = "Amazon Seller Partner",
      category = "Sales",
      description = Some("A program by Amazon that allows merchants to sell their products on Amazon's platforms, providing various tools and services to enhance their business."),
      openUrl = Some("https://sellercentral.amazon.com/orders/detail?orderID=$id")
    ),
    Integration(
      id = "amazon-sqs",
      title = "Amazon SQS",
      category = "Engineering",
      description = Some("A fully managed message queuing service by Amazon Web Services that enables the decoupling and scaling of microservices, distributed systems, and serverless applications."),
      openUrl = Some("https://console.aws.amazon.com/sqs/v2/home?region=$region#/queues/$id")
    ),
    Integration(
      id = "amplitude",
      title = "Amplitude",
      category = "Product",
      description = Some("Analytics platform that helps businesses understand user behavior, offering insights to enhance user engagement and retention."),
      openUrl = Some("https://analytics.amplitude.com/$project/events/$event")
    ),
    Integration(
      id = "apify-dataset",
      title = "Apify Dataset",
      category = "Engineering",
      description = Some("A part of Apify, a web scraping and automation platform, that allows users to store and manage data extracted from websites."),
      openUrl = Some("https://api.apify.com/v2/datasets/$id/items")
    ),
    Integration(
      id = "appfollow",
      title = "AppFollow",
      category = "Product",
      description = Some("Tool that provides analytics and app management functionalities, allowing businesses to track app performance across various platforms."),
      openUrl = Some("https://watch.appfollow.io/apps/$id")
    ),
    Integration(
      id = "appsflyer",
      title = "AppsFlyer",
      category = "Marketing",
      description = Some("Mobile attribution and marketing analytics platform that enables marketers to analyze and optimize their users' acquisition funnel."),
      openUrl = Some("")
    ),
    Integration(
      id = "asana",
      title = "Asana",
      category = "Project Management",
      description = Some("Helps teams organize, track, and manage their work, tasks and project management."),
      openUrl = Some("https://app.asana.com/0/$id")
    ),
    Integration(
      id = "ashby",
      title = "Ashby",
      category = "Human Resources",
      description = Some("All-in-one recruiting software consolidates your ATS, Analytics, Scheduling, and CRM."),
      openUrl = Some("https://ashby.com/resource/$id")
    ),
    Integration(
      id = "auth0",
      title = "Auth0",
      category = "Engineering",
      description = Some("Identity platform that provides authentication and authorization services."),
      openUrl = Some("https://manage.auth0.com/dashboard/us/$tenant/users/$id")
    ),
    Integration(
      id = "aws-cloudtrail",
      title = "AWS CloudTrail",
      category = "Engineering",
      description = Some("Amazon Web Service that enables governance, compliance, operational auditing, and risk auditing of your AWS account."),
      openUrl = Some("#")
    ),
    Integration(
      id = "azure-blob-storage",
      title = "Azure Blob Storage",
      category = "Engineering",
      description = Some("Object storage solution for the cloud, allowing unstructured data storage and serving of large amounts of data."),
      openUrl = Some("https://$account.blob.core.windows.net/$container/$blob")
    ),
    Integration(
      id = "azure-table",
      title = "Azure Table",
      category = "Engineering",
      description = Some("NoSQL data store for semi-structured data, providing a key/attribute store with a schema-less design."),
      openUrl = Some("https://portal.azure.com/#resource/subscriptions/$subscriptionId/resourceGroups/$resourceGroup/providers/Microsoft.Storage/storageAccounts/$storageAccount/tableServices/default/tables/$id")
    ),
    Integration(
      id = "babelforce",
      title = "Babelforce",
      category = "Customer",
      description = Some("No-code integration platform for customer service processes, automating call flows and other interactions."),
      openUrl = Some("#")
    ),
    Integration(
      id = "bamboo-Human Resources",
      title = "BambooHR",
      category = "Human Resources",
      description = Some("Human resources software that offers an online HR management system focusing on the employee lifecycle."),
      openUrl = Some("https://$domain.bambooHuman Resources.com/employees/employee.php?id=$id")
    ),
    Integration(
      id = "bigcommerce",
      title = "BigCommerce",
      category = "Shopping",
      description = Some("eCommerce platform that provides merchants with tools to create, manage, and scale an online store."),
      openUrl = Some("https://store-$id.mybigcommerce.com")
    ),
    Integration(
      id = "bigquery",
      title = "BigQuery",
      category = "Engineering",
      description = Some("Google's fully-managed, serverless data warehouse that enables super-fast SQL queries using the processing power of Google's infrastructure."),
      openUrl = Some("https://console.cloud.google.com/bigquery?project=$projectId&d=$datasetId&t=$id&p=$projectId&page=table")
    ),
    Integration(
      id = "bing-ads",
      title = "Bing Ads",
      category = "Marketing",
      description = Some("Service that provides pay-per-click advertising on both the Bing and Yahoo! search engines."),
      openUrl = Some("https://ui.ads.microsoft.com/adcampaigns/adcampaign/$id")
    ),
    Integration(
      id = "braintree",
      title = "Braintree",
      category = "Finance",
      description = Some("Full-stack payment platform known for its ease of integration, enabling companies to accept, process, and split payments in their mobile apps or websites."),
      openUrl = Some("https://www.braintreepayments.com/transaction/$id")
    ),
    Integration(
      id = "braze",
      title = "Braze",
      category = "Marketing",
      description = Some("Customer engagement platform that delivers messaging experiences across push, email, apps, and more."),
      openUrl = Some("#")
    ),
    Integration(
      id = "breezometer",
      title = "Breezometer",
      category = "Other",
      description = Some("Provider of air quality data and insights, offering APIs to businesses to include real-time air quality information in their products or services."),
      openUrl = Some("https://api.breezometer.com/resource/?apikey=$apiKey&id=$id")
    ),
    Integration(
      id = "callrail",
      title = "CallRail",
      category = "Sales",
      description = Some("Platform that tracks and manages phone calls and leads for businesses, providing insights into marketing campaigns."),
      openUrl = Some("https://app.callrail.com/calls/$id")
    ),
    Integration(
      id = "captain-data",
      title = "Captain Data",
      category = "Engineering",
      description = Some("Automation platform that helps in scraping and extracting data from various online sources."),
      openUrl = Some("#")
    ),
    Integration(
      id = "chargebee",
      title = "Chargebee",
      category = "Finance",
      description = Some("Subscription billing and revenue management platform designed to automate revenue operations of subscription-based businesses."),
      openUrl = Some("https://$domain.chargebee.com/customers/$id")
    ),
    Integration(
      id = "chargify",
      title = "Chargify",
      category = "Finance",
      description = Some("Billing software that specializes in recurring billing and subscription management."),
      openUrl = Some("https://$subdomain.chargify.com/subscriptions/$id")
    ),
    Integration(
      id = "chartmogul",
      title = "ChartMogul",
      category = "Finance",
      description = Some("Analytics platform that helps subscription businesses measure, understand, and grow their recurring revenue."),
      openUrl = Some("https://app.chartmogul.com/$accountId/subscriptions/$id")
    ),
    Integration(
      id = "clickhouse",
      title = "ClickHouse",
      category = "Engineering",
      description = Some("Open-source columnar database management system that allows real-time query processing suitable for OLAP."),
      openUrl = Some("https://clickhouse.$domain/tables/$id")
    ),
    Integration(
      id = "clickup-api",
      title = "ClickUp API",
      category = "Project Management",
      description = Some("Set of APIs that allows developers to integrate with ClickUp, a productivity tool designed to centralize tasks, docs, goals, and more."),
      openUrl = Some("https://api.clickup.com/api/v2/item/$id")
    ),
    Integration(
      id = "clockify",
      title = "Clockify",
      category = "Productivity",
      description = Some("Time-tracking tool that enables teams to track work hours across projects."),
      openUrl = Some("https://clockify.me/tracker/$id")
    ),
    Integration(
      id = "close-com",
      title = "Close.com",
      category = "Sales",
      description = Some("Sales engagement CRM designed to help salespeople dramatically increase their reach and productivity."),
      openUrl = Some("https://app.close.com/lead/$id")
    ),
    Integration(
      id = "cockroachdb",
      title = "CockroachDB",
      category = "Engineering",
      description = Some("Distributed SQL database that provides horizontal scaling and strong consistency across globally distributed data centers."),
      openUrl = Some("https://cockroachdb.$domain/databases/$id")
    ),
    Integration(
      id = "coda",
      title = "Coda",
      category = "Productivity",
      description = Some("Document editing platform that combines the functionality of word processing, spreadsheets, and databases."),
      openUrl = Some("https://coda.io/d/$documentName_d$id")
    ),
    Integration(
      id = "coin-api",
      title = "CoinAPI",
      category = "Finance",
      description = Some("All-in-one API providing information on various cryptocurrencies from multiple exchanges."),
      openUrl = Some("https://rest.coinapi.io/v1/symbols?id=$id")
    ),
    Integration(
      id = "coingecko-coins",
      title = "CoinGecko Coins",
      category = "Finance",
      description = Some("CoinGecko's API for retrieving information about various cryptocurrencies."),
      openUrl = Some("https://www.coingecko.com/en/coins/$id")
    ),
    Integration(
      id = "coinmarketcap",
      title = "CoinMarketCap",
      category = "Finance",
      description = Some("Website that provides various statistics and information on cryptocurrencies, including market capitalization, trading volume, and more."),
      openUrl = Some("https://coinmarketcap.com/currencies/$id")
    ),
    Integration(
      id = "commercetools",
      title = "commercetools",
      category = "Shopping",
      description = Some("Cloud-native, headless commerce platform offering APIs for building unique and engaging digital commerce applications."),
      openUrl = Some("https://mc.commercetools.com/$projectName/products/$id")
    ),
    Integration(
      id = "configcat",
      title = "ConfigCat",
      category = "Technoylog",
      description = Some("Feature flag and configuration management service that enables teams to roll out new features gradually."),
      openUrl = Some("https://app.configcat.com/feature-flag/$id")
    ),
    Integration(
      id = "confluence",
      title = "Confluence",
      category = "Productivity",
      description = Some("Collaboration tool by Atlassian that allows teams to create, share, and collaborate on projects in one place."),
      openUrl = Some("https://$domain.atlassian.net/wiki/spaces/$space/pages/$id")
    ),
    Integration(
      id = "convertkit",
      title = "ConvertKit",
      category = "Marketing",
      description = Some("Email marketing platform tailored for creators, offering tools to build connections with their audience."),
      openUrl = Some("https://app.convertkit.com/subscribers/$id")
    ),
    Integration(
      id = "copper",
      title = "Copper",
      category = "Sales",
      description = Some("CRM solution designed to help businesses build relationships and manage leads, specifically integrating with G Suite."),
      openUrl = Some("https://app.copper.com/lead/$id")
    ),
    Integration(
      id = "courier",
      title = "Courier",
      category = "Engineering",
      description = Some("Notification orchestration tool allowing developers to design and deliver user notifications across various channels."),
      openUrl = Some("https://api.courier.com/resource/$id")
    ),
    Integration(
      id = "datadog",
      title = "Datadog",
      category = "Engineering",
      description = Some("Monitoring and analytics platform that provides full-stack observability and business insights across hybrid multi-cloud environments."),
      openUrl = Some("https://app.datadoghq.com/dashboard/$id")
    ),
    Integration(
      id = "datascope",
      title = "Datascope",
      category = "Finance",
      description = Some(""),
      openUrl = Some("https://app.datascopeanalytics.com/datasets/$id")
    ),
    Integration(
      id = "delighted",
      title = "Delighted",
      category = "Customer",
      description = Some("Customer feedback platform that utilizes the Net Promoter System, enabling businesses to gather and analyze customer feedback."),
      openUrl = Some("https://delighted.com/dashboard/responses/$id")
    ),
    Integration(
      id = "developer-alcatraz",
      title = "Alcatraz",
      icon = AlcatrazIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-bower",
      title = "Bower",
      icon = BowerIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-cargo",
      title = "Cargo",
      icon = CargoIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-carthage",
      title = "Carthage",
      icon = CarthageIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-cocoapods",
      title = "Cocoapods",
      icon = CocoapodsIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-conda",
      title = "Conda",
      icon = CondaIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-cpan",
      title = "Cpan",
      icon = CpanIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-cran",
      title = "Cran",
      icon = CranIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-dev",
      title = "Dev",
      icon = DevIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-dub",
      title = "Dub",
      icon = DubIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-elm",
      title = "Elm",
      icon = ElmIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-go",
      title = "Go",
      icon = GoIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-hackage",
      title = "Hackage",
      icon = HackageIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-haskell",
      title = "Haskell",
      icon = HaskellIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-haxelib",
      title = "Haxelib",
      icon = HaxelibIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-hex",
      title = "Hex",
      icon = HexIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-homebrew",
      title = "Homebrew",
      icon = HomebrewIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-inqlude",
      title = "Inqlude",
      icon = InqludeIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-julia",
      title = "Julia",
      icon = JuliaIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-maven",
      title = "Maven",
      icon = MavenIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-meteor",
      title = "Meteor",
      icon = MeteorIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-nimble",
      title = "Nimble",
      icon = NimbleIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-npm",
      title = "Npm",
      icon = NpmIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-nuget",
      title = "Nuget",
      icon = NugetIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-packagist",
      title = "Packagist",
      icon = PackagistIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-pub",
      title = "Pub",
      icon = PubIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-puppet",
      title = "Puppet",
      icon = PuppetIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-purescript",
      title = "Purescript",
      icon = PurescriptIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-python",
      title = "Python",
      icon = PythonIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-racket",
      title = "Racket",
      icon = RacketIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-rubygems",
      title = "Rubygems",
      icon = RubygemsIcon(),
      category = "Developer",
    ),
    Integration(
      id = "developer-swift",
      title = "Swift",
      icon = SwiftIcon(),
      category = "Developer",
    ),
    Integration(
      id = "dixa",
      title = "Dixa",
      category = "Customer",
      description = Some("Customer service platform that allows businesses to engage with customers through various channels like phone, email, chat, and social media."),
      openUrl = Some("https://app.dixa.io/conversation/$id")
    ),
    Integration(
      id = "dockerhub",
      title = "Docker Hub",
      category = "Engineering",
      description = Some("Cloud-based registry service that allows developers to link code repositories, build, and store container images."),
      openUrl = Some("https://hub.docker.com/r/$username/$repository")
    ),
    Integration(
      id = "dremio",
      title = "Dremio",
      category = "Engineering",
      description = Some("Data lake engine that allows querying data across various sources, such as data lakes, relational and NoSQL databases, providing a unified data view."),
      openUrl = Some("https://dremio.$domain/project/$id")
    ),
    Integration(
      id = "drift",
      title = "Drift",
      category = "Marketing",
      description = Some("Conversational marketing and sales platform that connects businesses with the best leads in real-time."),
      openUrl = Some("https://app.drift.com/inboxes/$id")
    ),
    Integration(
      id = "dv-360",
      title = "DV 360",
      category = "Advertising",
      description = Some("Display & Video 360, Google's unified programmatic advertising platform that helps with planning, creative, buying, and measurement."),
      openUrl = Some("https://displayvideo.google.com/lineitem/$id")
    ),
    Integration(
      id = "dynamodb",
      title = "DynamoDB",
      category = "Engineering",
      description = Some("Amazon web service that offers a scalable and high-performance NoSQL database with seamless throughput and storage scaling."),
      openUrl = Some("https://console.aws.amazon.com/dynamodb/home?region=$region#tables:selected=$tableName;tab=items;item:id=$id")
    ),
    Integration(
      id = "elasticsearch",
      title = "Elasticsearch",
      category = "Engineering",
      description = Some("Distributed search and analytics engine that enables real-time search and data analysis functionalities."),
      openUrl = Some("http://elasticsearch.$domain/$index/$type/$id")
    ),
    Integration(
      id = "emailoctopus",
      title = "EmailOctopus",
      category = "Marketing",
      description = Some("Email marketing platform that allows users to send email newsletters, campaigns, and automated responses."),
      openUrl = Some("https://app.emailoctopus.com/a/dashboard/campaigns/$id")
    ),
    Integration(
      id = "everhour",
      title = "Everhour",
      category = "Productivity",
      description = Some("Time-tracking software that integrates with project management tools, providing insights into employee work hours."),
      openUrl = Some("https://app.everhour.com/#/tasks/$id")
    ),
    Integration(
      id = "exchange-rates",
      title = "Exchange Rates",
      category = "Finance",
      description = Some("APIs or services providing real-time exchange rate information for various currencies."),
      openUrl = Some("https://api.exchangerates.io/latest?base=$id")
    ),
    Integration(
      id = "facebook-marketing",
      title = "Facebook Marketing",
      category = "Marketing",
      description = Some("Suite of tools and platforms designed to help businesses market and advertise on Facebook."),
      openUrl = Some("https://www.facebook.com/adsmanager/manage/campaigns?act=$id")
    ),
    Integration(
      id = "facebook-pages",
      title = "Facebook Pages",
      category = "Marketing",
      description = Some("Feature on Facebook that allows businesses, public figures, and organizations to create a public presence on the platform."),
      openUrl = Some("https://www.facebook.com/$id")
    ),
    Integration(
      id = "faker",
      title = "Faker",
      category = "Engineering",
      description = Some("Library that generates fake data, such as names, addresses, and phone numbers, often used for testing."),
      openUrl = Some("#")
    ),
    Integration(
      id = "fastbill",
      title = "FastBill",
      category = "Finance",
      description = Some("Online accounting software that simplifies invoicing, expenses, and financial tracking for small businesses."),
      openUrl = Some("https://my.fastbill.com/customer/$id")
    ),
    Integration(
      id = "fauna",
      title = "Fauna",
      category = "Engineering",
      description = Some("Transactional, serverless NoSQL database that provides a flexible, secure, and scalable infrastructure for modern applications."),
      openUrl = Some("https://dashboard.fauna.com/db/$database/collections/$id")
    ),
    Integration(
      id = "firebolt",
      title = "Firebolt",
      category = "Engineering",
      description = Some("Cloud-native elastic data warehousing platform designed to provide high-performance analytics at reduced costs."),
      openUrl = Some("https://app.firebolt.io/data/$id")
    ),
    Integration(
      id = "freshcaller",
      title = "Freshcaller",
      category = "Customer",
      description = Some("Cloud-based call center software by Freshworks, designed to assist Customer Success through various channels."),
      openUrl = Some("https://web.freshcaller.com/calls/$id")
    ),
    Integration(
      id = "freshdesk",
      title = "Freshdesk",
      category = "Customer",
      description = Some("Customer Success software that offers a range of customer service tools to streamline support workflows."),
      openUrl = Some("https://$domain.freshdesk.com/a/tickets/$id")
    ),
    Integration(
      id = "freshsales",
      title = "Freshsales",
      category = "Sales",
      description = Some("Sales CRM by Freshworks that helps businesses manage leads, sales processes, and customer relationships."),
      openUrl = Some("https://$domain.freshsales.io/leads/$id")
    ),
    Integration(
      id = "freshservice",
      title = "Freshservice",
      category = "Customer",
      description = Some("IT service management tool by Freshworks that provides a range of IT support and helpdesk functionalities."),
      openUrl = Some("https://$domain.freshservice.com/tickets/$id")
    ),
    Integration(
      id = "fullstory",
      title = "FullStory",
      category = "Product",
      description = Some("Digital experience analytics platform that allows organizations to replay sessions, troubleshoot issues, and understand user behavior."),
      openUrl = Some("https://app.fullstory.com/session/$id")
    ),
    Integration(
      id = "gainsight-px",
      title = "Gainsight PX",
      category = "Product",
      description = Some("Product experience platform that helps businesses analyze user behavior and drive product adoption through in-app engagement."),
      openUrl = Some("https://app.gainsight.com/px/$id")
    ),
    Integration(
      id = "gcs",
      title = "Google Cloud Storage",
      category = "Engineering",
      description = Some("Scalable and flexible object storage service offered by Google Cloud, designed for storing and accessing data."),
      openUrl = Some("https://console.cloud.google.com/storage/browser/$bucketId/$objectId")
    ),
    Integration(
      id = "genesys",
      title = "Genesys",
      category = "Marketing",
      description = Some("Omnichannel customer experience and contact center solutions, including cloud and on-premises options."),
      openUrl = Some("https://app.genesys.com/interaction/$id")
    ),
    Integration(
      id = "getlago",
      title = "GetLago",
      category = "Other",
      description = Some(""),
      openUrl = Some("https://getlago.com/data/$id")
    ),
    Integration(
      id = "github",
      title = "GitHub",
      category = "Engineering",
      description = Some("Web-based platform that provides hosting for software development and a Git repository hosting service, offering collaboration features and tools."),
      openUrl = Some("https://github.com/$user/$repository")
    ),
    Integration(
      id = "gitlab",
      title = "GitLab",
      category = "Engineering",
      description = Some("Web-based Git repository manager that offers CI/CD tools and a platform for code collaboration."),
      openUrl = Some("https://gitlab.com/$user/$repository")
    ),
    Integration(
      id = "glassfrog",
      title = "GlassFrog",
      category = "Other",
      description = Some("Tool for facilitating Holacracy practices in organizations, providing a platform for transparent governance and operations."),
      openUrl = Some("https://app.glassfrog.com/circles/$id")
    ),
    Integration(
      id = "gnews",
      title = "GNews",
      category = "News",
      description = Some("Aggregates headlines from news sources worldwide, grouping similar stories together."),
      openUrl = Some("https://gnews.io/api/v3/search?q=$id&token=$apiKey")
    ),
    Integration(
      id = "gocardless",
      title = "GoCardless",
      category = "Finance",
      description = Some("Fintech company that provides a simple way to automate Direct Debit payments for businesses."),
      openUrl = Some("https://manage.gocardless.com/payments/$id")
    ),
    Integration(
      id = "gong",
      title = "Gong",
      category = "Sales",
      description = Some("Revenue intelligence platform that uses AI to analyze sales interactions and provide insights to sales teams."),
      openUrl = Some("https://app.gong.io/call/$id")
    ),
    Integration(
      id = "google-ads",
      title = "Google Ads",
      category = "Marketing",
      description = Some("Google's online advertising platform that allows businesses to display advertisements, product listings, and service offerings across Google's network."),
      openUrl = Some("https://ads.google.com/aw/campaigns?campaignId=$campaignId&account=$accountId")
    ),
    Integration(
      id = "google-analytics-data-api",
      title = "Google Analytics Data API",
      category = "Engineering",
      description = Some("Part of Google Analytics, this API allows for programmatic access to Google Analytics reporting data."),
      openUrl = Some("https://analyticsdata.googleapis.com/v1beta/$id")
    ),
    Integration(
      id = "google-analytics-v4",
      title = "Google Analytics v4",
      category = "Engineering",
      description = Some("Latest version of Google Analytics, offering improved insights and flexibility in tracking user interactions."),
      openUrl = Some("https://analyticsreporting.googleapis.com/v4/reports/$id")
    ),
    Integration(
      id = "google-directory",
      title = "Google Directory",
      category = "Human Resources",
      description = Some("Google Workspace Directory, which manages users, groups, and devices in Google Workspace."),
      openUrl = Some("https://www.googleapis.com/admin/directory/v1/users/$id")
    ),
    Integration(
      id = "google-pagespeed-insights",
      title = "Google PageSpeed Insights",
      category = "Engineering",
      description = Some("Tool that measures the performance of a web page and provides recommendations for improvement."),
      openUrl = Some("https://developers.google.com/speed/pagespeed/insights/?url=$id")
    ),
    Integration(
      id = "google-search-console",
      title = "Google Search Console",
      category = "Engineering",
      description = Some("Free service offered by Google that helps website owners monitor and troubleshoot their site's presence in Google Search results."),
      openUrl = Some("https://search.google.com/search-console/data/$id")
    ),
    Integration(
      id = "google-sheets",
      title = "Google Sheets",
      category = "Productivity",
      description = Some("Web-based application that allows users to create, update, and modify spreadsheets and share the data live online."),
      openUrl = Some("https://docs.google.com/spreadsheets/d/YOUR_DOCUMENT_ID/edit")
    ),
    Integration(
      id = "google-webfonts",
      title = "Google Webfonts",
      category = "Productivity",
      description = Some("Library that provides free access to a large collection of web fonts."),
      openUrl = Some("https://fonts.google.com/specimen/$font?id=$id")
    ),
    Integration(
      id = "google-workspace-admin-reports",
      title = "Google Workspace Admin Reports",
      category = "Human Resources",
      description = Some("Set of tools within Google Workspace that provides reports, audits, and alerts about user activity."),
      openUrl = Some("https://admin.googleapis.com/admin/reports/v1/activity/users/$id")
    ),
    Integration(
      id = "greenhouse",
      title = "Greenhouse",
      category = "Human Resources",
      description = Some("Recruiting software company that designs tools to optimize recruiting processes."),
      openUrl = Some("https://app.greenhouse.io/job_board/jobs/$id")
    ),
    Integration(
      id = "gridly",
      title = "Gridly",
      category = "Engineering",
      description = Some("Headless content management system designed for multilingual digital experiences and game content."),
      openUrl = Some("https://app.gridly.com/records/$id")
    ),
    Integration(
      id = "harvest",
      title = "Harvest",
      category = "Productivity",
      description = Some("Time-tracking software that enables individuals and teams to track the time spent on tasks and projects."),
      openUrl = Some("https://id.harvestapp.com/time/week/[$year/$month/$day]/$id")
    ),
    Integration(
      id = "hellobaton",
      title = "HelloBaton",
      category = "Product",
      description = Some("Purpose-built for managing software implementation & customer onboarding"),
      openUrl = Some("https://app.hellobaton.com/tasks/$id")
    ),
    Integration(
      id = "hubplanner",
      title = "HubPlanner",
      category = "Project Management",
      description = Some("Resource management and scheduling tool that offers insights into project timelines, capacity, and resource allocation."),
      openUrl = Some("https://app.hubplanner.com/grid/$id")
    ),
    Integration(
      id = "hubspot",
      title = "HubSpot",
      category = "Marketing",
      description = Some("Inbound marketing, sales, and customer service platform that helps businesses attract, engage, and delight customers."),
      openUrl = Some("https://app.hubspot.com/contacts/$portalId/contact/$id")
    ),
    Integration(
      id = "insightly",
      title = "Insightly",
      category = "Sales",
      description = Some("Customer relationship management (CRM) tool that offers features for managing contacts, sales, projects, and emails."),
      openUrl = Some("https://crm.insightly.com/page/recorddetail/$id")
    ),
    Integration(
      id = "instagram",
      title = "Instagram",
      category = "Marketing",
      description = Some("Social media platform that allows users to share photos and videos, as well as engage with others through likes, comments, and messages."),
      openUrl = Some("https://www.instagram.com/p/YOUR_POST_ID/")
    ),
    Integration(
      id = "instatus",
      title = "Instatus",
      category = "Engineering",
      description = Some("Status page platform that allows businesses to create and manage status pages for their services and applications."),
      openUrl = Some("https://instatus.com/status/$id")
    ),
    Integration(
      id = "intercom",
      title = "Intercom",
      category = "Marketing",
      description = Some("Customer messaging platform that enables businesses to communicate with customers through various channels within a unified interface."),
      openUrl = Some("https://app.intercom.com/a/apps/$appId/users/$id")
    ),
    Integration(
      id = "intruder",
      title = "Intruder",
      category = "Engineering",
      description = Some("Cloud-based security platform that provides automated cybersecurity vulnerability assessments."),
      openUrl = Some("https://app.intruder.io/dashboard/vulnerabilities/$id")
    ),
    Integration(
      id = "ip2whois",
      title = "IP2Whois",
      category = "Engineering",
      description = Some("Service that provides WHOIS lookup for domain name registration information, often used for cybersecurity or legal purposes."),
      openUrl = Some("https://www.ip2whois.com/domain?id=$id")
    ),
    Integration(
      id = "iterable",
      title = "Iterable",
      category = "Marketing",
      description = Some("Marketing automation platform that facilitates customer engagement through various channels like email, push, and SMS."),
      openUrl = Some("https://app.iterable.com/marketing/campaigns/$id")
    ),
    Integration(
      id = "jira",
      title = "Jira",
      category = "Project Management",
      description = Some("Project management tool by Atlassian used for bug tracking, issue tracking, and agile project management."),
      openUrl = Some("https://your-jira-domain.atlassian.net/browse/YOUR_JIRA_ID")
    ),
    Integration(
      id = "k6-cloud",
      title = "K6 Cloud",
      category = "Engineering",
      description = Some("Cloud-based load testing tool used to analyze the performance of web services and APIs."),
      openUrl = Some("https://app.k6.io/runs/$id")
    ),
    Integration(
      id = "klarna",
      title = "Klarna",
      category = "Finance",
      description = Some("Swedish fintech company that provides e-commerce payment solutions, including pay later and installment options."),
      openUrl = Some("https://klarna.com/order/$id")
    ),
    Integration(
      id = "klaviyo",
      title = "Klaviyo",
      category = "Marketing",
      description = Some("Email marketing platform that provides personalized email and SMS marketing services to e-commerce businesses."),
      openUrl = Some("https://www.klaviyo.com/campaigns/$id")
    ),
    Integration(
      id = "kustomer-singer",
      title = "Kustomer Singer",
      category = "Customer",
      description = Some("Related to Kustomer, a customer service CRM platform."),
      openUrl = Some("https://app.kustomer.com/data/$id")
    ),
    Integration(
      id = "kyriba",
      title = "Kyriba",
      category = "Finance",
      description = Some("Global treasury management platform that helps manage cash, forecast liquidity, and mitigate operational and financial risk."),
      openUrl = Some("https://platform.kyriba.com/data/$id")
    ),
    Integration(
      id = "launchdarkly",
      title = "LaunchDarkly",
      category = "Product",
      description = Some("Feature management platform that enables teams to control software features through toggles, allowing gradual rollouts and A/B testing."),
      openUrl = Some("https://app.launchdarkly.com/default/feature-flags/$id")
    ),
    Integration(
      id = "lemlist",
      title = "Lemlist",
      category = "Marketing",
      description = Some("Email automation platform that allows users to send personalized cold emails at scale."),
      openUrl = Some("https://app.lemlist.com/campaigns/$id")
    ),
    Integration(
      id = "lever-hiring",
      title = "Lever Hiring",
      category = "Human Resources",
      description = Some("Recruiting software designed to streamline the hiring process, providing tools for candidate tracking and collaboration."),
      openUrl = Some("https://jobs.lever.co/$company/$id")
    ),
    Integration(
      id = "linkedin-ads",
      title = "LinkedIn Ads",
      category = "Sales",
      description = Some("LinkedIn's advertising platform that allows businesses to target specific audiences within the professional network."),
      openUrl = Some("https://www.linkedin.com/ad/accounts/$id/campaigns")
    ),
    Integration(
      id = "linkedin-pages",
      title = "LinkedIn Pages",
      category = "Marketing",
      description = Some("Business pages on LinkedIn that allow companies to engage with followers and share content."),
      openUrl = Some("https://www.linkedin.com/company/$id")
    ),
    Integration(
      id = "linnworks",
      title = "Linnworks",
      category = "Shopping",
      description = Some("Multi-channel order management and inventory management platform for e-commerce businesses."),
      openUrl = Some("https://app.linnworks.com/inventory/items/$id")
    ),
    Integration(
      id = "local-application",
      title = "Application",
      icon = CalculatorOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-archive",
      title = "Archive",
      icon = ArchiveBoxOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-audio",
      title = "Audio",
      icon = MusicalNoteOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-book",
      title = "Book",
      icon = BookOpenOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-calendar",
      title = "Calendar",
      icon = CalendarDaysOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-certificate",
      title = "Certificate",
      icon = KeyOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-code",
      title = "Code",
      icon = CodeBracketOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-codeartifact",
      title = "Code Artifact",
      icon = CodeBracketSquareOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-contact",
      title = "Contact",
      icon = IdentificationOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-data",
      title = "Data",
      icon = TableCellsOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-database",
      title = "Database",
      icon = CircleStackOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-diskimage",
      title = "Disk Image",
      icon = ArchiveBoxOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-document",
      title = "Document",
      icon = DocumentTextOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-email",
      title = "Email",
      icon = EnvelopeOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-folder",
      title = "Folder",
      icon = FolderOpenOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-font",
      title = "Font",
      icon = LanguageOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-game",
      title = "Game",
      icon = PuzzlePieceOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-graphics",
      title = "Graphics",
      icon = CubeOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-hardware",
      title = "Hardware",
      icon = WrenchOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-image",
      title = "Image",
      icon = PhotoOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-map",
      title = "Map",
      icon = MapOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-other",
      title = "Other",
      icon = DocumentOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-science",
      title = "Science",
      icon = BeakerOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-screenshot",
      title = "Screenshot",
      icon = WindowOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "local-video",
      title = "Video",
      icon = FilmOutlineIcon(),
      category = "Local",
    ),
    Integration(
      id = "lokalise",
      title = "Lokalise",
      category = "Engineering",
      description = Some("Localization and translation management platform that helps teams manage multilingual content across applications and websites."),
      openUrl = Some("https://app.lokalise.com/project/$id")
    ),
    Integration(
      id = "looker",
      title = "Looker",
      category = "Productivity",
      description = Some("Business intelligence software and big data analytics platform that helps explore, analyze, and share real-time business analytics."),
      openUrl = Some("https://$domain.looker.com/explore/$project/$id")
    ),
    Integration(
      id = "mailchimp",
      title = "Mailchimp",
      category = "Marketing",
      description = Some("All-in-one marketing platform that provides email marketing services and automation tools."),
      openUrl = Some("https://usX.admin.mailchimp.com/campaigns/edit?id=$id")
    ),
    Integration(
      id = "mailerlite",
      title = "MailerLite",
      category = "Marketing",
      description = Some("Email marketing solution that offers features for creating and sending email newsletters and managing subscribers."),
      openUrl = Some("https://app.mailerlite.com/campaigns/$id/edit")
    ),
    Integration(
      id = "mailersend",
      title = "MailerSend",
      category = "Marketing",
      description = Some("Transactional email service that enables developers and businesses to send, track, and analyze emails."),
      openUrl = Some("https://app.mailersend.com/emails/$id")
    ),
    Integration(
      id = "mailgun",
      title = "Mailgun",
      category = "Marketing",
      description = Some("Email automation service providing tools for sending, receiving, and tracking emails."),
      openUrl = Some("https://app.mailgun.com/messages/$id")
    ),
    Integration(
      id = "mailjet-mail",
      title = "Mailjet Mail",
      category = "Marketing",
      description = Some("Cloud-based email delivery and tracking service that allows businesses to send marketing and transactional emails."),
      openUrl = Some("https://app.mailjet.com/messages/email/$id")
    ),
    Integration(
      id = "mailjet-sms",
      title = "Mailjet SMS",
      category = "Marketing",
      description = Some("Part of Mailjet that provides SMS marketing and notification services."),
      openUrl = Some("https://app.mailjet.com/messages/sms/$id")
    ),
    Integration(
      id = "marketo",
      title = "Marketo",
      category = "Marketing",
      description = Some("Marketing automation software that provides tools for lead management, email marketing, consumer marketing, and more."),
      openUrl = Some("https://app.marketo.com/lead/$id")
    ),
    Integration(
      id = "metabase",
      title = "Metabase",
      category = "Productivity",
      description = Some("Open-source business intelligence tool that allows users to ask questions and learn from data."),
      openUrl = Some("https://$domain.metabase.com/dashboard/$id")
    ),
    Integration(
      id = "microsoft-dataverse",
      title = "Microsoft Dataverse",
      category = "Productivity",
      description = Some("Scalable data platform and app platform in Microsoft Power Platform, providing data storage and management capabilities."),
      openUrl = Some("https://dataverse.microsoft.com/entities/$id")
    ),
    Integration(
      id = "microsoft-teams",
      title = "Microsoft Teams",
      category = "Productivity",
      description = Some("Collaboration platform that integrates with Microsoft 365, providing chat, video meetings, file storage, and application integration."),
      openUrl = Some("https://teams.microsoft.com/l/team/$id")
    ),
    Integration(
      id = "mixpanel",
      title = "Mixpanel",
      category = "Product",
      description = Some("User analytics platform that enables businesses to analyze user interactions across the entire customer journey."),
      openUrl = Some("https://mixpanel.com/report/$id")
    ),
    Integration(
      id = "monday",
      title = "Monday.com",
      category = "Project Management",
      description = Some("Work operating system that powers teams to run projects and workflows with confidence, also known as Monday.com."),
      openUrl = Some("https://$company.monday.com/boards/$id")
    ),
    Integration(
      id = "my-hours",
      title = "My Hours",
      category = "Human Resources",
      description = Some("Time tracking software that allows individuals and teams to log time spent on projects and tasks."),
      openUrl = Some("https://app.myhours.com/track/$id")
    ),
    Integration(
      id = "n8n",
      title = "n8n",
      category = "Productivity",
      description = Some("Workflow automation tool that connects various apps, devices, and services, with a strong focus on privacy and self-hosting."),
      openUrl = Some("https://$domain/workflow/$id")
    ),
    Integration(
      id = "nasa",
      title = "NASA",
      category = "Other",
      description = Some("APIs and data sets provided by NASA, it includes information about space missions, astronomical observations, and related scientific data."),
      openUrl = Some("https://api.nasa.gov/data/$id")
    ),
    Integration(
      id = "netsuite",
      title = "NetSuite",
      category = "Marketing",
      description = Some("Comprehensive cloud business software suite, including ERP, CRM, and e-commerce applications."),
      openUrl = Some("https://system.netsuite.com/app/common/entity/custjob.nl?id=$id")
    ),
    Integration(
      id = "news-api",
      title = "News API",
      category = "News",
      description = Some("JSON-based API that provides access to the latest news articles published by various sources around the world."),
      openUrl = Some("https://newsapi.org/v2/everything?q=$id")
    ),
    Integration(
      id = "notion",
      title = "Notion",
      category = "Productivity",
      description = Some("All-in-one workspace tool for notes, tasks, wikis, and databases, promoting collaboration within teams."),
      openUrl = Some("https://www.notion.so/$id")
    ),
    Integration(
      id = "nytimes",
      title = "NY Times",
      category = "News",
      description = Some("APIs offered by The New York Times, providing access to various data like articles, books, and movie reviews."),
      openUrl = Some("https://api.nytimes.com/svc/archive/v1/$year/$month.json?id=$id")
    ),
    Integration(
      id = "okta",
      title = "Okta",
      category = "Engineering",
      description = Some("Cloud-based service that provides identity and access management solutions for businesses."),
      openUrl = Some("https://$domain.okta.com/app/UserHome?id=$id")
    ),
    Integration(
      id = "omnisend",
      title = "Omnisend",
      category = "Marketing",
      description = Some("E-Commerce marketing automation platform that enables personalized and targeted email and SMS marketing."),
      openUrl = Some("https://app.omnisend.com/campaigns/$id")
    ),
    Integration(
      id = "onesignal",
      title = "OneSignal",
      category = "Marketing",
      description = Some("Service offering push notifications, in-app messages, and email to various platforms including web, mobile, and email."),
      openUrl = Some("https://app.onesignal.com/apps/$id")
    ),
    Integration(
      id = "open-exchange-rates",
      title = "Open Exchange Rates",
      category = "Finance",
      description = Some("Provides exchange rate data and currency conversion for over 200 currencies worldwide."),
      openUrl = Some("https://openexchangerates.org/api/latest.json?app_id=$id")
    ),
    Integration(
      id = "openweather",
      title = "OpenWeather",
      category = "Other",
      description = Some("Service that offers weather data, forecasts, nowcasts, and historical weather data for any location globally."),
      openUrl = Some("https://api.openweathermap.org/data/2.5/weather?id=$id&appid=$apiKey")
    ),
    Integration(
      id = "orbit",
      title = "Orbit",
      category = "Product",
      description = Some("Community experience platform that helps to build and measure community growth and engagement."),
      openUrl = Some("https://app.orbit.love/users/$id")
    ),
    Integration(
      id = "oura",
      title = "Oura",
      category = "Other",
      description = Some("Health Engineering company known for its smart ring that tracks sleep, activity, and readiness."),
      openUrl = Some("https://cloud.ouraring.com/user/$id")
    ),
    Integration(
      id = "outreach",
      title = "Outreach",
      category = "Sales",
      description = Some("Sales engagement platform that helps sales teams create, optimize, and repeat sales strategies."),
      openUrl = Some("https://app.outreach.io/outreach/$id")
    ),
    Integration(
      id = "pardot",
      title = "Pardot",
      category = "Marketing",
      description = Some("Marketing automation platform designed to create meaningful connections, generate leads, and provide ROI analysis."),
      openUrl = Some("https://pi.pardot.com/prospect/read/id/$id")
    ),
    Integration(
      id = "partnerstack",
      title = "PartnerStack",
      category = "Marketing",
      description = Some("Platform that helps companies to build partnerships with affiliates, resellers, and ambassadors to drive growth."),
      openUrl = Some("https://app.partnerstack.com/profile/$id")
    ),
    Integration(
      id = "paypal-transaction",
      title = "PayPal",
      category = "Finance",
      description = Some("PayPal's transaction APIs, enabling online payments and money transfers."),
      openUrl = Some("https://www.paypal.com/transaction/view?id=$id")
    ),
    Integration(
      id = "paystack",
      title = "Paystack",
      category = "Finance",
      description = Some("Engineering company that facilitates payments processing for businesses in Africa."),
      openUrl = Some("https://dashboard.paystack.com/#/transaction/$id")
    ),
    Integration(
      id = "pendo",
      title = "Pendo",
      category = "Product",
      description = Some("Product cloud creator for digital products and data-driven product teams."),
      openUrl = Some("https://app.pendo.io/page/$id")
    ),
    Integration(
      id = "persistiq",
      title = "PersistIQ",
      category = "Sales",
      description = Some("Sales engagement platform that automates and personalizes outbound sales campaigns."),
      openUrl = Some("https://app.persistiq.com/leads/$id")
    ),
    Integration(
      id = "pexels-api",
      title = "Pexels API",
      category = "Other",
      description = Some("Access to high-quality free stock photos and videos hosted on Pexels."),
      openUrl = Some("https://api.pexels.com/v1/photos/$id")
    ),
    Integration(
      id = "pinterest",
      title = "Pinterest",
      category = "Marketing",
      description = Some("Social media platform that allows users to discover, save, and share visual inspirations and ideas."),
      openUrl = Some("https://www.pinterest.com/pin/$id")
    ),
    Integration(
      id = "pipedrive",
      title = "Pipedrive",
      category = "Sales",
      description = Some("CRM and pipeline management tool that helps sales teams manage leads and deals."),
      openUrl = Some("https://$domain.pipedrive.com/deal/$id")
    ),
    Integration(
      id = "pivotal-tracker",
      title = "Pivotal Tracker",
      category = "Project Management",
      description = Some("Agile project management tool that supports software development collaboration."),
      openUrl = Some("https://www.pivotaltracker.com/story/show/$id")
    ),
    Integration(
      id = "plaid",
      title = "Plaid",
      category = "Finance",
      description = Some("Engineering platform that enables applications to connect with users’ bank accounts."),
      openUrl = Some("https://api.plaid.com/data/$id")
    ),
    Integration(
      id = "plausible",
      title = "Plausible",
      category = "Engineering",
      description = Some("Privacy-focused website analytics service."),
      openUrl = Some("https://plausible.io/stats/$id")
    ),
    Integration(
      id = "pocket",
      title = "Pocket",
      category = "Productivity",
      description = Some("Application that allows users to save articles, videos, and other content for later viewing."),
      openUrl = Some("https://getpocket.com/read/$id")
    ),
    Integration(
      id = "pokeapi",
      title = "PokéAPI",
      category = "Other",
      description = Some("API that provides access to detailed data on Pokémon characters, types, abilities, and more."),
      openUrl = Some("https://pokeapi.co/api/v2/pokemon/$id")
    ),
    Integration(
      id = "polygon-stock-api",
      title = "Polygon Stock API",
      category = "Finance",
      description = Some("Offers real-time and historic market data, including stocks, commodities, and cryptocurrencies."),
      openUrl = Some("https://api.polygon.io/v1/meta/symbols/$ticket/company?apiKey=$apiKey")
    ),
    Integration(
      id = "posthog",
      title = "PostHog",
      category = "Product",
      description = Some("Open-source product analytics platform that helps understand user behavior."),
      openUrl = Some("https://app.posthog.com/event/$id")
    ),
    Integration(
      id = "postmarkapp",
      title = "Postmarkapp",
      category = "Marketing",
      description = Some("Email service provider focused on delivering transactional emails quickly and reliably."),
      openUrl = Some("https://account.postmarkapp.com/messages/$id")
    ),
    Integration(
      id = "prestashop",
      title = "PrestaShop",
      category = "Shopping",
      description = Some("Open-source e-commerce platform allowing businesses to create and manage an online store."),
      openUrl = Some("https://$domain/index.php?id_product=$id&controller=product")
    ),
    Integration(
      id = "primetric",
      title = "Primetric",
      category = "Other",
      description = Some(""),
      openUrl = Some("https://app.primetric.com/project/$id")
    ),
    Integration(
      id = "public-apis",
      title = "Public APIs",
      category = "Other",
      description = Some("Collective list of free APIs for development, testing, and fun creative projects."),
      openUrl = Some("https://public-apis.io/data/$id")
    ),
    Integration(
      id = "punk-api",
      title = "Punk API",
      category = "Other",
      description = Some("API that provides information about different beers, including ingredients, methods, and tips."),
      openUrl = Some("https://api.punkapi.com/v2/beers/$id")
    ),
    Integration(
      id = "pypi",
      title = "PyPI",
      category = "Engineering",
      description = Some("Repository of software packages for the Python programming language."),
      openUrl = Some("https://pypi.org/project/$package/$id/")
    ),
    Integration(
      id = "qonto",
      title = "Qonto",
      category = "Finance",
      description = Some("European neobank that offers online banking services to businesses and freelancers."),
      openUrl = Some("https://my.qonto.com/transactions/$id")
    ),
    Integration(
      id = "qualaroo",
      title = "Qualaroo",
      category = "Product",
      description = Some("Tool for gathering and analyzing user feedback through targeted surveys and insights."),
      openUrl = Some("https://app.qualaroo.com/responses/$id")
    ),
    Integration(
      id = "quickbooks",
      title = "QuickBooks",
      category = "Finance",
      description = Some("Accounting software designed to manage payroll, inventory, sales, and other small business needs."),
      openUrl = Some("https://qbo.intuit.com/app/invoice?txnId=$id")
    ),
    Integration(
      id = "railz",
      title = "Railz",
      category = "Finance",
      description = Some("Unified API to access financial data from various accounting software."),
      openUrl = Some("https://app.railz.com/transaction/$id")
    ),
    Integration(
      id = "rd-station-marketing",
      title = "RD Station Marketing",
      category = "Marketing",
      description = Some("Marketing automation platform focused on helping businesses to grow and achieve results."),
      openUrl = Some("https://app.rdstation.com.br/lead/$id")
    ),
    Integration(
      id = "recharge",
      title = "ReCharge",
      category = "Finance",
      description = Some("Subscription payments platform that allows businesses to manage recurring billing and subscriptions."),
      openUrl = Some("https://dashboard.rechargepayments.com/customer/$id")
    ),
    Integration(
      id = "recreation",
      title = "Recreation",
      category = "Other",
      description = Some(""),
      openUrl = Some("https://app.recreation.io/event/$id")
    ),
    Integration(
      id = "recruitee",
      title = "Recruitee",
      category = "Human Resources",
      description = Some("Collaborative hiring platform designed to streamline the recruitment process."),
      openUrl = Some("https://company.recruitee.com/o/job/$id")
    ),
    Integration(
      id = "recurly",
      title = "Recurly",
      category = "Finance",
      description = Some("Subscription management platform providing billing, invoicing, and financial operations support."),
      openUrl = Some("https://$domain.recurly.com/admin/subscriptions/$id")
    ),
    Integration(
      id = "redshift",
      title = "Redshift",
      category = "Engineering",
      description = Some("Fully-managed, petabyte-scale data warehouse service."),
      openUrl = Some("https://console.redshift.aws.amazon.com/v2/data/$id")
    ),
    Integration(
      id = "reply-io",
      title = "Reply.io",
      category = "Marketing",
      description = Some("Automates one-to-one communication with customers across various channels."),
      openUrl = Some("https://app.reply.io/inbox/$id")
    ),
    Integration(
      id = "retently",
      title = "Retently",
      category = "Customer",
      description = Some("Measures customer satisfaction using Net Promoter Score (NPS)."),
      openUrl = Some("https://app.retently.com/surveys/$id")
    ),
    Integration(
      id = "rocket-chat",
      title = "Rocket.Chat",
      category = "Productivity",
      description = Some("Open-source team collaboration platform that offers chat, video conferencing, and file sharing."),
      openUrl = Some("https://$domain.rocket.chat/channel/$id")
    ),
    Integration(
      id = "s3",
      title = "S3",
      category = "Engineering",
      description = Some("Amazon Web Services object storage service designed for scalability and low-latency access."),
      openUrl = Some("https://$bucket.s3.amazonaws.com/$key")
    ),
    Integration(
      id = "salesforce",
      title = "Salesforce",
      category = "Sales",
      description = Some("Comprehensive Customer Relationship Management (CRM) platform."),
      openUrl = Some("https://$domain.salesforce.com/$id")
    ),
    Integration(
      id = "salesloft",
      title = "SalesLoft",
      category = "Sales",
      description = Some("Sales engagement platform that helps teams to reach, qualify, and convert leads."),
      openUrl = Some("https://app.salesloft.com/app/leads/$id")
    ),
    Integration(
      id = "sap-fieldglass",
      title = "SAP Fieldglass",
      category = "Other",
      description = Some("Vendor management system for services procurement and external workforce management."),
      openUrl = Some("https://www.fieldglass.net/worker/$id")
    ),
    Integration(
      id = "search-metrics",
      title = "Searchmetrics",
      category = "Marketing",
      description = Some("Search engine optimization and online visibility platform."),
      openUrl = Some("https://suite.searchmetrics.com/en/research/?url=$id")
    ),
    Integration(
      id = "secoda",
      title = "Secoda",
      category = "Productivity",
      description = Some("Data catalog tool designed to help teams find, understand, and use data."),
      openUrl = Some("https://app.secoda.co/document/$id")
    ),
    Integration(
      id = "sendgrid",
      title = "SendGrid",
      category = "Marketing",
      description = Some("Email delivery service used to send transactional or marketing emails."),
      openUrl = Some("https://mc.sendgrid.com/templates/edit/$id")
    ),
    Integration(
      id = "sendinblue",
      title = "Sendinblue",
      category = "Marketing",
      description = Some("Marketing platform specializing in email campaigns, automation, and SMS marketing."),
      openUrl = Some("https://my.sendinblue.com/camp/template/$id/message/edit")
    ),
    Integration(
      id = "senseforce",
      title = "",
      category = "Other",
      description = Some("Industrial IoT platform designed to connect and monitor machines and processes."),
      openUrl = Some("https://portal.senseforce.io/data/$id")
    ),
    Integration(
      id = "sentry",
      title = "Sentry",
      category = "Engineering",
      description = Some("Error tracking tool that monitors and fixes crashes in real time."),
      openUrl = Some("https://sentry.io/organizations/$organisation/issues/$id/")
    ),
    Integration(
      id = "shopify",
      title = "Shopify",
      category = "Shopping",
      description = Some("Commerce platform that allows businesses to create online stores and sell products."),
      openUrl = Some("https://$store.myshopify.com/admin/products/$id")
    ),
    Integration(
      id = "shortio",
      title = "Short.io",
      category = "Engineering",
      description = Some("Platform for creating and managing short, branded links."),
      openUrl = Some("https://app.short.io/links/$id")
    ),
    Integration(
      id = "slack",
      title = "Slack",
      category = "Productivity",
      description = Some("Collaboration hub that connects work with the tools and services people need to get things done."),
      openUrl = Some("https://$workspace.slack.com/archives/$channelId")
    ),
    Integration(
      id = "smaily",
      title = "Smaily",
      category = "Marketing",
      description = Some("Email marketing service for creating, sending, and analyzing email campaigns."),
      openUrl = Some("https://app.smaily.com/contacts/$id")
    ),
    Integration(
      id = "smartengage",
      title = "SmartEngage",
      category = "Marketing",
      description = Some("Cross-channel autoresponder platform designed to increase engagement with customers."),
      openUrl = Some("https://app.smartengage.com/user/$id")
    ),
    Integration(
      id = "smartsheets",
      title = "Smartsheet",
      category = "Project Management",
      description = Some("Work management and automation platform, allowing collaboration and visualization."),
      openUrl = Some("https://app.smartsheet.com/sheet/$id")
    ),
    Integration(
      id = "snapchat-marketing",
      title = "Snapchat Marketing",
      category = "Marketing",
      description = Some("Advertising and marketing through Snapchat's platform."),
      openUrl = Some("https://ads.snapchat.com/ads_manager/ad_account/$id")
    ),
    Integration(
      id = "snowflake",
      title = "Snowflake",
      category = "Engineering",
      description = Some("Cloud data platform that allows for secure and governed access to all data."),
      openUrl = Some("https://console.snowflake.com/data/$id")
    ),
    Integration(
      id = "sonar-cloud",
      title = "SonarCloud",
      category = "Engineering",
      description = Some("Cloud service for continuous code quality inspection and maintenance."),
      openUrl = Some("https://sonarcloud.io/dashboard?id=$id")
    ),
    Integration(
      id = "spacex-api",
      title = "SpaceX API",
      category = "Other",
      description = Some("API providing access to various SpaceX data, including launches, rockets, and more."),
      openUrl = Some("https://api.spacexdata.com/v4/launches/$id")
    ),
    Integration(
      id = "square",
      title = "Square",
      category = "Finance",
      description = Some("Financial services company providing mobile payment and point-of-sale solutions."),
      openUrl = Some("https://squareup.com/dashboard/orders/$id")
    ),
    Integration(
      id = "statuspage",
      title = "Statuspage",
      category = "Engineering",
      description = Some("Communicates real-time status and incident information to users."),
      openUrl = Some("https://$organisation.statuspage.io/incidents/$id")
    ),
    Integration(
      id = "strava",
      title = "Strava",
      category = "Other",
      description = Some("Social network for athletes, focused on tracking and sharing athletic activities."),
      openUrl = Some("https://www.strava.com/activities/$id")
    ),
    Integration(
      id = "stripe",
      title = "Stripe",
      category = "Finance",
      description = Some("Payment processing solutions for online businesses."),
      openUrl = Some("https://dashboard.stripe.com/payments/$id")
    ),
    Integration(
      id = "survey-sparrow",
      title = "SurveySparrow",
      category = "Marketing",
      description = Some("Online survey and feedback collection tool designed for user engagement."),
      openUrl = Some("https://app.surveysparrow.com/dashboard/responses/$id")
    ),
    Integration(
      id = "surveycto",
      title = "SurveyCTO",
      category = "Product",
      description = Some("Mobile data collection platform used in research and monitoring and evaluation efforts."),
      openUrl = Some("https://www.surveycto.com/collect/responses/$id")
    ),
    Integration(
      id = "surveymonkey",
      title = "SurveyMonkey",
      category = "Product",
      description = Some("Online survey tool for creating and conducting public or private surveys."),
      openUrl = Some("https://www.surveymonkey.com/r/$id")
    ),
    Integration(
      id = "talkdesk-explore",
      title = "Talkdesk Explore",
      category = "Customer",
      description = Some("Analytics platform within Talkdesk, providing insights and reporting for call centers."),
      openUrl = Some("https://explore.talkdesk.com/call/$id")
    ),
    Integration(
      id = "tempo",
      title = "Tempo",
      category = "Productivity",
      description = Some("Time-tracking and productivity enhancement tool used often in project management."),
      openUrl = Some("https://app.tempo.io/plan/$id")
    ),
    Integration(
      id = "teradata",
      title = "Teradata",
      category = "Engineering",
      description = Some("Provider of database and analytics-related products, services, and solutions."),
      openUrl = Some("https://console.teradata.com/data/$id")
    ),
    Integration(
      id = "the-guardian-api",
      title = "The Guardian API",
      category = "News",
      description = Some("API providing access to articles, podcasts, and videos from The Guardian newspaper."),
      openUrl = Some("https://content.guardianapis.com/$id")
    ),
    Integration(
      id = "tiktok-marketing",
      title = "TikTok Marketing",
      category = "Marketing",
      description = Some("Advertising and marketing platform of TikTok, catering to brand promotion within the app."),
      openUrl = Some("https://ads.tiktok.com/marketing_api/page/ad/$id")
    ),
    Integration(
      id = "timely",
      title = "Timely",
      category = "Productivity",
      description = Some("Automated time-tracking tool that captures and logs time spent on various tasks."),
      openUrl = Some("https://app.timelyapp.com/calendar/event/[id]")
    ),
    Integration(
      id = "tmdb",
      title = "TMDb",
      category = "Other",
      description = Some("Movie Database (TMDb) API, offering information about movies, TV shows, and celebrities."),
      openUrl = Some("https://www.themoviedb.org/movie/$id")
    ),
    Integration(
      id = "todoist",
      title = "Todoist",
      category = "Productivity",
      description = Some("Task management application that helps users organize and prioritize their projects and daily tasks."),
      openUrl = Some("https://todoist.com/showTask?id=$id")
    ),
    Integration(
      id = "toggl",
      title = "Toggl",
      category = "Productivity",
      description = Some("Time-tracking tool designed for teams and individuals to log hours and analyze productivity."),
      openUrl = Some("https://toggl.com/app/time-entries/$id")
    ),
    Integration(
      id = "trello",
      title = "Trello",
      category = "Project Management",
      description = Some("Collaboration tool that organizes projects into boards, lists, and cards for better workflow management."),
      openUrl = Some("https://trello.com/c/$id")
    ),
    Integration(
      id = "trustpilot",
      title = "Trustpilot",
      category = "Customer",
      description = Some("Online review platform that gathers and displays customer reviews for businesses."),
      openUrl = Some("https://www.trustpilot.com/review/$domain?id=$id")
    ),
    Integration(
      id = "tvmaze-schedule",
      title = "TVmaze Schedule",
      category = "Other",
      description = Some("API that provides television schedule and programming data."),
      openUrl = Some("https://www.tvmaze.com/shows/$id")
    ),
    Integration(
      id = "twilio-taskrouter",
      title = "Twilio TaskRouter",
      category = "Marketing",
      description = Some("Twilio service for routing tasks such as calls or messages to the right worker or process."),
      openUrl = Some("https://www.twilio.com/console/taskrouter/workspaces/$id")
    ),
    Integration(
      id = "twilio",
      title = "Twilio",
      category = "Marketing",
      description = Some("Cloud communications platform that enables programmable SMS, voice, chat, and video."),
      openUrl = Some("https://www.twilio.com/console/$resourceType/$id")
    ),
    Integration(
      id = "twitter",
      title = "Twitter/X",
      category = "Marketing",
      description = Some("Social networking service where users post and interact through messages known as tweets."),
      openUrl = Some("https://twitter.com/i/status/$id")
    ),
    Integration(
      id = "typeform",
      title = "Typeform",
      category = "Product",
      description = Some("Online software service that specializes in online form building and surveys."),
      openUrl = Some("https://$username.typeform.com/to/$id")
    ),
    Integration(
      id = "unleash",
      title = "Unleash",
      category = "Product",
      description = Some("Feature management platform enabling developers to toggle features on/off dynamically"),
      openUrl = Some("")
    ),
    Integration(
      id = "visma-economic",
      title = "Visma Economic",
      category = "Finance",
      description = Some("Cloud-based accounting and business management software."),
      openUrl = Some("https://app.economic.com/#/customers/$id")
    ),
    Integration(
      id = "vitally",
      title = "Vitally",
      category = "Customer",
      description = Some("Customer success platform designed to analyze and improve customer relationships and retention."),
      openUrl = Some("")
    ),
    Integration(
      id = "virtualerp-accounts",
      title = "Accounts",
      icon = DocumentChartBarOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-accounts-payable",
      title = "Accounts Payable",
      icon = DocumentArrowUpOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-accounts-receivables",
      title = "Accounts Receivables",
      icon = DocumentArrowDownOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-assets",
      title = "Assets",
      icon = ComputerDesktopOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-benefits",
      title = "Benefits",
      icon = CakeOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-budgets",
      title = "Budgets",
      icon = DocumentChartBarOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-campaigns",
      title = "Campaigns",
      icon = MegaphoneOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-companies",
      title = "Companies",
      icon = BuildingStorefrontOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-contacts",
      title = "Contacts",
      icon = IdentificationOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-content",
      title = "Content",
      icon = HashtagOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-cost-centres",
      title = "Cost Centres",
      icon = RectangleGroupOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-customers",
      title = "Customers",
      icon = UserOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-departments",
      title = "Departments",
      icon = RectangleGroupOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-deliveries",
      title = "Deliveries",
      icon = TruckOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-employees",
      title = "Employees",
      icon = UserGroupOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-facilities",
      title = "Facilities",
      icon = BuildingOfficeOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-financial-statements",
      title = "Financial Statements",
      icon = DocumentChartBarOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-interactions",
      title = "Interactions",
      icon = ChatBubbleLeftRightOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-interviews",
      title = "Interviews",
      icon = ChatBubbleLeftOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-inventory",
      title = "Inventory",
      icon = BeakerOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-invoices",
      title = "Invoices",
      icon = DocumentTextOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-jobs",
      title = "Jobs",
      icon = UserPlusOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-leads",
      title = "Leads",
      icon = InboxOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-leave-requests",
      title = "Leave Requests",
      icon = PauseOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-metrics",
      title = "Metrics",
      icon = ChartPieOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-orders",
      title = "Orders",
      icon = ShoppingBagOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-organizational-units",
      title = "Organizational Units",
      icon = RectangleGroupOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-opportunities",
      title = "Opportunities",
      icon = SquaresPlusOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-policies",
      title = "Products",
      icon = ListBulletOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-positions",
      title = "Products",
      icon = SquaresPlusOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-products",
      title = "Products",
      icon = PaintBrushOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-prospects",
      title = "Prospects",
      icon = UserPlusOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-regulations",
      title = "Regulations",
      icon = ScaleOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-requests",
      title = "Requests",
      icon = WrenchOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-sales-orders",
      title = "Sales Orders",
      icon = ReceiptPercentOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-segments",
      title = "Segments",
      icon = TagOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-spaces",
      title = "Spaces",
      icon = BuildingStorefrontOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-support-tickets",
      title = "Support Tickets",
      icon = TicketOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-training",
      title = "Training",
      icon = PresentationChartLineOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-vendors",
      title = "Vendors",
      icon = WindowOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-visitors",
      title = "Visitors",
      icon = UsersOutlineIcon(),
      category = "ERP",
    ),
    Integration(
      id = "virtualerp-web-analytics",
      title = "Web Analytics",
      icon = GlobeAsiaAustraliaOutlineIcon(),
      category = "ERP",
    ),    
    Integration(
      id = "waiteraid",
      title = "WaiterAid",
      category = "Other",
      description = Some(""),
      openUrl = Some("#")
    ),
    Integration(
      id = "weatherstack",
      title = "Weatherstack",
      category = "Other",
      description = Some("Weather data service providing real-time weather information through an API."),
      openUrl = Some("#")
    ),
    Integration(
      id = "webflow",
      title = "Webflow",
      category = "Productivity",
      description = Some("Design tool that allows users to design, build, and launch responsive websites visually."),
      openUrl = Some("https://webflow.com/design/$id")
    ),
    Integration(
      id = "wikipedia-pageviews",
      title = "Wikipedia Pageviews",
      category = "Other",
      description = Some("API or tool to access statistics on Wikipedia page views and traffic."),
      openUrl = Some("https://en.wikipedia.org/wiki?curid=$id")
    ),
    Integration(
      id = "woocommerce",
      title = "WooCommerce",
      category = "Shopping",
      description = Some("Open-source e-commerce plugin for WordPress, enabling online store functionality."),
      openUrl = Some("https://$domain/?post_type=product&p=$id")
    ),
    Integration(
      id = "workable",
      title = "Workable",
      category = "Human Resources",
      description = Some("Recruiting software that streamlines the hiring process from posting jobs to interviewing candidates."),
      openUrl = Some("https://$subdomain.workable.com/jobs/$id")
    ),
    Integration(
      id = "workramp",
      title = "WorkRamp",
      category = "Human Resources",
      description = Some("Training platform for employee onboarding, development, and continuous learning."),
      openUrl = Some("#")
    ),
    Integration(
      id = "wrike",
      title = "Wrike",
      category = "Project Management",
      description = Some("Collaborative work management platform with tools for planning, tracking, and reporting on projects."),
      openUrl = Some("https://www.wrike.com/workspace.htm?acc=$account#path=folder&id=$id")
    ),
    Integration(
      id = "xero",
      title = "Xero",
      category = "Finance",
      description = Some("Cloud-based accounting software for small and medium-sized businesses."),
      openUrl = Some("https://go.xero.com/Dashboard/$id OR https://go.xero.com/Contacts/View/$id")
    ),
    Integration(
      id = "yandex-metrics",
      title = "Yandex Metrics",
      category = "Product",
      description = Some("Web analytics service provided by Yandex, offering detailed statistics of user activity."),
      openUrl = Some("https://metrica.yandex.com/dashboard?id=$id")
    ),
    Integration(
      id = "yotpo",
      title = "Yotpo",
      category = "Marketing",
      description = Some("User-generated content marketing platform that helps brands collect and showcase reviews, photos, and more."),
      openUrl = Some("https://$domain/review/$id")
    ),
    Integration(
      id = "younium",
      title = "Younium",
      category = "Finance",
      description = Some("B2B subscription management platform focusing on billing, revenue recognition, and subscription analytics."),
      openUrl = Some("")
    ),
    Integration(
      id = "youtube-analytics",
      title = "YouTube Analytics",
      category = "Marketing",
      description = Some("Suite of tools and reporting for tracking performance and metrics on YouTube."),
      openUrl = Some("https://studio.youtube.com/video/$id/analytics")
    ),
    Integration(
      id = "zendesk-chat",
      title = "Zendesk Chat",
      category = "Customer",
      description = Some("Live chat support solution part of Zendesk's suite of customer service products."),
      openUrl = Some("https://dashboard.zopim.com/?sid=$id")
    ),
    Integration(
      id = "zendesk-sell",
      title = "Zendesk Sell",
      category = "Sales",
      description = Some("Sales CRM software designed to enhance productivity, processes, and pipeline visibility."),
      openUrl = Some("https://$subdomain.zendesk.com/sell/leads/$id")
    ),
    Integration(
      id = "zendesk-sunshine",
      title = "Zendesk Sunshine",
      category = "Marketing",
      description = Some("Customizable and open CRM platform within the Zendesk suite."),
      openUrl = Some("")
    ),
    Integration(
      id = "zendesk-support",
      title = "Zendesk Support",
      category = "Customer",
      description = Some("Customer Success ticketing system and service software provided by Zendesk."),
      openUrl = Some("https://$subdomain.zendesk.com/agent/tickets/$id")
    ),
    Integration(
      id = "zendesk-talk",
      title = "Zendesk Talk",
      category = "Customer",
      description = Some("Call center solution allowing customer service teams to provide phone support from the Zendesk interface."),
      openUrl = Some("https://$subdomain.zendesk.com/agent/tickets/$id")
    ),
    Integration(
      id = "zenefits",
      title = "Zenefits",
      category = "Human Resources",
      description = Some("Cloud-based software for managing human resources, payroll, benefits, and more."),
      openUrl = Some("#")
    ),
    Integration(
      id = "zenloop",
      title = "Zenloop",
      category = "Customer",
      description = Some("Customer feedback platform focusing on the Net Promoter Score (NPS) system."),
      openUrl = Some("#")
    ),
    Integration(
      id = "zoho-crm",
      title = "Zoho CRM",
      category = "Sales",
      description = Some("Customer relationship management software by Zoho, designed for managing sales, marketing, and support."),
      openUrl = Some("https://crm.zoho.com/crm/$organisation/tab/Leads/$id")
    ),
    Integration(
      id = "zoom",
      title = "Zoom",
      category = "Productivity",
      description = Some("Popular video conferencing platform used for virtual meetings, webinars, and collaboration."),
      openUrl = Some("https://zoom.us/j/$id")
    ),
    Integration(
      id = "zuora",
      title = "Zuora",
      category = "Finance",
      description = Some("Subscription billing, commerce, and finance platform for subscription-based businesses."),
      openUrl = Some("https://www.zuora.com/apps/$id")
    )
  )

  val integrationItems = list.map(l => l.id -> l).toMap

  def get(id: String) = {
    if (!integrationItems.contains(id)) {
      println("Integration not found with id: " + id)
    }
    integrationItems(id)
  }
}