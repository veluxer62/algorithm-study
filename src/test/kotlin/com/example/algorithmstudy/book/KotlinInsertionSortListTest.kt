package com.example.algorithmstudy.book

import com.example.algorithmstudy.generateList
import com.example.algorithmstudy.record
import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinInsertionSortListTest {
    /*
     * 연결 리스트를 삽입 정렬로 정렬하라.
     */

    @Test
    fun test_sort() {
        val head = ListNode(listOf(5, 2, 1, 3))
        val actual = record { sort(head) }
        Assertions.assertEquals(
            ListNode(listOf(1, 2, 3, 5)),
            actual,
        )

        val head2 = ListNode(generateList(30000))
        record { sort(head2) }
    }

    @Test
    fun test_sort2() {
        val head = ListNode(listOf(5, 2, 1, 3))
        val actual = record { sort(head) }
        Assertions.assertEquals(
            ListNode(listOf(1, 2, 3, 5)),
            actual,
        )

        val head2 = ListNode(generateList(30000))
        record { sort2(head2) }
    }

    private fun sort(head: ListNode): ListNode {
        val parent = ListNode(-1)
        var p: ListNode? = parent
        var h: ListNode? = head

        while (h != null) {
            while (p?.next != null && p.next.`val` < h.`val`) {
                p = p.next
            }

            val pNext = p?.next
            val hNext = h.next
            p?.next = h
            h.next = pNext
            h = hNext
            p = parent
        }

        return parent.next
    }

    private fun sort2(head: ListNode): ListNode {
        val parent = ListNode(-1)
        var p: ListNode? = parent
        var h: ListNode? = head

        while (h != null) {
            while (p?.next != null && p.next.`val` < h.`val`)
                p = p.next

            val pNext = p?.next
            val hNext = h.next
            p?.next = h
            h.next = pNext
            h = hNext

            if (h != null && p!!.`val` < h.`val`) {
                p = parent
            }
        }

        return parent.next
    }
}
