package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.algorithmstudy.FunctionsKt.generateList;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeLinkedListTest {
    private final Solution sut = new Solution();

    /*
     * 연결 리스트가 팰린드롬 구조인지 판별하라.
     */

    @Test
    public void test_isPalindrome() {
        var node = new ListNode(List.of(1, 2, 3, 2, 1));
        var actual = record(() -> sut.isPalindrome(node));
        assertTrue(actual);

        var node2 = new ListNode(generateList(1000000));
        record(() -> sut.isPalindrome(node2));
    }

    @Test
    public void test_isPalindrome2() {
        var node = new ListNode(List.of(1, 2, 3, 2, 1));
        var actual = record(() -> sut.isPalindrome2(node));
        assertTrue(actual);

        var node2 = new ListNode(generateList(1000000));
        record(() -> sut.isPalindrome2(node2));
    }

    @Test
    public void test_isPalindrome3() {
        var node = new ListNode(List.of(1, 2, 3, 2, 1));
        var actual = record(() -> sut.isPalindrome3(node));
        assertTrue(actual);

        var node2 = new ListNode(generateList(1000000));
        record(() -> sut.isPalindrome3(node2));
    }

    private static class Solution {
        public boolean isPalindrome(ListNode head) {
            var stack = new Stack<Integer>();

            var node = head;
            while (node != null) {
                stack.add(node.val);
                node = node.next;
            }

            node = head;
            while (node != null) {
                if (node.val != stack.pop()) {
                    return false;
                }
                node = node.next;
            }

            return true;
        }

        public boolean isPalindrome2(ListNode head) {
            Deque<Integer> deque = new LinkedList<>();
            var node = head;
            while (node != null) {
                deque.add(node.val);
                node = node.next;
            }

            while (!deque.isEmpty() && deque.size() > 1) {
                if (!deque.pollFirst().equals(deque.pollLast())) {
                    return false;
                }
            }

            return true;
        }

        public boolean isPalindrome3(ListNode head) {
            var fast = head;
            var slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            if (fast != null) {
                slow = slow.next;
            }

            ListNode rev = null;
            while (slow != null) {
                var next = slow.next;
                slow.next = rev;
                rev = slow;
                slow = next;
            }

            while (rev != null) {
                if (rev.val != head.val) return false;
                rev = rev.next;
                head = head.next;
            }

            return true;
        }
    }
}
