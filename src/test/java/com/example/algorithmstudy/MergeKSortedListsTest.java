package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeKSortedListsTest {
    private final Solution sut = new Solution();

    /*
     * k개의 정렬된 리스트를 1개의 정렬된 리스트로 병합하라.
     */

    @Test
    public void test_mergeKLists() {
        var lists = new ListNode[]{
                new ListNode(List.of(1, 4, 5)),
                new ListNode(List.of(1, 3, 4)),
                new ListNode(List.of(2, 7)),
        };
        var actual = sut.mergeKLists(lists);
        assertEquals(
                new ListNode(List.of(1, 1, 2, 3, 4, 4, 5, 7)),
                actual
        );
    }

    private static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            var pq = new PriorityQueue<ListNode>(Comparator.comparingInt(o -> o.val));

            var root = new ListNode(0);
            var tail = root;

            for (ListNode node : lists) {
                if (node != null) {
                    pq.add(node);
                }
            }

            while (!pq.isEmpty()) {
                tail.next = pq.poll();
                tail = tail.next;

                if (tail.next != null) {
                    pq.add(tail.next);
                }
            }

            return root.next;
        }

        /*
         * pq=[]
         * r=[0]
         * t=[0]
         *
         * pq=[[1,4,5],[1,3,4],[2,7]]
         *
         * t=[0,1,4,5]
         * r=[0,1,4,5]
         * t=[1,4,5]
         * pq=[[1,3,4],[2,7],[4,5]]
         *
         * t=[1,1,3,4]
         * r=[0,1,1,3,4]
         * t=[1,3,4]
         * pq=[[2,7],[3,4],[4,5]]
         *
         * t=[1,2,7]
         * r=[0,1,1,2,7]
         * t=[2,7]
         * pq=[[3,4],[4,5],[7]]
         *
         * t=[2,3,4]
         * r=[0,1,1,2,3,4]
         * t=[3,4]
         * pq=[[4,5],[4],[7]]
         *
         * t=[3,4,5]
         * r=[0,1,1,2,3,4,5]
         * t=[4,5]
         * pq=[[4],[5],[7]]
         *
         * t=[4,4]
         * r=[0,1,1,2,3,4,4]
         * t=[4]
         * pq=[[5],[7]]
         *
         * t=[4,5]
         * r=[0,1,1,2,3,4,4,5]
         * t=[5]
         * pq=[[7]]
         *
         * t=[5,7]
         * r=[0,1,1,2,3,4,4,5,7]
         * t=[7]
         * pq=[]
         */
    }
}
