package maths

import kotlin.math.log10

fun main() {
    var number = 234241
    println(log10(number.toDouble()).toInt() + 1)


    var count = 0

    while (number > 0) {
        count++
        number /= 10
    }

    println(count)
}