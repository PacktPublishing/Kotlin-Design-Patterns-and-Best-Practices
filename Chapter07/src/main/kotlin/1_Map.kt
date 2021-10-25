
fun main() {

    val letters = 'a'..'z'
    val ascii = mutableListOf<Int>()

    for (l in letters) {
        ascii.add(l.toInt())
    }

    println(ascii)
    println(('a'..'z').map { it.toInt() })
}
