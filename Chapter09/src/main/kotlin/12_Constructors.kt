fun main() {
    val c = User("Alexey")

    println(c.resetPassword)
}

// Don't do this
/*
class User(val name: String, val resetPassword: Boolean) {
    constructor(name: String) : this(name, true)
} */

class User(val name: String, val resetPassword: Boolean = true)