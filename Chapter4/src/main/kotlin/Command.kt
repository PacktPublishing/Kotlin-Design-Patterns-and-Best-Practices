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
    }
}

typealias Command = ()->Unit

val moveGenerator = fun(s: Trooper,
                        x: Int,
                        y: Int): Command {
    return fun() {
        s.move(x, y)
    }
}