package solutions

import workspaces.WorkspaceDay05

class Day05 : Solution<InstructionStacks, String> {
    override val day = "05"
    override val workspace = WorkspaceDay05()

    override fun parse(data: List<String>): InstructionStacks {
        // stacks
        val rawStacks = data.takeWhile { it != "" }
        val stackIndexes = rawStacks.last().foldIndexed(listOf<Int>()) { index, acc, c -> if (c == ' ') acc else acc + index }
        val preStacks = rawStacks
            .take(rawStacks.size - 1)
            .map { row -> stackIndexes.map { index -> row.getOrNull(index) } }
            .reversed()
        val stacks = mutableListOf<MutableList<Char>>()
        for (stackIndex in stackIndexes.indices) {
           for (layerIndex in 0 until rawStacks.size - 1) {
               if (stacks.size - 1 < stackIndex) stacks.add(mutableListOf())
               val item = preStacks[layerIndex][stackIndex]
               if (item != null && item != ' ') stacks[stackIndex].add(item)
           }
        }

        // instructions
        val rawInstructions = data.takeLastWhile { it != "" }
        val instructions = rawInstructions.map { rawInstruction ->
            val instructionSet = rawInstruction.split(" ")
            Instruction(
                instructionSet[1].toInt(),
                instructionSet[3].toInt() - 1,
                instructionSet[5].toInt() - 1
            )
        }

        return InstructionStacks(stacks, instructions)
    }
}

data class InstructionStacks(
    val stack: MutableList<MutableList<Char>>,
    val instructions: List<Instruction>
)


data class Instruction(
    val move: Int,
    val from: Int,
    val to: Int
)