package 基本语法

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

fun main(args: Array<String>) {

    //对象表达式
    val ab: AI = object : AI(1), BI {
        override val y = 15
    }
    println(ab.y)

    foo()
}

/**
 * 1.如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。 多个超类型可以由跟在冒号后面的逗号分隔的列表指定：
 */
open class AI(x: Int) {
    public open val y: Int = x
}

interface BI {
}

/**
 * 2.任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写：
 */
fun foo() {
    val adHoc = object {
        var x: Int = 2
        var y: Int = 2
    }
    println(adHoc.x + adHoc.y)
}

/**
 * 3.请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。
 * 如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，
 * 那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，
 * 就会是 Any。在匿名对象中添加的成员将无法访问。
 */
class C1 {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
        //    val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

//就像 Java 匿名内部类一样，对象表达式中的代码可以访问来自包含它的作用域的变量。
// （与 Java 不同的是，这不仅限于 final 变量。）
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
    // ……
}




