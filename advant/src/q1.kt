class q1 : advantQ() {
    override fun part1() {
        super.part1()
        val path: String = Day.DAY1.path + "part1/input.txt";
        val data: List<Int> = readFileAsInt(path)
        var count = 0;
        for (i in 1 until data.size) {
            if (data[i-1] < data[i]) {
                count++;
            }
        }
        println(count);
    }
    override fun part2() {
        super.part2()
        val path: String = Day.DAY1.path + "part1/input.txt";
        val data: List<Int> = readFileAsInt(path)
        var count = 0;
        for (i in 3 until data.size) {
            val sum1 = data[i-3] + data[i-2] + data[i-1]
            val sum2 = data[i-2] + data[i-1] + data[i]

            if (sum1 < sum2) {
                count++;
            }
        }
        println(count);
    }
}
