import kotlinx.coroutines.*
import java.lang.RuntimeException
import java.util.*

fun main() = runBlocking {
    val parent = launch(Dispatchers.Default) {
        supervisorScope {
            val children = List(10) { childId ->
                launch {
                    for (i in 1..1_000_000) {
                        UUID.randomUUID()

                        if (i % 100_000 == 0) {
                            println("$childId - $i")
                            yield()
                        }
                        if (childId == 8 && i == 300_000) {
                            throw RuntimeException("Something bad happened")
                        }
                    }
                }
            }
        }
    }
}