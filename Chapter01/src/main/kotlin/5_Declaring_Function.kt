fun main() {
    greet(getGreeting())
}

fun greet(greeting: String) {
    println(greeting)
}

// Short form
// fun greet(greeting: String) = println(greeting)

fun getGreeting(): String {
    return "Hello, Kotlin!"
}