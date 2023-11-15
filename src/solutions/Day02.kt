package solutions

import workspaces.Workspace
import workspaces.WorkspaceDay02

class Day02 : Solution<List<List<String>>, Int> {
    override val day: String
        get() = "02"
    override val workspace: Workspace<List<List<String>>, Int>
        get() = WorkspaceDay02()
    override fun parse(data: List<String>): List<List<String>> = data.map { it.split(" ") }
}