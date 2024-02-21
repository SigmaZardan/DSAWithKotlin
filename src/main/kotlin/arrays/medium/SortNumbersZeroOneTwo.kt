package arrays.medium


fun main() {
    // sort numbers
    val arr = arrayOf(1, 2, 0, 0, 1, 2, 0)
    sortBrute(arr)
    println(arr.joinToString())
}

fun sortBrute(arr: Array<Int>) {
    var zero = 0
    var one = 0
    var two = 0
    for (num in arr) {
        if (num == 0) zero++
        if (num == 1) one++
        if (num == 2) two++
    }
    println(zero)
    println(one)
    println(two)
    var i = 0
    for (j in 0 until zero) {
        arr[i++] = 0
    }
    for (j in 0 until one) {
        arr[i++] = 1
    }
    for (j in 0 until two) {
        arr[i++] = 2
    }
    println(arr.joinToString())
}