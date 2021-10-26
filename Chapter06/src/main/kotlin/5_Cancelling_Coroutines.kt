import kotlinx.coroutines.*

fun main() = runBlocking {
    val cancellable = launch {
        try {
            for (i in 1..1000) {
                println("Cancellable: $i")
                yield()
            }
        } catch (e: CancellationException) {
            e.printStackTrace()
        }
    }

    val notCancellable = launch {
        for (i in 1..10_000) {
            if (i % 100 == 0) {
                println("Not cancellable $i")
            }
        }
    }

    println("Canceling cancellable")
    cancellable.cancel()
    println("Canceling not cancellable")
    notCancellable.cancel()

    cancellable.join()
    notCancellable.join()
}