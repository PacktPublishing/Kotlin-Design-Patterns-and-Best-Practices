import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val numbersFlow: Flow<Int> = flow {
            println("New subscriber!")
            (1..10).forEach {
                println("Sending $it")
                emit(it)
            }
        }

        (1..4).forEach { coroutineId ->
            delay(5000)
            numbersFlow.buffer().collect { number ->
                delay(1000)
                println("Coroutine $coroutineId received $number")
            }
        }
    }


}