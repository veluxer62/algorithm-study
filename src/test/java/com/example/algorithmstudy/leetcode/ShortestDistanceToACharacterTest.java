package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShortestDistanceToACharacterTest {
    private final Solution sut = new Solution();

    /*

    Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

    The distance between two indices i and j is abs(i - j), where abs is the absolute value function.



    Example 1:

    Input: s = "loveleetcode", c = "e"
    Output: [3,2,1,0,1,0,0,1,2,2,1,0]
    Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
    The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
    The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
    For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
    The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
    Example 2:

    Input: s = "aaab", c = "b"
    Output: [3,2,1,0]


    Constraints:

    1 <= s.length <= 104
    s[i] and c are lowercase English letters.
    It is guaranteed that c occurs at least once in s.

     */

    @Test
    public void test_shortestToChar() {
        var s = "loveleetcode";
        var c = 'e';
        var actual = sut.shortestToChar(s, c);
        assertArrayEquals(
                new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0},
                actual
        );

        s = "aaab";
        c = 'b';
        actual = sut.shortestToChar(s, c);
        assertArrayEquals(
                new int[]{3, 2, 1, 0},
                actual
        );
    }

    @Test
    public void test_shortestToChar2() {
        var s = "loveleetcode";
        var c = 'e';
        var actual = sut.shortestToChar2(s, c);
        assertArrayEquals(
                new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0},
                actual
        );

        s = "aaab";
        c = 'b';
        actual = sut.shortestToChar2(s, c);
        assertArrayEquals(
                new int[]{3, 2, 1, 0},
                actual
        );
    }

    private static class Solution {
        public int[] shortestToChar(String s, char c) {
            var list = new ArrayList<Integer>();
            for (var i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    list.add(i);
                }
            }

            var result = new int[s.length()];
            for (var i = 0; i < s.length(); i++) {
                var min = Integer.MAX_VALUE;
                for (var item : list) {
                    min = Math.min(min, Math.abs(i - item));
                }
                result[i] = min;
            }

            return result;
        }

        public int[] shortestToChar2(String s, char c) {
            int n = s.length();
            int[] output = new int[n];
            int cPosition = -n;

            for(int i=0; i<n; i++){
                if(s.charAt(i) == c){
                    cPosition = i;
                }
                output[i] = i-cPosition;
            }

            for(int i=n-1; i>=0; i--){
                if(s.charAt(i) == c){
                    cPosition = i;
                }
                output[i] = Math.min(output[i], Math.abs(i - cPosition));
            }
            return output;
        }
    }
}
