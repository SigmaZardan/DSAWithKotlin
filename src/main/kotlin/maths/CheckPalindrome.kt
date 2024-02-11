package maths

fun main() {
    println(if (isPalindrome()) "Palindrome" else "Not Palindrome")
}

private fun isPalindrome(num: Int = 121): Boolean {
    val reversed = findReverse(num)
    return reversed == num
}

private fun findReverse(num: Int): Int {
    var reversed = 0
    var number = num
    while (number > 0) {
        val digit = number % 10
        reversed = reversed * 10 + digit
        number /= 10
    }
    return reversed
}
