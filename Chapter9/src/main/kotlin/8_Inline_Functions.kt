fun main() {
    logBeforeAfter {
        "Inlining"
    }
}

inline fun logBeforeAfter(block: () -> String) {
    println("Before")
    println(block())
    println("After")
}