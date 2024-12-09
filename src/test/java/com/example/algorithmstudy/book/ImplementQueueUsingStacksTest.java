package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementQueueUsingStacksTest {
    /*
     * 스택을 이용해 다음 연산을 지원하는 큐를 구현하라.
     */

    @Test
    public void test_stack() {
        var stack = new MyQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertFalse(stack.empty());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertTrue(stack.empty());
    }

    private static class MyQueue {
        private final Deque<Integer> input = new ArrayDeque<>();
        private final Deque<Integer> output = new ArrayDeque<>();

        public MyQueue() {
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }

            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
