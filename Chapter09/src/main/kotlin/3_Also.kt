fun main() {
    val l = (1..100).toList()

    l.filter { it % 2 == 0 }
        // Prints, but doesn't mutate the collection
        .also { println(it) }
        .map { it * it }
}