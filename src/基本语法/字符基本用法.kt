package 基本语法

fun main(args: Array<String>) {
    //test()
    //字符转换
    println(decimalDigitValue('0'))
    println(methodString())
}

fun test() {
    val a: Int = 10000
    println(a == a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA == anotherBoxedA) // 输出“true”
}

//字符
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}

//数组

/**
 * 数组在 Kotlin 中使用 Array 类来表示，它定义了 get 和 set 函数（按照运算符重载约定这会转变为 []）和 size 属性，
 * 以及一些其他有用的成员函数：
 */
fun arrayMethod() {
    //我们可以使用库函数 arrayOf() 来创建一个数组并传递元素值给它，这样 arrayOf(1, 2, 3) 创建了 array [1, 2, 3]。 或者，
    // 库函数 arrayOfNulls() 可以用于创建一个指定大小的、所有元素都为空的数组。
    val arrayOf = arrayOf(1, 67, 21, 31)

}

//字符串
fun methodString(): String {
    //原生字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行和任何其他字符:
    val text = """
    for (c in "foo")
        print(c)
    """

    // 你可以通过 trimMargin() 函数去除前导空格：
    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    return text2
}
