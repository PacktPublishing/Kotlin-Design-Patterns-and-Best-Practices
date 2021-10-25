import java.util.*

fun main(args: Array<String>) {
    lists()

    sets()

    maps()

    arrays()

    println(args.joinToString(", "))
}

fun arrays() {
    val musketeers: Array<String> = arrayOf("Athos", "Porthos", "Aramis")

    println(musketeers)

    listOf(1, 2, 3, 5).toTypedArray()
}

fun maps() {
    val movieBatmans = mapOf(

        "Batman Returns" to "Michael Keaton",

        "Batman Forever" to "Val Kilmer",

        "Batman & Robin" to "George Clooney"

    )

    println(movieBatmans["Batman Returns"])

    println("Batman Begins" !in movieBatmans)

    // Mutable map that is sorted by its keys

    val treeMap = TreeMap(

        mapOf(

            "Practical Pig" to "bricks",

            "Fifer" to "straw",

            "Fiddler" to "sticks"

        )

    )

    println(treeMap.keys)
}

fun sets() {
    val footballChampions = setOf("France", "Germany", "Spain", "Italy", "Brazil", "France", "Brazil", "Germany")

    println(footballChampions)

    println("Israel" in footballChampions) // false

    println("Italy" in footballChampions) // true
}

fun lists() {
    val hobbits = listOf("Frodo", "Sam", "Pippin", "Merry")

    println(hobbits[1])

    // Won't compile
    // hobbits[0] = "Bilbo" // Unresolved reference

    val editableHobbits = mutableListOf("Frodo", "Sam", "Pippin", "Merry")

    editableHobbits.add("Bilbo")
}
