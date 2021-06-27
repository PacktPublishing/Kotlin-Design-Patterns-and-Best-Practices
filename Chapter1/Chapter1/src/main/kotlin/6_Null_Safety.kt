fun main() {
    // Won't compile
    // val s: String = null // Null can not be a value of a non-null type String

    // Won't compile
    // printLength(null) // Null can not be a value of a non-null type String

    var willInitializeLater: String? = null
}

fun printLength(s: String) {
    println(s.length)
}