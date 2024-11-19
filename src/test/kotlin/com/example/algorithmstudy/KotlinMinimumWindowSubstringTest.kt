package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinMinimumWindowSubstringTest {
    /*
     * 문자열 s와 t를 입력받아 O(n)에 t의 모든 문자가 포함된 s의 최소 윈도우를 찾아라.
     */

    @Test
    fun test_minWindow() {
        val s = "ABDOBECODEBANC"
        val t = "ABC"
        val acutal: String = minWindow(s, t)
        assertEquals("BANC", acutal)
    }

    @Test
    fun test_minWindow2() {
        val s = "ABDOBECODEBANC"
        val t = "ABC"
        val acutal: String = minWindow2(s, t)
        assertEquals("BANC", acutal)
    }

    private fun minWindow(
        s: String,
        t: String,
    ): String {
        fun contains(subStr: String): Boolean {
            val sb = StringBuilder(subStr)

            for (c in t.toCharArray()) {
                if (sb.indexOf(c) != -1) {
                    sb.deleteCharAt(sb.indexOf(c))
                } else {
                    return false
                }
            }

            return true
        }

        for (windowSize in t.length until s.length + 1) {
            for (left in 0 until s.length - windowSize + 1) {
                val subStr = s.substring(left, left + windowSize)

                if (contains(subStr)) {
                    return subStr
                }
            }
        }

        return ""
    }

    private fun minWindow2(
        s: String,
        t: String,
    ): String {
        val need = mutableMapOf<Char, Int>()

        for (c in t.toCharArray()) {
            need[c] = need.getOrDefault(c, 0) + 1
        }

        var missing = t.length
        var left = 0
        var right = 0
        var start = 0
        var end = 0
        var minLen = Int.MAX_VALUE

        for (c in s.toCharArray()) {
            right++

            if (need.contains(c) && need[c]!! > 0) {
                missing--
            }

            need[c] = need.getOrDefault(c, 0) - 1

            if (missing == 0) {
                while (left < right && need[s[left]]!! < 0) {
                    need[s[left]] = need.getOrDefault(s[left], 0) + 1
                    left++
                }

                if (minLen > right - left + 1) {
                    minLen = right - left + 1
                    start = left
                    end = right
                }

                need[s[left]] = need.getOrDefault(s[left], 0) + 1
                missing++
                left++
            }
        }

        return s.substring(start, end)
    }
}
