package helpers

import STRING_REPEAT_CONSTANT

class IntTester {
    var counter = -1
    fun next(): Int{
        counter += 1
        if(counter == 0)
            return 0
        else if (counter == 1)
            return -1
        else if (counter == 2)
            return Int.MAX_VALUE
        else if (counter == 3)
            return Int.MIN_VALUE
        else
            return 3
    }
}