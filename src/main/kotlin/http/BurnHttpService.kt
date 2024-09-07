package http

import burp.api.montoya.http.HttpService
import helpers.BooleanTester
import helpers.ExceptionThrower
import helpers.IntTester
import helpers.StringTester

class BurnHttpService: HttpService {
    val hostExceptionThrower = ExceptionThrower()
    var hostStringTester = StringTester()

    val portExceptionThrower = ExceptionThrower()
    var portIntTester = IntTester()

    val secureExceptionThrower = ExceptionThrower()
    var secureBooleanTester = BooleanTester()

    val ipAddressExceptionThrower = ExceptionThrower()
    var ipAddressStringTester = StringTester()

    override fun host(): String? {
        hostExceptionThrower.throwIfNotDone("HttpService.host")
        return hostStringTester.next()
    }

    override fun port(): Int {
        portExceptionThrower.throwIfNotDone("HttpService.port")
        return portIntTester.next()
    }

    override fun secure(): Boolean {
        secureExceptionThrower.throwIfNotDone("HttpService.secure")
        return secureBooleanTester.next()
    }

    override fun ipAddress(): String? {
        ipAddressExceptionThrower.throwIfNotDone("HttpService.ipAddress")
        return ipAddressStringTester.next()
    }
}