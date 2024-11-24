package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinQueueReconstructionByHeightTest {
    /*
     * 여러 명의 사람들이 줄을 서 있다. 각각의 사람들은 (h, k)의 두 정수 쌍을 갖는데,
     * h는 그 사람의 키, k는 앞에 줄 서 있는 사람들 중 자신과 키가 같거나 더 큰 사람들의 수를 뜻한다.
     * 이 값이 올바르도록 줄을 재정렬하는 알고리즘을 작성하라.
     */

    @Test
    fun test_reconstructQueue() {
        val people =
            arrayOf(
                intArrayOf(7, 0),
                intArrayOf(4, 4),
                intArrayOf(7, 1),
                intArrayOf(6, 0),
                intArrayOf(6, 2),
                intArrayOf(5, 2),
            )

        val actual = reconstructQueue(people)

        assertArrayEquals(
            arrayOf(
                intArrayOf(6, 0),
                intArrayOf(7, 0),
                intArrayOf(5, 2),
                intArrayOf(6, 2),
                intArrayOf(4, 4),
                intArrayOf(7, 1),
            ),
            actual,
        )
    }

    private fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val pq =
            PriorityQueue<IntArray> { a, b ->
                if (a.first() != b.first()) {
                    b.first() - a.first()
                } else {
                    a.last() - b.last()
                }
            }

        pq.addAll(people)

        val result = mutableListOf<IntArray>()
        while (pq.isNotEmpty()) {
            val person = pq.poll()
            result.add(person.last(), person)
        }

        return result.toTypedArray()
    }
}
