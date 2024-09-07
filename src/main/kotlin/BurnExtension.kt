import extension.BurnExtensionUnloadingHandler
import burp.api.montoya.MontoyaApi

class BurnExtension(val api: MontoyaApi) {

    fun run(){
        val logging = api.logging()
        val extension = api.extension()
        try {
            extension.setName(null)
            throw Exception("extension.setName(null)")
        }catch (e: IllegalArgumentException){
            logging.logToOutput("Good, extension name shouldn't be null...")
        }
        extension.setName("BurnBurpDown".repeat(STRING_REPEAT_CONSTANT))
        extension.setName("BurnBurpDown")
        logging.logToOutput(extension.filename())
        logging.logToOutput(extension.isBapp().toString())
        try {
            extension.registerUnloadingHandler(null)
            throw Exception("extension.registerUnloadingHandler(null)")
        }catch (e: IllegalArgumentException){
            logging.logToOutput("Good, UnloadingHandler shouldn't be null...")
        }
        extension.registerUnloadingHandler(BurnExtensionUnloadingHandler())
        //extension.unload() // yeah, no
    }
}