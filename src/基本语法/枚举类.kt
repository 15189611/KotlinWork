package 基本语法

fun main(args: Array<String>) {
    println(Direction.LEFT)
    val talking = ProtocolState.WAITING.signal()
    println(talking)
    printAllValues<Direction>() //输出LEFT,UP,RIGHT,BOTTOM
}

//枚举类
//枚举类的最基本的用法是实现类型安全的枚举：
enum class Direction {
    LEFT, UP, RiGHT, BOTTOM
}

//初始化
//因为每一个枚举都是枚举类的实例，所以他们可以是这样初始化过的：
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

//匿名类
//枚举常量也可以声明自己的匿名类：
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

//使用枚举常量
//自 Kotlin 1.1 起，可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量 ：
//每个枚举常量都具有在枚举类声明中获取其名称和位置的属性：
//val name: String
//val ordinal: Int
inline fun <reified T : Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString { it.name })
}
