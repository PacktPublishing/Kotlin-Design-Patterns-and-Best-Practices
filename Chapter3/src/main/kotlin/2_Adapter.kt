import java.util.stream.Stream
import kotlin.streams.toList

fun main() {
    // This code won't work
    /*
    cellPhone(
        // Type mismatch: inferred type is UsbMini but UsbTypeC was expected
        charger(
            // Type mismatch: inferred type is USPlug but EUPlug was expected
            usPowerOutlet()
        )
    )*/

    cellPhone(
        charger(
            usPowerOutlet().toEUPlug()
        ).toUsbTypeC()
    )


    val l = listOf("a", "b", "c")

    streamProcessing(l.stream())

    val s = (Stream.generate { 42 }).toList()
    println(s)

    // Using an adapter in a wrong way may cause your program to never stop!
    // For example:
    /*
    println("Collecting elements")
    collectionProcessing(s.toList())
    */
}

fun <T> collectionProcessing(c: Collection<T>) {
    for (e in c) {
        println(e)
    }
}

fun <T> streamProcessing(stream: Stream<T>) {
    // Do something with stream
}

fun USPlug.toEUPlug(): EUPlug {
    val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
    return object : EUPlug {
        // Transfer power
        override val hasPower = hasPower
    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC {
        override val hasPower = hasPower
    }
}

// Power outlet exposes USPlug interface
fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower = 1
    }
}

// Charger accepts EUPlug interface and exposes UsbMini interface
fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini {
        override val hasPower = Power.valueOf(plug.hasPower)
    }
}

fun cellPhone(chargeCable: UsbTypeC) {
    if (chargeCable.hasPower) {
        println("I've Got The Power!")
    } else {
        println("No power")
    }
}

interface USPlug {
    val hasPower: Int
}

interface EUPlug {
    val hasPower: String // "TRUE" or "FALSE"
}


interface UsbMini {
    val hasPower: Power
}

enum class Power {
    TRUE, FALSE
}

interface UsbTypeC {
    val hasPower: Boolean
}





