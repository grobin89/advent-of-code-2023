package workspaces

import domain.Race

class WorkspaceDay06 : Workspace2<List<Race>, Long> {
    override fun part1(input: List<Race>): Long {
        return input
                .map { race -> findWaysToWin(race) }
                .fold(1) { acc, l -> l * acc }
    }

    override fun part2(input: List<Race>): Long {
        val race = parse2(input)
        return findWaysToWin(race)
    }

    private fun parse2(input: List<Race>): Race {
        val time = input.map { it.time }.joinToString("").toLong()
        val distance = input.map { it.distance }.joinToString("").toLong()
        return Race(time, distance)
    }

    private fun findWaysToWin(race: Race): Long {
        return (0L..race.time)
            .map { buttonHoldTime -> buttonHoldTime * (race.time - buttonHoldTime) }
            .filter { it > race.distance }
            .size.toLong()
    }
}