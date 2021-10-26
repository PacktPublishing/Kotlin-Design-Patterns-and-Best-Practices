fun main() {
    val michael = Manager()
    michael.think("Need to implement Coconut Cannon")
    michael.think("Should get some coffee")
    val memento = michael.saveThatThought()
    with(michael) {
        think("Or maybe tea?")
        think("No, actually, let's implement Pineapple Launcher")
    }
    michael.printThoughts()
    michael.`what was I thinking back then?`(memento)
    michael.printThoughts()
}

class Manager {
    private var thoughts = mutableListOf<String>()

    fun printThoughts() {
        println(thoughts)
    }

    inner class Memory(private val mindState: List<String>) {
        fun restore() {
            thoughts = mindState.toMutableList()
        }
    }

    fun saveThatThought(): Memory {
        return Memory(thoughts.toList())
    }

    fun `what was I thinking back then?`(memory: Memory) {
        memory.restore()
    }

    fun think(thought: String) {
        thoughts.add(thought)
        if (thoughts.size > 2) {
            thoughts.removeFirst()
        }
    }
}

