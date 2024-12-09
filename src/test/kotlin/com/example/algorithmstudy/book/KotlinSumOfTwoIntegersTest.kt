package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinSumOfTwoIntegersTest {
    /*
     * 두 정수 a와 b의 합을 구하라. + 또는 - 연산자는 사용할 수 없다.
     */

    @Test
    fun test_sum() {
        val a = -3
        val b = 2
        val actual: Int = sum(a, b)
        assertEquals(-1, actual)
    }

    @Test
    fun test_sum2() {
        val a = -3
        val b = 2
        val actual: Int = sum2(a, b)
        assertEquals(-1, actual)
    }

    private fun sum(
        a: Int,
        b: Int,
    ): Int {
        val binA = Integer.toBinaryString(a).padStart(32, '0')
        val binB = Integer.toBinaryString(b).padStart(32, '0')

        val result = mutableListOf<Char>()
        var sum = 0
        var carry = 0

        for (i in 0 until 32) {
            val A = Character.getNumericValue(binA[31 - i])
            val B = Character.getNumericValue(binB[31 - i])

            val Q1 = A and B
            val Q2 = A xor B
            val Q3 = Q2 and carry
            sum = carry xor Q2
            carry = Q1 or Q3

            result.add(0, Character.forDigit(sum, 2))
        }

        return Integer.parseUnsignedInt(String(result.toCharArray()), 2)
    }

    private fun sum2(
        a: Int,
        b: Int,
    ): Int {
        var A = a
        var B = b

        while (B != 0) {
            val carry = (A and B) shr 1
            A = A xor B
            B = carry
        }

        return A
    }
}
