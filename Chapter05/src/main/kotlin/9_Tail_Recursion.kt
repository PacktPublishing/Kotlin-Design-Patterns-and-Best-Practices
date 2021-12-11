tailrec fun sumRec(i: Int, sum: Long, numbers: List<Int>): Long {
    return if (i == numbers.size) {
        return sum
    } else {
        sumRec(i + 1, numbers[i] + sum, numbers)
    }
}

fun main() {

    val numbers = List(1_000_000) { it }

    println(sumRec(0, 0, numbers))

    val res = mergeSort(numbers.shuffled())

    println(res.take(100))
}

tailrec fun mergeSort(numbers: List<Int>): List<Int> {
    return when {
        numbers.size <= 1 -> numbers
        numbers.size == 2 -> {
            return if (numbers[0] < numbers[1]) {
                numbers
            } else {
                listOf(numbers[1], numbers[0])
            }
        }
        else -> {
            val left = mergeSort(numbers.slice(0..numbers.size / 2))
            val right = mergeSort(numbers.slice(numbers.size / 2 + 1 until numbers.size))
            return merge(left, right)
        }
    }
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var l = 0
    var r = 0
    while (l < left.size && r < right.size) {
        result += if (left[l] < right[r]) {
            left[l++]
        } else {
            right[r++]
        }
    }
    while (l < left.size) {
        result += left[l++]
    }
    while (r < right.size) {
        result += right[r++]
    }
    return result
}