fun main() {
    printNameLength(Profile(null))
}

fun printNameLength(p: Profile) {
    requireNotNull(p.firstName)
}

data class Profile(val firstName: String?)

class HttpClient {
    var body: String? = null
    var url: String = ""

    fun postRequest() {
        check(body != null) {
            "Body must be set in POST requests"
        }
    }
}