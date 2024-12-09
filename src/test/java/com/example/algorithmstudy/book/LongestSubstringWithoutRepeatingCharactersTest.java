package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private final Solution sut = new Solution();

    /*
     * 중복 문자가 없는 가장 긴 부분 문자열의 길이를 리턴하라.
     */

    @Test
    public void test_lengthOfLongestSubstring() {
        var str = "abcabcbbc";
        var actual = sut.lengthOfLongestSubstring(str);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            var used = new HashMap<Character, Integer>();
            var maxLength = 0;
            var left = 0;
            var right = 0;

            for (char c : s.toCharArray()) {
                if (used.containsKey(c) && left <= used.get(c)) {
                    left = used.get(c) + 1;
                } else {
                    maxLength = Math.max(maxLength, right - left + 1);
                }

                used.put(c, right);
                right++;
            }

            return maxLength;
        }

        /*
         * u={}
         * ml=0
         * l=0
         * r=0
         *
         * c=a
         * false
         * ml=(0, 0-0+1)=1
         * u={a=0}
         * r=1
         *
         * c=b
         * false
         * ml=(1, 1-0+1)=2
         * u={a=0,b=1}
         * r=2
         *
         * c=c
         * false
         * ml=(2, 2-0+1)=3
         * u={a=0,b=1,c=2}
         * r=3
         *
         * c=a
         * true & 0<=0
         * l=1
         * u={a=3,b=1,c=2}
         * r=4
         *
         * c=b
         * true & 1<=1
         * l=2
         * u={a=3,b=4,c=2}
         * r=5
         *
         * c=c
         * true & 2<=2
         * l=3
         * u={a=3,b=4,c=5}
         * r=6
         *
         * c=b
         * true & 3<=4
         * l=5
         * u={a=3,b=6,c=5}
         * r=7
         *
         * c=b
         * true & 5<=6
         * l=7
         * u={a=3,b=7,c=5}
         * r=8
         *
         * c=c
         * true & 7<=5
         * ml=(3, 8-7+1)=3
         * u={a=3,b=7,c=8}
         * r=9
         */
    }
}
