package solutions

class Answer(
    private val day: String,
    private val part: String,
    private val answer: String,
    private val test: String,
    private val assertion: String
) {
    fun print() {
        if (test == assertion) {
            println("${pre()}[PASS]  $answer")
        } else {
            println("${pre()}[FAIL]  $test  $assertion")
        }
    }
    private fun pre() = "$day : $part  =>  "
}