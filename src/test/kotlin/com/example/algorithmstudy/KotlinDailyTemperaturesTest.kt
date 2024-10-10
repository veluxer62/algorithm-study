package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KotlinDailyTemperaturesTest {
    /*
     * 매일의 온도 리스트 temperatures를 입력받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는지를 출력하라.
     */

    @Test
    fun test_dailyTemperatures() {
        val t = intArrayOf(23, 24, 25, 21, 19, 22, 26, 23)
        val actual: IntArray = dailyTemperatures(t)
        assertArrayEquals(
            intArrayOf(1, 1, 4, 2, 1, 1, 0, 0),
            actual,
        )
    }

    private fun dailyTemperatures(t: IntArray): IntArray {
        val result = IntArray(t.size)
        val stack = ArrayDeque<Int>()

        for (i in t.indices) {
            while (stack.isNotEmpty() && t[i] > t[stack.first()]) {
                val last = stack.removeFirst()
                result[last] = i - last
            }
            stack.addFirst(i)
        }

        return result
    }
}
