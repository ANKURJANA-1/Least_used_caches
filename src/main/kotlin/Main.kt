import kotlinx.coroutines.runBlocking
import storage.Storage
import java.util.*

fun main(args: Array<String>) = runBlocking {

    var quit = false
    val scanner: Scanner = Scanner(System.`in`)
    while (!quit) {
        val input = scanner.next()
        if (input == "q") {
            quit = true
        }

        var count = 0
        val storage: Storage<Int> = Storage()
        storage.save(10)
        storage.save(20)
        storage.save(30)
        storage.save(40)
        storage.save(50)

        storage.getRecent()
        storage.deleteRecent()
        storage.delete()
        storage.isContains(20)
        storage.delete()
        storage.showAll()
        storage.save(10)
        println()
        println()
        storage.showAll()
        storage.delete()
        println()
        println()
        storage.showAll()
        storage.delete()
        println()
        println()
        storage.showAll()
        storage.deleteRecent()
        println()
        println()
        storage.showAll()
        storage.save(10)
        storage.save(10)
    }

}