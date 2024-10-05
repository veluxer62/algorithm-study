package com.example.algorithmstudy

import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinSwapNodesInPairsTest {
    /*
     * 연결 리스트를 입력 받아 페어 단위로 스왑하라.
     */

    @Test
    fun test_swapPairs() {
        val node = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual = record { swapPairs(node) }
        Assertions.assertEquals(
            ListNode(listOf(2, 1, 4, 3, 6, 5)),
            actual,
        )
    }

    @Test
    fun test_swapPairs2() {
        val node = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual = record { swapPairs2(node) }
        Assertions.assertEquals(
            ListNode(listOf(2, 1, 4, 3, 6, 5)),
            actual,
        )
    }

    @Test
    fun test_swapPairs3() {
        val node = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual = record { swapPairs3(node) }
        Assertions.assertEquals(
            ListNode(listOf(2, 1, 4, 3, 6, 5)),
            actual,
        )
    }

    private fun swapPairs(head: ListNode): ListNode {
        var node: ListNode? = head
        while (node != null) {
            val tmp = node.`val`
            node.`val` = node.next.`val`
            node.next.`val` = tmp

            node = node.next.next
        }

        return head
    }

    private fun swapPairs2(head: ListNode): ListNode {
        var node = ListNode(0)
        val root = node
        node.next = head

        while (node.next != null && node.next.next != null) {
            val a = node.next
            val b = node.next.next

            a.next = b.next
            node.next = b
            node.next.next = a
            node = node.next.next
        }

        return root.next
    }

    private fun swapPairs3(head: ListNode?): ListNode? {
        while (head?.next != null) {
            val p = head.next
            head.next = swapPairs3(head.next.next)
            p.next = head
            return p
        }

        return head
    }
}
