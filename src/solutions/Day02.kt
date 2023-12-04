package solutions

import domain.CubeGame
import domain.CubeRound
import workspaces.WorkspaceDay02

class Day02 : Solution<List<CubeGame>, Int> {
    override val day = "02"
    override val workspace = WorkspaceDay02()

    override fun parse(data: List<String>): List<CubeGame> {
        return data.map {
            val gameNumber = it.split(":").first().split(" ").last().toInt()
            val rounds = it.split(":").last().split(";")
                .map { rawRound ->
                    val round = rawRound.split(",").map { cubeCount -> cubeCount.trim().split(" ") }
                    val red = round.find { it.last() == "red" }?.first() ?: "0"
                    val green = round.find { it.last() == "green" }?.first() ?: "0"
                    val blue = round.find { it.last() == "blue" }?.first() ?: "0"
                    CubeRound(red.toInt(), green.toInt(), blue.toInt())
                }
            CubeGame(gameNumber, rounds)
        }
    }
}