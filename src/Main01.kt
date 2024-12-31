import java.io.File
import kotlin.math.abs

fun main() {
    val input = File("day01.txt").readLines()
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()
    val secondMap = mutableMapOf<Int,Int>()
    
    for (i in input) {
        val temp = i.split("   ")
        firstList.add(temp[0].toInt())
        secondList.add(temp[1].toInt())
        if (secondMap.containsKey(temp[1].toInt())) {
            secondMap[temp[1].toInt()] = secondMap[temp[1].toInt()]!! + 1
        }
        else {
            secondMap[temp[1].toInt()] = 1
        }
    }

    firstList.sort()
    secondList.sort()

    var sum1 = 0
    var sum2 = 0

    for (i in 0..<firstList.size) {
        sum1 += abs(secondList[i] - firstList[i])
        if (secondMap.containsKey(firstList[i])) {
            sum2 += firstList[i] * secondMap[firstList[i]]!!
        }
    }

    println(sum1)
    print(sum2)
}