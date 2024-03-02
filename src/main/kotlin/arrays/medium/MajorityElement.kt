package arrays.medium

import kotlin.math.absoluteValue


fun main() {
    // finding the majority element in an array
    // if the given array is the following then
    // what is a majority element ?
    // the majority element is the number in the array that is present more than n / 2 times
    // in the array
    val arr = arrayOf(1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 3, 3, 3, 3)
    println(findMajorityOptimal(arr))
}

/// brute force solution
fun findMajorityElementBrute(arr: Array<Int>): Int {
    // simply sort the array
    // return the element at the n / 2 index because
    // the majority element is always present in an array
    // is the given condition as well
    arr.sort()
    return arr[arr.size / 2]
}


/// better solution
fun findMajorityBetter(arr: Array<Int>): Int {
    val map = mutableMapOf<Int, Int>()
    for (number in arr) {
        map[number] = map.getOrDefault(number, 0) + 1
    }
    return map.maxBy { it.value }.key
}

// time complexity -> O(n)
// space complexity -> O(number of unique elements in the array)


// optimal solution
// using moore's voting algorithm
fun findMajorityOptimal(arr: Array<Int>): Int {
    // we can use the sorting algorithm
    // if the majority element is present
    // in the n / 2 th position then
    // we can simply return the element
    // at the n / 2th index of the array


    // optimal solution is using a map
    var majorityElement = -1
    var count = 0

    for (num in arr) {
        if (count == 0) {
            majorityElement = num
            count = 1
        }
        else {
            if (num == majorityElement) count++ else count--
        }

    }
    return majorityElement
}

