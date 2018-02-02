package 基本语法

/**
 * 单列 实列 只需要把class 改成 object就行，默认就会成为唯一的实列
 */
object Single {
    val name = "Charles"
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