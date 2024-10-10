package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackUsingQueuesTest {
    /*
     * 큐를 이용해 스택을 구현하라
     */

    @Test
    public void test_stack() {
        var stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertFalse(stack.empty());
        assertEquals(1, stack.top());
        assertEquals(1, stack.pop());
        assertTrue(stack.empty());
    }

    private static class MyStack {
        private final Queue<Integer> queue = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
