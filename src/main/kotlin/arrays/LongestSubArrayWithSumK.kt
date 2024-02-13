package arrays


fun main() {
    val arr = arrayOf(1, 2, 3, 1, 1, 1)
    println(longestSubArray(arr, 3))
}

// brute force solution
// time complexity -> O(n ^ 3)
// space complexity -> O(size of sub-array list )
fun longestSubArray(arr: Array<Int>, sum: Int): Int {
    val subArrays = mutableListOf<List<Int>>()

    for (i in arr.indices) {
        for (j in i until arr.size) {
            val list = mutableListOf<Int>()
            if (i == j) {
                list.add(arr[i])
            } else {
                for (k in i..j) {
                    list.add(arr[k])
                }
            }
            subArrays.add(list)
        }
    }

    // after generating all the sub arrays
    var maxLength = -1
    for (list in subArrays) {
        val listSum = list.sum()
        if (sum == listSum) {
            if (list.size > maxLength) maxLength = list.size
        }
    }
    return maxLength
}