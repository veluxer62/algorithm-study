package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOf1BitsTest {
    private final Solution sut = new Solution();

    /*

    Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).



    Example 1:

    Input: n = 11

    Output: 3

    Explanation:

    The input binary string 1011 has a total of three set bits.

    Example 2:

    Input: n = 128

    Output: 1

    Explanation:

    The input binary string 10000000 has a total of one set bit.

    Example 3:

    Input: n = 2147483645

    Output: 30

    Explanation:

    The input binary string 1111111111111111111111111111101 has a total of thirty set bits.



    Constraints:

    1 <= n <= 231 - 1


    Follow up: If this function is called many times, how would you optimize it?

     */

    @Test
    public void test_hammingWeight() {
        var n = 11;
        var actual = sut.hammingWeight(n);
        assertEquals(3, actual);

        n = 128;
        actual = sut.hammingWeight(n);
        assertEquals(1, actual);

        n = 2147483645;
        actual = sut.hammingWeight(n);
        assertEquals(30, actual);
    }

    @Test
    public void test_hammingWeight2() {
        var n = 11;
        var actual = sut.hammingWeight2(n);
        assertEquals(3, actual);

        n = 128;
        actual = sut.hammingWeight2(n);
        assertEquals(1, actual);

        n = 2147483645;
        actual = sut.hammingWeight2(n);
        assertEquals(30, actual);
    }

    private static class Solution {
        public int hammingWeight(int n) {
            var count = 0;
            while (n != 0) {
                count += n & 1;
                n >>>= 1;
            }
            return count;
        }

        private static final int[] LOOKUP_TABLE = new int[256];

        static {
            for (int i = 0; i < 256; i++) {
                LOOKUP_TABLE[i] = Integer.bitCount(i);
            }
        }

        // 최적화
        public int hammingWeight2(int n) {
            return LOOKUP_TABLE[n & 0xFF] +
                    LOOKUP_TABLE[(n >>> 8) & 0xFF] +
                    LOOKUP_TABLE[(n >>> 16) & 0xFF] +
                    LOOKUP_TABLE[(n >>> 24) & 0xFF];
        }
    }
}
