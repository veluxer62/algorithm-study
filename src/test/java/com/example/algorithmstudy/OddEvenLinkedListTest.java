package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddEvenLinkedListTest {
    private final Solution sut = new Solution();

    /*
     * 연결 리스트를 홀수 번째 노드 다음에 짝수 번째 노드가 오도록 재구성하라. 공간 봅작도 O(1), 시간 복잡도 O(n)에 풀이하라.
     */

    @Test
    public void test_oddEvenList() {
        var given = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = sut.oddEvenList(given);
        assertEquals(
                new ListNode(List.of(1, 3, 5, 2, 4, 6)),
                actual
        );
    }

    private static class Solution {
        public ListNode oddEvenList(ListNode head) {
            var odd = head;
            var even = head.next;

            var evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;

                odd = odd.next;
                even = even.next;
            }

            odd.next = evenHead;

            return head;
        }

        /*
         * h = 1-2-3-4-5-6
         * o = 1-2-3-4-5-6
         * e = 2-3-4-5-6
         * eh = 2-3-4-5-6
         *
         * o = 1-3-4-5-6
         * e = 2-4-5-6
         * h = 1-3-4-5-6
         * eh = 2-4-5-6
         * o = 3-4-5-6
         * e = 4-5-6
         *
         * o = 3-5-6
         * e = 4-6
         * h = 1-3-5-6
         * eh = 2-4-6
         * o = 5-6
         * e = 6
         *
         * o = 5-2-4-6
         * h = 1-3-5-2-4-6
         */
    }
}
