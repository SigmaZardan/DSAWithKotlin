package binary_search


fun main() {
    val arr = arrayOf(1, 2, 3, 4, 10, 12, 14,16, 17, 19)
    println(findUpperBound(arr, 16))
}


// find the upper bound / finding the floor value
// find the index of the number in the array which is smaller than or equal to the target
fun findUpperBound(arr: Array<Int>, target: Int): Int {
    var low = 0
    var high = arr.size - 1
    while (low < high) {
        val mid = low + (high - low) / 2
        if (target == arr[mid]) {
            return mid
        } else if (arr[mid] < target) {
            // this can be the potential answer
            // but also search in the right hand side
            low = mid
        } else {
            high = mid - 1
        }
    }
    return high
}