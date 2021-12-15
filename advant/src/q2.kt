import java.io.File

data class Movement(val dir: String, val amount: Int)

class q2 : advantQ() {
    fun readFileAsMovement(path: String): List<Movement> {
        return File(path).useLines { it.toList().map(::parseMovement)}
    }

    fun parseMovement (s:String) : Movement {
        val m = s.split(" ")
        return Movement(m[0], m[1].toInt())
    }
    override fun part1() {
        super.part1()
        val path: String = Day.DAY2.path + "part1/input.txt";
        val data: List<Movement> = readFileAsMovement(path)
        var dis = 0
        var dept = 0
        data.forEach { m ->
            run {
                if (m.dir == "forward") dis += m.amount
                if (m.dir == "down") dept += m.amount
                if (m.dir == "up") dept -= m.amount
            }
        }
        println(dis)
        println(dept)
        println(dept*dis)

    }
    override fun part2() {
        super.part2()
        val path: String = Day.DAY2.path + "part1/input.txt";
        val data: List<Movement> = readFileAsMovement(path)
        var aim = 0
        var dis = 0
        var dept = 0
        data.forEach { m ->
            run {
                if (m.dir == "forward") {
                    dis += m.amount
                    dept += aim * m.amount
                }
                if (m.dir == "down") aim += m.amount
                if (m.dir == "up") aim -= m.amount
            }
        }
        println(dis)
        println(dept)
        println(dept*dis)
    }
}
