package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RansomNoteTest {
    private final Solution sut = new Solution();

    /*

    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.



    Example 1:

    Input: ransomNote = "a", magazine = "b"
    Output: false
    Example 2:

    Input: ransomNote = "aa", magazine = "ab"
    Output: false
    Example 3:

    Input: ransomNote = "aa", magazine = "aab"
    Output: true


    Constraints:

    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.

     */

    @Test
    public void test_canConstruct() {
        var ransomNote = "a";
        var magazine = "b";
        var actual = sut.canConstruct(ransomNote, magazine);
        assertFalse(actual);

        ransomNote = "aa";
        magazine = "ab";
        actual = sut.canConstruct(ransomNote, magazine);
        assertFalse(actual);

        ransomNote = "aa";
        magazine = "aab";
        actual = sut.canConstruct(ransomNote, magazine);
        assertTrue(actual);

        ransomNote = "aab";
        magazine = "baa";
        actual = sut.canConstruct(ransomNote, magazine);
        assertTrue(actual);

        ransomNote = "bg";
        magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        actual = sut.canConstruct(ransomNote, magazine);
        assertTrue(actual);

        ransomNote = "fihjjjjei";
        magazine = "hjibagacbhadfaefdjaeaebgi";
        actual = sut.canConstruct(ransomNote, magazine);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            var charCountMap = new HashMap<Character, Integer>();

            for (char c : magazine.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            for (char c : ransomNote.toCharArray()) {
                if (!charCountMap.containsKey(c) || charCountMap.get(c) <= 0) {
                    return false;
                }

                charCountMap.put(c, charCountMap.get(c) - 1);
            }

            return true;
        }
    }
}
