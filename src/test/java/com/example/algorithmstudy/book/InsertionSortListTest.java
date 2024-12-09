package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.algorithmstudy.FunctionsKt.generateList;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortListTest {
    private final Solution sut = new Solution();

    /*
     * 연결 리스트를 삽입 정렬로 정렬하라.
     */

    @Test
    public void test_sort() {
        var head = new ListNode(List.of(5, 2, 1, 3));
        var actual = record(() ->sut.sort(head));
        assertEquals(
                new ListNode(List.of(1, 2, 3, 5)),
                actual
        );

        var head2 = new ListNode(generateList(30000));
        record(() ->sut.sort(head2));
    }

    @Test
    public void test_sort2() {
        var head = new ListNode(List.of(5, 2, 1, 3));
        var actual = record(() -> sut.sort2(head));
        assertEquals(
                new ListNode(List.of(1, 2, 3, 5)),
                actual
        );

        var head2 = new ListNode(generateList(30000));
        record(() ->sut.sort2(head2));
    }

    private static class Solution {
        public ListNode sort(ListNode head) {
            var parent = new ListNode(-1);
            var p = parent;

            while (head != null) {
                while (p.next != null && p.next.val < head.val) {
                    p = p.next;
                }

                var pNext = p.next;
                var headNext = head.next;
                p.next = head;
                head.next = pNext;
                head = headNext;
                p = parent;
            }

            return parent.next;
        }

        public ListNode sort2(ListNode head) {
            var parent = new ListNode(-1);
            var p = parent;

            while (head != null) {
                while (p.next != null && p.next.val < head.val) {
                    p = p.next;
                }

                var pNext = p.next;
                var headNext = head.next;
                p.next = head;
                head.next = pNext;
                head = headNext;

                if (head != null && p.val > head.val)
                    p = parent;
            }

            return parent.next;
        }
    }
}
