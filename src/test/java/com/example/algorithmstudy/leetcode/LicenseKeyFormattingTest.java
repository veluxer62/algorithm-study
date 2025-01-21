package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicenseKeyFormattingTest {
    private final Solution sut = new Solution();

    /*

    You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

    We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

    Return the reformatted license key.



    Example 1:

    Input: s = "5F3Z-2e-9-w", k = 4
    Output: "5F3Z-2E9W"
    Explanation: The string s has been split into two parts, each part has 4 characters.
    Note that the two extra dashes are not needed and can be removed.
    Example 2:

    Input: s = "2-5g-3-J", k = 2
    Output: "2-5G-3J"
    Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.


    Constraints:

    1 <= s.length <= 105
    s consists of English letters, digits, and dashes '-'.
    1 <= k <= 104

     */

    @Test
    public void test_licenseKeyFormatting() {
        var s = "5F3Z-2e-9-w";
        var k = 4;
        var actual = sut.licenseKeyFormatting(s, k);
        assertEquals("5F3Z-2E9W", actual);

        s = "2-5g-3-J";
        k = 2;
        actual = sut.licenseKeyFormatting(s, k);
        assertEquals("2-5G-3J", actual);
    }

    private static class Solution {
        public String licenseKeyFormatting(String s, int k) {
            StringBuilder cleaned = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != '-') {
                    cleaned.append(Character.toUpperCase(c));
                }
            }

            StringBuilder reformatted = new StringBuilder();
            int length = cleaned.length();
            int firstGroupSize = length % k;

            if (firstGroupSize > 0) {
                reformatted.append(cleaned.substring(0, firstGroupSize));
            }

            for (int i = firstGroupSize; i < length; i += k) {
                if (reformatted.length() > 0) {
                    reformatted.append('-');
                }
                reformatted.append(cleaned.substring(i, i + k));
            }

            return reformatted.toString();
        }
    }
}
