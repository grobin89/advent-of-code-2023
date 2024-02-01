package solutions

import domain.Race
import workspaces.WorkspaceDay06

class Day06 : Solution<List<Race>, Long> {
    override val day = "06"
    override val workspace = WorkspaceDay06()

    override fun parse(data: List<String>): List<Race> {
        val (time, distance) = data.map { it.split("\\s+".toRegex()).drop(1).map { dPoint -> dPoint.toLong() } }
        return time.mapIndexed { index, t -> Race(t, distance[index]) }
    }
}