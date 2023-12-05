package workspaces

class WorkspaceDay03 : Workspace2<List<List<Char>>, Int> {
    override fun part1(input: List<List<Char>>): Int {
        val partNumbers = mutableListOf<Int>()
        val ignore = mutableSetOf<Pair<Int, Int>>()
        for ((xIndex, chars) in input.withIndex()) {
            chars.forEachIndexed { yIndex, char ->
                if (char.isDigit() || char == '.') return@forEachIndexed
                do {
                    val pin = detectDigit(input, ignore, xIndex, yIndex) ?: return@forEachIndexed
                    val extract = extractNumber(input, pin)
                    partNumbers.add(extract.first)
                    ignore.addAll(extract.second)
                } while (true)
            }
        }
        return partNumbers.sum()
    }

    override fun part2(input: List<List<Char>>): Int {
        val gears = mutableListOf<Int>()
        val ignore = mutableSetOf<Pair<Int, Int>>()
        val buffer = mutableListOf<Int>()
        for ((xIndex, chars) in input.withIndex()) {
            chars.forEachIndexed { yIndex, char ->
                if (char != '*') return@forEachIndexed
                do {
                    val pin = detectDigit(input, ignore, xIndex, yIndex) ?: break
                    val extract = extractNumber(input, pin)
                    buffer.add(extract.first)
                    ignore.addAll(extract.second)
                } while (true)

                if (buffer.size == 2) {
                    gears.add(buffer.fold(1) { ratio, gear -> ratio * gear })
                }
                buffer.clear()
            }
        }
        return gears.sum()
    }

    private fun detectDigit(input: List<List<Char>>, ignore: Set<Pair<Int, Int>>, x: Int, y: Int): Pair<Int, Int>? {
        for (xScan in x-1..x+1) {
            (y-1..y+1).forEach { yScan ->
                if (ignore.contains(Pair(xScan, yScan))) return@forEach
                if (input[xScan][yScan].isDigit()) return Pair(xScan, yScan)
            }
        }
        return null
    }

    private fun extractNumber(input: List<List<Char>>, pin: Pair<Int, Int>): Pair<Int, List<Pair<Int, Int>>> {
        val buffer = mutableListOf<Char>()
        val ignore = mutableListOf<Pair<Int, Int>>()
        val line = input[pin.first]
        var y = pin.second

        while (y - 1 >= 0 && line[y - 1].isDigit()) y -= 1

        while (y < line.size && line[y].isDigit()) {
            buffer.add(line[y])
            ignore.add(Pair(pin.first, y))
            y += 1
        }
        if (buffer.isEmpty()) throw Exception("error: no number detected with pin $pin")
        return Pair(buffer.joinToString("").toInt(), ignore)
    }
}