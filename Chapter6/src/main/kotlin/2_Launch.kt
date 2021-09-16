import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val latch = CountDownLatch(10_000)
    val c = AtomicInteger()
    val start = System.currentTimeMillis()

    for (i in 1..10_000) {
        GlobalScope.launch {
            c.incrementAndGet()
            delay(100)
            c.incrementAndGet()
            latch.countDown()
        }
    }

    latch.await(10, TimeUnit.SECONDS)

    println("Executed ${c.get() / 2} coroutines in ${System.currentTimeMillis() - start}ms")
}