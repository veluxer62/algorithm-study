package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatCountOfScovilleIndexTest {
    private final Solution sut = new Solution();

    /*
     * 다음과 같이 새로운 음식을 만들 때 모든 음식의 스코빌 지수가 k 이상이 되는 반복 횟수를 리턴하라.
     * 섞음 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */

    @Test
    public void test_repeatCountOfScovilleIndex() {
        var scoville = new int[]{1, 2, 3, 9, 10, 12};
        var k = 7;
        var actual = sut.repeatCountOfScovilleIndex(scoville, k);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int repeatCountOfScovilleIndex(int[] scoville, int k) {
            var pq = new PriorityQueue<Integer>();

            for (int s : scoville) {
                pq.add(s);
            }

            int result = 1;
            while (pq.size() >= 2) {
                pq.add(pq.poll() + (pq.poll() * 2));

                if (pq.peek() >= k) return result;
                result++;
            }

            return -1;
        }
    }
}
