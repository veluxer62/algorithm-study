package com.example.algorithmstudy

import com.example.algorithmstudy.utils.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigInteger

class KotlinAddTowNumbersTest {
    /*
     * 역순으로 저장된 연결 리스트의 숫자를 더하라
     */

    @Test
    fun test_add() {
        val a = ListNode(listOf(2, 4, 3))
        val b = ListNode(listOf(5, 6, 2))
        val actual = record { add(a, b) }
        Assertions.assertEquals(
            ListNode(listOf(7, 0, 6)),
            actual,
        )
    }

    @Test
    fun test_add2() {
        val a = ListNode(listOf(2, 4, 3))
        val b = ListNode(listOf(5, 6, 2))
        val actual = record { add2(a, b) }
        Assertions.assertEquals(
            ListNode(listOf(7, 0, 6)),
            actual,
        )
    }

    private fun add(
        a: ListNode,
        b: ListNode,
    ): ListNode {
        val ra = a.reverse()
        val rb = b.reverse()
        val sum = ra.toNumber() + rb.toNumber()
        return sum.toReversedListNode()
    }

    private fun ListNode.reverse(): ListNode {
        var prev: ListNode? = null
        var node: ListNode? = this

        while (node != null) {
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }

        return prev!!
    }

    private fun ListNode.toNumber(): BigInteger {
        val sb = StringBuilder()
        var tmp: ListNode? = this
        while (tmp != null) {
            sb.append(tmp.`val`)
            tmp = tmp.next
        }

        return sb.toString().toBigInteger()
    }

    private fun BigInteger.toReversedListNode(): ListNode {
        var prev: ListNode? = null
        var node: ListNode? = null

        for (c in this.toString().toCharArray()) {
            node = ListNode(Character.getNumericValue(c))
            node.next = prev
            prev = node
        }

        return node!!
    }

    private fun add2(
        a: ListNode,
        b: ListNode,
    ): ListNode {
        var ma: ListNode? = a
        var mb: ListNode? = b

        var node = ListNode(0)
        val root = node
        var sum: Int
        var carry = 0
        var reminder: Int

        while (ma != null || mb != null || carry != 0) {
            sum = 0

            if (ma != null) {
                sum += ma.`val`
                ma = ma.next
            }

            if (mb != null) {
                sum += mb.`val`
                mb = mb.next
            }

            reminder = (sum + carry) % 10
            carry = (sum + carry) / 10
            node.next = ListNode(reminder)
            node = node.next
        }

        return root.next
    }
}
