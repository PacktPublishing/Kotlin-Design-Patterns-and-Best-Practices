fun summarizer(): (Set<Int>) -> Double {
    val resultsCache = mutableMapOf<Set<Int>, Double>()

    return { numbers: Set<Int> ->
        resultsCache.computeIfAbsent(numbers, ::sum)
    }
}

fun sum(numbers: Set<Int>): Double {
    println("Computing")
    return numbers.sumByDouble { it.toDouble() }
}

fun main() {
    val input = listOf(
        setOf(1, 2, 3),
        setOf(3, 1, 2),
        setOf(2, 3, 1),
        setOf(4, 5, 6)
    )

    val summarizer = summarizer()

    input.forEach {
        println(summarizer(it))
    }
}