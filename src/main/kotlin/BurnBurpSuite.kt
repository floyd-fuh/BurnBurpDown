import burp.api.montoya.MontoyaApi
import burp.api.montoya.burpsuite.TaskExecutionEngine

class BurnBurpSuite(val api: MontoyaApi) {

    fun run(){
        val logging = api.logging()
        val burpsuite = api.burpSuite()
        logging.logToOutput(burpsuite.commandLineArguments().joinToString(" "))
        try {
            burpsuite.exportProjectOptionsAsJson(null)
            throw Exception("burpsuite.exportProjectOptionsAsJson(null)")
        }catch (e: NullPointerException){
            logging.logToOutput("Good, argument to exportProjectOptionsAsJson shouldn't be null...")
        }
        try {
            burpsuite.exportProjectOptionsAsJson("BurnBurpDown", null)
            throw Exception("burpsuite.exportProjectOptionsAsJson(\"BurnBurpDown\", null)")
        }catch (e: NullPointerException){
            logging.logToOutput("Good, argument to exportProjectOptionsAsJson shouldn't be null...")
        }
        try {
            burpsuite.exportUserOptionsAsJson(null)
            throw Exception("burpsuite.exportUserOptionsAsJson(null)")
        }catch (e: NullPointerException){
            logging.logToOutput("Good, argument to exportUserOptionsAsJson shouldn't be null...")
        }
        try {
            burpsuite.exportUserOptionsAsJson("BurnBurpDown", null)
            throw Exception("burpsuite.exportUserOptionsAsJson(\"BurnBurpDown\", null)")
        }catch (e: NullPointerException){
            logging.logToOutput("Good, argument to exportUserOptionsAsJson shouldn't be null...")
        }

        try {
            burpsuite.importProjectOptionsFromJson(null)
            throw Exception("burpsuite.importProjectOptionsFromJson(null)")
        }catch (e: Exception){ //TODO: throws burp.Zzny in 2024.7.4-31588... directly uncatchable for Extension developers as name changes on every new release
            logging.logToOutput("Good, argument to importProjectOptionsFromJson shouldn't be null...")
        }
        try {
            burpsuite.importProjectOptionsFromJson("[null, ]")
            throw Exception("burpsuite.importProjectOptionsFromJson(\"[null, ]\")")
        }catch (e: Exception){ //TODO: throws burp.Zzny in 2024.7.4-31588... directly uncatchable for Extension developers as name changes on every new release
            logging.logToOutput("Good, argument to importProjectOptionsFromJson shouldn't be an array of null...")
        }

        try {
            burpsuite.importUserOptionsFromJson(null)
            throw Exception("burpsuite.importUserOptionsFromJson(null)")
        }catch (e: Exception){
            logging.logToOutput("Good, argument to importUserOptionsFromJson shouldn't be null...")
        }
        try {
            burpsuite.importUserOptionsFromJson("[null, ]")
            throw Exception("burpsuite.importUserOptionsFromJson(\"[null, ]\")")
        }catch (e: Exception){
            logging.logToOutput("Good, argument to importUserOptionsFromJson shouldn't be an array of null...")
        }

        //burpsuite.shutdown() // yeah, no
        val version = burpsuite.version()
        logging.logToOutput(version.toString())
        logging.logToOutput(version.buildNumber().toString())
        logging.logToOutput(version.edition().toString())
        logging.logToOutput(version.name())


        val taskExecutionEngine = burpsuite.taskExecutionEngine()
        logging.logToOutput(taskExecutionEngine.state.toString())
        taskExecutionEngine.state = TaskExecutionEngine.TaskExecutionEngineState.RUNNING
        try {
            taskExecutionEngine.state = null
            throw Exception("taskExecutionEngine.setState()")
        }catch (e: NullPointerException) {
            logging.logToOutput("Good, argument to taskExecutionEngine.setState() shouldn't be null...")
        }
    }
}