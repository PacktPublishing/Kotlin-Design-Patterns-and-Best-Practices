fun main() {
    val originalUser = User("admin1", Role.ADMIN, setOf("READ", "WRITE", "DELETE"))
    allUsers += originalUser

    createUser("admin2", Role.ADMIN)

    println(allUsers)
}


enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}

data class User(
    val name: String,
    val role: Role,
    val permissions: Set<String>,
) {
    fun hasPermission(permission: String) = permission in permissions
}

private val allUsers = mutableListOf<User>()

fun createUser(_name: String, role: Role) {
    for (u in allUsers) {
        if (u.role == role) {
            allUsers += u.copy(name = _name)
            return
        }
    }
    // Handle case that no other user with such a role exists
}