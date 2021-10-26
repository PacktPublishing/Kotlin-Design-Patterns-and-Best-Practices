import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() {
    runBlocking {
        val t1 = measureTimeMillis {
            Blocking.profile("123")
        }

        val t2 = measureTimeMillis {
            Async().profile("123")
        }

        val t3 = measureTimeMillis {
            Suspend().profile("123")
        }

        println("Blocking code: $t1")
        println("Async: $t2")
        println("Suspend: $t3")
    }
}

class Blocking {
    companion object {
        fun profile(id: String): Profile {
            val bio = fetchBioOverHttp(id) // takes 1s
            val picture = fetchPictureFromDB(id) // takes 100ms
            val friends = fetchFriendsFromDB(id) // takes 500ms
            return Profile(bio, picture, friends)
        }

        private fun fetchFriendsFromDB(id: String): List<String> {
            Thread.sleep(500)
            return emptyList()
        }

        private fun fetchPictureFromDB(id: String): ByteArray? {
            Thread.sleep(100)
            return null
        }

        private fun fetchBioOverHttp(id: String): String {
            Thread.sleep(1000)
            return "Alexey Soshin, Software Architect"
        }
    }
}

class Async {
    suspend fun profile(id: String): Profile {
        val bio = fetchBioOverHttpAsync(id) // takes 1s
        val picture = fetchPictureFromDBAsync(id) // takes 100ms
        val friends = fetchFriendsFromDBAsync(id) // takes 500ms
        return Profile(bio.await(), picture.await(), friends.await())
    }

    private fun fetchFriendsFromDBAsync(id: String) = GlobalScope.async {
        delay(500)
        emptyList<String>()
    }

    private fun fetchPictureFromDBAsync(id: String) =
        GlobalScope.async {
            delay(100)
            null
        }

    private fun fetchBioOverHttpAsync(id: String) = GlobalScope.async {
        delay(1000)
        "Alexey Soshin, Software Architect"
    }
}

class Suspend {
    suspend fun profile(id: String): Profile {
        val bio = fetchBioOverHttp(id) // takes 1s
        val picture = fetchPictureFromDB(id) // takes 100ms
        val friends = fetchFriendsFromDB(id) // takes 500ms
        return Profile(bio, picture, friends)
    }

    private suspend fun fetchFriendsFromDB(id: String): List<String> {
        delay(500)
        return emptyList()
    }

    private suspend fun fetchPictureFromDB(id: String): ByteArray? {
        delay(100)
        return null
    }

    private suspend fun fetchBioOverHttp(id: String): String {
        delay(1000)
        return "Alexey Soshin, Software Architect"
    }
}


data class Profile(val bio: String, val picture: ByteArray?, val friends: List<String>)

/*
suspend fun profile(state: Int, id: String, context: ArrayList<Any>): Profile {
    when (state) {
        0 -> {
            context += fetchBioOverHttp(id) // takes 1s
            profile(1, id, context)
        }
        1 -> {
            context += fetchPictureFromDB(id) // takes 100ms
            profile(2, id, context)
        }
        2 -> {
            context += fetchFriendsFromDB(id) // takes 500ms
            profile(3, id, context)
        }
        3 -> {
            val (bio, picture, friends) = context
            return Profile(bio, picture, friends)
        }
    }
}*/
