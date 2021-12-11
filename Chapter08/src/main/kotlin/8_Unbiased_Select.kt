import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.selectUnbiased

fun main() {
    runBlocking {
        val firstOption = fastProducer("Quick&Angry 7")
        val secondOption = fastProducer("Revengers: Penultimatum")

        delay(10)
        val movieToWatch = selectUnbiased<String> {
            firstOption.onReceive { it }
            secondOption.onReceive { it }
        }
        println(movieToWatch)
    }
}

fun CoroutineScope.fastProducer(
    movieName: String
) = produce(capacity = 1) {
    send(movieName)
}
