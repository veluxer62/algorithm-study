package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinCheapestFlightsWithinKStopsTest {
    /*
     * 시작점에서 도착점까지의 가장 저렴한 가격을 계산하되, k개의 경유지 이내에 도착하는 가격을 리턴하라. 경로가 존재하지 않을 경우 -1을 리턴한다.
     */

    @Test
    fun test_findCheapestPrice() {
        val n = 0
        val flights =
            arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 200),
                intArrayOf(0, 2, 500),
            )
        val src = 0
        val dst = 2
        val k = 0
        val actual = findCheapestPrice(n, flights, src, dst, k)
        assertEquals(500, actual)
    }

    @Test
    fun test_findCheapestPrice2() {
        val n = 0
        val flights =
            arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 200),
                intArrayOf(0, 2, 500),
            )
        val src = 0
        val dst = 2
        val k = 0
        val actual = findCheapestPrice2(n, flights, src, dst, k)
        assertEquals(500, actual)
    }

    private fun findCheapestPrice(
        n: Int,
        flights: Array<IntArray>,
        src: Int,
        dst: Int,
        k: Int,
    ): Int {
        val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
        for (flight in flights) {
            graph.getOrPut(flight[0]) { mutableMapOf() }[flight[1]] = flight[2]
        }

        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { (_, price, _) -> price })
        pq.add(Triple(src, 0, 0))

        var kVisited = 0
        while (pq.isNotEmpty()) {
            val (u, price, visited) = pq.poll()

            if (u == dst) return price

            if (kVisited <= k) {
                kVisited = visited + 1

                for ((key, value) in graph[u]?.entries ?: continue) {
                    val alt = price + value
                    pq.add(Triple(key, alt, kVisited))
                }
            }
        }

        return -1
    }

    private fun findCheapestPrice2(
        n: Int,
        flights: Array<IntArray>,
        src: Int,
        dst: Int,
        k: Int,
    ): Int {
        val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
        for (flight in flights) {
            graph.getOrPut(flight[0]) { mutableMapOf() }[flight[1]] = flight[2]
        }

        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { (_, price, _) -> price })
        pq.add(Triple(src, 0, 0))

        var visited = mutableMapOf<Int, Int>()

        var kVisited: Int
        while (pq.isNotEmpty()) {
            val (u, price, v) = pq.poll()

            if (u == dst) return price

            visited[u] = v

            if (v <= k) {
                kVisited = v + 1

                for ((key, value) in graph[u]?.entries ?: continue) {
                    if (!visited.containsKey(key) || kVisited < visited[key]!!) {
                        val alt = price + value
                        pq.add(Triple(key, alt, kVisited))
                    }
                }
            }
        }

        return -1
    }
}
