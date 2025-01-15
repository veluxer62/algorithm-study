package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVowelsOfAStringTest {
    private final Solution sut = new Solution();

    /*

    Given a string s, reverse only all the vowels in the string and return it.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



    Example 1:

    Input: s = "IceCreAm"

    Output: "AceCreIm"

    Explanation:

    The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

    Example 2:

    Input: s = "leetcode"

    Output: "leotcede"



    Constraints:

    1 <= s.length <= 3 * 105
    s consist of printable ASCII characters.

     */

    @Test
    public void test_reverseVowels() {
        var s = "IceCreAm";
        var actual = sut.reverseVowels(s);
        assertEquals("AceCreIm", actual);

        s = "leetcode";
        actual = sut.reverseVowels(s);
        assertEquals("leotcede", actual);

        s = " ";
        actual = sut.reverseVowels(s);
        assertEquals(" ", actual);

        s = ".";
        actual = sut.reverseVowels(s);
        assertEquals(".", actual);
    }

    private static class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();

            int left = 0, right = s.length() - 1;

            while (left < right) {
                while (left < right && !isVowel(chars[left])) {
                    left++;
                }

                while (left < right && !isVowel(chars[right])) {
                    right--;
                }

                if (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
            }

            return new String(chars);
        }

        private boolean isVowel(char c) {
            return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
        }
    }
}
