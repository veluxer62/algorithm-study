package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinImplementQueueUsingStacksTest {
    /*
     * 스택을 이용해 다음 연산을 지원하는 큐를 구현하라.
     */

    @Test
    fun test_stack() {
        val stack = MyQueue()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        Assertions.assertEquals(1, stack.peek())
        Assertions.assertEquals(1, stack.pop())
        Assertions.assertEquals(2, stack.pop())
        Assertions.assertFalse(stack.empty())
        Assertions.assertEquals(3, stack.peek())
        Assertions.assertEquals(3, stack.pop())
        Assertions.assertTrue(stack.empty())
    }

    private class MyQueue {
        private val input = ArrayDeque<Int>()
        private val output = ArrayDeque<Int>()

        fun push(i: Int) {
            input.add(i)
        }

        fun peek(): Int {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.add(input.removeFirst())
                }
            }
            return output.first()
        }

        fun pop(): Int {
            peek()
            return output.removeFirst()
        }

        fun empty(): Boolean {
            return input.isEmpty() && output.isEmpty()
        }
    }
}
