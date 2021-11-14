import kotlinx.coroutines.*
import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool

fun main() {
    runBlocking {

        // This will use the Dispatcher from the parent coroutine
        launch {
            // Prints: main
            println(Thread.currentThread().name)
        }
        launch(Dispatchers.Default) {
            // Prints DefaultDispatcher-worker-1
            println(Thread.currentThread().name)
        }

        async(Dispatchers.IO) {
            for (i in 1..1000) {
                println(Thread.currentThread().name)
                yield()
            }
        }

        val myDispatcher = Executors
            .newFixedThreadPool(4)
            .asCoroutineDispatcher()

        val forkJoinPool = ForkJoinPool(4).asCoroutineDispatcher()

        repeat(1000) {
            launch(forkJoinPool) {
                println(Thread.currentThread().name)
            }
        }
    }
}