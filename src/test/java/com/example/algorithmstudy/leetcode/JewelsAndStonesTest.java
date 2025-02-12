package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JewelsAndStonesTest {
    private final Solution sut = new Solution();

    /*

    You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

    Letters are case sensitive, so "a" is considered a different type of stone from "A".



    Example 1:

    Input: jewels = "aA", stones = "aAAbbbb"
    Output: 3
    Example 2:

    Input: jewels = "z", stones = "ZZ"
    Output: 0


    Constraints:

    1 <= jewels.length, stones.length <= 50
    jewels and stones consist of only English letters.
    All the characters of jewels are unique.

     */

    @Test
    public void test_numJewelsInStones() {
        var jewels = "aA";
        var stones = "aAAbbbb";
        var actual = sut.numJewelsInStones(jewels, stones);
        assertEquals(3, actual);

        jewels = "z";
        stones = "ZZ";
        actual = sut.numJewelsInStones(jewels, stones);
        assertEquals(0, actual);
    }

    @Test
    public void test_numJewelsInStones2() {
        var jewels = "aA";
        var stones = "aAAbbbb";
        var actual = sut.numJewelsInStones2(jewels, stones);
        assertEquals(3, actual);

        jewels = "z";
        stones = "ZZ";
        actual = sut.numJewelsInStones2(jewels, stones);
        assertEquals(0, actual);
    }

    private static class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            var count = 0;
            for (char c : jewels.toCharArray()) {
                for (char cc : stones.toCharArray()) {
                    if (cc == c) {
                        count++;
                        stones = stones.replaceFirst(String.valueOf(c), String.valueOf(cc));
                    }
                }
            }

            return count;
        }

        public int numJewelsInStones2(String jewels, String stones) {
            var set = new HashSet<Character>();
            for (char c : jewels.toCharArray()) {
                set.add(c);
            }

            var count = 0;
            for (char c : stones.toCharArray()) {
                if (set.contains(c)) {
                    count++;
                }
            }

            return count;
        }
    }
}
