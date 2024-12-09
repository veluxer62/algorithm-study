package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Collections
import java.util.PriorityQueue

class KotlinDoublePriorityQueueTest {
    /*
     * 다음과 같은 연산을 수행하는 이중 우선순위 큐를 구현하라.
     *
     * 명령어  | 수신 탑(높이)
     * I 숫자 | 큐에 숫자 삽입
     * D 1  | 큐에서 최댓값 삭제
     * D -1 | 큐에서 최솟값 삭제
     */

    @Test
    fun test_doublePriorityQueue() {
        val operations = arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "I 333", "I 8", "I 7", "D -1")
        val actual: IntArray = doublePriorityQueue(operations)
        Assertions.assertArrayEquals(
            intArrayOf(333, -45),
            actual,
        )
    }

    private fun doublePriorityQueue(operations: Array<String>): IntArray {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

        for (operation in operations) {
            val op = operation.split(" ")

            when (op.first()) {
                "I" -> {
                    minHeap.add(op.last().toInt())
                    maxHeap.add(op.last().toInt())
                }

                "D" -> {
                    when (op.last()) {
                        "1" -> minHeap.remove(maxHeap.poll())
                        "-1" -> maxHeap.remove(minHeap.poll())
                    }
                }
            }
        }

        return intArrayOf(
            maxHeap.poll() ?: 0,
            minHeap.poll() ?: 0,
        )
    }
}
