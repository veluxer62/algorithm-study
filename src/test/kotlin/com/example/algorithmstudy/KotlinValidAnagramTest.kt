package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinValidAnagramTest {
    /*
     * t가 s의 애너그램인지 판별하라.
     */

    @Test
    fun test_isAnagram() {
        val s = "anagram"
        val t = "nagrama"
        val actual: Boolean = isAnagram(s, t)
        assertTrue(actual)
    }

    private fun isAnagram(
        s: String,
        t: String,
    ): Boolean {
        return String(s.toCharArray().sortedArray()) == String(t.toCharArray().sortedArray())
    }
}
