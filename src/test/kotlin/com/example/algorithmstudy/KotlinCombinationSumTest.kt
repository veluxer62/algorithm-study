package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinCombinationSumTest {
    /*
     * 숫자 집합 candidates를 조합하여 합이 target이 되는 엘리먼트를 나열하라. 각 숫자는 중복으로 나열 가능하다.
     */

    @Test
    fun test_combinationSum() {
        val candidates = intArrayOf(2, 3, 5, 8)
        val target = 8
        val actual: List<List<Int>> = combinationSum(candidates, target)
        assertEquals(
            listOf(
                listOf(2, 2, 2, 2),
                listOf(2, 3, 3),
                listOf(3, 5),
                listOf(8),
            ),
            actual,
        )
    }

    private fun combinationSum(
        candidates: IntArray,
        target: Int,
    ): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        fun dfs(
            index: Int,
            target: Int,
            path: ArrayDeque<Int>,
        ) {
            if (target < 0) return
            if (target == 0) {
                results.add(path.toList())
                return
            }

            for (i in index until candidates.size) {
                path.add(candidates[i])
                dfs(i, target - candidates[i], path)
                path.removeLast()
            }
        }

        dfs(0, target, ArrayDeque())

        return results
    }
}
