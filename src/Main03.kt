import java.io.File

fun calculate(currVals: List<String>): Int {
    var sumOfNums = 0
    for (curr in currVals) {
        val temp = curr.split(")")[0].split(",")

        if (temp.size != 2) {
            continue
        }

        val firstNum = temp[0]
        val secondNum = temp[1]

        if (firstNum.length > 3 || secondNum.length > 3) {
            continue
        }

        try {
            sumOfNums += firstNum.toInt() * secondNum.toInt()
        } catch (e: NumberFormatException) {
            continue
        }
    }
    return sumOfNums
}

fun main() {
    var input = File("day03.txt").readLines()
    var sumOfNums1 = 0
    for (line in input) {
        val currLine = line.split("mul(")
        sumOfNums1 += calculate(currLine)
    }

    var sumOfNums2 = 0
    var donts = File("day03.txt").readLines().toString().split("don't()").toMutableList()
    donts[0] = "do()" + donts[0]

    for (i in donts) {
        var dos = i.split("do()")
        for (j in 1..<dos.size) {
            val currVals = dos[j].split("mul(")
            sumOfNums2 += calculate(currVals)
        }
    }

    println(sumOfNums1)
    println(sumOfNums2)
}