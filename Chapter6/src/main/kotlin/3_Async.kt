import kotlinx.coroutines.*
import java.util.*

fun main() {

    runBlocking {
        val job: Deferred<UUID> = fastUuidAsync()
        println(job.await())
    }
}

fun fastUuidAsync() = GlobalScope.async {
    UUID.randomUUID()
}

fun slowUuidAsync() = GlobalScope.async {
    repeat(10_000_000) {
        UUID.randomUUID()
    }
    UUID.randomUUID()
}