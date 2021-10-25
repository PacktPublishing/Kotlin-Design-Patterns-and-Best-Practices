fun main() {
    val clintEastwoodQuotes = mapOf(
        "The Good, The Bad, The Ugly" to "Every gun makes its own tune.",
        "A Fistful Of Dollars" to "My mistake: four coffins."
    )
    val quote = clintEastwoodQuotes["Unforgiven"]

    if (quote != null) {
        println(quote)
    }

    // There is a movie with that name, so let will execute the block
    clintEastwoodQuotes["A Fistful Of Dollars"]?.let {
        println(it)
    }

    // Nothing will be printed, since there's no such movie
    clintEastwoodQuotes["Unforgiven"]?.let {
        println(it)
    }
}