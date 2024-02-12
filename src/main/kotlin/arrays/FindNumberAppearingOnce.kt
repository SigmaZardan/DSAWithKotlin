package arrays


fun main() {
    val arr = arrayOf(1, 1, 2, 2, 3, 4, 4, 5, 5, 8, 8, 7, 7)
    arr.sort()

    val a = 14
    val b = 54
    println(a and b)

    println(findOptimal(arr))
}

// brute force
fun findNumber(arr: Array<Int>): Int {
    arr.sort()
    for (i in arr.indices step 2) {
        if (i == arr.size - 1 || arr[i] != arr[i + 1]) return arr[i]
    }
    return -1
}


// using map
fun findNumberBetter(arr: Array<Int>): Int {
    val map = mutableMapOf<Int, Int>()

    for (num in arr) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    println(map)

    for (value in map) {
        if (value.value == 1) return value.key
    }
    return -1
}

// optimal approach
// time complexity -> O(n)
// space complexity -> O(1)
fun findOptimal(arr: Array<Int>): Int {
    var value = 0
    for (num in arr) {
        value = value xor num
    }
    return value
}

