package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.AbstractMap.SimpleEntry
import java.util.PriorityQueue

class KotlinNetworkDelayTimeTest {
    /*
     * k에서 출발해 모든 노드가 신호를 받을 수 있는 시간을 계산하라. 한 군데라도 노드에 도달할 수 없는 경우 -1을 리턴한다.
     * 입력값(u, v, w)는 각각 출발지, 도착지, 소요 시간으로 구성되며, 전체 노드의 개수는 n이다.
     */

    @Test
    fun test_networkDelayTime() {
        val times =
            arrayOf(
                intArrayOf(3, 1, 5),
                intArrayOf(3, 2, 2),
                intArrayOf(2, 1, 2),
                intArrayOf(3, 4, 1),
                intArrayOf(4, 5, 1),
                intArrayOf(5, 6, 1),
                intArrayOf(6, 7, 1),
                intArrayOf(7, 8, 1),
                intArrayOf(8, 1, 1),
            )
        val n = 8
        val k = 3
        val actual: Int = networkDelayTime(times, n, k)
        assertEquals(5, actual)
    }

    private fun networkDelayTime(
        times: Array<IntArray>,
        n: Int,
        k: Int,
    ): Int {
        val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
        for (time in times) {
            graph.getOrPut(time[0]) { mutableMapOf() }[time[1]] = time[2]
        }

        val dist = mutableMapOf<Int, Int>()
        val pq = PriorityQueue<Map.Entry<Int, Int>>(compareBy { (_, time) -> time })
        pq.add(SimpleEntry(k, 0))

        while (pq.isNotEmpty()) {
            val (u, dist_u) = pq.poll()

            if (dist.containsKey(u)) continue

            dist[u] = dist_u

            val path = graph[u] ?: continue
            for ((key, value) in path) {
                val alt = dist_u + value
                pq.add(SimpleEntry(key, alt))
            }
        }

        return if (dist.size == n) {
            dist.maxOf { it.value }
        } else {
            -1
        }
    }
}
