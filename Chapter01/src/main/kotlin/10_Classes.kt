fun main() {
    // Creating a class with empty constructor
    // val player = Player()

    val player = Player("Roland")

    println(player.name)

    // Won't compile
    // player.name = "Alex" // Val cannot be reassigned

    // Invalid score
    player.score = -10
}


// Class with default empty constructor
/*
class Player {

}
*/

class Player(name: String) {
    val name = name
        get() = field.toUpperCase()

    var score: Int = 0
        set(value) {
            field = if (value >= 0) {
                value
            } else {
                0
            }
        }
}