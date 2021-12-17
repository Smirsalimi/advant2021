import java.lang.Math.abs

class q7 : advantQ(){

    override fun part1() {
        super.part1()
        val path: String = Day.DAY7.path
        val data = readFileAsString(path)[0].split(",").map{it.toInt()}.sorted()


        val solutions = MutableList(data.last() + 1) {0}
        var dataindex = data.count{it == 0}

        var min = data.sum()
        solutions[0] = min
        var minIndex = 0
        // first round
        for(i in 1 until solutions.size) {
            while(i > data[dataindex]) {
                dataindex++;
            }
            solutions[i] = solutions[i-1] + dataindex - (data.size - dataindex)
            if(min > solutions[i]) {
                min = minOf(min, solutions[i])
                minIndex = i
            }
        }
        println(minIndex)
        println(min)
    }

    override fun part2() {
        val path: String = Day.DAY7.path
        val data = readFileAsString(path)[0].split(",").map{it.toInt()}.sorted()


        val solutions = MutableList(data.last() + 1) {0}
        var dataindex = data.count{it == 0}

        var min = data.sumOf { it * (it+1)/2 }
        solutions[0] = min
        var minIndex = 0

        // first round
        for(i in 1 until solutions.size) {
            while(i > data[dataindex]) {
                dataindex++;
            }

            solutions[i] = solutions[i-1] +
                    sumDistance(data.subList(0,dataindex), i) -
                    sumDistance(data.subList(dataindex, data.size), i-1)
            if(min > solutions[i]) {
                min = minOf(min, solutions[i])
                minIndex = i
            }
        }


        println(minIndex)
        println(min)

    }

    fun sumDistance(data:List<Int>, index:Int) : Int {
        var sum =0
        for (num in data) {
            sum += kotlin.math.abs(num - index)
        }
        return sum
    }
}