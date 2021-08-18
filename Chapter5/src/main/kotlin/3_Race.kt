import kotlin.concurrent.thread

fun main() {

    val scores = listOf(Player(0))

    val threads = List(2) {
        thread {
            for (i in 1..1000) {
                scores[0].score = scores[0].score + 1
            }
            println("Done")
        }
    }

    for (t in threads) {
        t.join()
    }

    println(scores[0].score)
}

private data class Player(var score: Int)
