package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DefragmenterTest {

    @ParameterizedTest
    @MethodSource("provideArrays")
    fun whenNullAndNotNullElements(array: Array<String?>, expected: Array<String?>) {
        defragment(array)
        assertThat(array).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideArrays(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(emptyArray<String?>(), emptyArray<String?>()),
                Arguments.of(arrayOf<String?>(null), arrayOf<String?>(null)),
                Arguments.of(arrayOf<String?>("1"), arrayOf<String?>("1")),
                Arguments.of(arrayOf<String?>("1", "2", "3"), arrayOf<String?>("1", "2", "3")),
                Arguments.of(arrayOf<String?>(null, null, null), arrayOf<String?>(null, null, null)),
                Arguments.of(arrayOf(null, null, "a", "b", "c"), arrayOf("a", "b", "c", null, null)),
                Arguments.of(arrayOf("a", null, "b", null, "c"), arrayOf("a", "b", "c", null, null)),
                Arguments.of(arrayOf("1", null, null, null, "2"), arrayOf("1", "2", null, null, null)),
                Arguments.of(arrayOf("a", "b", "c", null, null), arrayOf("a", "b", "c", null, null)),
                Arguments.of(arrayOf(null, "1", "2", null), arrayOf("1", "2", null, null)),
                Arguments.of(arrayOf(null, null, null, "1"), arrayOf("1", null, null, null))
            )
        }
    }
}
