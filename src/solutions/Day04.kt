package solutions

import workspaces.Workspace
import workspaces.WorkspaceDay04

class Day04 : Solution<List<List<Pair<Int, Int>>>, Int> {
    override val day: String = "04"
    override val workspace: Workspace<List<List<Pair<Int, Int>>>, Int> = WorkspaceDay04()

    override fun parse(data: List<String>): List<List<Pair<Int, Int>>> {
        return data.map { line -> line
            .split(",")
            .map { pair -> pair.split("-").map { it.toInt() } }
            .map { Pair(it[0], it[1]) }
        }
    }
}