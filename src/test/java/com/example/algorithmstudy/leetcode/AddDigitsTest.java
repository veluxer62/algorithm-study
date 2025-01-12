package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigitsTest {
    private final Solution sut = new Solution();

    /*

    Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.



    Example 1:

    Input: num = 38
    Output: 2
    Explanation: The process is
    38 --> 3 + 8 --> 11
    11 --> 1 + 1 --> 2
    Since 2 has only one digit, return it.
    Example 2:

    Input: num = 0
    Output: 0


    Constraints:

    0 <= num <= 231 - 1


    Follow up: Could you do it without any loop/recursion in O(1) runtime?

     */

    @Test
    public void test_addDigits() {
        var num = 38;
        var actual = sut.addDigits(num);
        assertEquals(2, actual);

        num = 0;
        actual = sut.addDigits(num);
        assertEquals(0, actual);

        num = 10;
        actual = sut.addDigits(num);
        assertEquals(1, actual);
    }

    @Test
    public void test_addDigits2() {
        var num = 38;
        var actual = sut.addDigits2(num);
        assertEquals(2, actual);

        num = 0;
        actual = sut.addDigits2(num);
        assertEquals(0, actual);

        num = 10;
        actual = sut.addDigits2(num);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int addDigits(int num) {
            var tmp = num;

            while (tmp >= 10) {
                var a = tmp % 10;
                var b = tmp / 10;
                tmp = a + b;
            }

            return tmp;
        }

        // 디지털 루트(Digital Root)
        // DigitalRoot = 1 + (num − 1) % 9
        public int addDigits2(int num) {
            if (num == 0) {
                return 0;
            }

            return 1 + (num - 1) % 9;
        }
    }
}
