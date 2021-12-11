fun main() {

    val letters = 'a'..'z'
    val ascii = mutableListOf<Int>()

    for (l in letters) {
        ascii.add(l.toInt())
    }

    println(ascii)
    val result: List<Int> = ('a'..'z').map { it.toInt() }
    println(result)
}
