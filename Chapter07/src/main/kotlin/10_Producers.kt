import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val chan = produce {
            (1..10).forEach {
                send(it)
            }
        }

        launch {
            chan.consumeEach {
                println(it)
            }
        }
    }
}
