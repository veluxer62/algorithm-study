package com.example.algorithmstudy.book

import com.example.algorithmstudy.generateList
import com.example.algorithmstudy.record
import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinSortListTest {
    /*
     * 연결 리스트를 O(n log n)에 정렬하라.
     */

    @Test
    fun test_sortList() {
        val head = ListNode(listOf(-1, 5, 3, 4, 0))
        val actual = record { sortList(head) }
        Assertions.assertEquals(
            ListNode(listOf(-1, 0, 3, 4, 5)),
            actual,
        )

        val head2 = ListNode(generateList(10000))
        record { sortList(head2) }
    }

    private fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var half: ListNode? = null
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast?.next != null) {
            half = slow
            slow = slow?.next
            fast = fast.next.next
        }
        half?.next = null

        val l1 = sortList(head)
        val l2 = sortList(slow)

        return mergeTwoList(l1, l2)
    }

    private fun mergeTwoList(
        l1: ListNode?,
        l2: ListNode?,
    ): ListNode? {
        var left = l1
        var right = l2

        if (left == null) return right
        if (right == null) return left

        if (left.`val` > right.`val`) {
            left = right.also { right = left }
        }

        left.next = mergeTwoList(left.next, right)

        return left
    }
}
