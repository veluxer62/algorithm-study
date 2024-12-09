package com.example.algorithmstudy.book

import com.example.algorithmstudy.generateList
import com.example.algorithmstudy.record
import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinMergeTowSortedListsTest {
    /*
     * 정렬되어 있는 두 연결 리스트를 합쳐라
     */

    @Test
    fun test_mergeTwoLists() {
        val l1 = ListNode(listOf(1, 2, 5))
        val l2 = ListNode(listOf(1, 3, 4))
        val actual = record { mergeTwoLists(l1, l2) }
        Assertions.assertEquals(ListNode(listOf(1, 1, 2, 3, 4, 5)), actual)

        val l11 = ListNode(generateList(10000))
        val l22 = ListNode(generateList(10000))
        record { mergeTwoLists(l11, l22) }
    }

    private fun mergeTwoLists(
        l1: ListNode?,
        l2: ListNode?,
    ): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}
