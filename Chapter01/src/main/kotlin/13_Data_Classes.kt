data class User(val username: String, private val password: String) {
    fun hidePassword() = "*".repeat(password.length)
}

fun main() {
    val user = User("Alexey", "abcd1234")
    println(user.hidePassword())
}