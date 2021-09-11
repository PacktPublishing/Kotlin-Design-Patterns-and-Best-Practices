import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.RuntimeException
import kotlin.random.Random

fun main() {

    runBlocking {
        val stock: Flow<Int> = flow {
            var i = 0
            while (true) {
                emit(++i)
                delay(100)
            }
        }

        var seconds = 0
        stock.conflate().collect { number ->
            delay(1000)
            seconds++
            println("$seconds seconds -> received $number")
        }
    }


}