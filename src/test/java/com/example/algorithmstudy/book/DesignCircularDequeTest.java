package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignCircularDequeTest {
    /*
     * 다음 연산을 제공하는 원형 데크를 디자인하라.
     */

    @Test
    public void test_MyCircularDeque() {
        var deque = new MyCircularDeque(5);

        assertTrue(deque.isEmpty());
        deque.insertFront(10);
        deque.insertFront(20);
        deque.insertFront(30);
        deque.insertLast(40);
        deque.insertLast(50);
        deque.deleteFront();
        deque.deleteLast();
        assertEquals(20, deque.getFront());
        assertEquals(40, deque.getRear());
        assertFalse(deque.isEmpty());
        assertFalse(deque.isFull());
        deque.insertLast(50);
        deque.insertLast(60);
        assertTrue(deque.isFull());
        assertEquals(60, deque.getRear());
    }

    private static class MyCircularDeque {
        private int len;
        private final int k;
        private final DoublyLinkedList head;
        private final DoublyLinkedList tail;

        public MyCircularDeque(int k) {
            head = new DoublyLinkedList(0);
            tail = new DoublyLinkedList(0);
            head.right = tail;
            tail.left = head;
            this.k = k;
            this.len = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            var node = new DoublyLinkedList(value);

            node.right = head.right;
            node.left = head;
            head.right.left = node;
            head.right = node;
            len++;

            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            var node = new DoublyLinkedList(value);
            node.left = tail.left;
            node.right = tail;
            tail.left.right = node;
            tail.left = node;
            len++;

            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            head.right.right.left = head;
            head.right = head.right.right;
            len--;

            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            tail.left.left.right = tail;
            tail.left = tail.left.left;
            len--;

            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : head.right.val;
        }

        public int getRear() {
            return isEmpty() ? -1 : tail.left.val;
        }

        public boolean isEmpty() {
            return len == 0;
        }

        public boolean isFull() {
            return len == k;
        }

        private static class DoublyLinkedList {
            DoublyLinkedList left;
            DoublyLinkedList right;
            int val;

            public DoublyLinkedList(int val) {
                this.val = val;
            }
        }
    }
}
