package domain

data class Almanac(
    val seeds: List<Long>,
    val maps: Map<String, List<RangeMap>>
) {
    fun getMappings(mapName: String): List<RangeMap> {
        return maps[mapName] ?: listOf()
    }
}
