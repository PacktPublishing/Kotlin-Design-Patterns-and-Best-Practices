import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // Prints DeferredCoroutine{Active}
        println("${getResult()}")

        // Prints "OK"
        println(getResultAsync().await())
    }
}

// This will produce a warning
fun CoroutineScope.getResult() = async {
    delay(100)
    "OK"
}

fun CoroutineScope.getResultAsync() = async {
    delay(100)
    "OK"
}