package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinKClosestPointsToOriginTest {
    /*
     * 평면상에 points 목록이 있을 때, 원점 (0, 0)에서 가장 가까운 k개의 점 목록을 순서대로 출력하라.
     * 평면상에 있는 두 점의 거리는 유클리드 거리로 한다.
     */

    @Test
    fun test_kClosest() {
        val points = arrayOf(intArrayOf(3, 3), intArrayOf(6, -1), intArrayOf(-2, 4))
        val actual: Array<IntArray> = kClosest(points, 2)
        assertArrayEquals(
            arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4)),
            actual,
        )
    }

    private fun kClosest(
        points: Array<IntArray>,
        k: Int,
    ): Array<IntArray> {
        val pq = PriorityQueue<Point>(Comparator.comparingLong { it.distance })

        for (point in points) {
            val distance = point[0].toLong() * point[0].toLong() + point[1].toLong() * point[1].toLong()
            pq.add(Point(distance, point))
        }

        val result = Array(k) { IntArray(2) }

        for (i in 0 until k) {
            result[i] = pq.poll().point
        }

        return result
    }

    private class Point(val distance: Long, val point: IntArray)
}
