package 基本语法

fun main(args: Array<String>) {
    val transform = transform("Red")
    println(transform)
    transform2("Green")
    println(hasPrefix("prefix-222"))
}

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun transform2(color: String) {
    when (color) {
        "Red" -> println("是红色")
        "Green" -> println("是Green")
        "Blue" -> println("是Blue")
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}



