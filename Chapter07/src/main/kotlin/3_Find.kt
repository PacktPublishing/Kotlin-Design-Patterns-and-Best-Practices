fun main() {

    val numbers = (1..100).reversed()

    println(findFizzbuzz(numbers.toList()))
    val found: Int? = (1..100).find { it % 3 == 0 && it % 5 == 0 }
    println(found)
}

fun findFizzbuzz(numbers: List<Int>): Int? {
    for (n in numbers) {
        if (n % 3 == 0 && n % 5 == 0) {
            return n
        }
    }
    return null
}