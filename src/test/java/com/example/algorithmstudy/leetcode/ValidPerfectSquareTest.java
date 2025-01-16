package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPerfectSquareTest {
    private final Solution sut = new Solution();

    /*

    Given a positive integer num, return true if num is a perfect square or false otherwise.

    A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

    You must not use any built-in library function, such as sqrt.



    Example 1:

    Input: num = 16
    Output: true
    Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
    Example 2:

    Input: num = 14
    Output: false
    Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.


    Constraints:

    1 <= num <= 231 - 1

     */

    @Test
    public void test_isPerfectSquare() {
        var num = 16;
        var actual = sut.isPerfectSquare(num);
        assertTrue(actual);

        num = 14;
        actual = sut.isPerfectSquare(num);
        assertFalse(actual);

        num = 2147483647;
        actual = sut.isPerfectSquare(num);
        assertFalse(actual);
    }

    @Test
    public void test_isPerfectSquare2() {
        var num = 16;
        var actual = sut.isPerfectSquare2(num);
        assertTrue(actual);

        num = 14;
        actual = sut.isPerfectSquare2(num);
        assertFalse(actual);

        num = 2147483647;
        actual = sut.isPerfectSquare2(num);
        assertFalse(actual);
    }

    private static class Solution {
        // time limit
        public boolean isPerfectSquare(int num) {
            if (num < 1) return false;

            var left = 0;
            var right = num;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int square = mid * mid;

                if (square == num) {
                    return true;
                } else  if (square > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return false;
        }

        /*

        Newton's method

        뉴턴의 방법의 장점
        - 빠른 수렴 속도.
        - 이진 탐색보다 적은 반복으로 정확한 값을 계산.

        뉴턴의 방법의 단점
        - 초기 추정값이 잘못되면 수렴하지 않을 수 있음.
        - 𝑓′(x)이 0에 가까운 경우(기울기가 평평할 때) 계산이 어려울 수 있음.

         */

        public boolean isPerfectSquare2(int num) {
            if (num < 1) {
                return false;
            }

            long x = num / 2 + 1;

            while (x * x > num) {
                x = (x + num / x) / 2;
            }

            return x * x == num;
        }
    }
}
