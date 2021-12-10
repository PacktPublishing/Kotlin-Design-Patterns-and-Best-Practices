import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Database

object DB {
    private val host = System.getenv("DB_HOST") ?: "localhost"
    private val port = System.getenv("DB_PORT")?.toIntOrNull() ?: 5432
    private val dbName = System.getenv("DB_NAME") ?: "cats_db"
    private val dbUser = System.getenv("DB_USER") ?: "cats_admin"
    private val dbPassword = System.getenv("DB_PASSWORD") ?: "abcd1234"
    fun connect() = Database.connect(
        "jdbc:postgresql://$host:$port/$dbName",
        driver = "org.postgresql.Driver",
        user = dbUser,
        password = dbPassword
    )
}

object CatsTable : IntIdTable() {
    val name = varchar("name", 20).uniqueIndex()
    val age = integer("age").default(0)
}

@Serializable
data class Cat(
    val id: Int,
    val name: String,
    val age: Int
)