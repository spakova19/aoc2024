import java.io.File

fun oneSlice(curr: List<String>): Boolean {
    var desc = false

    if (curr[0].toInt() > curr[1].toInt()) {
        desc = true
    }

    for (i in 0..<curr.size-1) {
        if (desc && (curr[i].toInt() <= curr[i+1].toInt() || curr[i].toInt() - curr[i+1].toInt() > 3)) {
            return false
        }

        else if (!desc && (curr[i+1].toInt() <= curr[i].toInt() || curr[i+1].toInt() - curr[i].toInt() > 3)) {
            return false
        }
    }

    return true
}

fun main() {
    val input = File("day02.txt").readLines()
    var count1 = 0
    var count2 = 0
    for (line in input) {
        val curr = line.split(" ")
        if (oneSlice(curr)) {
            count1++
            count2++
        }
        else {
            for (i in 0..<curr.size) {
                var temp = curr.toMutableList()
                temp.removeAt(i)
                if (oneSlice(temp)) {
                    count2++
                    break
                }
            }
        }
    }

    println(count1)
    println(count2)
}