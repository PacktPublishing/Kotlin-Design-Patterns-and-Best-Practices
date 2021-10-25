import io.vertx.core.Vertx
import io.vertx.pgclient.PgConnectOptions
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.PoolOptions
import io.vertx.sqlclient.SqlClient


object Db {
    val username = System.getenv("DATABASE_USERNAME") ?: "cats_admin"
    val password = System.getenv("DATABASE_PASSWORD") ?: "abcd1234"
    val database = System.getenv("DATABASE_NAME") ?: "cats_db"
    val host = System.getenv("DATABASE_HOST") ?: "localhost"

fun connect(vertx: Vertx): SqlClient {
    val connectOptions = PgConnectOptions()
        .setPort(5432)
        .setHost(host)
        .setDatabase(database)
        .setUser(username)
        .setPassword(password)

    val poolOptions = PoolOptions()
        .setMaxSize(20)

    return PgPool.client(
        vertx,
        connectOptions,
        poolOptions
    )
}
}
