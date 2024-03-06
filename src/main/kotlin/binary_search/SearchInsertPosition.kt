package binary_search


fun main() {
    // the question
    // find the ceiling of the target
    // ceiling -> the number in the array which is greater than or equal to the target
    // we have to return the index not the number
    // binary search
    val nums = arrayOf(1, 3, 5, 6)
    val target = 8

    println(findPosition(nums, target))
}

fun findPosition(arr: Array<Int>, target: Int): Int {
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (arr[mid] == target) {
            return mid
        } else if (target > arr[mid]) {
            // search in the right hand side
            low = mid + 1
        } else {
            // is the number in mid is greater than target
            // then this can be my potential answer
            // but -> we have to look in the left hand side of the array
            high = mid
        }
    }
    return if (arr[low] < target) arr.size else low
}
