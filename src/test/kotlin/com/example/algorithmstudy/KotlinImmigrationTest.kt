package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinImmigrationTest {
    /*
     * 각 심사관이 한 명을 심사하는 데 걸리는 시간이 담긴 배열 times가 주어질 때, 모든 사람이 심사를 받는 데 걸리는 시간의 최솟값을 출력하라.
     */

    @Test
    fun test_migrate() {
        val n = 6
        val times = intArrayOf(7, 10)
        val actual: Long = migrate(n, times)
        assertEquals(28, actual)
    }

    private fun migrate(
        n: Int,
        times: IntArray,
    ): Long {
        var answer = 0L
        var left = 1L
        var right = times.max() * n.toLong()
        var mid = right

        while (left <= right) {
            val calcN = times.fold(0L) { acc, time -> acc + (mid / time) }

            when {
                calcN >= n -> {
                    answer = mid
                    right = mid - 1
                }
                else -> left = mid + 1
            }

            mid = left + (right - left) / 2
        }

        return answer
    }
}
