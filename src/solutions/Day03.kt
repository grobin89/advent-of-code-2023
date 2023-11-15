package solutions

import workspaces.Workspace
import workspaces.WorkspaceDay03

class Day03 : Solution<List<String>, Int> {
    override val day: String = "03"
    override val workspace: Workspace<List<String>, Int> = WorkspaceDay03()
    override fun parse(data: List<String>): List<String> = data
}