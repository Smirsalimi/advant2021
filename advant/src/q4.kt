class bingo(val board:List<List<String>>) {
    val columnCounts = IntArray(5)
    val rowCounts = IntArray(5)
    var last = ""
    var done = false
    private val seen: List<BooleanArray> = List(5) { BooleanArray(5)  {false} }

    fun handle(num: String) : Boolean{
        for(i in 0..4) {
            for(j in 0..4) {
                if(board[i][j] == num) {
                    if(!seen[i][j]) {
                        seen[i][j] = true
                        columnCounts[j]++
                        rowCounts[i]++

                        if(columnCounts[j] >= 5 || rowCounts[i] >= 5) {
                            last = num
                            done = true
                            return true
                        }
                    }
                    return false
                }
            }
        }
        return false
    }

    fun getWinnings():Int {
        var sum = 0
        for(i in 0..4) {
            for (j in 0..4) {
                if (!seen[i][j]) {
                    sum += board[i][j].toInt()
                }
            }
        }
        return last.toInt() * sum
    }

    fun printBoard() {
        println(last)
        for(line in board) {
            println(line.joinToString(separator = " "))
        }
    }
}

class q4 : advantQ(){

    override fun part1() {
        super.part1()
        val path: String = Day.DAY4.path + "part1/input.txt";
        val data = readFileAsString(path)
        var boards:MutableList <bingo> = ArrayList()
        var inputs = data[0].split(',')

        for(i in 2 until data.size step 6 ) {
            boards.add(bingo(listOf(
                data[i].split(' ').filter { it != "" },
                data[i+1].split(' ').filter { it != "" },
                data[i+2].split(' ').filter { it != "" },
                data[i+3].split(' ').filter { it != "" },
                data[i+4].split(' ').filter { it != "" }
                )))
        }

        for (num in inputs) {
            for(board in boards) {
                if(board.handle(num)){
                    board.printBoard()
                    println(board.getWinnings())
                    return
                }
            }
        }
    }
    override fun part2() {
        super.part2()
        val path: String = Day.DAY4.path + "part1/input.txt";
        val data = readFileAsString(path)
        var boards:MutableList <bingo> = ArrayList()
        var inputs = data[0].split(',')

        for(i in 2 until data.size step 6 ) {
            boards.add(bingo(listOf(
                data[i].split(' ').filter { it != "" },
                data[i+1].split(' ').filter { it != "" },
                data[i+2].split(' ').filter { it != "" },
                data[i+3].split(' ').filter { it != "" },
                data[i+4].split(' ').filter { it != "" }
            )))
        }
        var last: bingo? = null
        for (num in inputs) {
            for(board in boards) {
                if(!board.done && board.handle(num)){
                    last = board
                }
            }
        }
        last!!.printBoard()
        println(last!!.getWinnings())

    }
}