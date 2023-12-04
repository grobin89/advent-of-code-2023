package workspaces

import domain.CubeGame

class WorkspaceDay02 : Workspace2<List<CubeGame>, Int> {
    override fun part1(input: List<CubeGame>): Int {
        val redThreshold = 12
        val greenThreshold = 13
        val blueThreshold = 14
        return input.filter { it.rounds.all { round ->
            round.red <= redThreshold && round.green <= greenThreshold && round.blue <= blueThreshold
        }}.sumOf { it.gameNumber }
    }

    override fun part2(input: List<CubeGame>): Int {
        return input.sumOf { game ->
            val minRed = game.rounds.maxOf { it.red.floor(1) }
            val minGreen = game.rounds.maxOf { it.green.floor(1) }
            val minBlue = game.rounds.maxOf { it.blue.floor(1) }
            minRed * minGreen * minBlue
        }
    }

    private fun Int.floor(floor: Int): Int = if (this < floor) floor else this
}