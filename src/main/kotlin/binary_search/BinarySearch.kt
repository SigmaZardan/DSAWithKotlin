package binary_search


fun main() {

    // binary search
    val arr = arrayOf(1, 2, 3, 4, 5, 10, 15, 16)
    // binary search is only applicable for a sorted array
    println(binarySearchRecursive(arr, target = 15, low = 0, high = arr.size - 1))

}

// iterative approach
fun binarySearchIterativeSolution(arr: Array<Int>, target: Int): Int {
    var low = 0
    var high = arr.size - 1
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


// recursive solution
fun binarySearchRecursive(arr: Array<Int>, target: Int, low: Int, high: Int): Int {
    // base condition
    if (low > high) return -1 // the target is not found
    val mid = low + (high - low) / 2

    if (arr[mid] == target) return mid
    if (target > arr[mid]) return binarySearchRecursive(arr, target, mid + 1, high)
    return binarySearchRecursive(arr, target, low, high - 1)
}




