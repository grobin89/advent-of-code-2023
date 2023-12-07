package workspaces

import domain.ScratchCard


class WorkspaceDay04 : Workspace2<List<ScratchCard>, Int> {
    override fun part1(input: List<ScratchCard>): Int = input.sumOf { score(it) }

    override fun part2(input: List<ScratchCard>): Int {
        val instances = mutableListOf<Int>()
        input.forEach { _ -> instances.add(1) }
        input.forEachIndexed { index, scratchCard ->
            val matches = scratchCard.scoredNumbers.size
            (index+1..index+matches).forEach { instances[it] += instances[index] }
        }
        return instances.sum()
    }

    private fun score(scratchCard: ScratchCard) = scratchCard.scoredNumbers
        .foldIndexed(0) { index, acc, _ -> if (index == 0) 1 else acc * 2 }

}