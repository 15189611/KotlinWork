package 基本语法

/**
 * 单列 实列 只需要把class 改成 object就行，默认就会成为唯一的实列
 */
object Single {
    val name = "Charles"
}

fun main(args: Array<String>) {
    val newInstance = AnotherSingle.newInstance()
    val newInstance1 = AnotherSingle.newInstance()
    val newInstance2 = AnotherSingle.newInstance()
    val newInstance3 = AnotherSingle.newInstance()
    println("对象0==="+ newInstance)
    println("对象1==="+ newInstance1)
    println("对象2==="+ newInstance2)
    println("对象3==="+ newInstance3)
}
//使用companion object

class AnotherSingle private constructor(){

    companion object {
        fun newInstance(): AnotherSingle {
            return Inner.another
        }
    }

    private object Inner {
        val another = AnotherSingle()
    }

}