import java.io.File

class q3 : advantQ(){

    fun pow2(pow: Int) : Int{
        var res = 1
        for(i in 1..pow) {
            res *= 2
        }
        return res
    }

    fun getMostCommonBit(data: List<String>, bitNum: Int) :Int{
        var count = 0
        data.forEach { m ->
            run {
                count += if(m[bitNum] == '0') -1 else 1
            }
        }
        return if (count >= 0) 1 else 0;
    }

    fun filterData(data: List<String>, bitNum: Int, bitVal: Int): List<String> {
        return data.filter { (it[bitNum]-'0') == bitVal}
    }

    override fun part1() {
        super.part1()
        val path: String = Day.DAY3.path + "part1/input.txt";
        val data: List<String> = readFileAsString(path)
        var gammaArray = IntArray(12);
        data.forEach { m ->
            run {
                for (i in 0 until data[0].length) {
                    gammaArray[i] += if(m[i] == '0') -1 else 1
                }
            }
        }
        var gammaInt = 0;
        for(i in 0 until data[0].length) {
            gammaInt += pow2(i) * if (gammaArray[data[0].length - 1 -i] > 0) 1 else 0
        }
        var wrap = 0
        for(i in 0 until data[0].length) {
            wrap += pow2(i) * 1
        }
        val epsilon = gammaInt.xor(wrap)
        println(gammaInt)
        println(epsilon)
        println(gammaInt*epsilon)

    }
    override fun part2() {
        super.part2()
        val path: String = Day.DAY3.path + "part1/input.txt";
        var oData = readFileAsString(path)
        var coData = readFileAsString(path)

        for(i in 0 until oData[0].length){
            val oVal = getMostCommonBit(oData, i)
            val coVal = if(getMostCommonBit(coData, i) == 1) 0 else 1
            if(oData.size != 1) {
                oData = filterData(oData, i, oVal)
            }

            if(coData.size != 1) {
                coData = filterData(coData, i, coVal)
            }
        }
        println(oData.size)
        println(coData.size)
        var oFinal = 0
        var coFinal = 0
        for(i in 0 until oData[0].length) {
            oFinal += pow2(i) * if ((oData[0][oData[0].length-1-i]-'0') > 0) 1 else 0
            coFinal += pow2(i) * if ((coData[0][oData[0].length-1-i]-'0') > 0) 1 else 0
        }
        println(oFinal)
        println(coFinal)
        println(oFinal * coFinal)
    }
}