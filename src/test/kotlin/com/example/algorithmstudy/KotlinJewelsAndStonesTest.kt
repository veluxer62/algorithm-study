package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinJewelsAndStonesTest {
    /*
     * J는 보석이며, S는 갖고 있는 돌이다. S에는 보석이 몇 개나 있을까? 대소문자는 구분한다.
     */

    @Test
    fun test_numJewelsInStones() {
        val j = "aA"
        val s = "aAAbbbb"
        val actual: Int = numJewelsInStones(j, s)
        Assertions.assertEquals(3, actual)
    }

    @Test
    fun test_numJewelsInStones2() {
        val j = "aA"
        val s = "aAAbbbb"
        val actual: Int = numJewelsInStones2(j, s)
        Assertions.assertEquals(3, actual)
    }

    private fun numJewelsInStones(
        j: String,
        s: String,
    ): Int {
        val freq = mutableMapOf<Char, Int>()
        for (c in s) {
            freq[c] = freq.getOrDefault(c, 0) + 1
        }

        var count = 0
        for (c in j) {
            if (freq.containsKey(c)) {
                count += freq[c]!!
            }
        }

        return count
    }

    private fun numJewelsInStones2(
        j: String,
        s: String,
    ): Int {
        var count = 0
        val freq = mutableSetOf<Char>()

        for (c in j) {
            freq.add(c)
        }

        for (c in s) {
            if (freq.contains(c)) count++
        }

        return count
    }
}
