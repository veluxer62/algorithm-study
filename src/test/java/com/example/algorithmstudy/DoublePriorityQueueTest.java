package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DoublePriorityQueueTest {
    private final Solution sut = new Solution();

    /*
     * 다음과 같은 연산을 수행하는 이중 우선순위 큐를 구현하라.
     *
     * 명령어  | 수신 탑(높이)
     * I 숫자 | 큐에 숫자 삽입
     * D 1  | 큐에서 최댓값 삭제
     * D -1 | 큐에서 최솟값 삭제
     */

    @Test
    public void test_doublePriorityQueue() {
        var operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "I 333", "I 8", "I 7", "D -1"};
        var actual = sut.doublePriorityQueue(operations);
        assertArrayEquals(
                new int[]{333, -45},
                actual
        );
    }

    private static class Solution {
        public int[] doublePriorityQueue(String[] operations) {
            var minHeap = new PriorityQueue<Integer>();
            var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

            for (String operation : operations) {
                var op = operation.split(" ");

                if ("I".equals(op[0])) {
                    minHeap.add(Integer.parseInt(op[1]));
                    maxHeap.add(Integer.parseInt(op[1]));
                } else if ("D".equals(op[0])) {
                    if ("1".equals(op[1])) {
                        minHeap.remove(maxHeap.poll());
                    } else if ("-1".equals(op[1])) {
                        maxHeap.remove(minHeap.poll());
                    }
                }
            }

            var maxValue = maxHeap.poll();
            var minValue = minHeap.poll();

            return new int[]{
                    maxValue == null ? 0 : maxValue,
                    minValue == null ? 0 : minValue
            };
        }
    }
}
