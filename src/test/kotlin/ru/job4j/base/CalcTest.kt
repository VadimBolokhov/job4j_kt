package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalcTest {

    @Test
    fun when1Plus1() {
        assertThat(add(1, 1,)).isEqualTo(2)
    }

    @Test
    fun when1Minus1() {
        assertThat(subtract(1, 1)).isEqualTo(0)
    }

    @Test
    fun when2Times2() {
        assertThat(multiply(2, 2)).isEqualTo(4)
    }

    @Test
    fun when2DividedBy2() {
        assertThat(divide(2, 2)).isEqualTo(1)
    }
}