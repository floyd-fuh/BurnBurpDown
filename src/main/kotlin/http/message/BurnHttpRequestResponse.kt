package http.message

import burp.api.montoya.core.Annotations
import burp.api.montoya.core.Marker
import burp.api.montoya.http.HttpService
import burp.api.montoya.http.handler.TimingData
import burp.api.montoya.http.message.ContentType
import burp.api.montoya.http.message.HttpRequestResponse
import burp.api.montoya.http.message.requests.HttpRequest
import burp.api.montoya.http.message.responses.HttpResponse
import java.util.*
import java.util.regex.Pattern

class BurnHttpRequestResponse: HttpRequestResponse {
    override fun request(): HttpRequest {
        TODO("Not yet implemented")
    }

    override fun response(): HttpResponse {
        TODO("Not yet implemented")
    }

    override fun httpService(): HttpService {
        TODO("Not yet implemented")
    }

    override fun annotations(): Annotations {
        TODO("Not yet implemented")
    }

    override fun timingData(): Optional<TimingData> {
        TODO("Not yet implemented")
    }

    override fun url(): String {
        TODO("Not yet implemented")
    }

    override fun hasResponse(): Boolean {
        TODO("Not yet implemented")
    }

    override fun contentType(): ContentType {
        TODO("Not yet implemented")
    }

    override fun statusCode(): Short {
        TODO("Not yet implemented")
    }

    override fun requestMarkers(): MutableList<Marker> {
        TODO("Not yet implemented")
    }

    override fun responseMarkers(): MutableList<Marker> {
        TODO("Not yet implemented")
    }

    override fun contains(p0: String?, p1: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(p0: Pattern?): Boolean {
        TODO("Not yet implemented")
    }

    override fun copyToTempFile(): HttpRequestResponse {
        TODO("Not yet implemented")
    }

    override fun withAnnotations(p0: Annotations?): HttpRequestResponse {
        TODO("Not yet implemented")
    }

    override fun withRequestMarkers(p0: MutableList<Marker>?): HttpRequestResponse {
        TODO("Not yet implemented")
    }

    override fun withRequestMarkers(vararg p0: Marker?): HttpRequestResponse {
        TODO("Not yet implemented")
    }

    override fun withResponseMarkers(p0: MutableList<Marker>?): HttpRequestResponse {
        TODO("Not yet implemented")
    }

    override fun withResponseMarkers(vararg p0: Marker?): HttpRequestResponse {
        TODO("Not yet implemented")
    }
}