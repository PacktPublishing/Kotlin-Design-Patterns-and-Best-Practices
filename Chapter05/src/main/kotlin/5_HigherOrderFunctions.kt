fun main() {

    val dwarfs = listOf(
        "Dwalin",
        "Balin",
        "Kili",
        "Fili",
        "Dori",
        "Nori",
        "Ori",
        "Oin",
        "Gloin",
        "Bifur",
        "Bofur",
        "Bombur",
        "Thorin"
    )
    for (d in dwarfs) {
        println(d)
    }

    dwarfs.forEach { d ->
        println(d)
    }

    dwarfs.forEach {
        println(it)
    }

    dwarfs.forEach(::println)
}