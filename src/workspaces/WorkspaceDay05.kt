package workspaces

import domain.Almanac
import domain.RangeMap

class WorkspaceDay05 : Workspace2<Almanac, Long> {
    override fun part1(input: Almanac): Long = input.seeds.minOfOrNull { it.chainConvert(input) } ?: 0L

    override fun part2(input: Almanac): Long {
        val seeds = input.seeds.foldIndexed(mutableListOf<LongRange>()) { index, acc, l ->
            if (index in 0 until input.seeds.size step 2) acc.add(LongRange(l, l + input.seeds[index + 1] - 1))
            acc
        }

        return seeds
            .transform( input.getMappings("seed-to-soil") )
            .transform( input.getMappings("soil-to-fertilizer") )
            .transform( input.getMappings("fertilizer-to-water") )
            .transform( input.getMappings("water-to-light") )
            .transform( input.getMappings("light-to-temperature") )
            .transform( input.getMappings("temperature-to-humidity") )
            .transform( input.getMappings("humidity-to-location") )
            .minOf { it.first }
    }

    private fun MutableList<LongRange>.transform(maps: List<RangeMap>): MutableList<LongRange> {
        val output = mutableListOf<LongRange>()

        this.forEach itemLoop@ { itemRange ->
            val remainders = mutableListOf<LongRange>()
            var init = true
            maps.forEach mapLoop@ { rangeMap ->
                val mappedItems = when {
                    init -> {
                        val values = rangeMap.map(itemRange)
                        remainders.addAll(values.drop(1).filterNotNull())
                        values.first()
                    }
                    remainders.isNotEmpty() -> {
                        val values = rangeMap.map(remainders.first())
                        remainders.removeFirst()
                        remainders.addAll(values.drop(1).filterNotNull())
                        values.first()
                    }
                    else -> null
                }

                init = false

                if (mappedItems == null) return@mapLoop
                output.merge(mappedItems)
            }

            if (remainders.isNotEmpty()) {
                remainders.forEach { output.merge(it) }
            }
        }
        return output
    }

    private fun LongRange.canMerge(mergingRange: LongRange): Boolean = this.first in mergingRange || this.last in mergingRange

    private fun LongRange.merge(mergingRange: LongRange): LongRange {
        val first = when { this.first < mergingRange.first -> this.first else -> mergingRange.first }
        val last = when { this.last > mergingRange.last -> this.last else -> mergingRange.last }
        return first..last
    }

    private fun MutableList<LongRange>.merge(item: LongRange) {
        val index = this.indexOfFirst { it.canMerge(item) }

        if (index < 0) {
            this.add(item)
            return
        }

        val mergingRange = this[index]
        if (mergingRange == item) return

        val mergedRange = mergingRange.merge(item)

        this[index] = mergedRange
    }

    private fun Long.convertWithMapper(mapper: String, almanac: Almanac): Long = almanac
        .maps[mapper]?.find { this in it.sourceRange }?.map(this) ?: this

    private fun Long.chainConvert(almanac: Almanac): Long = this
        .convertWithMapper("seed-to-soil", almanac)
        .convertWithMapper("soil-to-fertilizer", almanac)
        .convertWithMapper("fertilizer-to-water", almanac)
        .convertWithMapper("water-to-light", almanac)
        .convertWithMapper("light-to-temperature", almanac)
        .convertWithMapper("temperature-to-humidity", almanac)
        .convertWithMapper("humidity-to-location", almanac)
}