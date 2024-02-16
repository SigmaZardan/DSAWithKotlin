package arrays.medium


fun main() {

    // finding the two sum of the arrays
    val arr = arrayOf(3, 2, 4)
    val sum = 6
    println(twoSumOptimal(arr, sum).joinToString())
}

// simple brute force solution using two pointers
// time complexity -> O(n ^ 2)
// space complexity -> O(1)
fun twoSum(arr: Array<Int>, target: Int): IntArray {
    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            val sum = arr[i] + arr[j]
            if (sum == target) return intArrayOf(i, j)
        }
    }
    return intArrayOf()
}

// optimal solution
// using a map
fun twoSumOptimal(arr: Array<Int>, sum: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in arr.indices) {
        val keyKey = sum - arr[i]
        if (map.containsKey(keyKey)) {
            return intArrayOf(i, map[keyKey] ?: 0)
        }
        else {
            map[arr[i]] = i
        }
    }
    return intArrayOf(-1, -1)
}