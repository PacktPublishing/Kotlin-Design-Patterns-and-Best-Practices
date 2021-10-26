import java.io.BufferedReader
import java.io.FileReader

fun main() {
    val br = BufferedReader(FileReader("/some/path"))

    br.use {
        println(it.readLine())
    }
}