import java.io.File

fun check(curr: String) : Int {
    if (curr == "XMAS" || curr == "SAMX") {
        return 1
    }
    return 0
}

fun checkMas(first: String, second: String) : Int {
    if ((first == "MAS" || first == "SAM") && (second == "MAS" || second == "SAM")) {
        return 1
    }
    return 0
}


fun main() {
    val input = File("day04.txt").readLines()
    var count1 = 0 //xmas
    var count2 = 0 //mas in X shape
    for (i in 0..<input.size) {
        for (j in 0..<input[0].length) {
            //col
            if (i < input.size-3) {
                count1 += check(input[i][j].toString() + input[i+1][j] + input[i+2][j] + input[i+3][j])
            }

            //line
            if (j < input[0].length-3) {
                count1 += check(input[i][j].toString() + input[i][j+1] + input[i][j+2] + input[i][j+3])
            }

            //diag1
            if (j < input[0].length-3 && i > 2) {
                count1 += check(input[i][j].toString() + input[i-1][j+1] + input[i-2][j+2] + input[i-3][j+3])
            }

            //diag2
            if (j > 2 && i > 2) {
                count1 += check(input[i][j].toString() + input[i-1][j-1] + input[i-2][j-2] + input[i-3][j-3])
            }
        }
    }

    for (i in 0..<input.size-2) {
        for (j in 0..<input[0].length-2) {
            val first = input[i][j].toString() + input[i+1][j+1] + input[i+2][j+2]
            val second = input[i+2][j].toString() + input[i+1][j+1] + input[i][j+2]
            count2 += checkMas(first, second)
        }
    }

    println(count1)
    println(count2)
}