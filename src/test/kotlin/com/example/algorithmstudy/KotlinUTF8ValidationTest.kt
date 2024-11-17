package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinUTF8ValidationTest {
    /*
     * 입력값이 UTF-8 문자열이 맞는지 검증하라.
     */

    @Test
    fun test_isValid() {
        var data = intArrayOf(197, 130, 2)
        var actual: Boolean = isValid(data)
        Assertions.assertTrue(actual)

        data = intArrayOf(235, 140, 5)
        actual = isValid(data)
        Assertions.assertFalse(actual)
    }

    private fun isValid(data: IntArray): Boolean {
        fun check(
            start: Int,
            end: Int,
        ): Boolean {
            for (i in start + 1 until end + start + 1) {
                if (i >= data.size || data[i] shr 6 != 0b10) {
                    return false
                }
            }

            return true
        }

        var start = 0

        while (start < data.size) {
            val first = data[start]

            start +=
                when {
                    first shr 3 == 0b11110 && check(start, 3) -> 4
                    first shr 4 == 0b1110 && check(start, 2) -> 3
                    first shr 5 == 0b110 && check(start, 1) -> 2
                    first shr 7 == 0 -> 1
                    else -> return false
                }
        }

        return true
    }
}
