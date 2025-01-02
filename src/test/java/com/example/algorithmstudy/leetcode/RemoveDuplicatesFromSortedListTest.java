package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromSortedListTest {
    private final Solution sut = new Solution();

    /*

    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



    Example 1:


    Input: head = [1,1,2]
    Output: [1,2]
    Example 2:


    Input: head = [1,1,2,3,3]
    Output: [1,2,3]


    Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.

     */

    @Test
    public void test_deleteDuplicates() {
        var head = new ListNode(List.of(1, 1, 2));
        var actual = sut.deleteDuplicates(head);
        assertEquals(
                new ListNode(List.of(1, 2)),
                actual
        );

        head = new ListNode(List.of(1, 1, 2, 3, 3));
        actual = sut.deleteDuplicates(head);
        assertEquals(
                new ListNode(List.of(1, 2, 3)),
                actual
        );
    }

    private static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode current = head;

            while (current.next != null) {
                if (current.val == current.next.val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }

            return head;
        }
    }
}
