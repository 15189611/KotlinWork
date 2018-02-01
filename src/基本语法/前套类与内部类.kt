package 基本语法

fun main(args: Array<String>) {
    val foo = Outers.Nested().foo()
    println(foo)

    println(Outers2().Inner().foo())
}

//前套类
class Outers {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

//内部类
class Outers2 {
    private val bar: Int = 123

    //类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
    inner class Inner {
        fun foo() = bar
    }
}

//匿名内部类


