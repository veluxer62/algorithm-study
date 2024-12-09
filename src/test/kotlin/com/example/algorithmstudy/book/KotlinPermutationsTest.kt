package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinPermutationsTest {
    /*
     * 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라.
     */

    @Test
    fun test_permuteUnique() {
        val nums = intArrayOf(1, 2, 4)
        val actual: List<List<Int>> = permuteUnique(nums)
        assertEquals(
            listOf(
                listOf(1, 2, 4),
                listOf(1, 4, 2),
                listOf(2, 1, 4),
                listOf(2, 4, 1),
                listOf(4, 1, 2),
                listOf(4, 2, 1),
            ),
            actual,
        )
    }

    private fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(
            prevElements: MutableList<Int>,
            elements: List<Int>,
        ) {
            if (elements.isEmpty()) {
                result.add(prevElements.toList())
            }

            for (e in elements) {
                val next = elements.toMutableList()
                next.remove(e)

                prevElements.add(e)
                dfs(prevElements, next)
                prevElements.remove(e)
            }
        }

        dfs(mutableListOf(), nums.toList())

        return result
    }
}
