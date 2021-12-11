import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val chan = Channel<Int>()

        launch {
            for (c in chan) {
                println(c)
            }
        }

        (1..10).forEach {
            chan.send(it)
        }
        chan.close()
    }
}
