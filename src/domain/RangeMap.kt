package domain

data class RangeMap(
    val destinationStart: Long,
    val sourceStart: Long,
    val range: Long
) {
    val sourceRange: LongRange
        get() = sourceStart until (sourceStart + range)

    fun map(source: Long): Long {
        if (source in sourceRange) {
            val offset = source - sourceStart
            return destinationStart + offset
        }
        return source
    }

    fun map(itemRange: LongRange): List<LongRange?> {
        val (first, last) = listOf(itemRange.first, itemRange.last)

        return when {
            first in sourceRange && last in sourceRange -> listOf(
                map(itemRange.first)..map(itemRange.last)
            )
            first in sourceRange -> listOf(
                map(itemRange.first)..map(sourceRange.last),
                (sourceRange.last+1)..itemRange.last
            )
            last in sourceRange -> listOf(
                map(sourceRange.first)..map(itemRange.last),
                itemRange.first until sourceRange.first
            )
            first < sourceRange.first && last > sourceRange.last -> listOf(
                map(sourceRange.first)..map(sourceRange.last),
                itemRange.first until sourceRange.first,
                (sourceRange.last + 1)..itemRange.last
            )
            else -> listOf(null, itemRange)
        }
    }
}
