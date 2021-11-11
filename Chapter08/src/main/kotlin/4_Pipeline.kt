import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    runBlocking {
        val pagesProducer = producePages()
        val domProducer = produceDom(pagesProducer)
        val titleProducer = produceTitles(domProducer)
        titleProducer.consumeEach {
            println(it)
        }
    }
}

fun CoroutineScope.producePages() = produce {
    // This should actually fetch something from the Internet
    fun getPages(): List<String> {
        return listOf(
            "<html><body><h1>Cool stuff</h1></body></html>",
            "<html><body><h1>Even more stuff</h1></body></html>"
        )
    }

    val pages = getPages()

    while (this.isActive) {
        for (p in pages) {
            send(p)
        }
        delay(TimeUnit.SECONDS.toMillis(5))
    }
}

fun CoroutineScope.produceDom(pages: ReceiveChannel<String>) = produce {
    fun parseDom(page: String): Document {
        // In reality this would use a DOM library to parse string to DOM
        return Document(page)
    }

    for (p in pages) {
        send(parseDom(p))
    }
}

fun CoroutineScope.produceTitles(parsedPages: ReceiveChannel<Document>) = produce {
    fun getTitles(dom: Document): List<String> {
        return dom.getElementsByTagName("h1").map {
            it.toString()
        }
    }

    for (page in parsedPages) {
        for (t in getTitles(page)) {
            send(t)
        }
    }
}

data class Document(val html: String) {
    fun getElementsByTagName(tag: String): List<Document> {
        return listOf(Document("Some title"))
    }
}