package 基本语法

fun main(args: Array<String>) {
    val str: String = "1231"
    println(assert(str.length == 4))

    //类引用
    val kClass = Person2::class
    val kClassForJava = Person2::class.java

    println(kClass)
    println(kClassForJava)


}

class Person2 {
}