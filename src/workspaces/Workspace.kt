package workspaces

interface Workspace<T, R> {
    fun part(partNumber: String, input: T): R
}