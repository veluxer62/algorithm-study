package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinDesignCircularQueueTest {
    /*
     * 원형 큐를 디자인하라. 큐가 비어 있다면 -1을 리턴하며, 해당 원형 큐의 사용 예는 다음과 같다.
     */

    @Test
    fun test_myCircularQueue() {
        val circularQueue = MyCircularQueue(5)
        circularQueue.enQueue(10)
        circularQueue.enQueue(20)
        circularQueue.enQueue(30)
        circularQueue.enQueue(40)
        Assertions.assertEquals(40, circularQueue.Rear())
        Assertions.assertFalse(circularQueue.isFull())
        circularQueue.deQueue()
        circularQueue.deQueue()
        circularQueue.enQueue(50)
        circularQueue.enQueue(60)
        Assertions.assertEquals(60, circularQueue.Rear())
        circularQueue.enQueue(70)
        Assertions.assertTrue(circularQueue.isFull())
        Assertions.assertEquals(30, circularQueue.Front())
    }

    private class MyCircularQueue(length: Int) {
        private val q = IntArray(length)
        private var front: Int = 0
        private var rear: Int = -1
        private var len: Int = 0

        fun enQueue(value: Int): Boolean {
            if (isFull()) return false

            rear = (rear + 1) % q.size
            q[rear] = value
            len++

            return true
        }

        fun deQueue(): Boolean {
            if (isEmpty()) return false

            front = (front + 1) % q.size
            len--

            return true
        }

        fun Rear(): Int = if (isEmpty()) -1 else q[rear]

        fun isFull(): Boolean = len == q.size

        fun Front(): Int = if (isEmpty()) -1 else q[front]

        fun isEmpty(): Boolean = len == 0
    }
}
