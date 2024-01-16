sealed interface Response // sealed class / interface -> subclasses can ONLY be defiend in this module

object Loading: Resoponse // object makes a singleton, makes sense since when we see somethign loading, we dont need multiple classes being created. also dont need () because its not a class. its an interface
object TimedOut : Response

data class Loaded (val value : String) : Response // remember data classes need at least 1 parameter marked as val .
data class Error (val message : String , val exception : Throwable) : Reponse

fun getValue(): String = ""

fun getNameFromWebService(id: String, onResponse: (Response) -> Unit) {
    // most likely - start a thread here (or better launch coroutine)
    onResponse(Loading)
    // get result from web service
    try {
        val value = getValue()
        onResponse(Loaded(value))
    } catch (e: Throwable) {
        onResponse(Error("Could not load $id", e))
    }
}

fun main() {
    getNameFromWebService("42") { response ->
        when (response) {
            Loading -> {} // put a spinning progress meter on the screen with word "loaded"
            TimedOut -> {} // stop progress meter and pop up "timed out" message
            is Loaded -> {} // stop progress meter and use the loaded data
            is Error -> {} // stop progress meter and report error
        }
    }
}
