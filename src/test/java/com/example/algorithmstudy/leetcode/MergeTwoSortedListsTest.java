package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeTwoSortedListsTest {
    private final Solution sut = new Solution();

    /*

    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

    Return the head of the merged linked list.



    Example 1:


    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    Example 2:

    Input: list1 = [], list2 = []
    Output: []
    Example 3:

    Input: list1 = [], list2 = [0]
    Output: [0]


    Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.

     */

    @Test
    public void test_mergeTwoLists() {
        var list1 = new ListNode(List.of(1, 2, 4));
        var list2 = new ListNode(List.of(1, 3, 4));
        var actual = sut.mergeTwoLists(list1, list2);
        assertEquals(
                new ListNode(List.of(1, 1, 2, 3, 4, 4)),
                actual
        );

        list1 = null;
        list2 = null;
        actual = sut.mergeTwoLists(list1, list2);
        assertNull(actual);

        list2 = new ListNode(0);
        actual = sut.mergeTwoLists(list1, list2);
        assertEquals(
                new ListNode(0),
                actual
        );
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            var pq = new PriorityQueue<Integer>();
            var result = new ListNode(0);
            var temp = result;

            while (list1 != null) {
                pq.add(list1.val);
                list1 = list1.next;
            }

            while (list2 != null) {
                pq.add(list2.val);
                list2 = list2.next;
            }

            while (!pq.isEmpty()) {
                var cur = pq.poll();
                temp.next = new ListNode(cur);
                temp = temp.next;
            }

            return result.next;
        }
    }
}
