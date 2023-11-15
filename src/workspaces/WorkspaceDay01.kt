package workspaces

class WorkspaceDay01 : Workspace2<List<List<Int>>, Int> {
    override fun part1(input: List<List<Int>>): Int = input.maxOf { it.sum() }
    override fun part2(input: List<List<Int>>): Int = input.map { it.sum() }.sortedDescending().take(3).sum()
}