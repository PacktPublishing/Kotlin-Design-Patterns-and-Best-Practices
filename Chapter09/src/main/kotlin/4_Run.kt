fun main() {
    val lowerCaseName = JamesBond().run {
        name = "ROGER MOORE"
        movie = "THE MAN WITH THE GOLDEN GUN"
        name.toLowerCase() // <= Not JamesBond type
    }

    println(lowerCaseName)
}