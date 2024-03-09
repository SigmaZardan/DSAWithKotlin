package binary_search


fun main() {
    val arr = intArrayOf(7, 8, 10, 1, 2, 3, 5, 6)
    val target = 5
    // find the pivot first using binary search
    /// there can be a case where there is no pivot
    // the array is not sorted then there is no pivot
    // if the size of the array is 1
    // if there is no pivot then we can simply apply binary search
    // if there is pivot
    // then search for the element (0, pivot) in the array
    // if you find the index then return it
    // otherwise
    // search in the right side (pivot + 1, size - 1)
    println(searchInRotate(arr, target))


}


fun searchInRotate(arr: IntArray, target: Int): Int {
    var answer: Int
    val size = arr.size
    val pivot = findPivot(arr)
    if (pivot == -1) {
        answer = binarySearch(arr, target, 0, size - 1)
    } else {
        answer = binarySearch(arr, target, 0, pivot)
        if (answer == -1) {
            answer = binarySearch(arr, target, pivot + 1, size - 1)
        }
    }
    return answer
}

fun findPivot(arr: IntArray): Int {
    var low = 0
    val size = arr.size
    var high = size - 1
    // if the array has a single element or the last element is greater than
    // the first element then the array has not been rotated
    if (arr[low] < arr[high] || size == 1) return -1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
            return mid - 1
        } else if (mid + 1 < size && arr[mid + 1] < arr[mid]) {
            return mid
        } else {
            // check if you are in the down stream or up stream
            if (arr[0] > arr[mid]) {
                // in the down stream
                // pivot lies in the left side
                high = mid - 1
            } else {
                /// pivot lies in the right side
                low = mid + 1
            }
        }
    }
    return -1
}

fun binarySearch(arr: IntArray, target: Int, low: Int, high: Int): Int {
    var low = low
    var high = high
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (target == arr[mid]) {
            return mid
        } else if (target < arr[mid]) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}
