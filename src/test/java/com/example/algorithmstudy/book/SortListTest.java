package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.algorithmstudy.FunctionsKt.generateList;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortListTest {
    private final Solution sut = new Solution();

    /*
     * 연결 리스트를 O(n log n)에 정렬하라.
     */

    @Test
    public void test_sortList() {
        var head = new ListNode(List.of(-1, 5, 3, 4, 0));
        var actual = record(() -> sut.sortList(head));
        assertEquals(
                new ListNode(List.of(-1, 0, 3, 4, 5)),
                actual
        );

        var head2 = new ListNode(generateList(10000));
        record(() -> sut.sortList(head2));
    }

    @Test
    public void test_sortList2() {
        var head = new ListNode(List.of(-1, 5, 3, 4, 0));
        var actual = record(() -> sut.sortList2(head));
        assertEquals(
                new ListNode(List.of(-1, 0, 3, 4, 5)),
                actual
        );

        var head2 = new ListNode(generateList(10000));
        record(() -> sut.sortList2(head2));
    }

    private static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode half = null, slow = head, fast = head;
            while (fast != null && fast.next != null) {
                half = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            half.next = null;

            var l1 = sortList(head);
            var l2 = sortList(slow);

            return mergeTwoLists(l1, l2);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if (l1.val > l2.val) {
                var temp = l1;
                l1 = l2;
                l2 = temp;
            }

            l1.next = mergeTwoLists(l1.next, l2);

            return l1;
        }

        public ListNode sortList2(ListNode head) {
            quicksort(head, null);
            return head;
        }

        private void quicksort(ListNode head, ListNode tail) {
            if (head == tail) return;

            var pivot = head;
            var left = head;
            var right = head.next;

            while (right != tail) {
                if (right.val < pivot.val) {
                    left = left.next;

                    var temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                }
                right = right.next;
            }

            var temp = head.val;
            head.val = left.val;
            left.val = temp;

            quicksort(head, left);
            quicksort(head.next, tail);
        }
    }
}
