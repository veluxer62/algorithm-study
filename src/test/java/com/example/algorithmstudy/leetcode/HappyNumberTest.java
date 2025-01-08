package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumberTest {
    private final Solution sut = new Solution();

    /*

    Write an algorithm to determine if a number n is happy.

    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.



    Example 1:

    Input: n = 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
    Example 2:

    Input: n = 2
    Output: false


    Constraints:

    1 <= n <= 231 - 1

     */

    @Test
    public void test_isHappy() {
        var n = 19;
        var actual = sut.isHappy(n);
        assertTrue(actual);

        n = 2;
        actual = sut.isHappy(n);
        assertFalse(actual);
    }

    @Test
    public void test_isHappy2() {
        var n = 19;
        var actual = sut.isHappy2(n);
        assertTrue(actual);

        n = 2;
        actual = sut.isHappy2(n);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isHappy(int n) {
            var slow = n;
            var fast = n;

            do {
                slow = sumOfSquares(slow);
                fast = sumOfSquares(sumOfSquares(fast));
            } while(slow != fast);

            return slow == 1;
        }

        private int sumOfSquares(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return sum;
        }

        public boolean isHappy2(int n) {
            var set = new HashSet<Integer>();

            while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = sumOfSquares(n);
            }

            return n == 1;
        }
    }
}
