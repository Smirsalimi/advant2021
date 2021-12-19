class q8 : advantQ(){

    override fun part1() {
        super.part1()
        val path: String = Day.DAY8.path
        val data = readFileAsString(path)
        val result = data.sumOf { println(it)
            countUniqueNums(it.split('|')[1]) }
        println(result)
    }

    fun countUniqueNums(output: String): Int {
        return output.split(' ').count { isUniqueNum(it) }
    }

    fun isUniqueNum(num:String): Boolean {
        return when(num.length) {
            2,3,4,7-> true
            else -> false
        }
    }
    override fun part2() {
        super.part2()
        val path: String = Day.DAY8.path
        val data = readFileAsString(path)
        println(data.sumByLong { sumOutput(it) })
    }

    fun sumOutput(data:String) :Long {
        val signals = data.split(" | ")[0].split(' ')
        val output = data.split(" | ")[1].split(' ')
        var mapping: Array<String> = Array(10) {""}
        signals.forEach {
            when (it.length) {
                2 -> mapping[1] = it
                3 -> mapping[7] = it
                4 -> mapping[4] = it
            }
        }
        var sum = 0L
        output.forEachIndexed { index, num ->
            var currentNum = when (num.length) {
                    2 -> 1
                    3 -> 7
                    4 -> 4
                    5 -> {
                        if (containsNum(num, mapping[1], 2)) {
                            3
                        } else if (containsNum(num, mapping[4], 3)) {
                            5
                        } else {
                            2
                        }
                    }
                    6 -> {
                        if (containsNum(num, mapping[4], 4)) {
                            9
                        } else if (!containsNum(num, mapping[1], 2)) {
                            6
                        } else {
                            0
                        }
                    }
                    else -> 8
                }
            sum += pow(3-index) * currentNum
        }
        return sum
    }

    fun containsNum (a: String, b: String, matchRule: Int): Boolean {
        return matchRule <= b.count {a.contains(it)}
    }

    fun pow(power: Int) :Int {
        var num = 1
        for(i in 1..power)
            num *= 10
        return num
    }

    inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
        var sum = 0L
        for (element in this) {
            sum += selector(element)
        }
        return sum
    }

}
