fun main() = aoc {
    input { readInput("Day03") }

    val mulRegex = "mul\\(\\d+,\\d+\\)".toRegex()
    val digitsRegex = "\\d+".toRegex()
    val tokenRegex = "$mulRegex|(do|don't)\\(\\)".toRegex()

    fun calculateMul(mul: String): Int {
        var multiplyResult = 1

        digitsRegex.findAll(mul).forEach { result ->
            multiplyResult *= result.value.toInt()
        }
        return multiplyResult
    }

    part(1) {
        var totalResult = 0

        mulRegex.findAll(input.joinToString("")).forEach { matchResult ->
            totalResult += calculateMul(matchResult.value)
        }
        totalResult
    }

    part(2) {
        var totalResult = 0
        var calculationBlocked = false

        tokenRegex.findAll(input.joinToString("")).forEach { matchResult ->
            when {
                matchResult.value == "do()" -> calculationBlocked = false
                matchResult.value == "don't()" -> calculationBlocked = true
                !calculationBlocked -> totalResult += calculateMul(matchResult.value)
            }
        }

        totalResult
    }
}