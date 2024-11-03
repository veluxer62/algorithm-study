package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementInAnArrayTest {
    private final Solution sut = new Solution();

    /*
     * 정렬되지 않은 배열에서 k번째 큰 엘리먼트를 추출하라.
     */

    @Test
    public void test_findKthLargest() {
        var nums = new int[]{1,3,2,3,1,2,4,5,5,6};
        var k = 4;
        var actual = sut.findKthLargest(nums, k);
        assertEquals(4, actual);
    }

    @Test
    public void test_findKthLargest2() {
        var nums = new int[]{1,3,2,3,1,2,4,5,5,6};
        var k = 4;
        var actual = sut.findKthLargest2(nums, k);
        assertEquals(4, actual);
    }

    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            var heap = new BinaryHeap();

            for (int num : nums) {
                heap.insert(num);
            }

            for (int i = 0; i < k - 1; i++) {
                heap.extract();
            }

            return heap.extract();
        }

        public int findKthLargest2(int[] nums, int k) {
            var heap = new PriorityQueue<Integer>(Collections.reverseOrder());

            for (int num : nums) {
                heap.add(num);
            }

            for (int i = 0; i < k - 1; i++) {
                heap.poll();
            }

            return heap.poll();
        }
    }

    private static class BinaryHeap {
        private List<Integer> elems;

        public BinaryHeap() {
            elems = new ArrayList<>();
            elems.add(null);
        }

        private void swap(int i, int j) {
            var temp = elems.get(i);
            elems.set(i, elems.get(j));
            elems.set(j, temp);
        }

        private void percolateUp() {
            var idx = elems.size() - 1;
            var parentIdx = idx / 2;

            while (parentIdx > 0) {
                if (elems.get(idx) > elems.get(parentIdx)) {
                    swap(idx, parentIdx);
                }

                idx = parentIdx;
                parentIdx = idx / 2;
            }
        }

        public void insert(int k) {
            elems.add(k);
            percolateUp();
        }

        private void maxHeapify(int i) {
            var left = i * 2;
            var right = i * 2 + 1;
            var largest = i;

            if (left <= elems.size() - 1 && elems.get(left) > elems.get(largest)) {
                largest = left;
            }

            if (right <= elems.size() - 1 && elems.get(right) > elems.get(largest)) {
                largest = right;
            }

            if (largest != i) {
                swap(largest, i);
                maxHeapify(largest);
            }
        }

        public int extract() {
            var extracted = elems.get(1);

            elems.set(1, elems.get(elems.size() - 1));
            elems.remove(elems.size() - 1);

            maxHeapify(1);

            return extracted;
        }
    }
}
