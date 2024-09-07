package helpers

class BooleanTester {
    var counter = -1
    fun next(): Boolean{
        counter += 1
        return counter != 0
    }
}