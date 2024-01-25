package solutions

import parseFile
import parseTestFile
import workspaces.Workspace

interface Solution<I, O> {
    val day: String
    val workspace: Workspace<I, O>
    fun run(part: String): Answer {
        // test
        val testFile = parseTestFile(day, part)
        val assertion = testFile.first()
        val testData = parse(testFile.subList(1, testFile.size))
        val test = workspace.part(part, testData).toString()

        if (test != assertion) return Answer(day, part, "", test, assertion)

        // answer
        val mainFile = parseFile(day, part)
        val data = parse(mainFile)
        val answer = workspace.part(part, data).toString()

        return Answer(day, part, answer, test, assertion)
    }

    fun parse(data: List<String>): I
}
