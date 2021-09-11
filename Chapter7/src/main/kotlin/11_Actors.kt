import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val actor = actor<Int> {
            channel.consumeEach {
                println(it)
            }
        }

        (1..10).forEach {
            actor.send(it)
        }
    }
}