import kotlin.random.Random

fun main() {
    var order: PizzaOrderStatus = OrderReceived(Random.nextInt())
    println(order)
    order = order.nextStatus()
    println(order)
    order = order.nextStatus()
    println(order)
    order = order.nextStatus()
    println(order)
}


// Java-like code that uses enum to represent State
/*enum class PizzaOrderStatus {
    ORDER_RECEIVED, PIZZA_BEING_MADE, OUT_FOR_DELIVERY, COMPLETED;

    fun nextStatus(): PizzaOrderStatus {
        return when (this) {
            ORDER_RECEIVED -> PIZZA_BEING_MADE
            PIZZA_BEING_MADE -> OUT_FOR_DELIVERY
            OUT_FOR_DELIVERY -> COMPLETED
            COMPLETED -> COMPLETED
        }
    }
}*/

sealed class PizzaOrderStatus(protected val orderId: Int) {
    abstract fun nextStatus(): PizzaOrderStatus
}

class OrderReceived(orderId: Int) : PizzaOrderStatus(orderId) {
    override fun nextStatus() = PizzaBeingMade(orderId)
}

class PizzaBeingMade(orderId: Int) : PizzaOrderStatus(orderId) {
    override fun nextStatus() = OutForDelivery(orderId)
}

class OutForDelivery(orderId: Int) : PizzaOrderStatus(orderId) {
    override fun nextStatus() = Completed(orderId)
}

class Completed(orderId: Int) : PizzaOrderStatus(orderId) {
    override fun nextStatus() = this
}