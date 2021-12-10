fun main() {
    val environment = Parser.server(listOf("port: 8080", "environment: production"))
    println(environment)
}


class Parser {

    companion object {
        fun server(propertyStrings: List<String>): ServerConfiguration {
            val parsedProperties = mutableListOf<Property>()
            for (p in propertyStrings) {
                parsedProperties += property(p)
            }

            return ServerConfigurationImpl(parsedProperties)
        }

        fun property(prop: String): Property {
            val (name, value) = prop.split(":")

            return when (name) {
                "port" -> IntProperty(name, value.trim().toInt())
                "environment" -> StringProperty(name, value.trim())
                else -> throw RuntimeException("Unknown property: $name")
            }
        }
    }
}


interface Property {

    val name: String

    val value: Any

}


interface ServerConfiguration {

    val properties: List<Property>

}

data class ServerConfigurationImpl(

    override val properties: List<Property>

) : ServerConfiguration

data class StringProperty(

    override val name: String,

    override val value: String

) : Property

data class IntProperty(

    override val name: String,

    override val value: Int

) : Property