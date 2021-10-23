fun main() {
    val hero = OurHero()
    hero.shoot()
    hero.currentWeapon = Weapons::banana
    hero.shoot()
}

class OurHero {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    var currentWeapon = Weapons::peashooter

    val shoot = fun() {
        currentWeapon(x, y, direction)
    }

}

enum class Direction {
    LEFT, RIGHT
}

data class Projectile(
    private var x: Int,
    private var y: Int,
    private var direction: Direction
)

interface Weapon {
    fun shoot(
        x: Int,
        y: Int,
        direction: Direction
    ): Projectile
}

object Weapons {
    // Flies straight
    fun peashooter(x: Int, y: Int, direction: Direction): Projectile {
        println("It's a peashooter")
        return Projectile(x, y, direction)
    }

    // Returns back after reaching end of the screen
    fun banana(x: Int, y: Int, direction: Direction): Projectile {
        println("It's a banana")
        return Projectile(x, y, direction)
    }

    // Explodes on contact
    fun pomegranate(x: Int, y: Int, direction: Direction): Projectile {
        println("It's a pomegranate")
        return Projectile(x, y, direction)
    }
}


