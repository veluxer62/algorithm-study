package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.example.algorithmstudy.FunctionsKt.generateList;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTowSortedListsTest {
    private final Solution sut = new Solution();

    /*
     * 정렬되어 있는 두 연결 리스트를 합쳐라
     */

    @Test
    public void test_mergeTwoLists() {
        var l1 = new ListNode(List.of(1, 2, 5));
        var l2 = new ListNode(List.of(1, 3, 4));
        var actual = record(() -> sut.mergeTwoLists(l1, l2));
        assertEquals(new ListNode(List.of(1, 1, 2, 3, 4, 5)), actual);

        var l11 = new ListNode(generateList(10000));
        var l22 = new ListNode(generateList(10000));
        record(() -> sut.mergeTwoLists(l11, l22));
    }

    @Test
    public void test_mergeTwoLists2() {
        var l1 = new ListNode(List.of(1, 2, 5));
        var l2 = new ListNode(List.of(1, 3, 4));
        var actual = record(() -> sut.mergeTwoLists2(l1, l2));
        assertEquals(new ListNode(List.of(1, 1, 2, 3, 4, 5)), actual);

        var l11 = new ListNode(generateList(10000));
        var l22 = new ListNode(generateList(10000));
        record(() -> sut.mergeTwoLists2(l11, l22));
    }

    private static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            var list1 = new LinkedList<Integer>();
            var list2 = new LinkedList<Integer>();

            var tmp = l1;
            while (tmp != null) {
                list1.add(tmp.val);
                tmp = tmp.next;
            }

            tmp = l2;
            while (tmp != null) {
                list2.add(tmp.val);
                tmp = tmp.next;
            }

            list1.addAll(list2);
            list1.sort(Integer::compareTo);

            return new ListNode(list1);
        }

        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists2(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists2(l1, l2.next);
                return l2;
            }
        }
    }
}
