package binary_search


fun main() {
    val arr = arrayOf(1, 2, 4, 10, 12,16, 17, 19)
    println(findLowerBound(arr, 16))
}


fun findLowerBound(arr: Array<Int>, target: Int): Int {
    // what is lower bound ?
    // lower bound is the index that represents the number in the array which is
    // greater than or equal to the target
    // is it also known as finding the ceiling
    var low = 0
    var high = arr.size - 1

    while (low < high) {
        val mid = low + (high - low) / 2
        if (arr[mid] == target) {
            return mid
        } else if (arr[mid] > target) {
            // this might be my answer
            // but find other values on the left hand side
            // if present
            high = mid
        } else {
            low = mid + 1
        }

    }
    return high
}