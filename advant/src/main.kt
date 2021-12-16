
fun main(args: Array<String>) {
    val day: Day = Day.valueOf("DAY4")
    day.advantQ.part1()
    day.advantQ.part2()
}


enum class Day (val path:String, val advantQ: advantQ) {
    DAY1("inputs/day1/", q1()),
    DAY2("inputs/day2/", q2()),
    DAY3("inputs/day3/", q3()),
    DAY4("inputs/day4/", q4())
}



