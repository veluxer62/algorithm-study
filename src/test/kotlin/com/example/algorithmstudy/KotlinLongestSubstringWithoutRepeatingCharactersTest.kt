package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinLongestSubstringWithoutRepeatingCharactersTest {
    /*
     * 중복 문자가 없는 가장 긴 부분 문자열의 길이를 리턴하라.
     */

    @Test
    fun test_lengthOfLongestSubstring() {
        val str = "abcabcbbc"
        val actual: Int = lengthOfLongestSubstring(str)
        Assertions.assertEquals(3, actual)
    }

    private fun lengthOfLongestSubstring(str: String): Int {
        val used = mutableMapOf<Char, Int>()
        var maxLength = 0
        var left = 0
        var right = 0

        for (c in str) {
            if (left <= used.getOrDefault(c, -1)) {
                left = used.getOrDefault(c, 0) + 1
            } else {
                maxLength = maxLength.coerceAtLeast(right - left + 1)
            }

            used[c] = right
            right++
        }

        return maxLength
    }
}
