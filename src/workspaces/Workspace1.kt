package workspaces

interface Workspace1<T, R> : Workspace<T, R> {
    fun part1(input: T): R
    override fun part(partNumber: String, input: T): R {
        when(partNumber) {
            "1" -> return part1(input)
        }
        throw Exception("part [$partNumber] does not exist")
    }
}