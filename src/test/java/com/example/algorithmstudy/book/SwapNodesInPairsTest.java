package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapNodesInPairsTest {
    private final Solution sut = new Solution();

    /*
     * 연결 리스트를 입력 받아 페어 단위로 스왑하라.
     */

    @Test
    public void test_swapPairs() {
        var node = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = record(() -> sut.swapPairs(node));
        assertEquals(
                new ListNode(List.of(2, 1, 4, 3, 6, 5)),
                actual
        );
    }

    @Test
    public void test_swapPairs2() {
        var node = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = record(() -> sut.swapPairs2(node));
        assertEquals(
                new ListNode(List.of(2, 1, 4, 3, 6, 5)),
                actual
        );
    }

    @Test
    public void test_swapPairs3() {
        var node = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = record(() -> sut.swapPairs3(node));
        assertEquals(
                new ListNode(List.of(2, 1, 4, 3, 6, 5)),
                actual
        );
    }

    private static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode node = head;

            while (node != null && node.next != null) {
                int tmp;
                tmp = node.val;
                node.val = node.next.val;
                node.next.val = tmp;

                node = node.next.next;
            }

            return head;
        }

        public ListNode swapPairs2(ListNode head) {
            var node = new ListNode(0);
            var root = node;
            node.next = head;

            while (node.next != null && node.next.next != null) {
                var a = node.next;
                var b = node.next.next;
                a.next = b.next;
                node.next = b;
                node.next.next = a;
                node = node.next.next;
            }

            return root.next;
        }

        /*
         * n = 0
         * r = 0
         * n = 0-1-2-3-4-5-6
         * r = 0-1-2-3-4-5-6
         *
         * a = 1-2-3-4-5-6
         * b = 2-3-4-5-6
         * a = 1-3-4-5-6
         * n = 0-2-3-4-5-6
         * n = 0-2-1-3-4-5-6
         * n = 1-3-4-5-6
         * r = 0-2-1-3-4-5-6
         *
         * a = 3-4-5-6
         * b = 4-5-6
         * a = 3-5-6
         * n = 1-4-5-6
         * n = 1-4-3-5-6
         * n = 3-5-6
         * r = 0-2-1-4-3-5-6
         *
         * a = 5-6
         * b = 6
         * a = 5-null
         * n = 3-6
         * n = 3-6-5
         * n = 5
         * r = 0-2-1-4-3-6-5
         */

        public ListNode swapPairs3(ListNode head) {
            if (head != null && head.next != null) {
                var p = head.next;
                head.next = swapPairs3(head.next.next);
                p.next = head;
                return p;
            }

            return head;
        }

        /*
         * h=1-2-3-4-5-6
         * p=2-3-4-5-6
         * h=1-
         *      h=3-4-5-6
         *      p=4-5-6
         *      h=3-
         *          h=5-6
         *          p=6
         *          h=5-
         *              h=null
         *          h=5-null
         *          p=6-5-null
         *      h=3-6-5-null
         *      p=4-3-6-5-null
         * h=1-4-3-6-5-null
         * p=2-1-4-3-6-5-null
         */
    }
}
