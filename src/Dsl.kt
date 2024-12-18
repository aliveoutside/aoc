class AocContext {
    var input = emptyList<String>()
    val results = mutableMapOf<Int, Any>()

    fun input(lines: () -> List<String>) {
        input = lines()
    }

    fun part(partNumber: Int = 1, block: (List<String>) -> Any) {
        results[partNumber] = block(input)
    }
}

fun aoc(execute: AocContext.() -> Unit) {
    val context = AocContext()
    context.execute()

    context.results.forEach { part, result -> println("Part $part: $result") }
}