package domain

data class ScratchCard(
    val cardNumber: Int,
    val winningNumbers: Set<Int>,
    val scratchNumbers: Set<Int>
) {
    val scoredNumbers: Set<Int> = scratchNumbers intersect winningNumbers
}
