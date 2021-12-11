import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

fun main() {

    runBlocking {
        val numbersFlow: Flow<Int> = flow {
            println("New subscriber!")
            (1..10).forEach {
                println("Sending $it")
                emit(it)
                if (it == 9) {
                    throw RuntimeException()
                }
            }
        }

        (1..4).forEach { coroutineId ->
            delay(5000)
            launch(Dispatchers.Default) {
                try {
                    numbersFlow.collect { number ->
                        delay(1000)
                        println("Coroutine $coroutineId received $number")
                    }
                } catch (e: Exception) {
                    println("Coroutine $coroutineId got an error")
                }
            }
        }
    }
}