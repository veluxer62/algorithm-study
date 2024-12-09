package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinLongestPalindromicSubstringTest {
    /*
     * 가장 긴 팰린드롬 부분 문자열을 출력하라.
     */

    @Test
    fun test_longestPalindrome() {
        val str = "dcbabcdd"
        val actual: String = longestPalindrome(str)
        assertEquals("dcbabcd", actual)
    }

    private var left = 0
    private var maxLen = 0

    private fun longestPalindrome(str: String): String {
        if (str.length < 2) return str

        for (i in str.indices) {
            extendPalindrome(str, i, i + 1)
            extendPalindrome(str, i, i + 2)
        }

        return str.substring(left, left + maxLen)
    }

    private fun extendPalindrome(
        str: String,
        i: Int,
        j: Int,
    ) {
        var start = i
        var end = j

        while (start >= 0 && end < str.length && str[start] == str[end]) {
            start--
            end++
        }

        if (maxLen < end - start - 1) {
            left = start + 1
            maxLen = end - start - 1
        }
    }
}
