package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedList2Test {
    private final Solution sut = new Solution();

    /*
     * 위치 left에서 right까지를 역순으로 만들어라. 위치는 1부터 시작한다.
     */

    @Test
    public void test_reverseList() {
        var head = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        var actual = sut.reverseList(head, 2, 5);
        assertEquals(
                new ListNode(List.of(1, 5, 4, 3, 2, 6)),
                actual
        );
    }

    private static class Solution {
        public ListNode reverseList(ListNode head, int left, int right) {
            var root = new ListNode(0);
            root.next = head;

            var start = root;
            for (int i = 0; i < left - 1; i++) {
                start = start.next;
            }

            var end = start.next;
            for (int i = 0; i < right - left; i++) {
                var tmp = start.next;
                start.next = end.next;
                end.next = end.next.next;
                start.next.next = tmp;
                System.out.println(root);
            }

            return root.next;
        }
    }
}
