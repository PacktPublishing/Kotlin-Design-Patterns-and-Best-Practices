data class Request(val email: String, val question: String) {
    fun isKnownEmail(): Boolean {
        TODO()
    }

    fun isFromJuniorDeveloper(): Boolean {
        TODO()
    }
}

fun handleRequest(r: Request) {
    // Validate 
    if (r.email.isEmpty() || r.question.isEmpty()) {
        return
    }

    // Authenticate 
    // Make sure that you know whos is this user 
    if (r.isKnownEmail()) {
        return
    }

    // Authorize
    // Requests from juniors are automatically ignored by architects 
    if (r.isFromJuniorDeveloper()) {
        return
    }

    println("I don't know. Did you check StackOverflow?")
}

val authentication = fun(next: Handler) =
    fun(request: Request): Response {
        if (!request.isKnownEmail()) {
            throw IllegalArgumentException()
        }
        return next(request)
    }

data class Response(val answer: String)

typealias Handler = (request: Request) -> Response