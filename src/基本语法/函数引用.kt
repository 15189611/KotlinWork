package 基本语法

fun main(args: Array<String>) {
    //当我们有一个命名函数声明如下：
    fun isOdd(x: Int) = x % 2 != 0
    // 当上下文中已知函数期望的类型时，:: 可以用于重载函数。 例如：
    fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"


    //我们可以很容易地直接调用它（isOdd(5)），
    // 但是我们也可以把它作为一个值传递。例如传给另一个函数。 为此，我们使用 :: 操作符：
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))
    //这里 ::isOdd 是函数类型 (Int) -> Boolean 的一个值。

}