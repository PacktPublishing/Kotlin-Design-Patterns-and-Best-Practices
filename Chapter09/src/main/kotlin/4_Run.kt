fun main() {
    val year = JamesBond().run {
        name = "ROGER MOORE"
        movie = "THE MAN WITH THE GOLDEN GUN"
        1974 // <= Not JamesBond type
    }

    println(year)
}