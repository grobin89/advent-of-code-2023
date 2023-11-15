package workspaces

import java.lang.Exception

class WorkspaceDay02 : Workspace2<List<List<String>>, Int> {
    override fun part1(input: List<List<String>>): Int {
        var score = 0

        input.forEach {
            score += round(it[0], it[1]) + pick(it[1])
        }

        return score
    }

    override fun part2(input: List<List<String>>): Int {
        var score = 0
        input.forEach {
            score += outcome(it[1]) + pick(translate(it[0], it[1])!!)
        }
        return score
    }


    private val rock = listOf("A", "X")
    private val paper = listOf("B", "Y")
    private val scissors = listOf("C", "Z")

    private val lose = mapOf(
        "B" to "X",
        "C" to "Y",
        "A" to "Z"
    )

    private val draw = mapOf(
        "A" to "X",
        "B" to "Y",
        "C" to "Z"
    )

    private val win = mapOf(
        "A" to "Y",
        "B" to "Z",
        "C" to "X"
    )

    private fun pick(choice: String): Int {
        if (choice in rock) return 1
        if (choice in paper) return 2
        if (choice in scissors) return 3
        else throw Exception("Not a legal choice")
    }

    private fun round(opponent: String, you: String): Int {
        if (pick(opponent) == pick(you)) return 3
        if (opponent in rock && you in paper) return 6
        if (opponent in paper && you in scissors) return 6
        if (opponent in scissors && you in rock) return 6
        return 0
    }

    private fun outcome(choice: String): Int {
        if (choice == "X") return 0
        if (choice == "Y") return 3
        if (choice == "Z") return 6
        throw Exception("Not a legal choice!")
    }

    private fun translate(opponent: String, outcome: String): String? {
        if (outcome == "X") return lose[opponent]
        if (outcome == "Y") return draw[opponent]
        if (outcome == "Z") return win[opponent]
        throw Exception("Not a legal outcome option!")
    }
}