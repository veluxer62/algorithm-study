package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinSheepAndWolvesTest {
    /*
     * 양의 수가 늑대와 같거나 적으면 잡아먹힌다.
     * 잡아먹히지 않도록 하면서 최대한 많은 수의 양을 모아 루트로 돌아온다고 할 때 모을 수 있는 양의 최댓값을 출력하라.
     */

    @Test
    fun test_solution() {
        val info = intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1)
        val edged =
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 4),
                intArrayOf(0, 8),
                intArrayOf(8, 7),
                intArrayOf(9, 10),
                intArrayOf(9, 11),
                intArrayOf(4, 3),
                intArrayOf(6, 5),
                intArrayOf(4, 6),
                intArrayOf(8, 9),
            )

        val actual = solution(info, edged)

        assertEquals(5, actual)
    }

    private fun solution(
        info: IntArray,
        edged: Array<IntArray>,
    ): Int {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        var answer = 1

        for (edge in edged) {
            graph.putIfAbsent(edge.first(), mutableListOf())
            graph[edge.first()]?.add(edge.last())
        }

        val queue = LinkedList<Node>()
        queue.offer(Node(0, 1, 0, graph[0]!!))

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            for (nexNode in node.nodes) {
                val nextSheep = if (info[nexNode] == 0) node.sheep + 1 else node.sheep
                val nextWolves = if (info[nexNode] == 1) node.wolves + 1 else node.wolves

                if (nextSheep > nextWolves) {
                    answer = answer.coerceAtLeast(nextSheep)

                    val candidateNodes = node.nodes.toMutableList()
                    candidateNodes.remove(nexNode)

                    if (graph[nexNode] != null) {
                        candidateNodes.addAll(graph[nexNode]!!)
                    }

                    queue.offer(Node(nexNode, nextSheep, nextWolves, candidateNodes))
                }
            }
        }

        return answer
    }

    private data class Node(
        val index: Int,
        val sheep: Int,
        val wolves: Int,
        val nodes: List<Int>,
    )
}
