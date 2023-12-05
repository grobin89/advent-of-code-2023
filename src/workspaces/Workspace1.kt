package workspaces

interface Workspace1<I, O> : Workspace<I, O> {
    fun part1(input: I): O
    override fun part(partNumber: String, input: I): O {
        when(partNumber) {
            "1" -> return part1(input)
        }
        throw Exception("part [$partNumber] does not exist")
    }
}