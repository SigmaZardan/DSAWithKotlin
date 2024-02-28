package arrays.medium

import kotlin.math.floor


fun main() {
    // sort numbers
    val arr = arrayOf(1, 2, 0, 0, 1, 2, 0)
    optimalSolutionUsingDutchFlagAlgorithm(arr)
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

// optimal approach
fun optimalSolutionUsingDutchFlagAlgorithm(arr: Array<Int>): Array<Int> {
    var low = 0
    var mid = 0
    var high = arr.size - 1

    while (mid <= high) {
        when (arr[mid]) {
            0 -> {
                swap(arr, low, mid)
                low++
                mid++
            }

            2 -> {
                swap(arr, mid, high)
                high--
            }

            else -> mid++
        }
    }
    return arr
}

fun swap(arr: Array<Int>, first: Int, second: Int) {
    val temp = arr[first]
    arr[first] = arr[second]
    arr[second] = temp
}