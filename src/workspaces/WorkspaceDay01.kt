package workspaces

class WorkspaceDay01 : Workspace2<List<String>, Int> {
    override fun part1(input: List<String>): Int = input.sumOf { getInteger(it) }

    override fun part2(input: List<String>): Int = input
//        .map {
//            val digits = replaceWordToInteger(it)
//            println("$digits = $it")
//            it
//        }
        .sumOf {
                replaceWordToInteger(it)
    }

    private fun getInteger(input: String): Int {
        val first = input.first { it.isDigit() }.digitToInt()
        val last = input.last { it.isDigit() }.digitToInt()
        return (first * 10) + last
    }

    private fun replaceWordToInteger(input: String): Int {
        val firstDigitIndex = input.indexOfFirst { it.isDigit() }
        val lastDigitIndex = input.indexOfLast { it.isDigit() }
        val firstWord = findFirstWord(input) ?: ""
        val lastWord = findLastWord(input) ?: ""
        val firstWordIndex = if (firstWord == "") -1 else input.indexOf(firstWord)
        val lastWordIndex = if (lastWord == "") -1 else input.lastIndexOf(lastWord)

        val firstDigit = when {
            firstWordIndex == -1 -> input[firstDigitIndex]
            firstDigitIndex == -1 -> dict[firstWord]
            firstDigitIndex < firstWordIndex -> input[firstDigitIndex]
            firstWordIndex < firstDigitIndex -> dict[firstWord]
            else -> ""
        }

        val lastDigit = when {
            lastWordIndex == -1 -> input[lastDigitIndex]
            lastDigitIndex == -1 -> dict[lastWord]
            lastDigitIndex > lastWordIndex -> input[lastDigitIndex]
            lastWordIndex > lastDigitIndex -> dict[lastWord]
            else -> ""
        }

        return "$firstDigit$lastDigit".toInt()
    }

    private fun findFirstWord(input: String): String? {
        var rank = -1
        var firstWord: String? = null
        dict.keys.forEach { word ->
            val index = input.indexOf(word)
            if (index == -1) return@forEach
            if (rank == -1) rank = index
            else if (index < rank) rank = index
            if (index == rank) firstWord = word
        }
        return firstWord
    }

    private fun findLastWord(input: String): String? {
        var rank = -1
        var lastWord: String? = null
        dict.keys.forEach { word ->
            val index = input.lastIndexOf(word)
            if (index == -1) return@forEach
            if (rank == -1) rank = index
            else if (index > rank) rank = index
            if (index == rank) lastWord = word
        }
        return lastWord
    }

    private val dict = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
}