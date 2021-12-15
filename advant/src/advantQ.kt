import java.io.File

open class advantQ {
    fun readFileAsInt(fileName: String): List<Int> = File(fileName).useLines { it.toList().map { it.toInt() }}
    fun readFileAsString(fileName: String): List<String> = File(fileName).useLines { it.toList()}

    open fun part1() {
        println("Running part 1:")
    }
    open fun part2() {
        println("Running part 2:")
    }

}