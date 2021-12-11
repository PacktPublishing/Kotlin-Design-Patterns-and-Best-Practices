import java.util.*

fun main() {
    // Will cause ConcurrentModificationException
    printAndClear(mutableListOf("a", "b", "c"))

    val firstEdition = Triple("Design Patterns with Kotlin", 310, 2018)
}

private fun <T> printAndClear(list: MutableList<T>) {
    for (e in list) {
        println(e)
        list.remove(e)
    }
}