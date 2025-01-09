package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseLinkedListTest {
    private final Solution sut = new Solution();

    /*

    Given the head of a singly linked list, reverse the list, and return the reversed list.



    Example 1:


    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
    Example 2:


    Input: head = [1,2]
    Output: [2,1]
    Example 3:

    Input: head = []
    Output: []


    Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000


    Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

     */

    @Test
    public void test_reverseList() {
        var head = new ListNode(List.of(1, 2, 3, 4, 5));
        var actual = sut.reverseList(head);
        assertEquals(
                new ListNode(List.of(5, 4, 3, 2, 1)),
                actual
        );

        head = new ListNode(List.of(1, 2));
        actual = sut.reverseList(head);
        assertEquals(
                new ListNode(List.of(2, 1)),
                actual
        );

        head = null;
        actual = sut.reverseList(head);
        assertNull(actual);
    }

    @Test
    public void test_reverseList2() {
        var head = new ListNode(List.of(1, 2, 3, 4, 5));
        var actual = sut.reverseList2(head);
        assertEquals(
                new ListNode(List.of(5, 4, 3, 2, 1)),
                actual
        );

        head = new ListNode(List.of(1, 2));
        actual = sut.reverseList2(head);
        assertEquals(
                new ListNode(List.of(2, 1)),
                actual
        );

        head = null;
        actual = sut.reverseList2(head);
        assertNull(actual);
    }

    @Test
    public void test_reverseList3() {
        var head = new ListNode(List.of(1, 2, 3, 4, 5));
        var actual = sut.reverseList3(head);
        assertEquals(
                new ListNode(List.of(5, 4, 3, 2, 1)),
                actual
        );

        head = new ListNode(List.of(1, 2));
        actual = sut.reverseList3(head);
        assertEquals(
                new ListNode(List.of(2, 1)),
                actual
        );

        head = null;
        actual = sut.reverseList3(head);
        assertNull(actual);
    }

    private static class Solution {
        public ListNode reverseList(ListNode head) {
            var stack = new ArrayDeque<Integer>();

            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }

            var result = new ListNode(0);
            var curr = result;

            while (!stack.isEmpty()) {
                var val = stack.pop();
                curr.next = new ListNode(val);
                curr = curr.next;
            }

            return result.next;
        }

        public ListNode reverseList2(ListNode head) {
            ListNode prev = null;
            ListNode current = head;

            while (current != null) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            return prev;
        }

        public ListNode reverseList3(ListNode head) {
            if (head == null || head.next == null) {
                return head; // Base case: empty list or single node
            }

            ListNode newHead = reverseList3(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }
}
