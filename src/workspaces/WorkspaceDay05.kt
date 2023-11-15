package workspaces

import solutions.InstructionStacks

class WorkspaceDay05 : Workspace2<InstructionStacks, String> {
    override fun part1(input: InstructionStacks): String {
        val instructions = input.instructions
        val stacks = input.stack

        instructions.forEach { instruction ->
            for (move in 1..instruction.move) {
                val item = stacks[instruction.from].removeLast()
                stacks[instruction.to].add(item)
            }
        }

        return stacks.map { it.last() }.joinToString("")
    }

    override fun part2(input: InstructionStacks): String {
        val instructions = input.instructions
        val stacks = input.stack

        instructions.forEach { instruction ->
            val items = stacks[instruction.from].takeLast(instruction.move)
            for (remove in 1 ..instruction.move) stacks[instruction.from].removeLast()
            stacks[instruction.to].addAll(items)
        }
        return stacks.map { it.last() }.joinToString("")
    }

}