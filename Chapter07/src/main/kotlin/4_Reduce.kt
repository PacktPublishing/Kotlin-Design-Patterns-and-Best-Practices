fun main() {
    val numbers = 1..100

    var sum = 0
    for (n in numbers) {
        sum += n
    }
    println(sum)

    println((1..100).reduce { sum, n -> sum + n })
}