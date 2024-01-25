package solutions

import domain.Almanac
import domain.RangeMap
import workspaces.WorkspaceDay05

class Day05 : Solution<Almanac, Long> {
    override val day = "05"
    override val workspace = WorkspaceDay05()

    override fun parse(data: List<String>): Almanac {
        val seeds = data.first().split(":").last().trim().split(" ").map { it.toLong() }
        val maps = mutableMapOf<String, MutableList<RangeMap>>()
        var currentMap: String? = null
        data.takeLast(data.size - 1)
            .forEach mapLoop@ {
                if (it == "") return@mapLoop
                if (it.split(" ").contains("map:")) {
                    currentMap = it.split(" ").first()
                }
                else {
                    if (currentMap == null) throw Exception("no current map detected.")
                    val rangeMapValues = it.split(" ").map { item -> item.toLong() }
                    val rangeMap = RangeMap(rangeMapValues[0], rangeMapValues[1], rangeMapValues[2])
                    maps.getOrPut(currentMap ?: "no-map") { mutableListOf(rangeMap) }.add(rangeMap)
                }
            }
        return Almanac(seeds, maps)
    }
}