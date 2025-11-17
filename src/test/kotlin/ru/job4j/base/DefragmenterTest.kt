package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefragmenterTest {

    @Test
    fun whenNullAndNotNullElements() {
        val array = arrayOf(null, "1", null, null, "2")
        val expected = arrayOf("1", "2", null, null, null)

        defragment(array)

        assertThat(array).isEqualTo(expected)
    }
}