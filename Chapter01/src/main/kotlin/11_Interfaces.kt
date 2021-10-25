import kotlin.random.*

fun main() {

}

interface DiceRoller {
    fun rollDice(): Int = Random.nextInt(0, 6)
}