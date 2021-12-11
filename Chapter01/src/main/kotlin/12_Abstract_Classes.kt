abstract class Moveable() {

    protected var x: Int = 0

    protected var y: Int = 0

    open fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun position() = "$x $y"
}

open class ActivePlayer(val name: String) : Moveable(), DiceRoller

class ConfusedPlayer(name: String) : ActivePlayer(name) {

    // move() must be declared open
    override fun move(x: Int, y: Int) {

        this.x = y // must be declared protected

        this.y = x // must be declared protected
    }

}

fun main() {
    val player = ConfusedPlayer("Alex")
    val diceX = player.rollDice()
    val diceY = player.rollDice()

    println("Dice rolled $diceX $diceY")
    player.move(diceX, diceY)

    println("Player at ${player.position()}")
}