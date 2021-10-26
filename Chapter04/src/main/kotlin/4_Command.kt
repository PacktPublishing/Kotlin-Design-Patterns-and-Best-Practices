fun main() {
    val t = Trooper()

    t.addOrder(moveGenerator(t, 1, 1))
    t.addOrder(moveGenerator(t, 2, 2))
    t.addOrder(moveGenerator(t, 3, 3))

    t.executeOrders()
}

open class Trooper {
    private val orders = mutableListOf<Command>()

    fun addOrder(order: Command) {
        this.orders.add(order)
    }

    fun executeOrders() {
        while (orders.isNotEmpty()) {
            val order = orders.removeFirst()
            order() // Compile error for now
        }
    }
    // More code here

    fun move(x: Int, y: Int) {
        println("Moving to $x:$y")
    }
}

typealias Command = () -> Unit

val moveGenerator = fun(
    s: Trooper,
    x: Int,
    y: Int
): Command {
    return fun() {
        s.move(x, y)
    }
}