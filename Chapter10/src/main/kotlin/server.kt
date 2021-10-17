import cats.CatsServiceImpl
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(
        CIO,
        port = 8080,
        module = Application::mainModule
    ).start(wait = true)
}

fun Application.mainModule() {
    DB.connect()

    transaction {
        SchemaUtils.create(CatsTable)
    }

    install(ContentNegotiation) {
        json()
    }
    val catsService = CatsServiceImpl()
    routing {
        get("/status") {
            call.respond(mapOf("status" to "OK"))
        }
        cats(catsService)
    }
    println("open http://localhost:8080")
}

