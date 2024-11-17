package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOf1BitsTest {
    private final Solution sut = new Solution();

    /*
     * 부호 없는 정수형을 입력받아 1비트의 개수를 출력하라.
     */

    @Test
    public void test_hammingWeight() {
        int n = 0b11111111111111111111111111111001;
        var actual = sut.hammingWeight(n);
        assertEquals(30, actual);
    }

    @Test
    public void test_hammingWeight2() {
        int n = 0b11111111111111111111111111111001;
        var actual = sut.hammingWeight2(n);
        assertEquals(30, actual);
    }

    private static class Solution {
        public int hammingWeight(int n) {
            return Integer.bitCount(n);
        }

        public int hammingWeight2(int n) {
            var count = 0;

            while (n != 0) {
                n &= n - 1;
                count++;
            }

            return count;
        }
    }
}
