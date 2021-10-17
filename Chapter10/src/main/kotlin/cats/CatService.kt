package cats

import Cat
import CatsTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

interface CatsService {
    fun findAll(): List<Cat>
    fun find(id: Int): Cat?
    fun create(name: String, age: Int): EntityID<Int>
}

class CatsServiceImpl : CatsService {
    override fun findAll(): List<Cat> {
        return transaction {
            CatsTable.selectAll().map { row ->
                Cat(
                    row[CatsTable.id].value,
                    row[CatsTable.name],
                    row[CatsTable.age]
                )
            }
        }
    }

    override fun find(id: Int): Cat? {
        return transaction {
            val row = CatsTable.select {
                CatsTable.id.eq(id)
            }.firstOrNull()

            if (row != null) {
                Cat(
                    row[CatsTable.id].value,
                    row[CatsTable.name],
                    row[CatsTable.age]
                )
            }
            else {
                null
            }
        }
    }

    override fun create(name: String, age: Int): EntityID<Int> {
        return transaction {
            CatsTable.insertAndGetId { cat ->
                cat[CatsTable.name] = name
                cat[CatsTable.age] = age
            }
        }
    }
}

