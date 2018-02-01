package 基本语法

fun main(args: Array<String>) {
    //一般来说，要创建这样类的实例，我们需要提供类型参数,但是kotlin帮我们推断省了
    //val box: Box<Int> = Box<Int>(1)

    val box = Box("小美眉")
    box.action()

    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy(ints, any) // 错误：期望 (Array<Any>, Array<Any>)
}

class Box<T>(t: T) {
    var value = t
    fun action() {
        println("你好美女" + value)
    }
}

/**
在 Kotlin 中，有一种方法向编译器解释这种情况。这称为声明处型变：我们可以标注 Source 的类型参数 T 来确保它仅从 Source<T>
成员中返回（生产），并从不被消费。 为此，我们提供 out 修饰符：*/
interface Source<out T> {
    fun next(): T

    fun demo(str: Source<String>) {
        val objects: Source<Any> = str // 这个没问题，因为 T 是一个 out-参数
    }
}

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]

}

