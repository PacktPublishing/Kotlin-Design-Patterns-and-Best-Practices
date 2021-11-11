import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach

fun main() {
    runBlocking {
        val workChannel = generateWork()
        val resultChannel = Channel<String>()
        val workers = List(10) {
            doWorkAsync(workChannel, resultChannel)
        }

        resultChannel.consumeEach {
            println(it)
        }
    }
}


private fun CoroutineScope.doWorkAsync(
    channel: ReceiveChannel<String>,
    resultChannel: Channel<String>
) = async(Dispatchers.Default) {
    for (p in channel) {
        resultChannel.send(p.repeat(2))
    }
}