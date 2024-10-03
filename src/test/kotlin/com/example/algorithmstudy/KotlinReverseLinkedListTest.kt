package com.example.algorithmstudy

import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinReverseLinkedListTest {
    /*
     * 연결 리스트를 뒤집어라
     */

    @Test
    fun test_reverseList() {
        val list = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual = record { reverseList(list) }
        Assertions.assertEquals(
            ListNode(listOf(6, 5, 4, 3, 2, 1)),
            actual,
        )

        val list2 = ListNode(generateList(30000))
        record { reverseList(list2) }
    }

    @Test
    fun test_reverseList2() {
        val list = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual = record { reverseList2(list) }
        Assertions.assertEquals(
            ListNode(listOf(6, 5, 4, 3, 2, 1)),
            actual,
        )

        val list2 = ListNode(generateList(30000))
        record { reverseList2(list2) }
    }

    private fun reverseList(list: ListNode): ListNode? {
        return reverse(list, null)
    }

    private fun reverse(
        node: ListNode?,
        prev: ListNode?,
    ): ListNode? {
        if (node == null) return prev

        val next = node.next
        node.next = prev

        return reverse(next, node)
    }

    private fun reverseList2(head: ListNode): ListNode? {
        var prev: ListNode? = null
        var node = head

        while (node != null) {
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }

        return prev
    }

    /*
     * p=null
     * n=1-2-3-4-5-6
     * next=2-3-4-5-6
     * n=1-null
     * p=1-null
     * n=2-3-4-5-6
     * next=3-4-5-6
     * n=2-1-null
     * p=2-1-null
     * n=3-4-5-6
     */
}
