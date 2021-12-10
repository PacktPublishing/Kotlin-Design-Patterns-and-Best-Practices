fun main() {
    Logger.log("Hello World")
}

/**
 * Object keyword will create a Singleton
 */
object Logger {
    init {
        println("I was accessed for the first time")

        // Initialization logic goes here
    }

    fun log(message: String) {
        println("Logging $message")
    }
    // More code goes here
}

