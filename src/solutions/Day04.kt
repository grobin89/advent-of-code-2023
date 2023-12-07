package solutions

import domain.ScratchCard
import workspaces.WorkspaceDay04

class Day04 : Solution<List<ScratchCard>, Int> {
    override val day: String = "04"
    override val workspace = WorkspaceDay04()

    override fun parse(data: List<String>): List<ScratchCard> {
        return data.map {
            val cardNumber = it.split(":").first().split(" ").last().trim().toInt()
            val (winningNumbers, scratchNumbers) = it.split(":").last().split("|").map { raw ->
                raw.trim().split("\\s+".toRegex()).map { it.toInt() }.toSet()
            }
            ScratchCard(cardNumber, winningNumbers, scratchNumbers)
        }
    }
}