package 基本语法

/**
 * 类成员
类可以包含：

构造函数和初始化块
函数
属性
嵌套类和内部类
对象声明
 */


//主构造
class Person constructor(name: String) {
    //1.如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。

}

//次构造
class Son {
    /**
     * 请注意，初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句
     * ，因此所有初始化块中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，
     * 这种委托仍会隐式发生，并且仍会执行初始化块：
     */
    init {
        println("Init block")   //执行顺序 先执行 init 再执行次构造函数
    }

    //2.次构造
    constructor(name: String, sex: String) {
        println("Constructor")
    }
}

//去掉默认空构造
class SonToSun private constructor() {
    /**
     * 如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。构造函数的可见性是 public。
     * 如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数：
     */
}

//调用超类实现
//派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现：
open class Foo {
    open fun f() {
        println("Foo.f()")
    }

    open val x: Int get() = 1
}

class Bar : Foo() {
    override fun f() {
        super.f()
        println("Bar.f()")
    }

    override val x: Int get() = super.x + 1
}

//在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
class Bar2 : Foo() {
    override fun f() { /* …… */
    }

    override val x: Int get() = 0

    inner class Baz {
        fun g() {
            super@Bar2.f() // 调用 Foo 实现的 f()
            println(super@Bar2.x) // 使用 Foo 实现的 x 的 getter
        }
    }
}

//覆盖规则
//在 Kotlin 中，实现继承由下述规则规定：如果一个类从它的直接超类继承相同成员的多个实现，
// 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。 为了表示采用从哪个超类型继承的实现，
// 我们使用由尖括号中超类型名限定的 super，如 super<Base>：
open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } // 接口成员默认就是“open”的

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
    }
}
//同时继承 A 和 B 没问题，并且 a() 和 b() 也没问题因为 C 只继承了每个函数的一个实现。
// 但是 f() 由 C 继承了两个实现，所以我们必须在 C 中覆盖 f() 并且提供我们自己的实现来消除歧义。
