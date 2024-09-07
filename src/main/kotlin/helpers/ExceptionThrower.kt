package helpers

class ExceptionThrower {
    var counter = 0
    fun throwIfNotDone(message: String){
        Api.l.logToError("$message was called")
        counter += 1
        if(counter == 1){
            throw RuntimeException(message + ".RuntimeException")
        }else if(counter == 2){
            throw Exception(message + ".Exception")
        }else if(counter == 3){
            throw NullPointerException(message + ".NullPointerException")
        }else if(counter == 4){
            val k = 5 / 0
        }
    }
}