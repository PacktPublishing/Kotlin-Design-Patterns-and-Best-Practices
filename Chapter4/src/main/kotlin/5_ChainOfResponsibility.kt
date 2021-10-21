fun main() {
    val req = Request(
        "developer@company.com",
        "Why do we need Software Architects?"
    )

    val chain = basicValidation(authentication(finalResponse()))

    val res = chain(req)

    println(res)
}

data class Request(val email: String, val question: String) {
    fun isKnownEmail(): Boolean {
        return true
    }

    fun isFromJuniorDeveloper(): Boolean {
        return false
    }
}

// This is the incorrect implementation of what we want to achieve
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

val basicValidation = fun(next: Handler) =
    fun(request: Request): Response {
        if (request.email.isEmpty() || request.question.isEmpty()) {
            throw IllegalArgumentException()
        }
        return next(request)
    }

val finalResponse = fun() =
    fun(request: Request): Response {
        return Response("I don't know")
    }

data class Response(val answer: String)

typealias Handler = (request: Request) -> Response