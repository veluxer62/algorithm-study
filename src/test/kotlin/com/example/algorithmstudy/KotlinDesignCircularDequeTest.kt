package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinDesignCircularDequeTest {
    /*
     * 다음 연산을 제공하는 원형 데크를 디자인하라.
     */

    @Test
    fun test_MyCircularDeque() {
        val deque = MyCircularDeque(5)

        Assertions.assertTrue(deque.isEmpty())
        deque.insertFront(10)
        deque.insertFront(20)
        deque.insertFront(30)
        deque.insertLast(40)
        deque.insertLast(50)
        deque.deleteFront()
        deque.deleteLast()
        Assertions.assertEquals(20, deque.getFront())
        Assertions.assertEquals(40, deque.getRear())
        Assertions.assertFalse(deque.isEmpty())
        Assertions.assertFalse(deque.isFull())
        deque.insertLast(50)
        deque.insertLast(60)
        Assertions.assertTrue(deque.isFull())
        Assertions.assertEquals(60, deque.getRear())
    }

    private class MyCircularDeque(val k: Int) {
        val head: DoublyLinkedList = DoublyLinkedList(0)
        val tail: DoublyLinkedList = DoublyLinkedList(1)
        var len: Int = 0

        init {
            head.right = tail
            tail.left = head
        }

        fun insertFront(v: Int): Boolean {
            if (isFull()) return false

            val node = DoublyLinkedList(v)
            node.right = head.right
            node.left = head
            head.right?.left = node
            head.right = node
            len++

            return true
        }

        fun insertLast(v: Int): Boolean {
            if (isFull()) return false

            val node = DoublyLinkedList(v)
            node.left = tail.left
            node.right = tail
            tail.left?.right = node
            tail.left = node
            len++

            return true
        }

        fun deleteFront(): Boolean {
            if (isEmpty()) return false

            head.right?.right?.left = head
            head.right = head.right?.right
            len--

            return true
        }

        fun deleteLast(): Boolean {
            if (isEmpty()) return false

            tail.left?.left?.right = tail
            tail.left = tail.left?.left
            len--

            return true
        }

        fun getFront(): Int = if (isEmpty()) -1 else head.right?.v ?: -1

        fun getRear(): Int = if (isEmpty()) -1 else tail.left?.v ?: -1

        fun isEmpty(): Boolean = len == 0

        fun isFull(): Boolean = len == k

        private class DoublyLinkedList(val v: Int) {
            var left: DoublyLinkedList? = null
            var right: DoublyLinkedList? = null
        }
    }
}
