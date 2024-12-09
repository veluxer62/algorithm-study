package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignCircularQueueTest {
    /*
     * 원형 큐를 디자인하라. 큐가 비어 있다면 -1을 리턴하며, 해당 원형 큐의 사용 예는 다음과 같다.
     */

    @Test
    public void test_myCircularQueue() {
        var circularQueue = new MyCircularQueue(5);
        circularQueue.enQueue(10);
        circularQueue.enQueue(20);
        circularQueue.enQueue(30);
        circularQueue.enQueue(40);
        assertEquals(40, circularQueue.Rear());
        assertFalse(circularQueue.isFull());
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(50);
        circularQueue.enQueue(60);
        assertEquals(60, circularQueue.Rear());
        circularQueue.enQueue(70);
        assertTrue(circularQueue.isFull());
        assertEquals(30, circularQueue.Front());
    }

    private static class MyCircularQueue {
        private final int[] q;
        private int front = 0, rear = -1, len = 0;

        public MyCircularQueue(int length) {
            this.q = new int[length];
        }

        public boolean enQueue(int value) {
            if (this.isFull()) return false;

            this.rear = (this.rear + 1) % this.q.length;
            this.q[this.rear] = value;
            this.len++;

            return true;
        }

        public int Rear() {
            return this.isEmpty() ? -1 : this.q[this.rear];
        }

        public boolean isFull() {
            return this.len == this.q.length;
        }

        public boolean deQueue() {
            if (this.isEmpty()) return false;

            this.front = (this.front + 1) % this.q.length;
            this.len--;

            return true;
        }

        public int Front() {
            return this.isEmpty() ? -1 : this.q[this.front];
        }

        public boolean isEmpty() {
            return this.len == 0;
        }
    }
}
