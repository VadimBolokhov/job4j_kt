package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MaxTest {

    @ParameterizedTest
    @CsvSource(value = [
        "1, 1, 1",
        "1, 2, 2",
        "2, 1, 2"
    ])
    fun whenMaxWithTwoArgs(first: Int, second: Int, expected: Int) {
        assertThat(max(first, second)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = [
        "1, 1, 1, 1",
        "1, 2, 3, 3",
        "1, 3, 2, 3",
        "3, 1, 2, 3"
    ])
    fun whenMaxWithThreeArgs(first: Int, second: Int, third: Int, expected: Int) {
        assertThat(max(first, second, third)).isEqualTo(expected)
    }
}
