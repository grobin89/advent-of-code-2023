package workspaces

interface Workspace2<T, R> : Workspace1<T, R> {
    fun part2(input: T): R
    override fun part(partNumber: String, input: T): R {
        when(partNumber) {
            "1" -> return part1(input)
            "2" -> return part2(input)
        }
        throw Exception("part [$partNumber] does not exist")
    }
}