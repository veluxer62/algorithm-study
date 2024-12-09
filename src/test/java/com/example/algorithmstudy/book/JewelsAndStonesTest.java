package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JewelsAndStonesTest {
    private final Solution sut = new Solution();

    /*
     * J는 보석이며, S는 갖고 있는 돌이다. S에는 보석이 몇 개나 있을까? 대소문자는 구분한다.
     */

    @Test
    public void test_numJewelsInStones() {
        var j = "aA";
        var s = "aAAbbbb";
        var actual = sut.numJewelsInStones(j, s);
        assertEquals(3, actual);
    }

    @Test
    public void test_numJewelsInStones2() {
        var j = "aA";
        var s = "aAAbbbb";
        var actual = sut.numJewelsInStones2(j, s);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            var freq = new HashMap<Character, Integer>();
            for (char c : stones.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }

            var count = 0;
            for (char c : jewels.toCharArray()) {
                if (freq.containsKey(c)) {
                    count += freq.get(c);
                }
            }

            return count;
        }

        public int numJewelsInStones2(String jewels, String stones) {
            var count = 0;
            var freq = new HashSet<Character>();

            for (char c : jewels.toCharArray()) {
                freq.add(c);
            }

            for (char c : stones.toCharArray()) {
                if (freq.contains(c)) {
                    count++;
                }
            }

            return count;
        }
    }
}
