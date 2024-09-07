package extension

import burp.api.montoya.extension.ExtensionUnloadingHandler
import helpers.ExceptionThrower

class BurnExtensionUnloadingHandler: ExtensionUnloadingHandler {
    val exceptionThrower = ExceptionThrower()
    override fun extensionUnloaded(){
        exceptionThrower.throwIfNotDone("ExtensionUnloadingHandler.extensionUnloaded")
    }
}