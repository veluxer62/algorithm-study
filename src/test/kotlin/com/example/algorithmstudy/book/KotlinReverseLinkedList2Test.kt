package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinReverseLinkedList2Test {
    /*
     * 위치 left에서 right까지를 역순으로 만들어라. 위치는 1부터 시작한다.
     */

    @Test
    fun test_reverseList() {
        val head = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual: ListNode = reverseList(head, 2, 5)
        Assertions.assertEquals(
            ListNode(listOf(1, 5, 4, 3, 2, 6)),
            actual,
        )
    }

    private fun reverseList(
        head: ListNode,
        left: Int,
        right: Int,
    ): ListNode {
        val root = ListNode(0)
        root.next = head
        var start = root

        for (i in 0 until left - 1) {
            start = start.next
        }

        val end = start.next
        for (i in 0 until right - left) {
            val tmp = start.next
            start.next = end.next
            end.next = end.next.next
            start.next.next = tmp
        }

        return root.next
    }
}
