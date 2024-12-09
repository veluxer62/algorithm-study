package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HammingDistanceTest {
    private final Solution sut = new Solution();

    /*
     * 두 정수를 입력받아 몇 비트가 다른지 계산하라.
     */

    @Test
    public void test_hammingDistance() {
        var x = 1;
        var y = 6;
        var actual = sut.hammingDistance(x, y);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int hammingDistance(int x, int y) {
            var xor = x ^ y;
            return Integer.bitCount(xor);
        }
    }
}
