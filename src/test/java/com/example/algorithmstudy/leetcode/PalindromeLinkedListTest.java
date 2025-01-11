package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeLinkedListTest {
    private final Solution sut = new Solution();

    /*

    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.



    Example 1:


    Input: head = [1,2,2,1]
    Output: true
    Example 2:


    Input: head = [1,2]
    Output: false


    Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9


    Follow up: Could you do it in O(n) time and O(1) space?

     */

    @Test
    public void test_isPalindrome() {
        var head = new ListNode(List.of(1, 2, 2, 1));
        var actual = sut.isPalindrome(head);
        assertTrue(actual);

        head = new ListNode(List.of(1, 2));
        actual = sut.isPalindrome(head);
        assertFalse(actual);
    }

    @Test
    public void test_isPalindrome2() {
        var head = new ListNode(List.of(1, 2, 2, 1));
        var actual = sut.isPalindrome2(head);
        assertTrue(actual);

        head = new ListNode(List.of(1, 2));
        actual = sut.isPalindrome2(head);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isPalindrome(ListNode head) {
            var stack = new ArrayDeque<Integer>();
            var curr = head;

            while (curr != null) {
                stack.push(curr.val);
                curr = curr.next;
            }

            curr = head;
            while(!stack.isEmpty()) {
                if (curr.val != stack.pop()) return false;
                curr = curr.next;
            }

            return true;
        }

        public boolean isPalindrome2(ListNode head) {
            if (head == null || head.next == null) return true;

            // 절반 위치 찾기
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 뒷부분 반전
            ListNode secondHalf = reverseList(slow);
            ListNode firstHalf = head;

            // 앞부분과 뒷부분 같은지 비교
            while (secondHalf != null) {
                if (firstHalf.val != secondHalf.val) {
                    return false;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
        }
    }
}
