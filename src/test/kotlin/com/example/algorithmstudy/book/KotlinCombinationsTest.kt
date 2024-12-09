package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinCombinationsTest {
    /*
     * 전체 수 n을 입력받아 k개의 조합을 리턴하라.
     */

    @Test
    fun test_combine() {
        val n = 5
        val k = 3
        val actual: List<List<Int>> = combine(n, k)
        Assertions.assertEquals(
            listOf(
                listOf(1, 2, 3),
                listOf(1, 2, 4),
                listOf(1, 2, 5),
                listOf(1, 3, 4),
                listOf(1, 3, 5),
                listOf(1, 4, 5),
                listOf(2, 3, 4),
                listOf(2, 3, 5),
                listOf(2, 4, 5),
                listOf(3, 4, 5),
            ),
            actual,
        )
    }

    private fun combine(
        n: Int,
        k: Int,
    ): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        fun dfs(
            elements: LinkedList<Int>,
            start: Int,
            k: Int,
        ) {
            if (k == 0) {
                results.add(elements.toList())
                return
            }

            for (i in start until n + 1) {
                elements.add(i)
                dfs(elements, i + 1, k - 1)
                elements.removeLast()
            }
        }

        dfs(LinkedList<Int>(), 1, k)

        return results
    }
}
