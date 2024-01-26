package com.harana.search.client.models

object Integrations {

  val list = List(
    Integration(
      id = "activecampaign",
      title = "ActiveCampaign",
      category = "Marketing",
      description = "Customer experience automation platform that offers email marketing, automation, sales automation, and CRM functionalities, enabling businesses to connect and engage with their customers.",
      openUrl = "https://$account.activehosted.com/admin/campaigns/edit?id=$campaign_id"
    ),
    Integration(
      id = "adjust",
      title = "Adjust",
      category = "Product",
      description = "End-to-end solution for every stage of the app marketing journey.",
      openUrl = "https://app.adjust.com/$entity-type/$entity-id"
    ),
    Integration(
      id = "aha",
      title = "Aha!",
      category = "Product",
      description = "Product roadmap software that helps businesses define their strategy, create visual roadmaps, and manage releases and ideas, emphasizing on alignment with company goals.",
      openUrl = "https://$domain.aha.io/$feature-type/$id"
    ),
    Integration(
      id = "aircall",
      title = "Aircall",
      category = "Customer",
      description = "Cloud-based phone system designed for teams like Customer Success or sales, providing seamless integration with various CRM and helpdesk tools.",
      openUrl = "https://app.aircall.io/calls/$id"
    ),
    Integration(
      id = "airtable",
      title = "Airtable",
      category = "Productivity",
      description = "Cloud collaboration service that functions like a spreadsheet but gives the power of a database, enabling teams to organize work and share information easily.",
      openUrl = "https://airtable.com/$base/$table/$record"
    ),
    Integration(
      id = "alloydb",
      title = "AllowDB",
      category = "Engineering",
      description = "Fully managed PostgreSQL-compatible database service for your most demanding enterprise database workloads.",
      openUrl = "https://app.alloydb.com/$id"
    ),
    Integration(
      id = "alpha-vantage",
      title = "Alpha Vantage",
      category = "Finance",
      description = "APIs for real-time and historical data on stocks, physical currencies, digital/crypto currencies, and technical indicators, catering to various developers and investors.",
      openUrl = "https://www.alphavantage.co/$symbol"
    ),
    Integration(
      id = "amazon-ads",
      title = "Amazon Ads",
      category = "Marketing",
      description = "Suite of advertising products by Amazon that allow vendors, sellers, and authors to promote their products and brands on Amazon's platforms, enhancing visibility and sales.",
      openUrl = "https://ads.amazon.com/adgroups/$id"
    ),
    Integration(
      id = "amazon-seller-partner",
      title = "Amazon Seller Partner",
      category = "Sales",
      description = "A program by Amazon that allows merchants to sell their products on Amazon's platforms, providing various tools and services to enhance their business.",
      openUrl = "https://sellercentral.amazon.com/orders/detail?orderID=$id"
    ),
    Integration(
      id = "amazon-sqs",
      title = "Amazon SQS",
      category = "Engineering",
      description = "A fully managed message queuing service by Amazon Web Services that enables the decoupling and scaling of microservices, distributed systems, and serverless applications.",
      openUrl = "https://console.aws.amazon.com/sqs/v2/home?region=$region#/queues/$id"
    ),
    Integration(
      id = "amplitude",
      title = "Amplitude",
      category = "Product",
      description = "Analytics platform that helps businesses understand user behavior, offering insights to enhance user engagement and retention.",
      openUrl = "https://analytics.amplitude.com/$project/events/$event"
    ),
    Integration(
      id = "apify-dataset",
      title = "Apify Dataset",
      category = "Engineering",
      description = "A part of Apify, a web scraping and automation platform, that allows users to store and manage data extracted from websites.",
      openUrl = "https://api.apify.com/v2/datasets/$id/items"
    ),
    Integration(
      id = "appfollow",
      title = "AppFollow",
      category = "Product",
      description = "Tool that provides analytics and app management functionalities, allowing businesses to track app performance across various platforms.",
      openUrl = "https://watch.appfollow.io/apps/$id"
    ),
    Integration(
      id = "appsflyer",
      title = "AppsFlyer",
      category = "Marketing",
      description = "Mobile attribution and marketing analytics platform that enables marketers to analyze and optimize their users' acquisition funnel.",
      openUrl = ""
    ),
    Integration(
      id = "asana",
      title = "Asana",
      category = "Project Management",
      description = "Helps teams organize, track, and manage their work, tasks and project management.",
      openUrl = "https://app.asana.com/0/$id"
    ),
    Integration(
      id = "ashby",
      title = "Ashby",
      category = "Human Resources",
      description = "All-in-one recruiting software consolidates your ATS, Analytics, Scheduling, and CRM.",
      openUrl = "https://ashby.com/resource/$id"
    ),
    Integration(
      id = "auth0",
      title = "Auth0",
      category = "Engineering",
      description = "Identity platform that provides authentication and authorization services.",
      openUrl = "https://manage.auth0.com/dashboard/us/$tenant/users/$id"
    ),
    Integration(
      id = "aws-cloudtrail",
      title = "AWS CloudTrail",
      category = "Engineering",
      description = "Amazon Web Service that enables governance, compliance, operational auditing, and risk auditing of your AWS account.",
      openUrl = "#"
    ),
    Integration(
      id = "azure-blob-storage",
      title = "Azure Blob Storage",
      category = "Engineering",
      description = "Object storage solution for the cloud, allowing unstructured data storage and serving of large amounts of data.",
      openUrl = "https://$account.blob.core.windows.net/$container/$blob"
    ),
    Integration(
      id = "azure-table",
      title = "Azure Table",
      category = "Engineering",
      description = "NoSQL data store for semi-structured data, providing a key/attribute store with a schema-less design.",
      openUrl = "https://portal.azure.com/#resource/subscriptions/$subscriptionId/resourceGroups/$resourceGroup/providers/Microsoft.Storage/storageAccounts/$storageAccount/tableServices/default/tables/$id"
    ),
    Integration(
      id = "babelforce",
      title = "Babelforce",
      category = "Customer",
      description = "No-code integration platform for customer service processes, automating call flows and other interactions.",
      openUrl = "#"
    ),
    Integration(
      id = "bamboo-Human Resources",
      title = "BambooHR",
      category = "Human Resources",
      description = "Human resources software that offers an online HR management system focusing on the employee lifecycle.",
      openUrl = "https://$domain.bambooHuman Resources.com/employees/employee.php?id=$id"
    ),
    Integration(
      id = "bigcommerce",
      title = "BigCommerce",
      category = "Shopping",
      description = "eCommerce platform that provides merchants with tools to create, manage, and scale an online store.",
      openUrl = "https://store-$id.mybigcommerce.com"
    ),
    Integration(
      id = "bigquery",
      title = "BigQuery",
      category = "Engineering",
      description = "Google's fully-managed, serverless data warehouse that enables super-fast SQL queries using the processing power of Google's infrastructure.",
      openUrl = "https://console.cloud.google.com/bigquery?project=$projectId&d=$datasetId&t=$id&p=$projectId&page=table"
    ),
    Integration(
      id = "bing-ads",
      title = "Bing Ads",
      category = "Marketing",
      description = "Service that provides pay-per-click advertising on both the Bing and Yahoo! search engines.",
      openUrl = "https://ui.ads.microsoft.com/adcampaigns/adcampaign/$id"
    ),
    Integration(
      id = "braintree",
      title = "Braintree",
      category = "Finance",
      description = "Full-stack payment platform known for its ease of integration, enabling companies to accept, process, and split payments in their mobile apps or websites.",
      openUrl = "https://www.braintreepayments.com/transaction/$id"
    ),
    Integration(
      id = "braze",
      title = "Braze",
      category = "Marketing",
      description = "Customer engagement platform that delivers messaging experiences across push, email, apps, and more.",
      openUrl = "#"
    ),
    Integration(
      id = "breezometer",
      title = "Breezometer",
      category = "Other",
      description = "Provider of air quality data and insights, offering APIs to businesses to include real-time air quality information in their products or services.",
      openUrl = "https://api.breezometer.com/resource/?apikey=$apiKey&id=$id"
    ),
    Integration(
      id = "callrail",
      title = "CallRail",
      category = "Sales",
      description = "Platform that tracks and manages phone calls and leads for businesses, providing insights into marketing campaigns.",
      openUrl = "https://app.callrail.com/calls/$id"
    ),
    Integration(
      id = "captain-data",
      title = "Captain Data",
      category = "Engineering",
      description = "Automation platform that helps in scraping and extracting data from various online sources.",
      openUrl = "#"
    ),
    Integration(
      id = "chargebee",
      title = "Chargebee",
      category = "Finance",
      description = "Subscription billing and revenue management platform designed to automate revenue operations of subscription-based businesses.",
      openUrl = "https://$domain.chargebee.com/customers/$id"
    ),
    Integration(
      id = "chargify",
      title = "Chargify",
      category = "Finance",
      description = "Billing software that specializes in recurring billing and subscription management.",
      openUrl = "https://$subdomain.chargify.com/subscriptions/$id"
    ),
    Integration(
      id = "chartmogul",
      title = "ChartMogul",
      category = "Finance",
      description = "Analytics platform that helps subscription businesses measure, understand, and grow their recurring revenue.",
      openUrl = "https://app.chartmogul.com/$accountId/subscriptions/$id"
    ),
    Integration(
      id = "clickhouse",
      title = "ClickHouse",
      category = "Engineering",
      description = "Open-source columnar database management system that allows real-time query processing suitable for OLAP.",
      openUrl = "https://clickhouse.$domain/tables/$id"
    ),
    Integration(
      id = "clickup-api",
      title = "ClickUp API",
      category = "Project Management",
      description = "Set of APIs that allows developers to integrate with ClickUp, a productivity tool designed to centralize tasks, docs, goals, and more.",
      openUrl = "https://api.clickup.com/api/v2/item/$id"
    ),
    Integration(
      id = "clockify",
      title = "Clockify",
      category = "Productivity",
      description = "Time-tracking tool that enables teams to track work hours across projects.",
      openUrl = "https://clockify.me/tracker/$id"
    ),
    Integration(
      id = "close-com",
      title = "Close.com",
      category = "Sales",
      description = "Sales engagement CRM designed to help salespeople dramatically increase their reach and productivity.",
      openUrl = "https://app.close.com/lead/$id"
    ),
    Integration(
      id = "cockroachdb",
      title = "CockroachDB",
      category = "Engineering",
      description = "Distributed SQL database that provides horizontal scaling and strong consistency across globally distributed data centers.",
      openUrl = "https://cockroachdb.$domain/databases/$id"
    ),
    Integration(
      id = "coda",
      title = "Coda",
      category = "Productivity",
      description = "Document editing platform that combines the functionality of word processing, spreadsheets, and databases.",
      openUrl = "https://coda.io/d/$documentName_d$id"
    ),
    Integration(
      id = "coin-api",
      title = "CoinAPI",
      category = "Finance",
      description = "All-in-one API providing information on various cryptocurrencies from multiple exchanges.",
      openUrl = "https://rest.coinapi.io/v1/symbols?id=$id"
    ),
    Integration(
      id = "coingecko-coins",
      title = "CoinGecko Coins",
      category = "Finance",
      description = "CoinGecko's API for retrieving information about various cryptocurrencies.",
      openUrl = "https://www.coingecko.com/en/coins/$id"
    ),
    Integration(
      id = "coinmarketcap",
      title = "CoinMarketCap",
      category = "Finance",
      description = "Website that provides various statistics and information on cryptocurrencies, including market capitalization, trading volume, and more.",
      openUrl = "https://coinmarketcap.com/currencies/$id"
    ),
    Integration(
      id = "commercetools",
      title = "commercetools",
      category = "Shopping",
      description = "Cloud-native, headless commerce platform offering APIs for building unique and engaging digital commerce applications.",
      openUrl = "https://mc.commercetools.com/$projectName/products/$id"
    ),
    Integration(
      id = "configcat",
      title = "ConfigCat",
      category = "Technoylog",
      description = "Feature flag and configuration management service that enables teams to roll out new features gradually.",
      openUrl = "https://app.configcat.com/feature-flag/$id"
    ),
    Integration(
      id = "confluence",
      title = "Confluence",
      category = "Productivity",
      description = "Collaboration tool by Atlassian that allows teams to create, share, and collaborate on projects in one place.",
      openUrl = "https://$domain.atlassian.net/wiki/spaces/$space/pages/$id"
    ),
    Integration(
      id = "convertkit",
      title = "ConvertKit",
      category = "Marketing",
      description = "Email marketing platform tailored for creators, offering tools to build connections with their audience.",
      openUrl = "https://app.convertkit.com/subscribers/$id"
    ),
    Integration(
      id = "copper",
      title = "Copper",
      category = "Sales",
      description = "CRM solution designed to help businesses build relationships and manage leads, specifically integrating with G Suite.",
      openUrl = "https://app.copper.com/lead/$id"
    ),
    Integration(
      id = "courier",
      title = "Courier",
      category = "Engineering",
      description = "Notification orchestration tool allowing developers to design and deliver user notifications across various channels.",
      openUrl = "https://api.courier.com/resource/$id"
    ),
    Integration(
      id = "datadog",
      title = "Datadog",
      category = "Engineering",
      description = "Monitoring and analytics platform that provides full-stack observability and business insights across hybrid multi-cloud environments.",
      openUrl = "https://app.datadoghq.com/dashboard/$id"
    ),
    Integration(
      id = "datascope",
      title = "Datascope",
      category = "Finance",
      description = "",
      openUrl = "https://app.datascopeanalytics.com/datasets/$id"
    ),
    Integration(
      id = "delighted",
      title = "Delighted",
      category = "Customer",
      description = "Customer feedback platform that utilizes the Net Promoter System, enabling businesses to gather and analyze customer feedback.",
      openUrl = "https://delighted.com/dashboard/responses/$id"
    ),
    Integration(
      id = "dixa",
      title = "Dixa",
      category = "Customer",
      description = "Customer service platform that allows businesses to engage with customers through various channels like phone, email, chat, and social media.",
      openUrl = "https://app.dixa.io/conversation/$id"
    ),
    Integration(
      id = "dockerhub",
      title = "Docker Hub",
      category = "Engineering",
      description = "Cloud-based registry service that allows developers to link code repositories, build, and store container images.",
      openUrl = "https://hub.docker.com/r/$username/$repository"
    ),
    Integration(
      id = "dremio",
      title = "Dremio",
      category = "Engineering",
      description = "Data lake engine that allows querying data across various sources, such as data lakes, relational and NoSQL databases, providing a unified data view.",
      openUrl = "https://dremio.$domain/project/$id"
    ),
    Integration(
      id = "drift",
      title = "Drift",
      category = "Marketing",
      description = "Conversational marketing and sales platform that connects businesses with the best leads in real-time.",
      openUrl = "https://app.drift.com/inboxes/$id"
    ),
    Integration(
      id = "dv-360",
      title = "DV 360",
      category = "Advertising",
      description = "Display & Video 360, Google's unified programmatic advertising platform that helps with planning, creative, buying, and measurement.",
      openUrl = "https://displayvideo.google.com/lineitem/$id"
    ),
    Integration(
      id = "dynamodb",
      title = "DynamoDB",
      category = "Engineering",
      description = "Amazon web service that offers a scalable and high-performance NoSQL database with seamless throughput and storage scaling.",
      openUrl = "https://console.aws.amazon.com/dynamodb/home?region=$region#tables:selected=$tableName;tab=items;item:id=$id"
    ),
    Integration(
      id = "elasticsearch",
      title = "Elasticsearch",
      category = "Engineering",
      description = "Distributed search and analytics engine that enables real-time search and data analysis functionalities.",
      openUrl = "http://elasticsearch.$domain/$index/$type/$id"
    ),
    Integration(
      id = "emailoctopus",
      title = "EmailOctopus",
      category = "Marketing",
      description = "Email marketing platform that allows users to send email newsletters, campaigns, and automated responses.",
      openUrl = "https://app.emailoctopus.com/a/dashboard/campaigns/$id"
    ),
    Integration(
      id = "everhour",
      title = "Everhour",
      category = "Productivity",
      description = "Time-tracking software that integrates with project management tools, providing insights into employee work hours.",
      openUrl = "https://app.everhour.com/#/tasks/$id"
    ),
    Integration(
      id = "exchange-rates",
      title = "Exchange Rates",
      category = "Finance",
      description = "APIs or services providing real-time exchange rate information for various currencies.",
      openUrl = "https://api.exchangerates.io/latest?base=$id"
    ),
    Integration(
      id = "facebook-marketing",
      title = "Facebook Marketing",
      category = "Marketing",
      description = "Suite of tools and platforms designed to help businesses market and advertise on Facebook.",
      openUrl = "https://www.facebook.com/adsmanager/manage/campaigns?act=$id"
    ),
    Integration(
      id = "facebook-pages",
      title = "Facebook Pages",
      category = "Marketing",
      description = "Feature on Facebook that allows businesses, public figures, and organizations to create a public presence on the platform.",
      openUrl = "https://www.facebook.com/$id"
    ),
    Integration(
      id = "faker",
      title = "Faker",
      category = "Engineering",
      description = "Library that generates fake data, such as names, addresses, and phone numbers, often used for testing.",
      openUrl = "#"
    ),
    Integration(
      id = "fastbill",
      title = "FastBill",
      category = "Finance",
      description = "Online accounting software that simplifies invoicing, expenses, and financial tracking for small businesses.",
      openUrl = "https://my.fastbill.com/customer/$id"
    ),
    Integration(
      id = "fauna",
      title = "Fauna",
      category = "Engineering",
      description = "Transactional, serverless NoSQL database that provides a flexible, secure, and scalable infrastructure for modern applications.",
      openUrl = "https://dashboard.fauna.com/db/$database/collections/$id"
    ),
    Integration(
      id = "firebolt",
      title = "Firebolt",
      category = "Engineering",
      description = "Cloud-native elastic data warehousing platform designed to provide high-performance analytics at reduced costs.",
      openUrl = "https://app.firebolt.io/data/$id"
    ),
    Integration(
      id = "freshcaller",
      title = "Freshcaller",
      category = "Customer",
      description = "Cloud-based call center software by Freshworks, designed to assist Customer Success through various channels.",
      openUrl = "https://web.freshcaller.com/calls/$id"
    ),
    Integration(
      id = "freshdesk",
      title = "Freshdesk",
      category = "Customer",
      description = "Customer Success software that offers a range of customer service tools to streamline support workflows.",
      openUrl = "https://$domain.freshdesk.com/a/tickets/$id"
    ),
    Integration(
      id = "freshsales",
      title = "Freshsales",
      category = "Sales",
      description = "Sales CRM by Freshworks that helps businesses manage leads, sales processes, and customer relationships.",
      openUrl = "https://$domain.freshsales.io/leads/$id"
    ),
    Integration(
      id = "freshservice",
      title = "Freshservice",
      category = "Customer",
      description = "IT service management tool by Freshworks that provides a range of IT support and helpdesk functionalities.",
      openUrl = "https://$domain.freshservice.com/tickets/$id"
    ),
    Integration(
      id = "fullstory",
      title = "FullStory",
      category = "Product",
      description = "Digital experience analytics platform that allows organizations to replay sessions, troubleshoot issues, and understand user behavior.",
      openUrl = "https://app.fullstory.com/session/$id"
    ),
    Integration(
      id = "gainsight-px",
      title = "Gainsight PX",
      category = "Product",
      description = "Product experience platform that helps businesses analyze user behavior and drive product adoption through in-app engagement.",
      openUrl = "https://app.gainsight.com/px/$id"
    ),
    Integration(
      id = "gcs",
      title = "Google Cloud Storage",
      category = "Engineering",
      description = "Scalable and flexible object storage service offered by Google Cloud, designed for storing and accessing data.",
      openUrl = "https://console.cloud.google.com/storage/browser/$bucketId/$objectId"
    ),
    Integration(
      id = "genesys",
      title = "Genesys",
      category = "Marketing",
      description = "Omnichannel customer experience and contact center solutions, including cloud and on-premises options.",
      openUrl = "https://app.genesys.com/interaction/$id"
    ),
    Integration(
      id = "getlago",
      title = "GetLago",
      category = "Other",
      description = "",
      openUrl = "https://getlago.com/data/$id"
    ),
    Integration(
      id = "github",
      title = "GitHub",
      category = "Engineering",
      description = "Web-based platform that provides hosting for software development and a Git repository hosting service, offering collaboration features and tools.",
      openUrl = "https://github.com/$user/$repository"
    ),
    Integration(
      id = "gitlab",
      title = "GitLab",
      category = "Engineering",
      description = "Web-based Git repository manager that offers CI/CD tools and a platform for code collaboration.",
      openUrl = "https://gitlab.com/$user/$repository"
    ),
    Integration(
      id = "glassfrog",
      title = "GlassFrog",
      category = "Other",
      description = "Tool for facilitating Holacracy practices in organizations, providing a platform for transparent governance and operations.",
      openUrl = "https://app.glassfrog.com/circles/$id"
    ),
    Integration(
      id = "gnews",
      title = "GNews",
      category = "News",
      description = "Aggregates headlines from news sources worldwide, grouping similar stories together.",
      openUrl = "https://gnews.io/api/v3/search?q=$id&token=$apiKey"
    ),
    Integration(
      id = "gocardless",
      title = "GoCardless",
      category = "Finance",
      description = "Fintech company that provides a simple way to automate Direct Debit payments for businesses.",
      openUrl = "https://manage.gocardless.com/payments/$id"
    ),
    Integration(
      id = "gong",
      title = "Gong",
      category = "Sales",
      description = "Revenue intelligence platform that uses AI to analyze sales interactions and provide insights to sales teams.",
      openUrl = "https://app.gong.io/call/$id"
    ),
    Integration(
      id = "google-ads",
      title = "Google Ads",
      category = "Marketing",
      description = "Google's online advertising platform that allows businesses to display advertisements, product listings, and service offerings across Google's network.",
      openUrl = "https://ads.google.com/aw/campaigns?campaignId=$campaignId&account=$accountId"
    ),
    Integration(
      id = "google-analytics-data-api",
      title = "Google Analytics Data API",
      category = "Engineering",
      description = "Part of Google Analytics, this API allows for programmatic access to Google Analytics reporting data.",
      openUrl = "https://analyticsdata.googleapis.com/v1beta/$id"
    ),
    Integration(
      id = "google-analytics-v4",
      title = "Google Analytics v4",
      category = "Engineering",
      description = "Latest version of Google Analytics, offering improved insights and flexibility in tracking user interactions.",
      openUrl = "https://analyticsreporting.googleapis.com/v4/reports/$id"
    ),
    Integration(
      id = "google-directory",
      title = "Google Directory",
      category = "Human Resources",
      description = "Google Workspace Directory, which manages users, groups, and devices in Google Workspace.",
      openUrl = "https://www.googleapis.com/admin/directory/v1/users/$id"
    ),
    Integration(
      id = "google-pagespeed-insights",
      title = "Google PageSpeed Insights",
      category = "Engineering",
      description = "Tool that measures the performance of a web page and provides recommendations for improvement.",
      openUrl = "https://developers.google.com/speed/pagespeed/insights/?url=$id"
    ),
    Integration(
      id = "google-search-console",
      title = "Google Search Console",
      category = "Engineering",
      description = "Free service offered by Google that helps website owners monitor and troubleshoot their site's presence in Google Search results.",
      openUrl = "https://search.google.com/search-console/data/$id"
    ),
    Integration(
      id = "google-sheets",
      title = "Google Sheets",
      category = "Productivity",
      description = "Web-based application that allows users to create, update, and modify spreadsheets and share the data live online.",
      openUrl = "https://docs.google.com/spreadsheets/d/YOUR_DOCUMENT_ID/edit"
    ),
    Integration(
      id = "google-webfonts",
      title = "Google Webfonts",
      category = "Productivity",
      description = "Library that provides free access to a large collection of web fonts.",
      openUrl = "https://fonts.google.com/specimen/$font?id=$id"
    ),
    Integration(
      id = "google-workspace-admin-reports",
      title = "Google Workspace Admin Reports",
      category = "Human Resources",
      description = "Set of tools within Google Workspace that provides reports, audits, and alerts about user activity.",
      openUrl = "https://admin.googleapis.com/admin/reports/v1/activity/users/$id"
    ),
    Integration(
      id = "greenhouse",
      title = "Greenhouse",
      category = "Human Resources",
      description = "Recruiting software company that designs tools to optimize recruiting processes.",
      openUrl = "https://app.greenhouse.io/job_board/jobs/$id"
    ),
    Integration(
      id = "gridly",
      title = "Gridly",
      category = "Engineering",
      description = "Headless content management system designed for multilingual digital experiences and game content.",
      openUrl = "https://app.gridly.com/records/$id"
    ),
    Integration(
      id = "harvest",
      title = "Harvest",
      category = "Productivity",
      description = "Time-tracking software that enables individuals and teams to track the time spent on tasks and projects.",
      openUrl = "https://id.harvestapp.com/time/week/[$year/$month/$day]/$id"
    ),
    Integration(
      id = "hellobaton",
      title = "HelloBaton",
      category = "Product",
      description = "Purpose-built for managing software implementation & customer onboarding",
      openUrl = "https://app.hellobaton.com/tasks/$id"
    ),
    Integration(
      id = "hubplanner",
      title = "HubPlanner",
      category = "Project Management",
      description = "Resource management and scheduling tool that offers insights into project timelines, capacity, and resource allocation.",
      openUrl = "https://app.hubplanner.com/grid/$id"
    ),
    Integration(
      id = "hubspot",
      title = "HubSpot",
      category = "Marketing",
      description = "Inbound marketing, sales, and customer service platform that helps businesses attract, engage, and delight customers.",
      openUrl = "https://app.hubspot.com/contacts/$portalId/contact/$id"
    ),
    Integration(
      id = "insightly",
      title = "Insightly",
      category = "Sales",
      description = "Customer relationship management (CRM) tool that offers features for managing contacts, sales, projects, and emails.",
      openUrl = "https://crm.insightly.com/page/recorddetail/$id"
    ),
    Integration(
      id = "instagram",
      title = "Instagram",
      category = "Marketing",
      description = "Social media platform that allows users to share photos and videos, as well as engage with others through likes, comments, and messages.",
      openUrl = "https://www.instagram.com/p/YOUR_POST_ID/"
    ),
    Integration(
      id = "instatus",
      title = "Instatus",
      category = "Engineering",
      description = "Status page platform that allows businesses to create and manage status pages for their services and applications.",
      openUrl = "https://instatus.com/status/$id"
    ),
    Integration(
      id = "intercom",
      title = "Intercom",
      category = "Marketing",
      description = "Customer messaging platform that enables businesses to communicate with customers through various channels within a unified interface.",
      openUrl = "https://app.intercom.com/a/apps/$appId/users/$id"
    ),
    Integration(
      id = "intruder",
      title = "Intruder",
      category = "Engineering",
      description = "Cloud-based security platform that provides automated cybersecurity vulnerability assessments.",
      openUrl = "https://app.intruder.io/dashboard/vulnerabilities/$id"
    ),
    Integration(
      id = "ip2whois",
      title = "IP2Whois",
      category = "Engineering",
      description = "Service that provides WHOIS lookup for domain name registration information, often used for cybersecurity or legal purposes.",
      openUrl = "https://www.ip2whois.com/domain?id=$id"
    ),
    Integration(
      id = "iterable",
      title = "Iterable",
      category = "Marketing",
      description = "Marketing automation platform that facilitates customer engagement through various channels like email, push, and SMS.",
      openUrl = "https://app.iterable.com/marketing/campaigns/$id"
    ),
    Integration(
      id = "jira",
      title = "Jira",
      category = "Project Management",
      description = "Project management tool by Atlassian used for bug tracking, issue tracking, and agile project management.",
      openUrl = "https://your-jira-domain.atlassian.net/browse/YOUR_JIRA_ID"
    ),
    Integration(
      id = "k6-cloud",
      title = "K6 Cloud",
      category = "Engineering",
      description = "Cloud-based load testing tool used to analyze the performance of web services and APIs.",
      openUrl = "https://app.k6.io/runs/$id"
    ),
    Integration(
      id = "klarna",
      title = "Klarna",
      category = "Finance",
      description = "Swedish fintech company that provides e-commerce payment solutions, including pay later and installment options.",
      openUrl = "https://klarna.com/order/$id"
    ),
    Integration(
      id = "klaviyo",
      title = "Klaviyo",
      category = "Marketing",
      description = "Email marketing platform that provides personalized email and SMS marketing services to e-commerce businesses.",
      openUrl = "https://www.klaviyo.com/campaigns/$id"
    ),
    Integration(
      id = "kustomer-singer",
      title = "Kustomer Singer",
      category = "Customer",
      description = "Related to Kustomer, a customer service CRM platform.",
      openUrl = "https://app.kustomer.com/data/$id"
    ),
    Integration(
      id = "kyriba",
      title = "Kyriba",
      category = "Finance",
      description = "Global treasury management platform that helps manage cash, forecast liquidity, and mitigate operational and financial risk.",
      openUrl = "https://platform.kyriba.com/data/$id"
    ),
    Integration(
      id = "launchdarkly",
      title = "LaunchDarkly",
      category = "Product",
      description = "Feature management platform that enables teams to control software features through toggles, allowing gradual rollouts and A/B testing.",
      openUrl = "https://app.launchdarkly.com/default/feature-flags/$id"
    ),
    Integration(
      id = "lemlist",
      title = "Lemlist",
      category = "Marketing",
      description = "Email automation platform that allows users to send personalized cold emails at scale.",
      openUrl = "https://app.lemlist.com/campaigns/$id"
    ),
    Integration(
      id = "lever-hiring",
      title = "Lever Hiring",
      category = "Human Resources",
      description = "Recruiting software designed to streamline the hiring process, providing tools for candidate tracking and collaboration.",
      openUrl = "https://jobs.lever.co/$company/$id"
    ),
    Integration(
      id = "linkedin-ads",
      title = "LinkedIn Ads",
      category = "Sales",
      description = "LinkedIn's advertising platform that allows businesses to target specific audiences within the professional network.",
      openUrl = "https://www.linkedin.com/ad/accounts/$id/campaigns"
    ),
    Integration(
      id = "linkedin-pages",
      title = "LinkedIn Pages",
      category = "Marketing",
      description = "Business pages on LinkedIn that allow companies to engage with followers and share content.",
      openUrl = "https://www.linkedin.com/company/$id"
    ),
    Integration(
      id = "linnworks",
      title = "Linnworks",
      category = "Shopping",
      description = "Multi-channel order management and inventory management platform for e-commerce businesses.",
      openUrl = "https://app.linnworks.com/inventory/items/$id"
    ),
    Integration(
      id = "local-application",
      title = "Application",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-archive",
      title = "Archive",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-audio",
      title = "Audio",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-book",
      title = "Book",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-calendar",
      title = "Calendar",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-certificate",
      title = "Certificate",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-code",
      title = "Code",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-codeartifact",
      title = "Code Artifact",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-contact",
      title = "Contact",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-data",
      title = "Data",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-database",
      title = "Database",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-diskimage",
      title = "Disk Image",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-document",
      title = "Document",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-email",
      title = "Email",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-folder",
      title = "Folder",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-font",
      title = "Font",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-game",
      title = "Game",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-graphics",
      title = "Graphics",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-hardware",
      title = "Hardware",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-image",
      title = "Image",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-map",
      title = "Map",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-other",
      title = "Other",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-science",
      title = "Science",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-screenshot",
      title = "Screenshot",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "local-video",
      title = "Video",
      category = "Local",
      description = "",
      openUrl = ""
    ),
    Integration(
      id = "lokalise",
      title = "Lokalise",
      category = "Engineering",
      description = "Localization and translation management platform that helps teams manage multilingual content across applications and websites.",
      openUrl = "https://app.lokalise.com/project/$id"
    ),
    Integration(
      id = "looker",
      title = "Looker",
      category = "Productivity",
      description = "Business intelligence software and big data analytics platform that helps explore, analyze, and share real-time business analytics.",
      openUrl = "https://$domain.looker.com/explore/$project/$id"
    ),
    Integration(
      id = "mailchimp",
      title = "Mailchimp",
      category = "Marketing",
      description = "All-in-one marketing platform that provides email marketing services and automation tools.",
      openUrl = "https://usX.admin.mailchimp.com/campaigns/edit?id=$id"
    ),
    Integration(
      id = "mailerlite",
      title = "MailerLite",
      category = "Marketing",
      description = "Email marketing solution that offers features for creating and sending email newsletters and managing subscribers.",
      openUrl = "https://app.mailerlite.com/campaigns/$id/edit"
    ),
    Integration(
      id = "mailersend",
      title = "MailerSend",
      category = "Marketing",
      description = "Transactional email service that enables developers and businesses to send, track, and analyze emails.",
      openUrl = "https://app.mailersend.com/emails/$id"
    ),
    Integration(
      id = "mailgun",
      title = "Mailgun",
      category = "Marketing",
      description = "Email automation service providing tools for sending, receiving, and tracking emails.",
      openUrl = "https://app.mailgun.com/messages/$id"
    ),
    Integration(
      id = "mailjet-mail",
      title = "Mailjet Mail",
      category = "Marketing",
      description = "Cloud-based email delivery and tracking service that allows businesses to send marketing and transactional emails.",
      openUrl = "https://app.mailjet.com/messages/email/$id"
    ),
    Integration(
      id = "mailjet-sms",
      title = "Mailjet SMS",
      category = "Marketing",
      description = "Part of Mailjet that provides SMS marketing and notification services.",
      openUrl = "https://app.mailjet.com/messages/sms/$id"
    ),
    Integration(
      id = "marketo",
      title = "Marketo",
      category = "Marketing",
      description = "Marketing automation software that provides tools for lead management, email marketing, consumer marketing, and more.",
      openUrl = "https://app.marketo.com/lead/$id"
    ),
    Integration(
      id = "metabase",
      title = "Metabase",
      category = "Productivity",
      description = "Open-source business intelligence tool that allows users to ask questions and learn from data.",
      openUrl = "https://$domain.metabase.com/dashboard/$id"
    ),
    Integration(
      id = "microsoft-dataverse",
      title = "Microsoft Dataverse",
      category = "Productivity",
      description = "Scalable data platform and app platform in Microsoft Power Platform, providing data storage and management capabilities.",
      openUrl = "https://dataverse.microsoft.com/entities/$id"
    ),
    Integration(
      id = "microsoft-teams",
      title = "Microsoft Teams",
      category = "Productivity",
      description = "Collaboration platform that integrates with Microsoft 365, providing chat, video meetings, file storage, and application integration.",
      openUrl = "https://teams.microsoft.com/l/team/$id"
    ),
    Integration(
      id = "mixpanel",
      title = "Mixpanel",
      category = "Product",
      description = "User analytics platform that enables businesses to analyze user interactions across the entire customer journey.",
      openUrl = "https://mixpanel.com/report/$id"
    ),
    Integration(
      id = "monday",
      title = "Monday.com",
      category = "Project Management",
      description = "Work operating system that powers teams to run projects and workflows with confidence, also known as Monday.com.",
      openUrl = "https://$company.monday.com/boards/$id"
    ),
    Integration(
      id = "my-hours",
      title = "My Hours",
      category = "Human Resources",
      description = "Time tracking software that allows individuals and teams to log time spent on projects and tasks.",
      openUrl = "https://app.myhours.com/track/$id"
    ),
    Integration(
      id = "n8n",
      title = "n8n",
      category = "Productivity",
      description = "Workflow automation tool that connects various apps, devices, and services, with a strong focus on privacy and self-hosting.",
      openUrl = "https://$domain/workflow/$id"
    ),
    Integration(
      id = "nasa",
      title = "NASA",
      category = "Other",
      description = "APIs and data sets provided by NASA, it includes information about space missions, astronomical observations, and related scientific data.",
      openUrl = "https://api.nasa.gov/data/$id"
    ),
    Integration(
      id = "netsuite",
      title = "NetSuite",
      category = "Marketing",
      description = "Comprehensive cloud business software suite, including ERP, CRM, and e-commerce applications.",
      openUrl = "https://system.netsuite.com/app/common/entity/custjob.nl?id=$id"
    ),
    Integration(
      id = "news-api",
      title = "News API",
      category = "News",
      description = "JSON-based API that provides access to the latest news articles published by various sources around the world.",
      openUrl = "https://newsapi.org/v2/everything?q=$id"
    ),
    Integration(
      id = "notion",
      title = "Notion",
      category = "Productivity",
      description = "All-in-one workspace tool for notes, tasks, wikis, and databases, promoting collaboration within teams.",
      openUrl = "https://www.notion.so/$id"
    ),
    Integration(
      id = "nytimes",
      title = "NY Times",
      category = "News",
      description = "APIs offered by The New York Times, providing access to various data like articles, books, and movie reviews.",
      openUrl = "https://api.nytimes.com/svc/archive/v1/$year/$month.json?id=$id"
    ),
    Integration(
      id = "okta",
      title = "Okta",
      category = "Engineering",
      description = "Cloud-based service that provides identity and access management solutions for businesses.",
      openUrl = "https://$domain.okta.com/app/UserHome?id=$id"
    ),
    Integration(
      id = "omnisend",
      title = "Omnisend",
      category = "Marketing",
      description = "E-Commerce marketing automation platform that enables personalized and targeted email and SMS marketing.",
      openUrl = "https://app.omnisend.com/campaigns/$id"
    ),
    Integration(
      id = "onesignal",
      title = "OneSignal",
      category = "Marketing",
      description = "Service offering push notifications, in-app messages, and email to various platforms including web, mobile, and email.",
      openUrl = "https://app.onesignal.com/apps/$id"
    ),
    Integration(
      id = "open-exchange-rates",
      title = "Open Exchange Rates",
      category = "Finance",
      description = "Provides exchange rate data and currency conversion for over 200 currencies worldwide.",
      openUrl = "https://openexchangerates.org/api/latest.json?app_id=$id"
    ),
    Integration(
      id = "openweather",
      title = "OpenWeather",
      category = "Other",
      description = "Service that offers weather data, forecasts, nowcasts, and historical weather data for any location globally.",
      openUrl = "https://api.openweathermap.org/data/2.5/weather?id=$id&appid=$apiKey"
    ),
    Integration(
      id = "orbit",
      title = "Orbit",
      category = "Product",
      description = "Community experience platform that helps to build and measure community growth and engagement.",
      openUrl = "https://app.orbit.love/users/$id"
    ),
    Integration(
      id = "oura",
      title = "Oura",
      category = "Other",
      description = "Health Engineering company known for its smart ring that tracks sleep, activity, and readiness.",
      openUrl = "https://cloud.ouraring.com/user/$id"
    ),
    Integration(
      id = "outreach",
      title = "Outreach",
      category = "Sales",
      description = "Sales engagement platform that helps sales teams create, optimize, and repeat sales strategies.",
      openUrl = "https://app.outreach.io/outreach/$id"
    ),
    Integration(
      id = "pardot",
      title = "Pardot",
      category = "Marketing",
      description = "Marketing automation platform designed to create meaningful connections, generate leads, and provide ROI analysis.",
      openUrl = "https://pi.pardot.com/prospect/read/id/$id"
    ),
    Integration(
      id = "partnerstack",
      title = "PartnerStack",
      category = "Marketing",
      description = "Platform that helps companies to build partnerships with affiliates, resellers, and ambassadors to drive growth.",
      openUrl = "https://app.partnerstack.com/profile/$id"
    ),
    Integration(
      id = "paypal-transaction",
      title = "PayPal",
      category = "Finance",
      description = "PayPal's transaction APIs, enabling online payments and money transfers.",
      openUrl = "https://www.paypal.com/transaction/view?id=$id"
    ),
    Integration(
      id = "paystack",
      title = "Paystack",
      category = "Finance",
      description = "Engineering company that facilitates payments processing for businesses in Africa.",
      openUrl = "https://dashboard.paystack.com/#/transaction/$id"
    ),
    Integration(
      id = "pendo",
      title = "Pendo",
      category = "Product",
      description = "Product cloud creator for digital products and data-driven product teams.",
      openUrl = "https://app.pendo.io/page/$id"
    ),
    Integration(
      id = "persistiq",
      title = "PersistIQ",
      category = "Sales",
      description = "Sales engagement platform that automates and personalizes outbound sales campaigns.",
      openUrl = "https://app.persistiq.com/leads/$id"
    ),
    Integration(
      id = "pexels-api",
      title = "Pexels API",
      category = "Other",
      description = "Access to high-quality free stock photos and videos hosted on Pexels.",
      openUrl = "https://api.pexels.com/v1/photos/$id"
    ),
    Integration(
      id = "pinterest",
      title = "Pinterest",
      category = "Marketing",
      description = "Social media platform that allows users to discover, save, and share visual inspirations and ideas.",
      openUrl = "https://www.pinterest.com/pin/$id"
    ),
    Integration(
      id = "pipedrive",
      title = "Pipedrive",
      category = "Sales",
      description = "CRM and pipeline management tool that helps sales teams manage leads and deals.",
      openUrl = "https://$domain.pipedrive.com/deal/$id"
    ),
    Integration(
      id = "pivotal-tracker",
      title = "Pivotal Tracker",
      category = "Project Management",
      description = "Agile project management tool that supports software development collaboration.",
      openUrl = "https://www.pivotaltracker.com/story/show/$id"
    ),
    Integration(
      id = "plaid",
      title = "Plaid",
      category = "Finance",
      description = "Engineering platform that enables applications to connect with users’ bank accounts.",
      openUrl = "https://api.plaid.com/data/$id"
    ),
    Integration(
      id = "plausible",
      title = "Plausible",
      category = "Engineering",
      description = "Privacy-focused website analytics service.",
      openUrl = "https://plausible.io/stats/$id"
    ),
    Integration(
      id = "pocket",
      title = "Pocket",
      category = "Productivity",
      description = "Application that allows users to save articles, videos, and other content for later viewing.",
      openUrl = "https://getpocket.com/read/$id"
    ),
    Integration(
      id = "pokeapi",
      title = "PokéAPI",
      category = "Other",
      description = "API that provides access to detailed data on Pokémon characters, types, abilities, and more.",
      openUrl = "https://pokeapi.co/api/v2/pokemon/$id"
    ),
    Integration(
      id = "polygon-stock-api",
      title = "Polygon Stock API",
      category = "Finance",
      description = "Offers real-time and historic market data, including stocks, commodities, and cryptocurrencies.",
      openUrl = "https://api.polygon.io/v1/meta/symbols/$ticket/company?apiKey=$apiKey"
    ),
    Integration(
      id = "posthog",
      title = "PostHog",
      category = "Product",
      description = "Open-source product analytics platform that helps understand user behavior.",
      openUrl = "https://app.posthog.com/event/$id"
    ),
    Integration(
      id = "postmarkapp",
      title = "Postmarkapp",
      category = "Marketing",
      description = "Email service provider focused on delivering transactional emails quickly and reliably.",
      openUrl = "https://account.postmarkapp.com/messages/$id"
    ),
    Integration(
      id = "prestashop",
      title = "PrestaShop",
      category = "Shopping",
      description = "Open-source e-commerce platform allowing businesses to create and manage an online store.",
      openUrl = "https://$domain/index.php?id_product=$id&controller=product"
    ),
    Integration(
      id = "primetric",
      title = "Primetric",
      category = "Other",
      description = "",
      openUrl = "https://app.primetric.com/project/$id"
    ),
    Integration(
      id = "public-apis",
      title = "Public APIs",
      category = "Other",
      description = "Collective list of free APIs for development, testing, and fun creative projects.",
      openUrl = "https://public-apis.io/data/$id"
    ),
    Integration(
      id = "punk-api",
      title = "Punk API",
      category = "Other",
      description = "API that provides information about different beers, including ingredients, methods, and tips.",
      openUrl = "https://api.punkapi.com/v2/beers/$id"
    ),
    Integration(
      id = "pypi",
      title = "PyPI",
      category = "Engineering",
      description = "Repository of software packages for the Python programming language.",
      openUrl = "https://pypi.org/project/$package/$id/"
    ),
    Integration(
      id = "qonto",
      title = "Qonto",
      category = "Finance",
      description = "European neobank that offers online banking services to businesses and freelancers.",
      openUrl = "https://my.qonto.com/transactions/$id"
    ),
    Integration(
      id = "qualaroo",
      title = "Qualaroo",
      category = "Product",
      description = "Tool for gathering and analyzing user feedback through targeted surveys and insights.",
      openUrl = "https://app.qualaroo.com/responses/$id"
    ),
    Integration(
      id = "quickbooks",
      title = "QuickBooks",
      category = "Finance",
      description = "Accounting software designed to manage payroll, inventory, sales, and other small business needs.",
      openUrl = "https://qbo.intuit.com/app/invoice?txnId=$id"
    ),
    Integration(
      id = "railz",
      title = "Railz",
      category = "Finance",
      description = "Unified API to access financial data from various accounting software.",
      openUrl = "https://app.railz.com/transaction/$id"
    ),
    Integration(
      id = "rd-station-marketing",
      title = "RD Station Marketing",
      category = "Marketing",
      description = "Marketing automation platform focused on helping businesses to grow and achieve results.",
      openUrl = "https://app.rdstation.com.br/lead/$id"
    ),
    Integration(
      id = "recharge",
      title = "ReCharge",
      category = "Finance",
      description = "Subscription payments platform that allows businesses to manage recurring billing and subscriptions.",
      openUrl = "https://dashboard.rechargepayments.com/customer/$id"
    ),
    Integration(
      id = "recreation",
      title = "Recreation",
      category = "Other",
      description = "",
      openUrl = "https://app.recreation.io/event/$id"
    ),
    Integration(
      id = "recruitee",
      title = "Recruitee",
      category = "Human Resources",
      description = "Collaborative hiring platform designed to streamline the recruitment process.",
      openUrl = "https://company.recruitee.com/o/job/$id"
    ),
    Integration(
      id = "recurly",
      title = "Recurly",
      category = "Finance",
      description = "Subscription management platform providing billing, invoicing, and financial operations support.",
      openUrl = "https://$domain.recurly.com/admin/subscriptions/$id"
    ),
    Integration(
      id = "redshift",
      title = "Redshift",
      category = "Engineering",
      description = "Fully-managed, petabyte-scale data warehouse service.",
      openUrl = "https://console.redshift.aws.amazon.com/v2/data/$id"
    ),
    Integration(
      id = "reply-io",
      title = "Reply.io",
      category = "Marketing",
      description = "Automates one-to-one communication with customers across various channels.",
      openUrl = "https://app.reply.io/inbox/$id"
    ),
    Integration(
      id = "retently",
      title = "Retently",
      category = "Customer",
      description = "Measures customer satisfaction using Net Promoter Score (NPS).",
      openUrl = "https://app.retently.com/surveys/$id"
    ),
    Integration(
      id = "rocket-chat",
      title = "Rocket.Chat",
      category = "Productivity",
      description = "Open-source team collaboration platform that offers chat, video conferencing, and file sharing.",
      openUrl = "https://$domain.rocket.chat/channel/$id"
    ),
    Integration(
      id = "s3",
      title = "S3",
      category = "Engineering",
      description = "Amazon Web Services object storage service designed for scalability and low-latency access.",
      openUrl = "https://$bucket.s3.amazonaws.com/$key"
    ),
    Integration(
      id = "salesforce",
      title = "Salesforce",
      category = "Sales",
      description = "Comprehensive Customer Relationship Management (CRM) platform.",
      openUrl = "https://$domain.salesforce.com/$id"
    ),
    Integration(
      id = "salesloft",
      title = "SalesLoft",
      category = "Sales",
      description = "Sales engagement platform that helps teams to reach, qualify, and convert leads.",
      openUrl = "https://app.salesloft.com/app/leads/$id"
    ),
    Integration(
      id = "sap-fieldglass",
      title = "SAP Fieldglass",
      category = "Other",
      description = "Vendor management system for services procurement and external workforce management.",
      openUrl = "https://www.fieldglass.net/worker/$id"
    ),
    Integration(
      id = "search-metrics",
      title = "Searchmetrics",
      category = "Marketing",
      description = "Search engine optimization and online visibility platform.",
      openUrl = "https://suite.searchmetrics.com/en/research/?url=$id"
    ),
    Integration(
      id = "secoda",
      title = "Secoda",
      category = "Productivity",
      description = "Data catalog tool designed to help teams find, understand, and use data.",
      openUrl = "https://app.secoda.co/document/$id"
    ),
    Integration(
      id = "sendgrid",
      title = "SendGrid",
      category = "Marketing",
      description = "Email delivery service used to send transactional or marketing emails.",
      openUrl = "https://mc.sendgrid.com/templates/edit/$id"
    ),
    Integration(
      id = "sendinblue",
      title = "Sendinblue",
      category = "Marketing",
      description = "Marketing platform specializing in email campaigns, automation, and SMS marketing.",
      openUrl = "https://my.sendinblue.com/camp/template/$id/message/edit"
    ),
    Integration(
      id = "senseforce",
      title = "",
      category = "Other",
      description = "Industrial IoT platform designed to connect and monitor machines and processes.",
      openUrl = "https://portal.senseforce.io/data/$id"
    ),
    Integration(
      id = "sentry",
      title = "Sentry",
      category = "Engineering",
      description = "Error tracking tool that monitors and fixes crashes in real time.",
      openUrl = "https://sentry.io/organizations/$organisation/issues/$id/"
    ),
    Integration(
      id = "shopify",
      title = "Shopify",
      category = "Shopping",
      description = "Commerce platform that allows businesses to create online stores and sell products.",
      openUrl = "https://$store.myshopify.com/admin/products/$id"
    ),
    Integration(
      id = "shortio",
      title = "Short.io",
      category = "Engineering",
      description = "Platform for creating and managing short, branded links.",
      openUrl = "https://app.short.io/links/$id"
    ),
    Integration(
      id = "slack",
      title = "Slack",
      category = "Productivity",
      description = "Collaboration hub that connects work with the tools and services people need to get things done.",
      openUrl = "https://$workspace.slack.com/archives/$channelId"
    ),
    Integration(
      id = "smaily",
      title = "Smaily",
      category = "Marketing",
      description = "Email marketing service for creating, sending, and analyzing email campaigns.",
      openUrl = "https://app.smaily.com/contacts/$id"
    ),
    Integration(
      id = "smartengage",
      title = "SmartEngage",
      category = "Marketing",
      description = "Cross-channel autoresponder platform designed to increase engagement with customers.",
      openUrl = "https://app.smartengage.com/user/$id"
    ),
    Integration(
      id = "smartsheets",
      title = "Smartsheet",
      category = "Project Management",
      description = "Work management and automation platform, allowing collaboration and visualization.",
      openUrl = "https://app.smartsheet.com/sheet/$id"
    ),
    Integration(
      id = "snapchat-marketing",
      title = "Snapchat Marketing",
      category = "Marketing",
      description = "Advertising and marketing through Snapchat's platform.",
      openUrl = "https://ads.snapchat.com/ads_manager/ad_account/$id"
    ),
    Integration(
      id = "snowflake",
      title = "Snowflake",
      category = "Engineering",
      description = "Cloud data platform that allows for secure and governed access to all data.",
      openUrl = "https://console.snowflake.com/data/$id"
    ),
    Integration(
      id = "sonar-cloud",
      title = "SonarCloud",
      category = "Engineering",
      description = "Cloud service for continuous code quality inspection and maintenance.",
      openUrl = "https://sonarcloud.io/dashboard?id=$id"
    ),
    Integration(
      id = "spacex-api",
      title = "SpaceX API",
      category = "Other",
      description = "API providing access to various SpaceX data, including launches, rockets, and more.",
      openUrl = "https://api.spacexdata.com/v4/launches/$id"
    ),
    Integration(
      id = "square",
      title = "Square",
      category = "Finance",
      description = "Financial services company providing mobile payment and point-of-sale solutions.",
      openUrl = "https://squareup.com/dashboard/orders/$id"
    ),
    Integration(
      id = "statuspage",
      title = "Statuspage",
      category = "Engineering",
      description = "Communicates real-time status and incident information to users.",
      openUrl = "https://$organisation.statuspage.io/incidents/$id"
    ),
    Integration(
      id = "strava",
      title = "Strava",
      category = "Other",
      description = "Social network for athletes, focused on tracking and sharing athletic activities.",
      openUrl = "https://www.strava.com/activities/$id"
    ),
    Integration(
      id = "stripe",
      title = "Stripe",
      category = "Finance",
      description = "Payment processing solutions for online businesses.",
      openUrl = "https://dashboard.stripe.com/payments/$id"
    ),
    Integration(
      id = "survey-sparrow",
      title = "SurveySparrow",
      category = "Marketing",
      description = "Online survey and feedback collection tool designed for user engagement.",
      openUrl = "https://app.surveysparrow.com/dashboard/responses/$id"
    ),
    Integration(
      id = "surveycto",
      title = "SurveyCTO",
      category = "Product",
      description = "Mobile data collection platform used in research and monitoring and evaluation efforts.",
      openUrl = "https://www.surveycto.com/collect/responses/$id"
    ),
    Integration(
      id = "surveymonkey",
      title = "SurveyMonkey",
      category = "Product",
      description = "Online survey tool for creating and conducting public or private surveys.",
      openUrl = "https://www.surveymonkey.com/r/$id"
    ),
    Integration(
      id = "talkdesk-explore",
      title = "Talkdesk Explore",
      category = "Customer",
      description = "Analytics platform within Talkdesk, providing insights and reporting for call centers.",
      openUrl = "https://explore.talkdesk.com/call/$id"
    ),
    Integration(
      id = "tempo",
      title = "Tempo",
      category = "Productivity",
      description = "Time-tracking and productivity enhancement tool used often in project management.",
      openUrl = "https://app.tempo.io/plan/$id"
    ),
    Integration(
      id = "teradata",
      title = "Teradata",
      category = "Engineering",
      description = "Provider of database and analytics-related products, services, and solutions.",
      openUrl = "https://console.teradata.com/data/$id"
    ),
    Integration(
      id = "the-guardian-api",
      title = "The Guardian API",
      category = "News",
      description = "API providing access to articles, podcasts, and videos from The Guardian newspaper.",
      openUrl = "https://content.guardianapis.com/$id"
    ),
    Integration(
      id = "tiktok-marketing",
      title = "TikTok Marketing",
      category = "Marketing",
      description = "Advertising and marketing platform of TikTok, catering to brand promotion within the app.",
      openUrl = "https://ads.tiktok.com/marketing_api/page/ad/$id"
    ),
    Integration(
      id = "timely",
      title = "Timely",
      category = "Productivity",
      description = "Automated time-tracking tool that captures and logs time spent on various tasks.",
      openUrl = "https://app.timelyapp.com/calendar/event/[id]"
    ),
    Integration(
      id = "tmdb",
      title = "TMDb",
      category = "Other",
      description = "Movie Database (TMDb) API, offering information about movies, TV shows, and celebrities.",
      openUrl = "https://www.themoviedb.org/movie/$id"
    ),
    Integration(
      id = "todoist",
      title = "Todoist",
      category = "Productivity",
      description = "Task management application that helps users organize and prioritize their projects and daily tasks.",
      openUrl = "https://todoist.com/showTask?id=$id"
    ),
    Integration(
      id = "toggl",
      title = "Toggl",
      category = "Productivity",
      description = "Time-tracking tool designed for teams and individuals to log hours and analyze productivity.",
      openUrl = "https://toggl.com/app/time-entries/$id"
    ),
    Integration(
      id = "trello",
      title = "Trello",
      category = "Project Management",
      description = "Collaboration tool that organizes projects into boards, lists, and cards for better workflow management.",
      openUrl = "https://trello.com/c/$id"
    ),
    Integration(
      id = "trustpilot",
      title = "Trustpilot",
      category = "Customer",
      description = "Online review platform that gathers and displays customer reviews for businesses.",
      openUrl = "https://www.trustpilot.com/review/$domain?id=$id"
    ),
    Integration(
      id = "tvmaze-schedule",
      title = "TVmaze Schedule",
      category = "Other",
      description = "API that provides television schedule and programming data.",
      openUrl = "https://www.tvmaze.com/shows/$id"
    ),
    Integration(
      id = "twilio-taskrouter",
      title = "Twilio TaskRouter",
      category = "Marketing",
      description = "Twilio service for routing tasks such as calls or messages to the right worker or process.",
      openUrl = "https://www.twilio.com/console/taskrouter/workspaces/$id"
    ),
    Integration(
      id = "twilio",
      title = "Twilio",
      category = "Marketing",
      description = "Cloud communications platform that enables programmable SMS, voice, chat, and video.",
      openUrl = "https://www.twilio.com/console/$resourceType/$id"
    ),
    Integration(
      id = "twitter",
      title = "Twitter/X",
      category = "Marketing",
      description = "Social networking service where users post and interact through messages known as tweets.",
      openUrl = "https://twitter.com/i/status/$id"
    ),
    Integration(
      id = "typeform",
      title = "Typeform",
      category = "Product",
      description = "Online software service that specializes in online form building and surveys.",
      openUrl = "https://$username.typeform.com/to/$id"
    ),
    Integration(
      id = "unleash",
      title = "Unleash",
      category = "Product",
      description = "Feature management platform enabling developers to toggle features on/off dynamically",
      openUrl = ""
    ),
    Integration(
      id = "visma-economic",
      title = "Visma Economic",
      category = "Finance",
      description = "Cloud-based accounting and business management software.",
      openUrl = "https://app.economic.com/#/customers/$id"
    ),
    Integration(
      id = "vitally",
      title = "Vitally",
      category = "Customer",
      description = "Customer success platform designed to analyze and improve customer relationships and retention.",
      openUrl = ""
    ),
    Integration(
      id = "waiteraid",
      title = "WaiterAid",
      category = "Other",
      description = "",
      openUrl = "#"
    ),
    Integration(
      id = "weatherstack",
      title = "Weatherstack",
      category = "Other",
      description = "Weather data service providing real-time weather information through an API.",
      openUrl = "#"
    ),
    Integration(
      id = "webflow",
      title = "Webflow",
      category = "Productivity",
      description = "Design tool that allows users to design, build, and launch responsive websites visually.",
      openUrl = "https://webflow.com/design/$id"
    ),
    Integration(
      id = "wikipedia-pageviews",
      title = "Wikipedia Pageviews",
      category = "Other",
      description = "API or tool to access statistics on Wikipedia page views and traffic.",
      openUrl = "https://en.wikipedia.org/wiki?curid=$id"
    ),
    Integration(
      id = "woocommerce",
      title = "WooCommerce",
      category = "Shopping",
      description = "Open-source e-commerce plugin for WordPress, enabling online store functionality.",
      openUrl = "https://$domain/?post_type=product&p=$id"
    ),
    Integration(
      id = "workable",
      title = "Workable",
      category = "Human Resources",
      description = "Recruiting software that streamlines the hiring process from posting jobs to interviewing candidates.",
      openUrl = "https://$subdomain.workable.com/jobs/$id"
    ),
    Integration(
      id = "workramp",
      title = "WorkRamp",
      category = "Human Resources",
      description = "Training platform for employee onboarding, development, and continuous learning.",
      openUrl = "#"
    ),
    Integration(
      id = "wrike",
      title = "Wrike",
      category = "Project Management",
      description = "Collaborative work management platform with tools for planning, tracking, and reporting on projects.",
      openUrl = "https://www.wrike.com/workspace.htm?acc=$account#path=folder&id=$id"
    ),
    Integration(
      id = "xero",
      title = "Xero",
      category = "Finance",
      description = "Cloud-based accounting software for small and medium-sized businesses.",
      openUrl = "https://go.xero.com/Dashboard/$id OR https://go.xero.com/Contacts/View/$id"
    ),
    Integration(
      id = "yandex-metrics",
      title = "Yandex Metrics",
      category = "Product",
      description = "Web analytics service provided by Yandex, offering detailed statistics of user activity.",
      openUrl = "https://metrica.yandex.com/dashboard?id=$id"
    ),
    Integration(
      id = "yotpo",
      title = "Yotpo",
      category = "Marketing",
      description = "User-generated content marketing platform that helps brands collect and showcase reviews, photos, and more.",
      openUrl = "https://$domain/review/$id"
    ),
    Integration(
      id = "younium",
      title = "Younium",
      category = "Finance",
      description = "B2B subscription management platform focusing on billing, revenue recognition, and subscription analytics.",
      openUrl = ""
    ),
    Integration(
      id = "youtube-analytics",
      title = "YouTube Analytics",
      category = "Marketing",
      description = "Suite of tools and reporting for tracking performance and metrics on YouTube.",
      openUrl = "https://studio.youtube.com/video/$id/analytics"
    ),
    Integration(
      id = "zendesk-chat",
      title = "Zendesk Chat",
      category = "Customer",
      description = "Live chat support solution part of Zendesk's suite of customer service products.",
      openUrl = "https://dashboard.zopim.com/?sid=$id"
    ),
    Integration(
      id = "zendesk-sell",
      title = "Zendesk Sell",
      category = "Sales",
      description = "Sales CRM software designed to enhance productivity, processes, and pipeline visibility.",
      openUrl = "https://$subdomain.zendesk.com/sell/leads/$id"
    ),
    Integration(
      id = "zendesk-sunshine",
      title = "Zendesk Sunshine",
      category = "Marketing",
      description = "Customizable and open CRM platform within the Zendesk suite.",
      openUrl = ""
    ),
    Integration(
      id = "zendesk-support",
      title = "Zendesk Support",
      category = "Customer",
      description = "Customer Success ticketing system and service software provided by Zendesk.",
      openUrl = "https://$subdomain.zendesk.com/agent/tickets/$id"
    ),
    Integration(
      id = "zendesk-talk",
      title = "Zendesk Talk",
      category = "Customer",
      description = "Call center solution allowing customer service teams to provide phone support from the Zendesk interface.",
      openUrl = "https://$subdomain.zendesk.com/agent/tickets/$id"
    ),
    Integration(
      id = "zenefits",
      title = "Zenefits",
      category = "Human Resources",
      description = "Cloud-based software for managing human resources, payroll, benefits, and more.",
      openUrl = "#"
    ),
    Integration(
      id = "zenloop",
      title = "Zenloop",
      category = "Customer",
      description = "Customer feedback platform focusing on the Net Promoter Score (NPS) system.",
      openUrl = "#"
    ),
    Integration(
      id = "zoho-crm",
      title = "Zoho CRM",
      category = "Sales",
      description = "Customer relationship management software by Zoho, designed for managing sales, marketing, and support.",
      openUrl = "https://crm.zoho.com/crm/$organisation/tab/Leads/$id"
    ),
    Integration(
      id = "zoom",
      title = "Zoom",
      category = "Productivity",
      description = "Popular video conferencing platform used for virtual meetings, webinars, and collaboration.",
      openUrl = "https://zoom.us/j/$id"
    ),
    Integration(
      id = "zuora",
      title = "Zuora",
      category = "Finance",
      description = "Subscription billing, commerce, and finance platform for subscription-based businesses.",
      openUrl = "https://www.zuora.com/apps/$id"
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