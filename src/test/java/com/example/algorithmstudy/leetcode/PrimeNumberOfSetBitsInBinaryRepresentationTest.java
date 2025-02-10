package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeNumberOfSetBitsInBinaryRepresentationTest {
    private final Solution sut = new Solution();

    /*

    Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.

    Recall that the number of set bits an integer has is the number of 1's present when written in binary.

    For example, 21 written in binary is 10101, which has 3 set bits.


    Example 1:

    Input: left = 6, right = 10
    Output: 4
    Explanation:
    6  -> 110 (2 set bits, 2 is prime)
    7  -> 111 (3 set bits, 3 is prime)
    8  -> 1000 (1 set bit, 1 is not prime)
    9  -> 1001 (2 set bits, 2 is prime)
    10 -> 1010 (2 set bits, 2 is prime)
    4 numbers have a prime number of set bits.
    Example 2:

    Input: left = 10, right = 15
    Output: 5
    Explanation:
    10 -> 1010 (2 set bits, 2 is prime)
    11 -> 1011 (3 set bits, 3 is prime)
    12 -> 1100 (2 set bits, 2 is prime)
    13 -> 1101 (3 set bits, 3 is prime)
    14 -> 1110 (3 set bits, 3 is prime)
    15 -> 1111 (4 set bits, 4 is not prime)
    5 numbers have a prime number of set bits.


    Constraints:

    1 <= left <= right <= 106
    0 <= right - left <= 104

     */

    @Test
    public void test_countPrimeSetBits() {
        var left = 6;
        var right = 10;
        var actual = sut.countPrimeSetBits(left, right);
        assertEquals(4, actual);

        left = 10;
        right = 15;
        actual = sut.countPrimeSetBits(left, right);
        assertEquals(5, actual);
    }

    @Test
    public void test_countPrimeSetBits2() {
        var left = 6;
        var right = 10;
        var actual = sut.countPrimeSetBits2(left, right);
        assertEquals(4, actual);

        left = 10;
        right = 15;
        actual = sut.countPrimeSetBits2(left, right);
        assertEquals(5, actual);
    }

    private static class Solution {
        private final Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103);

        public int countPrimeSetBits(int left, int right) {
            var count = 0;

            for (int i = left; i <= right; i++) {
                var binary = Integer.toBinaryString(i);
                binary = binary.replace("0", "");
                if (primes.contains(binary.length())) {
                    count++;
                }
            }

            return count;
        }

        public int countPrimeSetBits2(int left, int right) {
            var count = 0;

            for (int i = left; i <= right; i++) {
                if (primes.contains(countBit(i))) {
                    count++;
                }
            }

            return count;
        }

        private int countBit(int num) {
            var count = 0;

            while (num > 0) {
                int remainder = num % 2;
                if (remainder == 1) count++;
                num /= 2;
            }

            return count;
        }

        public int countPrimeSetBits3(int l, int r) {
            Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
            int cnt = 0;
            for (int i = l; i <= r; i++) {
                int bits = 0;
                for (int n = i; n > 0; n >>= 1)
                    bits += n & 1;
                cnt += primes.contains(bits) ? 1 : 0;
            }
            return cnt;
        }
    }
}
