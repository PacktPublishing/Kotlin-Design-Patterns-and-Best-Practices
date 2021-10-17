import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServerTest {
    @AfterAll
    fun cleanup() {
        DB.connect()
        transaction {
            SchemaUtils.drop(CatsTable)
        }
    }

    @BeforeAll
    fun setup() {
        DB.connect()
        transaction {
            SchemaUtils.create(CatsTable)
        }
    }

    @Test
    fun testStatus() {
        withTestApplication(Application::mainModule) {
            val response = handleRequest(HttpMethod.Get, "/status").response
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals("""{"status":"OK"}""", response.content)
        }
    }

    @Test
    fun `POST creates a new cat`() {
        withTestApplication(Application::mainModule) {
            val response = handleRequest(HttpMethod.Post, "/cats") {
                addHeader(
                    HttpHeaders.ContentType,
                    ContentType.Application.FormUrlEncoded.toString()
                )
                setBody(
                    listOf(
                        "name" to "Meatloaf",
                        "age" to 4.toString()
                    ).formUrlEncode()
                )
            }.response
            assertEquals(HttpStatusCode.Created, response.status())
        }
    }

    @Nested
    inner class `With cat in DB` {

        @Test
        fun `GET with ID fetches a single cat`() {
            withTestApplication(Application::mainModule) {
                val response = handleRequest(HttpMethod.Get, "/cats/$id").response
                assertEquals("""{"id":$id,"name":"Fluffy","age":0}""", response.content)
            }
        }

        lateinit var id: EntityID<Int>

        @BeforeEach
        fun setup() {
            DB.connect()
            id = transaction {
                CatsTable.insertAndGetId { cat ->
                    cat[name] = "Fluffy"
                }
            }
        }

        @AfterEach
        fun teardown() {
            DB.connect()
            transaction {
                CatsTable.deleteAll()
            }
        }


        @Test
        fun `GET without ID fetches all cats`() {
            withTestApplication(Application::mainModule) {
                val response = handleRequest(HttpMethod.Get, "/cats").response
                assertEquals("""[{"id":$id,"name":"Fluffy","age":0}]""", response.content)
            }
        }
    }
}