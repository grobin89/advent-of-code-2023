package workspaces

class WorkspaceDay04 : Workspace2<List<List<Pair<Int, Int>>>, Int> {
    override fun part1(input: List<List<Pair<Int, Int>>>): Int {
        var answer = 0
        input.forEach {
            val firstRange = it[0]
            val secondRange = it[1]

            if (rangeInRange(firstRange, secondRange)) {
                answer += 1
            }
        }

        return answer
    }

    override fun part2(input: List<List<Pair<Int, Int>>>): Int {
        var answer = 0
        input.forEach {
            val firstRange = it[0]
            val secondRange = it[1]

            if (rangePartlyInRange(firstRange, secondRange)) {
                answer += 1
            }
        }
        return answer
    }

    private fun rangeInRange(firstRange: Pair<Int, Int>, secondRange: Pair<Int, Int>): Boolean {
        if (firstRange.first >= secondRange.first && firstRange.second <= secondRange.second ) {
            return true
        }

        if (secondRange.first >= firstRange.first && secondRange.second <= firstRange.second) {
            return true
        }

        return false
    }

    private fun rangePartlyInRange(firstRange: Pair<Int, Int>, secondRange: Pair<Int, Int>): Boolean {
        if (firstRange.first in secondRange.first..secondRange.second) return true
        if (firstRange.second in secondRange.first..secondRange.second) return true
        if (secondRange.first in firstRange.first..firstRange.second) return true
        if (secondRange.second in firstRange.first..firstRange.second) return true
        return false
    }


}