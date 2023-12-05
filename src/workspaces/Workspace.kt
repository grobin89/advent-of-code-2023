package workspaces

interface Workspace<I, O> {
    fun part(partNumber: String, input: I): O
}