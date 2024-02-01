package workspaces

import domain.Race

class WorkspaceDay06 : Workspace2<List<Race>, Long> {
    override fun part1(input: List<Race>): Long {
        return input
                .map { race ->
                    (0L..race.time)
                            .map { buttonHoldTime -> buttonHoldTime * (race.time - buttonHoldTime) }
                            .filter { it > race.distance }
                            .size.toLong()
                }
                .fold(1) { acc, l -> l * acc }
    }

    override fun part2(input: List<Race>): Long {
        TODO("Not yet implemented")
    }
}