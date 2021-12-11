fun main() {
    println(subtract(4)(5))

    val infoLogger = createLogger(LogLevel.INFO)
    infoLogger("Log something")
}

// If this is a function without currying at all
fun subtract(x: Int, y: Int): Int {
    return x - y
}

// This is a complex way to implement currying
/*
fun subtract(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x - y
    }
}
*/

// And it could be simplified
//fun subtract(x: Int) = fun(y: Int) = x - y

// Simplest way
fun subtract(x: Int) = { y: Int -> x - y }


enum class LogLevel {
    ERROR, WARNING, INFO
}

fun log(level: LogLevel, message: String) =
    println("$level: $message")

val errorLog = fun(message: String) {
    log(LogLevel.ERROR, message)
}

fun createLogger(level: LogLevel): (String) -> Unit {
    return { message: String ->
        log(level, message)
    }
}