package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {
    private final Solution sut = new Solution();

    /*

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".



    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.


    Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.

     */

    @Test
    public void test_longestCommonPrefix() {
        var strs = new String[]{"flower", "flow", "flight"};
        var actual = sut.longestCommonPrefix(strs);
        assertEquals("fl", actual);

        strs = new String[]{"dog", "racecar", "car"};
        actual = sut.longestCommonPrefix(strs);
        assertEquals("", actual);

        strs = new String[]{"reflower", "flow", "flight"};
        actual = sut.longestCommonPrefix(strs);
        assertEquals("", actual);

        strs = new String[]{"flower", "flower", "flower", "flower"};
        actual = sut.longestCommonPrefix(strs);
        assertEquals("flower", actual);
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            var first = strs[0];

            if (first.isEmpty()) return "";

            var result = new StringBuilder();
            var i = 0;
            while (i < first.length()) {
                var c = first.charAt(i);

                var flag = true;
                for (var str : strs) {
                    if (!str.startsWith(result + String.valueOf(c))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result.append(c);
                }

                i++;
            }


            return result.toString();
        }
    }
}
