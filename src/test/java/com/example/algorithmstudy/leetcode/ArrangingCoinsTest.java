package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrangingCoinsTest {
    private final Solution sut = new Solution();

    /*

    You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

    Given the integer n, return the number of complete rows of the staircase you will build.



    Example 1:


    Input: n = 5
    Output: 2
    Explanation: Because the 3rd row is incomplete, we return 2.
    Example 2:


    Input: n = 8
    Output: 3
    Explanation: Because the 4th row is incomplete, we return 3.


    Constraints:

    1 <= n <= 231 - 1

     */

    @Test
    public void test_arrangeCoins() {
        var n = 5;
        var actual = sut.arrangeCoins(n);
        assertEquals(2, actual);

        n = 8;
        actual = sut.arrangeCoins(n);
        assertEquals(3, actual);
    }

    @Test
    public void test_arrangeCoins2() {
        var n = 5;
        var actual = sut.arrangeCoins2(n);
        assertEquals(2, actual);

        n = 8;
        actual = sut.arrangeCoins2(n);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int arrangeCoins(int n) {
            var i = 1;
            while (true) {
                n = n - i;
                if (n < 0) break;
                i++;
            }

            return i - 1;
        }

        public int arrangeCoins2(int n) {
            long start = 1;
            long end = n;
            long ans = 0;
            long mid;

            while (start <= end) {
                mid = start + (end - start) / 2;

                long coinCount = (mid * (mid + 1)) / 2;

                if (coinCount <= n) {
                    ans = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return (int) ans;
        }
    }
}
