fun main() {

    ifs()

    whens()

    loops()
}

fun loops() {
    for (c in "Word") {

        println(c)

    }

    val jokers = listOf("Heath Ledger", "Joaquin Phoenix", "Jack Nicholson")

    for (j in jokers) {
        println(j)
    }

    for (i in 0..9) {
        println(i)
    }

    for (i in 0 until 10) {
        println("for until $i") // Same output as the previous loop
    }

    for (i in 9 downTo 0) {
        println("for downTo $i") // 9, 8, 7...
    }

    var x = 0
    while (x < 10) {
        x++
        println("while $x")
    }

    x = 5
    do {
        println("do while $x")
        x--
    } while (x > 0)
}

fun whens() {
    println(archenemy("Batman"))
    println(archenemy("Wolverine"))
}

fun ifs() {
    println(getUnixSocketPolling(true))

    println(getUnixSocketPolling(false))
}

fun getUnixSocketPolling(isBsd: Boolean): String {
    return if (isBsd) {
        "kqueue"
    } else {
        "epoll"
    }
}

// Shorter version:
/*
fun getUnixSocketPolling(isBsd: Boolean): String =
    if (isBsd) "kqueue" else "epoll"*/



fun archenemy(heroName: String) = when (heroName) {
    "Batman" -> "Joker"
    "Superman" -> "Lex Luthor"
    "Spider-Man" -> "Green Goblin"
    else -> "Sorry, no idea"
}