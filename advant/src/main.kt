
fun main(args: Array<String>) {
    val day: Day = Day.valueOf("DAY7")
    day.advantQ.part1()
    day.advantQ.part2()
}

/*
Not needed just wanted to try out enums in kotlin
 */
enum class Day (val path:String, val advantQ: advantQ) {
    DAY1("inputs/day1/", q1()),
    DAY2("inputs/day2/", q2()),
    DAY3("inputs/day3/", q3()),
    DAY4("inputs/day4/", q4()),
    DAY5("inputs/day5/", q5()),
    DAY6("inputs/day6/", q6()),
    DAY7("inputs/day7.txt", q7())
}



