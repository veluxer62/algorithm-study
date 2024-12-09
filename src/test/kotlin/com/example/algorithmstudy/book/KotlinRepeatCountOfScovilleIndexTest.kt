package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinRepeatCountOfScovilleIndexTest {
    /*
     * 다음과 같이 새로운 음식을 만들 때 모든 음식의 스코빌 지수가 k 이상이 되는 반복 횟수를 리턴하라.
     * 섞음 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */

    @Test
    fun test_repeatCountOfScovilleIndex() {
        val scoville = intArrayOf(1, 2, 3, 9, 10, 12)
        val k = 7
        val actual: Int = repeatCountOfScovilleIndex(scoville, k)
        assertEquals(2, actual)
    }

    private fun repeatCountOfScovilleIndex(
        scoville: IntArray,
        k: Int,
    ): Int {
        val pq = PriorityQueue<Int>()
        for (s in scoville) {
            pq.add(s)
        }

        var result = 1
        while (pq.size >= 2) {
            pq.add(pq.poll() + (pq.poll() * 2))

            if (pq.peek() >= k) return result
            result++
        }

        return -1
    }
}
