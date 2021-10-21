fun main() {
    val mail = MailBuilder()
        .recepients(listOf("hello@world.com"))
        .message("Hello")
        .build()

    println(mail.to)
    println(mail.cc)
    println(mail.message)
}

class MailBuilder {
    private var recepients: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var title: String = ""
    private var message: String = ""
    private var important: Boolean = false

    class Mail internal constructor(
        val to: List<String>,
        val cc: List<String>?,
        val title: String?,
        val message: String?,
        val important: Boolean
    )

    fun build(): Mail {
        if (recepients.isEmpty()) {
            throw RuntimeException("To property is empty")
        }

        return Mail(recepients, cc, title, message, important)
    }

    fun message(message: String = ""): MailBuilder {
        this.message = message
        return this
    }

    fun recepients(recepients: List<String>): MailBuilder {
        this.recepients = recepients
        return this
    }

    // More functions to be implemented here
}