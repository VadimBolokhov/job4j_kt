package ru.job4j.base

fun defragment(array: Array<String?>) {
    for ((i, element) in array.withIndex()) {
        if (element == null) {
            for (j: Int in i + 1 until array.size) {
                if (array[j] != null) {
                    array[i] = array[j]
                    array[j] = null
                    break
                }
            }
        }
    }
}