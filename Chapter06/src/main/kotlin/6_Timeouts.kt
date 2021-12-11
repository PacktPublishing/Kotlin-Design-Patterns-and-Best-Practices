import kotlinx.coroutines.*
import kotlin.random.Random

fun main() = runBlocking {
    val coroutine = async {
        withTimeout(500) {
            try {
                val time = Random.nextLong(1000)
                println("It will take me $time to do")
                delay(time)
                println("Returning profile")
                "Profile"
            } catch (e: TimeoutCancellationException) {
                e.printStackTrace()
            }
        }
    }

    println("Result: ${coroutine.await()}")
}