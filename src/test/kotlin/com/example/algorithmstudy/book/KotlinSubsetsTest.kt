package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinSubsetsTest {
    /*
     * 모든 부분집합을 리턴하라.
     */

    @Test
    fun test_subsets() {
        val nums = intArrayOf(1, 2, 4)
        val actual: List<List<Int>> = subsets(nums)
        assertEquals(
            listOf(
                listOf(),
                listOf(1),
                listOf(1, 2),
                listOf(1, 2, 4),
                listOf(1, 4),
                listOf(2),
                listOf(2, 4),
                listOf(4),
            ),
            actual,
        )
    }

    private fun subsets(nums: IntArray): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        fun dfs(
            index: Int,
            path: ArrayDeque<Int>,
        ) {
            results.add(path.toList())

            for (i in index until nums.size) {
                path.add(nums[i])
                dfs(i + 1, path)
                path.removeLast()
            }
        }

        dfs(0, ArrayDeque())

        return results
    }
}
