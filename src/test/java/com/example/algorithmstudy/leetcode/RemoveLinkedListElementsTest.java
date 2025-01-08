package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RemoveLinkedListElementsTest {
    private final Solution sut = new Solution();

    /*

    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.



    Example 1:


    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
    Example 2:

    Input: head = [], val = 1
    Output: []
    Example 3:

    Input: head = [7,7,7,7], val = 7
    Output: []


    Constraints:

    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50

     */

    @Test
    public void test_removeElements() {
        var head = new ListNode(List.of(1,2,6,3,4,5,6));
        var val = 6;
        var actual = sut.removeElements(head, val);
        assertEquals(
                new ListNode(List.of(1,2,3,4,5)),
                actual
        );

        head = null;
        val = 1;
        actual = sut.removeElements(head, val);
        assertNull(actual);

        head = new ListNode(List.of(7,7,7,7));
        val = 7;
        actual = sut.removeElements(head, val);
        assertNull(actual);
    }

    private static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode current = dummy;

            while (current.next != null) {
                if (current.next.val == val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }

            return dummy.next;
        }
    }
}
