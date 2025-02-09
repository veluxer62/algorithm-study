package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSmallestLetterGreaterThanTargetTest {
    private final Solution sut = new Solution();

    /*

    You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

    Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.



    Example 1:

    Input: letters = ["c","f","j"], target = "a"
    Output: "c"
    Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
    Example 2:

    Input: letters = ["c","f","j"], target = "c"
    Output: "f"
    Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
    Example 3:

    Input: letters = ["x","x","y","y"], target = "z"
    Output: "x"
    Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].


    Constraints:

    2 <= letters.length <= 104
    letters[i] is a lowercase English letter.
    letters is sorted in non-decreasing order.
    letters contains at least two different characters.
    target is a lowercase English letter.

     */

    @Test
    public void test_nextGreatestLetter() {
        var letters = new char[]{'c', 'f', 'j'};
        var target = 'a';
        var actual = sut.nextGreatestLetter(letters, target);
        assertEquals('c', actual);

        letters = new char[]{'c', 'f', 'j'};
        target = 'c';
        actual = sut.nextGreatestLetter(letters, target);
        assertEquals('f', actual);

        letters = new char[]{'x', 'x', 'y', 'y'};
        target = 'z';
        actual = sut.nextGreatestLetter(letters, target);
        assertEquals('x', actual);
    }

    @Test
    public void test_nextGreatestLetter2() {
        var letters = new char[]{'c', 'f', 'j'};
        var target = 'a';
        var actual = sut.nextGreatestLetter2(letters, target);
        assertEquals('c', actual);

        letters = new char[]{'c', 'f', 'j'};
        target = 'c';
        actual = sut.nextGreatestLetter2(letters, target);
        assertEquals('f', actual);

        letters = new char[]{'x', 'x', 'y', 'y'};
        target = 'z';
        actual = sut.nextGreatestLetter2(letters, target);
        assertEquals('x', actual);
    }

    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            var pq = new PriorityQueue<Character>();
            for (char letter : letters) {
                if (letter > target) {
                    pq.add(letter);
                }
            }

            if (pq.isEmpty()) {
                return letters[0];
            }

            return pq.poll();
        }

        public char nextGreatestLetter2(char[] letters, char target) {
            char s = ' ';

            for (char letter : letters) {
                if (letter == target) {
                    continue;
                }

                if (letter > target && (s == ' ' || letter < s)) {
                    s = letter;
                }
            }

            return s == ' ' ? letters[0] : s;
        }
    }
}
