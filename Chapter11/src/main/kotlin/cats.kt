import io.vertx.core.json.JsonObject
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import io.vertx.sqlclient.Tuple
import kotlinx.coroutines.launch

class CatsVerticle : CoroutineVerticle() {
    override suspend fun start() {
        val db = Db.connect(vertx)
        vertx.eventBus().consumer<Int>("cats:delete") { req ->
            launch {
                val id = req.body()
                db.preparedQuery("DELETE FROM cats WHERE ID = $1")
                    .execute(Tuple.of(id)).await()
                req.reply(null)
            }
        }
        vertx.eventBus().consumer<JsonObject>("cats:update") { req ->
            launch {
                val body = req.body()
                db.preparedQuery("UPDATE cats SET name = $1, age = $2 WHERE ID = $3")
                    .execute(
                        Tuple.of(
                            body.getString("name"),
                            body.getInteger("age"),
                            body.getInteger("id")
                        )
                    ).await()
                req.reply(body.getInteger("id"))
            }
        }
    }
}