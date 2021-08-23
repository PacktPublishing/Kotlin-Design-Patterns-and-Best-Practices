import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            println(Thread.currentThread().name)
        }
        GlobalScope.launch {
            println("GlobalScope.launch: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println(Thread.currentThread().name)
        }
    }
}