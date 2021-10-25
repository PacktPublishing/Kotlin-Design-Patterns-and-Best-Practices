fun main() {
    val tree = Node(
        1,
        Empty,
        Node(
            2,
            Node(3)
        )
    )

    println(tree)
    println(tree.sum())
}

sealed interface Tree<out T>

object Empty : Tree<Nothing> {
    override fun toString() = "Empty"
}

data class Node<T>(
    val value: T,
    val left: Tree<T> = Empty,
    val right: Tree<T> = Empty
) : Tree<T>

fun Tree<Int>.sum(): Long = when (this) {
    Empty -> 0
    is Node -> value + left.sum() + right.sum()
}
