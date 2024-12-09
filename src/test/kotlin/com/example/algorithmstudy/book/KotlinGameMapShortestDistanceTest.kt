package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinGameMapShortestDistanceTest {
    /*
     * 상대 팀 진영에 도착할 수 있는 최단 거리를 출력하라.
     */

    @Test
    fun test_shortestDistance() {
        var maps =
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 1),
                intArrayOf(0, 0, 0, 0, 1),
            )
        var actual = shortestDistance(maps)
        assertEquals(11, actual)

        maps =
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1),
            )
        actual = shortestDistance(maps)
        assertEquals(-1, actual)
    }

    private fun shortestDistance(maps: Array<IntArray>): Int {
        val pq = PriorityQueue<Position>(compareBy { o -> o.distance })
        val dist = mutableMapOf<Int, Position>()

        fun findPath(
            y: Int,
            x: Int,
            distance: Int,
        ) {
            if (y >= 0 && y < maps.size && x >= 0 && x < maps[0].size && maps[y][x] != 0) {
                maps[y][x] = 0
                pq.add(Position(y, x, distance + 1))
            }
        }

        pq.add(Position(0, 0, 1))
        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            if (!dist.containsKey(cur.key)) {
                dist[cur.key] = cur

                findPath(cur.y, cur.x + 1, cur.distance)
                findPath(cur.y, cur.x - 1, cur.distance)
                findPath(cur.y + 1, cur.x, cur.distance)
                findPath(cur.y - 1, cur.x, cur.distance)
            }
        }

        return dist[((maps.size - 1) * 1000) + (maps[0].size - 1)]?.distance ?: -1
    }

    private data class Position(
        val y: Int,
        val x: Int,
        val distance: Int,
    ) {
        val key = y * 1000 + x
    }
}
