fun main() {

    val page = Page(
        Container(
            Image,
            Link,
            Image
        ),
        Table,
        Link,
        Container(
            Table,
            Link
        ),
        Container(
            Image,
            Container(
                Image,
                Link
            )
        )
    )

    println(collectLinks(page))
}

fun collectLinks(page: Page): List<String> {
    // No need for intermediate variable there
    return LinksCrawler().run {
        page.accept(this)
        this.links
    }
}


class LinksCrawler {
    private var _links = mutableListOf<String>()

    val links
        get() = _links.toList()

    fun visit(page: Page) {
        visit(page.elements)
    }

    fun visit(container: Container) = visit(container.elements)

    private fun visit(elements: List<HtmlElement>) {
        for (e in elements) {
            when (e) {
                is Container -> e.accept(this)
                is Link -> _links.add(e.href)
                is Image -> _links.add(e.src)
                else -> {
                }
            }
        }
    }
}

private fun Container.accept(feature: LinksCrawler) {
    feature.visit(this)
}

// Same as above but shorter
private fun Page.accept(feature: LinksCrawler) = feature.visit(this)


class Page(val elements: MutableList<HtmlElement> = mutableListOf()) {
    constructor(vararg elements: HtmlElement) : this(mutableListOf()) {
        for (s in elements) {
            this.elements.add(s)
        }
    }
}


sealed class HtmlElement

class Container(val elements: MutableList<HtmlElement> = mutableListOf()) : HtmlElement() {

    constructor(vararg units: HtmlElement) : this(mutableListOf()) {
        for (u in units) {
            this.elements.add(u)
        }
    }
}

object Image : HtmlElement() {
    val src: String
        get() = "https://some.image"
}

object Link : HtmlElement() {
    val href: String
        get() = "https://some.link"
}

object Table : HtmlElement()