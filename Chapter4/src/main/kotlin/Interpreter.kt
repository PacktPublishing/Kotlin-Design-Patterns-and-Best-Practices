fun main() {

    val sql = select("name, age") {
        from("users") {
            where("age > 25")
        } // Closes from
    } // Closes select

    println(sql) // "SELECT name, age FROM users WHERE age > 25"
}

fun select(columns: String, from: SelectClause.() -> Unit):
        SelectClause {
    return SelectClause(columns).apply(from)
}

class SelectClause(private val columns: String) {
    private lateinit var from: FromClause
    fun from(
        table: String,
        where: FromClause.() -> Unit
    ): FromClause {
        this.from = FromClause(table)
        return this.from.apply(where)
    }

    override fun toString() = "SELECT $columns $from"
}

class FromClause(private val table: String) {
    private lateinit var where: WhereClause

    fun where(conditions: String) = this.apply {
        where = WhereClause(conditions)
    }

    override fun toString() = "FROM $table $where"
}

class WhereClause(private val conditions: String) {
    override fun toString() = "WHERE $conditions"
}