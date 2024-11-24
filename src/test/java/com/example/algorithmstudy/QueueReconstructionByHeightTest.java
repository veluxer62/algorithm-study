package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QueueReconstructionByHeightTest {
    private final Solution sut = new Solution();

    /*
     * 여러 명의 사람들이 줄을 서 있다. 각각의 사람들은 (h, k)의 두 정수 쌍을 갖는데,
     * h는 그 사람의 키, k는 앞에 줄 서 있는 사람들 중 자신과 키가 같거나 더 큰 사람들의 수를 뜻한다.
     * 이 값이 올바르도록 줄을 재정렬하는 알고리즘을 작성하라.
     */

    @Test
    public void test_reconstructQueue() {
        var people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {6, 0}, {6, 2}, {5, 2}};
        var actual = sut.reconstructQueue(people);
        assertArrayEquals(
                new int[][]{{6, 0}, {7, 0}, {5, 2}, {6, 2}, {4, 4}, {7, 1}},
                actual
        );
    }

    private static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            var pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
            pq.addAll(Arrays.asList(people));

            var result = new ArrayList<int[]>();
            while (!pq.isEmpty()) {
                var person = pq.poll();
                result.add(person[1], person);
            }

            return result.toArray(new int[people.length][2]);
        }
    }
}
