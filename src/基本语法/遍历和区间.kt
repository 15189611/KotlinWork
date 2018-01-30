package 基本语法

fun main(args: Array<String>) {
    //遍历
    var lists = listOf<Int>(1, 3, 7, 12, 143, 31, 543, 32)
    // foreachShow(lists)

    // 遍历区间 闭区间：包含 100
    for (list in 1..100) {
        //  println(list)
    }

    //遍历区间，半开区间：不包含 100
    for (list in 1 until 100) {
        //  println(list)
    }

    //遍历区间 并且每次都跳过2个数
    for (list in 1..100 step 2) {
        //   println(list)
    }

    //倒序遍历，从10 到 1
    for (list in 10 downTo 1) {
        //  println(list)
    }

    //通过索引遍历一个数组
    //foreachIndex(lists)

    //通过索引遍历 传递是区间
    foreachIndexRange(2..300)
}

private fun foreachShow(arrayLists: List<Int>) {
    for (list in arrayLists) {
        println(list)
    }
}

//通过索引遍历一个数组
fun foreachIndex(array: List<Int>) {
    for (i in array.indices) {
        println(array[i])
    }
}

//注意上面这种“在区间上遍历”会编译成优化的实现而不会创建额外对象。 或者你可以用库函数 withIndex：

fun foreachIndexRange(array: IntRange) {
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}

