fun main() {
    val listOfLists = listOf(listOf(1, 2), listOf(3, 4, 5), listOf(6, 7, 8))

    val flattened = mutableListOf<Int>()

    for (list in listOfLists) {
        flattened.addAll(list)
    }

    println(flattened)
    println(listOfLists.flatMap { it })
}