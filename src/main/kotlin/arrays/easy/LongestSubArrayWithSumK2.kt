package arrays.easy


fun main() {

    // we are given an array
    val arr = arrayOf(1, 2, 1, 0, 1)
    val sum = 4
    // find the sub - array with the longest length having the sum == 4 in this case
    //
    println(bruteForce(arr, sum))
}


/// brute force
// find a list with all the sub arrays
// for each item in the list
// find whether the sum of the numbers in the list is equal to the sum given in the
// question
// then find the maxLength of the list that hast he sum equal to the given sum
fun bruteForce(arr:Array<Int>, sum:Int): Int {
    val subArray = mutableListOf<List<Int>>()
    var maxLength = -1

    for (i in arr.indices) {
        for (j in i until arr.size) {
            val list = mutableListOf<Int>()
            if (i == j) {
               list.add(arr[i])
            }
            else {
                for (k in i..j) {
                    list.add(arr[k])
                }
            }
            subArray.add(list)
        }

    }

    for (list in subArray) {
        val sumOfNumbers = list.sum()
        if (sumOfNumbers == sum) {
            if (list.size > maxLength) maxLength = list.size
        }
    }

    return maxLength
}