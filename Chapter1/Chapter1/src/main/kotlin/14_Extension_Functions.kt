data class Password(val password: String) {
    fun hidePassword() = "*".repeat(password.length)
}

fun String.hidePassword() = "*".repeat(this.length)

fun main() {
    val password: String = "secretpassword"

    println("Password: ${password.hidePassword()}")
}