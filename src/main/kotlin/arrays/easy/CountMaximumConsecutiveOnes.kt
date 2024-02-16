package arrays.easy


fun main() {
    val arr = arrayOf(1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0)
    println(findMaxCount(arr))
}

fun findMaxCount(arr: Array<Int>): Int {
    var maxCount = -1
    var currentCount = 0

    for (number in arr) {
        if (number == 1) {
            currentCount++
        } else {
            if (currentCount > maxCount) maxCount = currentCount
            currentCount = 0
        }
    }
    return maxCount
}