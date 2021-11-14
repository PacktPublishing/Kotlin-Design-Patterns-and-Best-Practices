import kotlin.random.Random

fun main() {
    // Will return "String" half of the time and null the other half
    val stringOrNull: String? = if (Random.nextBoolean()) "String" else null


    // Java-way check
    if (stringOrNull != null) {
        println(stringOrNull.length)
    }

    val alwaysLength = stringOrNull?.length ?: 0

    val response: Response? = Response(UserProfile(null, null))
    println(response?.profile?.firstName?.length)
}

data class Response(
    val profile: UserProfile?
)

data class UserProfile(
    val firstName: String?,
    val lastName: String?
)

