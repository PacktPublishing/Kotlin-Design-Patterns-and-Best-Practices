fun main() {
    val productManager = Michael
    val company = MyCompany(productManager)
    company.taskCompleted(true)
}

interface ProductManager {
    fun isAllGood(majorRelease: Boolean): Boolean
}

object Michael : Canary, ProductManager {
    private val kenny = Kenny(this)
    private val brad = Brad(this)

    override fun isAllGood(majorRelease: Boolean): Boolean {
        if (!kenny.isEating() && !kenny.isSleeping()) {
            println(kenny.doesMyCodeWork())
        } else if (!brad.isEating() && !brad.isSleeping()) {
            println(brad.doesMyCodeWork())
        }
        return true
    }
}

interface Canary {

}

interface QA {
    fun doesMyCodeWork(): Boolean
}

interface Parrot {
    fun isEating(): Boolean
    fun isSleeping(): Boolean
}


class Kenny(private val productManager: ProductManager) : QA, Parrot {
    override fun isSleeping(): Boolean {
        return false
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun doesMyCodeWork(): Boolean {
        return true
    }
}

class Brad(private val productManager: ProductManager) : QA, Parrot {
    override fun isSleeping(): Boolean {
        return false
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun doesMyCodeWork(): Boolean {
        return true
    }
}

object Me
class MyCompany(private val productManager: ProductManager) {
    fun taskCompleted(isMajorRelease: Boolean) {
        println(productManager.isAllGood(isMajorRelease))
    }
}
