package workspaces

class WorkspaceDay03 : Workspace2<List<String>, Int> {
    override fun part1(input: List<String>): Int {
        val priority = mappedLetters()
        return input
            .map {
                val half = it.length / 2
                listOf(it.substring(0, half), it.substring(half))
            }
            .sumOf { priority[findDuplicate(it)]!! }
    }

    override fun part2(input: List<String>): Int {
        val priority = mappedLetters()
        return input.chunked(3).sumOf { priority[findDuplicate(it)]!! }
    }

    private fun mappedLetters(): HashMap<Char, Int> {
        val letters = CharRange('a', 'z').toList() + CharRange('A', 'Z').toList()
        val mappedLetters = HashMap<Char, Int>()
        letters.forEachIndexed { index, item -> mappedLetters[item] = index + 1 }
        return mappedLetters
    }

    private fun findDuplicate(ruckSack: List<String>): Char {
        val badges = ruckSack.fold(ruckSack.first().toSet()) { accum, pocket -> accum intersect pocket.toSet() }
        return badges.first()
    }

}