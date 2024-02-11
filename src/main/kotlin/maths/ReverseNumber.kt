package maths


fun main() {
var number = 123412
    var reverseNumber = 0

    while(number > 0) {
       val digit = number % 10
        reverseNumber = reverseNumber * 10 + digit
        number /= 10
    }
    println(reverseNumber)

}