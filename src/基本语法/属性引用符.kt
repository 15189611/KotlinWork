package 基本语法

val x = 1
var y = 3

/**
 * 属性引用
要把属性作为 Kotlin中 的一等对象来访问，我们也可以使用 :: 运算符：
 */
fun main(args: Array<String>) {

    println(::x.get()) // 输出 "1"
    println(::x.name)  // 输出 "x"

    //对于可变属性，例如 var y = 1，::y 返回 KMutableProperty<Int> 类型的一个值， 该类型有一个 set() 方法。
    ::y.set(4)
    println(y)

    //属性引用可以用在不需要参数的函数处：
    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length)) // 输出 [1, 2, 3]

    //要访问属于类的成员的属性，我们这样限定它：
    val prop = A1::p
    println(prop.get(A1(3))) // 输出 "3"

    //正则，匹配为数字的
    val numberRegex = "\\d+".toRegex()
    println(numberRegex.matches("29")) // 输出“true”

    val isNumber = numberRegex::matches
    println(isNumber("29")) // 输出“true”

    val strings = listOf("abc", "124", "a70")
    println(strings.filter(numberRegex::matches)) // 输出“[124]”  过滤了不是数字的

    //属性引用也可以绑定：
    val prop = "abc"::length
    println(prop.get())   // 输出“3”

    //自 Kotlin 1.2 起，无需显式指定 this 作为接收者：this::foo 与 ::foo 是等价的。
}

class A1(val p: Int)