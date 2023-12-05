package workspaces

interface Workspace2<I, O> : Workspace1<I, O> {
    fun part2(input: I): O
    override fun part(partNumber: String, input: I): O {
        when(partNumber) {
            "1" -> return part1(input)
            "2" -> return part2(input)
        }
        throw Exception("part [$partNumber] does not exist")
    }
}