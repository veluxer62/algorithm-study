package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinLongestRepeatingCharacterReplacementTest {
    /*
     * 대문자로 구성된 문자열 s가 주어졌을 때 k번만큼의 변경으로 만들 수 있는 연속으로 반복된 문자열의 가장 긴 길이를 출력하라.
     */

    @Test
    fun test_replace() {
        val s = "AAABBCD"
        val k = 2
        val actual: Int = replace(s, k)
        assertEquals(5, actual)
    }

    private fun replace(
        s: String,
        k: Int,
    ): Int {
        var left = 0
        val counts = mutableMapOf<Char, Int>()

        for (right in 1 until s.length + 1) {
            counts[s[right - 1]] = counts.getOrDefault(s[right - 1], 0) + 1

            val maxCharCount = counts.maxOf { it.value }

            if (right - left - maxCharCount > k) {
                counts[s[left]] = counts.getOrDefault(s[left], 0) - 1
                left++
            }
        }

        return s.length - left
    }
}
