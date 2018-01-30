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