package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanPlaceFlowersTest {
    private final Solution sut = new Solution();

    /*

    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.



    Example 1:

    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true
    Example 2:

    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: false


    Constraints:

    1 <= flowerbed.length <= 2 * 104
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length

     */

    @Test
    public void test_canPlaceFlowers() {
        var flowerbed = new int[]{1,0,0,0,1};
        var n = 1;
        var actual = sut.canPlaceFlowers(flowerbed, n);
        assertTrue(actual);

        flowerbed = new int[]{1,0,0,0,1};
        n = 2;
        actual = sut.canPlaceFlowers(flowerbed, n);
        assertFalse(actual);

        flowerbed = new int[]{1,0,0,0,0,0,1};
        n = 2;
        actual = sut.canPlaceFlowers(flowerbed, n);
        assertTrue(actual);

        flowerbed = new int[]{1,0,1,0,1,0,1};
        n = 1;
        actual = sut.canPlaceFlowers(flowerbed, n);
        assertFalse(actual);

        flowerbed = new int[]{0,0,1,0,1};
        n = 1;
        actual = sut.canPlaceFlowers(flowerbed, n);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            int length = flowerbed.length;

            for (int i = 0; i < length; i++) {
                if (flowerbed[i] == 0) {
                    boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                    boolean rightEmpty = (i == length - 1 || flowerbed[i + 1] == 0);

                    if (leftEmpty && rightEmpty) {
                        flowerbed[i] = 1;
                        count++;

                        if (count >= n) {
                            return true;
                        }
                    }
                }
            }

            return count >= n;
        }
    }
}
