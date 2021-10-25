fun main() {
    val snail = Snail()
    snail.seeHero()
    snail.getHit(1)
    snail.getHit(10)
}

interface WhatCanHappen {
    fun seeHero()

    fun getHit(pointsOfDamage: Int)

    fun calmAgain()
}

class Snail : WhatCanHappen {
    private var healthPoints = 10
    private var mood: Mood = Still

    override fun seeHero() {
        mood = when (mood) {
            is Still -> {
                println("Aggressive")
                Aggressive
            }
            else -> {
                println("No change")
                mood
            }
        }
    }

    override fun getHit(pointsOfDamage: Int) {
        println("Hit for $pointsOfDamage points")
        healthPoints -= pointsOfDamage

        println("Health: $healthPoints")
        mood = when {
            (healthPoints <= 0) -> {
                println("Dead")
                Dead
            }
            mood is Aggressive -> {
                println("Retreating")
                Retreating
            }
            else -> {
                println("No change")
                mood
            }
        }
    }

    override fun calmAgain() {
    }
}

sealed class Mood {
    // Some abstract methods here, like draw(), for example
}

object Still : Mood()

object Aggressive : Mood()

object Retreating : Mood()

object Dead : Mood()