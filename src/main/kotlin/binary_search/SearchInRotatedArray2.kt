package binary_search


fun main() {
    val arr = intArrayOf(1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1)
    val target = 2
    println(search(arr, target))
}
fun search(nums: IntArray, target: Int): Boolean {
    // we can keep ignoring a number from each sides
    // because they are duplicate values
    // pivot might also be the target
    val pivot = findPivot2(nums)
    var answer = false
    val size = nums.size
    if (pivot == -1) {
        answer = binarySearch2(nums, target, 0, size - 1)
    } else if (nums[pivot] == target) {
        answer = true
    } else {
        answer = binarySearch2(nums, target, 0, pivot)
        if (!answer) {
            answer = binarySearch2(nums, target, pivot + 1, size - 1)
        }
    }

    return answer
}

fun findPivot2(arr: IntArray): Int {
    var low = 0
    val size = arr.size
    var high = size - 1

    if (arr[low] < arr[high]) return -1
    while (low <= high) {
        val mid = low + (high - low) / 2

        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
            return mid - 1
        } else if (mid + 1 < size && arr[mid + 1] < arr[mid]) {
            return mid
        } else if (arr[mid] > arr[0]) {
            // in the upgoing portion of the arrayy
            low = mid + 1
        } else if (arr[mid] < arr[0]) {
            // in the down portion
            high = mid - 1
        } else {
            // before ignoring the values at low and high
            // we have to check whether they are pivot or not
            // check if the number at low is pivot or not
            if (low + 1 < size && arr[low + 1] < arr[low]) return low
            if (high - 1 >= 0 && arr[high - 1] > arr[high]) return high - 1
            low++
            high--
        }
    }
    return -1
}

fun binarySearch2(arr: IntArray, target: Int, low: Int, high: Int): Boolean {
    var low = low
    var high = high

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (arr[mid] == target) {
            return true
        } else if (arr[mid] < target) {
            // search in the right hand side
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return false
}