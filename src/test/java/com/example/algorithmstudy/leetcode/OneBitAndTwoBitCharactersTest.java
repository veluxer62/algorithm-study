package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneBitAndTwoBitCharactersTest {
    private final Solution sut = new Solution();

    /*

    We have two special characters:

    The first character can be represented by one bit 0.
    The second character can be represented by two bits (10 or 11).
    Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.



    Example 1:

    Input: bits = [1,0,0]
    Output: true
    Explanation: The only way to decode it is two-bit character and one-bit character.
    So the last character is one-bit character.
    Example 2:

    Input: bits = [1,1,1,0]
    Output: false
    Explanation: The only way to decode it is two-bit character and two-bit character.
    So the last character is not one-bit character.


    Constraints:

    1 <= bits.length <= 1000
    bits[i] is either 0 or 1.

     */

    @Test
    public void test_isOneBitCharacter() {
        var bits = new int[]{1,0,0};
        var actual = sut.isOneBitCharacter(bits);
        assertTrue(actual);

        System.out.println("===");

        bits = new int[]{1,1,1,0};
        actual = sut.isOneBitCharacter(bits);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int ones = 0;

            for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
                ones++;
            }

            return ones % 2 <= 0;
        }
    }
}
