import bridge.good.RegularLegs
import bridge.good.Rifle
import bridge.good.StormTrooper

class Squad(private val units: List<StormTrooper>) {
    fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }

    fun attack(x: Long, y: Long) {
        for (u in units) {
            u.attackRebel(x, y)
        }
    }
}


fun main() {
    // TODO varargs?
    val bobaFett = StormTrooper(Rifle(), RegularLegs())

    val squad = Squad(listOf(bobaFett.copy(), bobaFett.copy(), bobaFett.copy()))
}