package binary_search


fun main() {
    val arr = intArrayOf(1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5)
    val target = 4
    println(findFirstAndLastOcc(arr, target).joinToString())
}

fun findFirstAndLastOcc(arr: IntArray, target: Int): IntArray {
    val ans = intArrayOf(-1, -1)
    if (arr.size == 0) return ans
    ans[0] = search(arr, target, true)
    ans[1] = search(arr, target, false)
    return ans

    // finding the first occurrence
    // use the floor concept
    // finding a value in the arr that is less than or equal to the target
    // but in this case since i am looking for a value
    // that is indeed equal to the target but occurs at the beginning
    // then i can ignore this value
    // mid value == target
    // looking for the first occurrence
    // check if the mid -1 value is not equal to the target,
    // if not equal then this current mid is my answer because since the array is sorted,
    // this is the first occurrence
    // but if the mid -1 is equal to the target, then i can ignore this current mid value
    // because i am looking for the first occurrence
    // high = mid - 1


    // mid value < target , low =mid + 1
    // else mid value > target, high = mid - 1


    // finding the last occurrence
    // use the ceil concept
    // value >= target
    // but in this case since in am looking for a value that is indeed equal to the target
    // then i can ignore the greater value
    // mid value == target
    // check if the mid + 1 value is not equal to the target,
    // if it is not then this mid value is my answer
    // otherwise , i need to search in the right because mid + 1 value which is my target
    // can posssibly be my answer but again i have to check fully
    // but one this is for sure that i can ignore the current mid value
    // low = mid + 1
    // mid value > target, search in the left , high = mid - 1
    // mid value < target , search in the right , low = mid + 1
}


fun search(arr: IntArray, target: Int, isFirstOcc: Boolean): Int {
    var low = 0
    var high = arr.size - 1

    while (low < high) {
        val mid = low + (high - low) / 2

        if (arr[mid] == target) {
            // check if this is the answer
            if (isFirstOcc) {
                //check mid -1 value
                if (mid - 1 >= 0 && arr[mid - 1] != target) {
                    return mid
                } else {
                    high = mid - 1
                }
            } else {
                if (mid + 1 < arr.size && arr[mid + 1] != target) {
                    return mid
                } else {
                    low = mid + 1
                }
            }
        } else if (arr[mid] < target) {
            // ignore this value and search in the right
            // because i am looking for th target
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return if (arr[low] != target) -1 else low
}