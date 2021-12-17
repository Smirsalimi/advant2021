class q6 : advantQ() {
    override fun part1() {
        super.part1()
        val path: String = Day.DAY6.path + "part1/input.txt";
        val data: MutableList<Int> = readFileAsString(path)[0].split(",").map { it.toInt() }.toMutableList()
        val days = 79
        var sum: Long = data.size.toLong()

        for(i in data) {
            sum += calcChildCount(i, days)
        }
        println(sum)
    }

    fun calcChildCount(num:Int, day:Int): Long {
        var sum:Long = 0
        if(num > day) {
            return 0
        }
        val children = (day - num)/7 + 1
        sum+=children
        for(i in 0 until children) {
            val rem = day-(i*7)-num -1
            val d = calcChildCount(8, rem)
            sum+= d
        }
        return sum
    }
    override fun part2() {
        super.part2()

        val path: String = Day.DAY6.path + "part1/input.txt";
        val data: MutableList<Int> = readFileAsString(path)[0].split(",").map { it.toInt() }.toMutableList()
        val days = 256
        var sum: Long = + 0L +data.size
        val birthDays: MutableList<Long> = MutableList(days+10){0}
        for(i in data) {
            val count = birthDays[i]
            birthDays[i] = count + 1
        }

        for(i in 0 until days) {
            val newFish = birthDays[i]
            val countNew = birthDays[i+9]
            birthDays[i+9] = newFish + countNew
            val countOld = birthDays[i+7]
            birthDays[i+7] = countOld + newFish
            sum+=newFish.toLong()
        }
        println(sum)

    }

}