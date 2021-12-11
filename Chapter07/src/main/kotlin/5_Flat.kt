fun main() {
    val listOfLists: List<List<Int>> = listOf(listOf(1, 2), listOf(3, 4, 5), listOf(6, 7, 8))

    val flattened = mutableListOf<Int>()

    for (list in listOfLists) {
        flattened.addAll(list)
    }

    println(flattened)

    val flat: List<Int> = listOfLists.flatten()
    println(flat)
    println(listOfLists.flatMap { it })
}