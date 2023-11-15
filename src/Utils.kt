import java.io.File

fun parseFile(day: String, part: String): List<String> = File("src/data/Day$day-$part.txt").readLines()
fun parseTestFile(day: String, part: String): List<String> = File("src/data/Day$day-$part-test.txt").readLines()