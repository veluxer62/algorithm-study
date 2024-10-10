package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue

class KotlinImplementStackUsingQueuesTest {
    /*
     * 큐를 이용해 스택을 구현하라
     */

    @Test
    fun test_stack() {
        val stack = MyStack()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        Assertions.assertEquals(3, stack.top())
        Assertions.assertEquals(3, stack.pop())
        Assertions.assertEquals(2, stack.pop())
        Assertions.assertFalse(stack.empty())
        Assertions.assertEquals(1, stack.top())
        Assertions.assertEquals(1, stack.pop())
        Assertions.assertTrue(stack.empty())
    }

    private class MyStack {
        private val queue: Queue<Int> = LinkedList()

        fun push(i: Int) {
            queue.add(i)
            for (i in 1 until queue.size) {
                queue.add(queue.remove())
            }
        }

        fun top(): Int = queue.peek()

        fun pop(): Int = queue.remove()

        fun empty(): Boolean = queue.isEmpty()
    }
}
