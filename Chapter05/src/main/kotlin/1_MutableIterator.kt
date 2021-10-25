fun main() {
    // Will cause ConcurrentModificationException
    printAndClear(mutableListOf("a", "b", "c"))
}
private fun <T> printAndClear(list: MutableList<T>) {
    for (e in list) {
        println(e)
        list.remove(e)
    }
}