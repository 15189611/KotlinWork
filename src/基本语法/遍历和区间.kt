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
        println(list)
    }
}

private fun foreachShow(arrayLists: List<Int>) {
    for (list in arrayLists) {
        println(list)
    }
}

