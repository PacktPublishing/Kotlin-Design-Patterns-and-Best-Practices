fun main() {
    val bobaFett = StormTrooper(Rifle(), RegularLegs())

    val squad = Squad(listOf(bobaFett.copy(), bobaFett.copy(), bobaFett.copy()))

    squad.attackRebel(1, 2)

    val secondSquad = Squad(
        bobaFett.copy(),
        bobaFett.copy(),
        bobaFett.copy()
    )
}

class Squad(private val units: List<Trooper>) : Trooper {

    constructor(vararg units: Trooper) : this(units.toList())

    override fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for (u in units) {
            u.attackRebel(x, y)
        }
    }
}

