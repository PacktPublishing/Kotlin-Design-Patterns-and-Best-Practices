import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

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