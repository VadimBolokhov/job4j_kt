package ru.job4j.base

fun add(first : Int, second: Int) : Int {
    return first + second
}

fun subtract(first: Int, second: Int) : Int {
    return first - second
}

fun multiply(first: Int, second: Int) : Int {
    return first * second
}

fun divide(first: Int, second: Int) : Int {
    return first / second
}

fun main() {
    val plus = add(1, 1)
    println("1 + 1 = $plus")

    val minus = subtract(1, 1)
    println("1 - 1 = $minus")

    val times = multiply(2, 2)
    println("2 * 2 = $times")

    val dividedBy = divide(2, 2)
    println("2 / 2 = $dividedBy")
}
