package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinNumberOf1BitsTest {
    /*
     * 부호 없는 정수형을 입력받아 1비트의 개수를 출력하라.
     */

    @Test
    fun test_hammingWeight() {
        val n = -7
        val actual: Int = hammingWeight(n)
        Assertions.assertEquals(30, actual)
    }

    @Test
    fun test_hammingWeight2() {
        val n = -7
        val actual: Int = hammingWeight2(n)
        Assertions.assertEquals(30, actual)
    }

    private fun hammingWeight(n: Int): Int {
        return Integer.bitCount(n)
    }

    private fun hammingWeight2(n: Int): Int {
        var count = 0
        var temp = n

        while (temp != 0) {
            temp = temp and temp - 1
            count++
        }

        return count
    }
}
