import solutions.*

fun main(args: Array<String>) {
    args.forEach {
        if (!it.matches("^\\d{2}-\\d{1}$".toRegex())) {
            println("00 : 0  =>  [ERRA]  Invalid argument [$it]")
            return
        }

        val solutionRef = it.split("-")
        val day = solutionRef.first()
        val part = solutionRef.last()

        solve(day).run(part).print()
    }
}


fun solve(day: String): Solution<*, *> {
    when(day) {
        "01" -> return Day01()
        "02" -> return Day02()
    }
    throw Exception("Could not find solution with day [$day]!")
}
