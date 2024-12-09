package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinMinimumHeightTreesTest {
    /*
     * 노드 개수와 무방향 그래프를 입력받아 트리가 최소 높이가 되는 루트의 목록을 리턴하라. 각 노드는 0부터 n - 1까지, n개만큼 존재한다.
     */

    @Test
    fun test_minHeightTrees() {
        var n = 7
        var edges =
            arrayOf(
                intArrayOf(0, 3),
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(4, 3),
                intArrayOf(5, 3),
                intArrayOf(6, 5),
            )
        var actual = minHeightTrees(n, edges)
        assertEquals(
            listOf(3, 5),
            actual,
        )

        n = 10
        edges =
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(3, 5),
                intArrayOf(5, 9),
                intArrayOf(4, 6),
                intArrayOf(4, 7),
                intArrayOf(7, 8),
            )
        actual = minHeightTrees(n, edges)
        assertEquals(
            listOf(2),
            actual,
        )
    }

    private fun minHeightTrees(
        n: Int,
        edges: Array<IntArray>,
    ): List<Int> {
        if (n == 1) return listOf(0)

        val graph = mutableMapOf<Int, MutableList<Int>>()
        for (edge in edges) {
            graph.getOrPut(edge.first()) { mutableListOf() }.add(edge.last())
            graph.getOrPut(edge.last()) { mutableListOf() }.add(edge.first())
        }

        var leaves = mutableListOf<Int>()
        for (i in 0 until n) {
            if (graph[i]?.size == 1) {
                leaves.add(i)
            }
        }

        var total = n
        while (total > 2) {
            total -= leaves.size

            val newLeaves = mutableListOf<Int>()
            for (leaf in leaves) {
                val neighbor = graph[leaf]?.first()!!
                graph[neighbor]?.remove(leaf)

                if (graph[neighbor]?.size == 1) {
                    newLeaves.add(neighbor)
                }
            }

            leaves = newLeaves
        }

        return leaves
    }
}
