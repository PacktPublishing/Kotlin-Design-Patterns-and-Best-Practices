fun main() {
    Server.withPort(8080)
}

class Server private constructor(port: Long) {

    init {
        println("Server started on port $port")
    }

    companion object {
        fun withPort(port: Long): Server {
            return Server(port)
        }
    }
}

