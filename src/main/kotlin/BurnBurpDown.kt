import burp.api.montoya.BurpExtension
import burp.api.montoya.MontoyaApi


// Montoya API Documentation: https://portswigger.github.io/burp-extensions-montoya-api/javadoc/burp/api/montoya/MontoyaApi.html
// Montoya Extension Examples: https://github.com/PortSwigger/burp-extensions-montoya-api-examples


class BurpBurpDown: BurpExtension {
    // Uncomment this section if you wish to use persistent settings and automatic UI Generation from: https://github.com/ncoblentz/BurpMontoyaLibrary
    // Add one or more persistent settings here
    // private lateinit var exampleNameSetting : StringExtensionSetting



    override fun initialize(api: MontoyaApi?) {

        // In Kotlin, you have to explicitly define variables as nullable with a ? as in MontoyaApi? above
        // This is necessary because the Java Library allows null to be passed into this function
        // requireNotNull is a built-in Kotlin function to check for null and throw an Illegal Argument exception if it is null
        // after checking for null, the Kotlin compiler knows that any reference to api below will not = null and you no longer have to check it
        requireNotNull(api) { "api : MontoyaApi is not allowed to be null" }

        // Assign the MontoyaApi instance (not nullable) to a class instance variable to be accessible from other functions in this class
        Api.a = api
        Api.l = api.logging()

        // This will print to Burp Suite's Extension output and can be used to debug whether the extension loaded properly
        val logging = api.logging()
        logging.logToOutput("Started loading the BurnBurpDown extension...")


        // Name our extension when it is displayed inside of Burp Suite
        val extension = api.extension()
        extension.setName("BurnBurpDown")

        logging.logToOutput("\n++++++Doing tests for section extension...")
        val burnExtension = BurnExtension(api)
        burnExtension.run()

        logging.logToOutput("\n++++++Doing tests for section BurpSuite...")
        val burnBurpSuite = BurnBurpSuite(api)
        burnBurpSuite.run()

        logging.logToOutput("\n++++++Doing tests for section Scanner...")
        val burnScanner = BurnScanner(api)
        burnScanner.run()

        //TODO
        val collaborator = api.collaborator()
        //TODO
        val comparer = api.comparer()
        //TODO
        val decoder = api.decoder()
        //TODO
        val http = api.http()
        //TODO
        val intruder = api.intruder()
        //TODO
        //val logging = api.logging()
        //TODO
        val organizer = api.organizer()
        //TODO
        val persistence = api.persistence()
        //TODO
        val proxy = api.proxy()
        //TODO
        val repeater = api.repeater()




        //TODO
        val scope = api.scope()
        //TODO
        val siteMap = api.siteMap()
        //TODO
        val userInterface = api.userInterface()
        //TODO
        val utilities = api.utilities()
        //TODO
        val websockets = api.websockets()



        // See logging comment above
        val msg = "...Finished loading the extension. Looks like Burp's Montoya is still " +
                "behaving similar to Burp 2024.7.4-31588..."
        logging.logToOutput(msg)
        logging.logToError(msg)
    }
}