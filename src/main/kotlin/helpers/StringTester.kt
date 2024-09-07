package helpers

import DONE_STRING
import STRING_REPEAT_CONSTANT

class StringTester {
    var counter = -1
    fun next(): String?{
        counter += 1
        if(counter == 0)
            return null
        else if (counter == 1)
            return ""
        else if (counter == 2)
            return "Burn".repeat(STRING_REPEAT_CONSTANT)
        else
            return DONE_STRING
    }
}