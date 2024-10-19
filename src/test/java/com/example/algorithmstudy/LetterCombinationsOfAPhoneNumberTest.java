package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCombinationsOfAPhoneNumberTest {
    private final Solution sut = new Solution();

    /*
     * 2에서 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자를 출력하라.
     */

    @Test
    public void test_letterCombinations() {
        var digits = "24";
        var actual = sut.letterCombinations(digits);
        assertEquals(
                List.of("ag", "ah", "ai", "bg", "bh", "bi", "cg", "ch", "ci"),
                actual
        );
    }

    private static class Solution {
        public List<String> letterCombinations(String digits) {
            var result = new ArrayList<String>();

            if (digits == null || digits.length() == 0) return result;

            Map<Character, List<Character>> dic = Map.of(
                    '0', List.of(),
                    '1', List.of(),
                    '2', List.of('a', 'b', 'c'),
                    '3', List.of('d', 'e', 'f'),
                    '4', List.of('g', 'h', 'i'),
                    '5', List.of('j', 'k', 'l'),
                    '6', List.of('m', 'n', 'o'),
                    '7', List.of('p', 'q', 'r', 's'),
                    '8', List.of('t', 'u', 'v'),
                    '9', List.of('w', 'x', 'y', 'z')
            );

            dfs(result, dic, digits, 0, new StringBuilder());

            return result;
        }

        private void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {
            if (path.length() == digits.length()) {
                result.add(String.valueOf(path));
                return;
            }

            for (char c : dic.get(digits.charAt(index))) {
                dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
            }
        }

        /*
         * r=[]
         * d=24
         * i=0
         * p=
         *
         *      r=[]
         *      i=0
         *      p=
         *
         *      c=a
         *          r=[]
         *          i=1
         *          p=a
         *
         *          c=g
         *              r=[]
         *              i=2
         *              p=ag
         *
         *              r=[ag]
         *          c=h
         *              r=[ag]
         *              i=2
         *              p=ah
         *
         *              r=[ag, ah]
         *          c=i
         *              r=[ag, ah]
         *              i=2
         *              p=ai
         *
         *              r=[ag, ah, ai]
         */
    }
}
