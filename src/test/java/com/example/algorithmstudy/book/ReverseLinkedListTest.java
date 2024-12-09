package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.example.algorithmstudy.FunctionsKt.generateList;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedListTest {
    private final Solution sut = new Solution();

    /*
     * 연결 리스트를 뒤집어라
     */

    @Test
    public void test_reverseList() {
        var list = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = record(() -> sut.reverseList(list));
        assertEquals(
                new ListNode(List.of(6, 5, 4, 3, 2, 1)),
                actual
        );

        var list2 = new ListNode(generateList(30000));
        record(() -> sut.reverseList(list2));
    }

    @Test
    public void test_reverseList2() {
        var list = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = record(() -> sut.reverseList2(list));
        assertEquals(
                new ListNode(List.of(6, 5, 4, 3, 2, 1)),
                actual
        );

        var list2 = new ListNode(generateList(30000));
        record(() -> sut.reverseList2(list2));
    }

    @Test
    public void test_reverseList3() {
        var list = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = record(() -> sut.reverseList3(list));
        assertEquals(
                new ListNode(List.of(6, 5, 4, 3, 2, 1)),
                actual
        );

        var list2 = new ListNode(generateList(30000));
        record(() -> sut.reverseList3(list2));
    }

    private static class Solution {
        public ListNode reverseList(ListNode node) {
            var list = new LinkedList<Integer>();

            var tmp = node;
            while (tmp != null) {
                list.add(tmp.val);
                tmp = tmp.next;
            }

            list.sort(Collections.reverseOrder());


            return new ListNode(list);
        }

        public ListNode reverseList2(ListNode node) {
            return reverse(node, null);
        }

        public ListNode reverseList3(ListNode head) {
            ListNode prev = null, node = head;

            while (node != null) {
                var next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            return prev;
        }

        private ListNode reverse(ListNode node, ListNode prev) {
            if (node == null) return prev;
            var next = node.next;
            node.next = prev;
            return reverse(next, node);
        }

        /*
         * 1-2-3-4-5-6, null
         * n=2-3-4-5-6
         * 1-null
         *
         * 2-3-4-5-6, 1-null
         * n=3-4-5-6
         * 2-1-null
         *
         * 3-4-5-6, 2-1-null
         * n=4-5-6
         * 3-2-1-null
         *
         * 4-5-6, 3-2-1-null
         * n=5-6
         * 4-3-2-1-null
         *
         * 5-6, 4-3-2-1-null
         * n=6
         * 5-4-3-2-1-null
         *
         * 6, 5-4-3-2-1-null
         * n=null
         * 6-5-4-3-2-1-null
         *
         * null, 6-5-4-3-2-1-null
         */
    }
}
