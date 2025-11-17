package ru.job4j.base

fun draw(size: Int) {
    val token = "*"
    for (raw: Int in 0 until size) {
        for (column: Int in 0 until size) {
            print(
                if (raw == column || raw + column == size - 1) token else " "
            )
        }
        println()
    }
}