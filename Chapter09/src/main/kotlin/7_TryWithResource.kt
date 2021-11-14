import java.io.BufferedReader
import java.io.FileReader

fun main() {
    val br = BufferedReader(FileReader("./src/main/kotlin/7_TryWithResource.kt"))

    br.use {
        println(it.readLines())
    }
}