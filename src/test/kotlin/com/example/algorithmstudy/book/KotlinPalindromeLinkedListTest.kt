package com.example.algorithmstudy.book

import com.example.algorithmstudy.generateList
import com.example.algorithmstudy.record
import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Stack

class KotlinPalindromeLinkedListTest {
    /*
     * 연결 리스트가 팰린드롬 구조인지 판별하라.
     */

    @Test
    fun test_isPalindrome() {
        val node = ListNode(listOf(1, 2, 3, 2, 1))
        val actual = record { isPalindrome(node) }
        assertTrue(actual)

        val node2 = ListNode(generateList(1000000))
        record { isPalindrome(node2) }
    }

    @Test
    fun test_isPalindrome2() {
        val node = ListNode(listOf(1, 2, 3, 2, 1))
        val actual = record { isPalindrome2(node) }
        assertTrue(actual)

        val node2 = ListNode(generateList(1000000))
        record { isPalindrome2(node2) }
    }

    @Test
    fun test_isPalindrome3() {
        val node = ListNode(listOf(1, 2, 3, 2, 1))
        val actual = record { isPalindrome3(node) }
        assertTrue(actual)

        val node2 = ListNode(generateList(1000000))
        record { isPalindrome3(node2) }
    }

    private fun isPalindrome(node: ListNode): Boolean {
        val stack = Stack<Int>()

        var head: ListNode? = node
        while (head != null) {
            stack.add(head.`val`)
            head = head.next
        }

        head = node
        while (head != null) {
            if (head.`val` != stack.pop()) {
                return false
            }

            head = head.next
        }

        return true
    }

    private fun isPalindrome2(node: ListNode): Boolean {
        val deque = LinkedList<Int>()
        var head: ListNode? = node
        while (head != null) {
            deque.add(head.`val`)
            head = head.next
        }

        while (deque.isNotEmpty() && deque.size > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false
            }
        }

        return true
    }

    private fun isPalindrome3(node: ListNode): Boolean {
        var fast: ListNode? = node
        var slow: ListNode? = node

        while (fast?.next != null) {
            fast = fast.next.next
            slow = slow?.next
        }

        if (fast != null) {
            slow = slow?.next
        }

        var rev: ListNode? = null
        while (slow != null) {
            val tmp = slow.next
            slow.next = rev
            rev = slow
            slow = tmp
        }

        var head: ListNode? = node
        while (rev != null) {
            if (rev.`val` != head?.`val`) {
                return false
            }

            rev = rev.next
            head = head.next
        }

        return true
    }
}
