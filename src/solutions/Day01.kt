package solutions

import workspaces.Workspace
import workspaces.WorkspaceDay01

class Day01 : Solution<List<String>, Int> {
    override val day: String = "01"
    override val workspace: Workspace<List<String>, Int> = WorkspaceDay01()
    override fun parse(data: List<String>): List<String> = data
}