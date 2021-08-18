fun main() {

    val next = counter()
    println(next())
    println(next())
    println(next())
}

fun counter(): () -> Int {
    var i = 0
    return { i++ }
}