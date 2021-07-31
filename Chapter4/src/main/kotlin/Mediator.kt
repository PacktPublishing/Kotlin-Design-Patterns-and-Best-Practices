interface QA {
    fun doesMyCodeWork(): Boolean
}

interface Parrot {
    fun isEating(): Boolean
    fun isSleeping(): Boolean
}

interface Owl {
    fun isEating(): Boolean
    fun isSleeping(): Boolean
}

object Kenny : QA, Parrot {
    val developer = Me
    // Implements interface methods based on parrot schedule
    override fun doesMyCodeWork(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEating(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSleeping(): Boolean {
        TODO("Not yet implemented")
    }
}
object Brad : QA, Parrot {
    val senior = Kenny
    val developer = Me
    override fun doesMyCodeWork(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEating(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSleeping(): Boolean {
        TODO("Not yet implemented")
    }
}

object George : QA, Owl {
    val mate = Kenny
    override fun doesMyCodeWork(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEating(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSleeping(): Boolean {
        TODO("Not yet implemented")
    }
}

object Me

class MyCompany(private val manager: Manager) {
    val cto = Me
    val qa = Kenny

    fun taskCompleted() {
        if (!qa.isEating() && !qa.isSleeping()) {
            println(qa.doesMyCodeWork())
        }
    }
}