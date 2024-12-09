package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinHammingDistanceTest {
    /*
     * 두 정수를 입력받아 몇 비트가 다른지 계산하라.
     */

    @Test
    fun test_hammingDistance() {
        val x = 1
        val y = 6
        val actual: Int = hammingDistance(x, y)
        assertEquals(3, actual)
    }

    private fun hammingDistance(
        x: Int,
        y: Int,
    ): Int {
        return (x xor y).countOneBits()
    }
}
