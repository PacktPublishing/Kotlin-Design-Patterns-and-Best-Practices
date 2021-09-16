tailrec fun sumRec(i: Int, sum: Long, numbers: List<Int>): Long {
    return if (i == numbers.size) {
        return sum
    } else {
        sumRec(i+1, numbers[i] + sum, numbers)
    }
}

fun main() {

    val numbers = List(1_000_000) {it}

    println(sumRec(0,  0, numbers))
}