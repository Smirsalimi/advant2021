import java.lang.Integer.max
import java.lang.Integer.min

class q5 : advantQ() {
    data class Location(val x: Int, val y: Int)

    override fun part1() {
        super.part1()
        val path: String = Day.DAY5.path + "part1/input.txt";
        val smokeMap: MutableMap<Location, Int> = HashMap()
        val data: List<String> = readFileAsString(path)
        for(line in data) {
            val points = line.split(" -> ")
            val start = getLocation(points[0])
            val end = getLocation(points[1])
            if(start.x == end.x) {
                for (i in min(start.y, end.y)..max(start.y, end.y)){
                    val currentLocation = Location(start.x, i)
                    val count = smokeMap.getOrDefault(currentLocation, 0)
                    smokeMap[currentLocation] = count + 1
                }
            }
            if(start.y == end.y) {
                for (i in min(start.x, end.x)..max(start.x, end.x)){
                    val currentLocation = Location(i, start.y)
                    val count = smokeMap.getOrDefault(currentLocation, 0)
                    smokeMap[currentLocation] = count + 1
                }
            }
        }
        println(smokeMap.values.count { it>=2 })
    }

    private fun getLocation(line:String) :Location {
        val start = line.split(",")
        return Location(start[0].toInt(), start[1].toInt())
    }

    override fun part2() {
        super.part2()
        val path: String = Day.DAY5.path + "part1/input.txt";
        val smokeMap: MutableMap<Location, Int> = HashMap()
        val data: List<String> = readFileAsString(path)
        for(line in data) {
            val points = line.split(" -> ")
            val start = getLocation(points[0])
            val end = getLocation(points[1])
            if(start.x == end.x) {
                for (i in min(start.y, end.y)..max(start.y, end.y)){
                    val currentLocation = Location(start.x, i)
                    val count = smokeMap.getOrDefault(currentLocation, 0)
                    smokeMap[currentLocation] = count + 1
                }
            }
            if(start.y == end.y) {
                for (i in min(start.x, end.x)..max(start.x, end.x)){
                    val currentLocation = Location(i, start.y)
                    val count = smokeMap.getOrDefault(currentLocation, 0)
                    smokeMap[currentLocation] = count + 1
                }
            }
            if(kotlin.math.abs(start.x - end.x) == kotlin.math.abs(start.y - end.y)) {
                val xDir = if(start.x > end.x) -1 else 1
                val yDir = if(start.y > end.y) -1 else 1
                for(i in 0..kotlin.math.abs(start.x - end.x)){
                    val currentLocation = Location(start.x + i*xDir, start.y + i*yDir)
                    val count = smokeMap.getOrDefault(currentLocation, 0)
                    smokeMap[currentLocation] = count + 1
                }
            }
        }
        println(smokeMap.values.count { it>=2 })
    }
}
