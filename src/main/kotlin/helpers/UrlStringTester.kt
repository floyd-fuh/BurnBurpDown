package helpers

import DONE_STRING
import REQUEST_URL


class UrlStringTester {
    var counter = -1
    val stringTester = StringTester()
    fun next(): String?{
        val next = stringTester.next()
        if(next != DONE_STRING)
            return next
        //TODO: Test some other things...
        counter += 1
        if(counter == 0)
            return "ftps://ginandjuice.shop/"
        else if (counter == 1)
            return "https://foo:bar@ginandjuice.shop/akkk;a=b?c=d#e=f"
        else
            return REQUEST_URL
    }
}