package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinOddEvenLinkedListTest {
    /*
     * 연결 리스트를 홀수 번째 노드 다음에 짝수 번째 노드가 오도록 재구성하라. 공간 봅작도 O(1), 시간 복잡도 O(n)에 풀이하라.
     */

    @Test
    fun test_oddEvenList() {
        val given = ListNode(listOf(1, 2, 3, 4, 5, 6))
        val actual: ListNode = oddEvenList(given)
        assertEquals(
            ListNode(listOf(1, 3, 5, 2, 4, 6)),
            actual,
        )
    }

    private fun oddEvenList(head: ListNode): ListNode {
        var odd = head
        var even: ListNode? = head.next
        val evenHead = even

        while (even?.next != null) {
            odd.next = odd.next.next
            even.next = even.next.next
            odd = odd.next
            even = even.next
        }

        odd.next = evenHead

        return head
    }
}
