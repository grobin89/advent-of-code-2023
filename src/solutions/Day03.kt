package solutions

import workspaces.WorkspaceDay03

class Day03 : Solution<List<List<Char>>, Int> {
    override val day = "03"
    override val workspace = WorkspaceDay03()
    override fun parse(data: List<String>) = data.map { it.map { it } }
}