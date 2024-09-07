import burp.api.montoya.MontoyaApi
import burp.api.montoya.http.HttpService
import burp.api.montoya.http.message.HttpRequestResponse
import burp.api.montoya.http.message.requests.HttpRequest
import burp.api.montoya.http.message.responses.HttpResponse
import burp.api.montoya.scanner.AuditConfiguration
import burp.api.montoya.scanner.BuiltInAuditConfiguration
import scanner.BurnScanCheck

class BurnScanner(val api: MontoyaApi) {

    fun run(){
        val logging = api.logging()
        val scanner = api.scanner()
        val bChecks = scanner.bChecks()
        try {
            val bCheckImportResult = bChecks.importBCheck(null, true)
            logging.logToError(bCheckImportResult.importErrors().joinToString(", "))
            throw Exception("bChecks.importBCheck(null)")
        }catch (e: NullPointerException) {
            logging.logToError("Good, argument to bChecks.importBCheck() shouldn't be null...")
        }

        logging.logToError("Registering Scan check...")
        scanner.registerScanCheck(BurnScanCheck())

        val httpRequestHttp1 = HttpRequest.httpRequest(HttpService.httpService(REQUEST_URL), HTTP_REQUEST_STRING_GET_GIN_HTTP1)
        val httpResponseHttp1 = HttpResponse.httpResponse(HTTP_RESPONSE_STRING_GET_GIN_HTTP1)

        val httpRequestHttp2 = HttpRequest.httpRequest(HttpService.httpService(REQUEST_URL), HTTP_REQUEST_STRING_GET_GIN_HTTP2)
        val httpResponseHttp2 = HttpResponse.httpResponse(HTTP_RESPONSE_STRING_GET_GIN_HTTP2)


        logging.logToError("Starting startAudit...")
        val auditToDelete = scanner.startAudit(AuditConfiguration.auditConfiguration(BuiltInAuditConfiguration.LEGACY_ACTIVE_AUDIT_CHECKS))
        auditToDelete.addRequest(httpRequestHttp1.withPath("/?shouldGetDeletedAkaCancelled"))
        auditToDelete.addRequest(httpRequestHttp2.withPath("/?shouldGetDeletedAkaCancelled"))
        auditToDelete.delete()


        val audit = scanner.startAudit(AuditConfiguration.auditConfiguration(BuiltInAuditConfiguration.LEGACY_ACTIVE_AUDIT_CHECKS))

        logging.logToError("Adding request to the scan check...")
        for (i in 1..5) {
            audit.addRequest(
                HttpRequest.httpRequest(HTTP_REQUEST_STRING_GET_GIN_HTTP2).withPath("/?missingHttpService$i")
            )
            audit.addRequest(httpRequestHttp1.withPath("/?valid$i"))
            audit.addRequest(httpRequestHttp2.withPath("/?valid$i"))
            try {
                audit.addRequestResponse(
                    HttpRequestResponse.httpRequestResponse(
                        httpRequestHttp2.withPath("/?nullResponse$i"),
                        null
                    )
                )
            } catch (e: NullPointerException) {
                logging.logToError("Good, response argument to audit.addRequestResponse() shouldn't be null...")
            }
            audit.addRequestResponse(
                HttpRequestResponse.httpRequestResponse(
                    httpRequestHttp1.withPath("/?validAsFullRequestResponse$i"),
                    httpResponseHttp1
                )
            )
            audit.addRequestResponse(
                HttpRequestResponse.httpRequestResponse(
                    httpRequestHttp2.withPath("/?validAsFullRequestResponse$i"),
                    httpResponseHttp2
                )
            )
        }
        logging.logToError("Status Message: ${audit.statusMessage()}")
        logging.logToError("Error count: ${audit.errorCount()}")
        logging.logToError("InsertionPointCount: ${audit.insertionPointCount()}")
        logging.logToError("Request count: ${audit.requestCount()}")

        try{
            audit.issues()
            logging.logToOutput("oh, audit.issues is now suppported...")
        }catch(e: UnsupportedOperationException){
            logging.logToError("Ok, audit.issues() is still not supported...")
        }

    }
}