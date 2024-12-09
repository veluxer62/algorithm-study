package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinMergeKSortedListsTest {
    /*
     * k개의 정렬된 리스트를 1개의 정렬된 리스트로 병합하라.
     */

    @Test
    fun test_mergeKLists() {
        val lists =
            arrayOf(
                ListNode(listOf(1, 4, 5)),
                ListNode(listOf(1, 3, 4)),
                ListNode(listOf(2, 7)),
            )
        val actual: ListNode = mergeKLists(lists)
        Assertions.assertEquals(
            ListNode(listOf(1, 1, 2, 3, 4, 4, 5, 7)),
            actual,
        )
    }

    private fun mergeKLists(lists: Array<ListNode>): ListNode {
        val pq = PriorityQueue<ListNode>(Comparator.comparingInt { it.`val` })
        val root = ListNode(0)
        var tail = root

        for (node in lists) {
            if (node.next != null) {
                pq.add(node)
            }
        }

        while (pq.isNotEmpty()) {
            tail.next = pq.poll()
            tail = tail.next!!

            if (tail.next != null) {
                pq.add(tail.next!!)
            }
        }

        return root.next
    }
}
