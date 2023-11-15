package solutions

import workspaces.WorkspaceDay01

class Day01 : Solution<List<List<Int>>, Int> {
    override val day = "01"
    override val workspace = WorkspaceDay01()
    override fun parse(data: List<String>): List<List<Int>> {
        return data
            .joinToString(",")
            .split(",,")
            .map { chunk -> chunk.split(",").map { it.toInt() } }
    }
}