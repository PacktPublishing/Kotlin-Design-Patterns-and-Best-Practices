import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch

fun main() {
    val vertx = Vertx.vertx()
    vertx.deployVerticle(ServerVerticle())
    vertx.deployVerticle(CatsVerticle())
}

class ServerVerticle : CoroutineVerticle() {
    override suspend fun start() {
        val router = router()

        vertx.createHttpServer()
            .requestHandler(router)
            .listen(8081)
        println("open http://localhost:8081/status")
    }

    private fun router(): Router {
        // Our router code comes here now

        val router = Router.router(vertx)
        router.route().handler(BodyHandler.create())
        router.get("/status").handler { ctx ->
            val json = json {
                obj(
                    "status" to "OK"
                )
            }

            ctx.response()
                .setStatusCode(200)
                .end(json.toString())
        }
        router.mountSubRouter("/cats", catsRouter())

        return router
    }

    private fun catsRouter(): Router {
        val router = Router.router(vertx)
        router.delete("/:id").handler { ctx ->
            val id = ctx.request().getParam("id").toInt()
            vertx.eventBus().request<Int>("cats:delete", id) {
                ctx.end()
            }
        }
        router.put("/:id").handler { ctx ->
            launch {
                val id = ctx.request().getParam("id").toInt()
                val body: JsonObject = ctx.bodyAsJson.mergeIn(json {
                    obj("id" to id)
                })

                vertx.eventBus().request<Int>("cats:update", body) { res ->
                    ctx.end(res.result().body().toString())
                }
            }
        }
        return router
    }
}


