package arrays


fun main() {
    val arr = arrayOf(1, 2, 3, 5)
    val n = 5
    println(missingOptimal1(arr, n))

}

// brute force solution
// time complexity -> O(n ^ 2)
// space -> O(1)
fun missingNumber(arr: Array<Int>, n: Int): Int {
    var missingNumber = -1

    for (i in 1..5) {
        var isPresent = false
        for (j in arr) {
            if (i == j) {
                isPresent = true
                break
            }
        }
        if (!isPresent) missingNumber = i
    }
    return missingNumber
}

// better approach
fun missingBetter(arr: Array<Int>, n: Int): Int {
    // using ??
    // we are using hashing
    val hashArray = Array(n + 1) { 0 }
    var missingNumber = -1

    for (number in arr) {
        hashArray[number] = 1
    }

    for (i in 1 until hashArray.size) {
        if (hashArray[i] == 0) {
            missingNumber = i
            break
        }
    }
    return missingNumber
}

// optimal approach one
fun missingOptimal1(arr: Array<Int>, n: Int): Int {
    val sum = (1..n).sum()
    val sum1 = arr.sum()
    return sum - sum1
}
// time complexity -> O(n)
// space complexity -> O(1)