package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfectNumberTest {
    private final Solution sut = new Solution();

    /*

    A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

    Given an integer n, return true if n is a perfect number, otherwise return false.



    Example 1:

    Input: num = 28
    Output: true
    Explanation: 28 = 1 + 2 + 4 + 7 + 14
    1, 2, 4, 7, and 14 are all divisors of 28.
    Example 2:

    Input: num = 7
    Output: false


    Constraints:

    1 <= num <= 108

     */

    @Test
    public void test_checkPerfectNumber() {
        var num = 28;
        var actual = sut.checkPerfectNumber(num);
        assertTrue(actual);

        num = 7;
        actual = sut.checkPerfectNumber(num);
        assertFalse(actual);

        num = 6;
        actual = sut.checkPerfectNumber(num);
        assertTrue(actual);
    }

    @Test
    public void test_checkPerfectNumber2() {
        var num = 28;
        var actual = sut.checkPerfectNumber2(num);
        assertTrue(actual);

        num = 7;
        actual = sut.checkPerfectNumber2(num);
        assertFalse(actual);

        num = 6;
        actual = sut.checkPerfectNumber2(num);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean checkPerfectNumber(int num) {
            var half = num / 2;
            var sum = 0;
            var i = 1;
            while (i <= half) {
                if (num % i == 0) {
                    sum += i;
                }
                i++;
            }

            return sum == num;
        }

        public boolean checkPerfectNumber2(int num) {
            if (num <= 1) return false;

            int sum = 1;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;

                    if (i != num / i) {
                        sum += num / i;
                    }
                }
            }
            return sum == num;
        }
    }
}
