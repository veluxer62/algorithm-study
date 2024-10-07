package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {
    private final Solution sut = new Solution();

    /*
     * 대중소 세 종류 괄호로 된 입력값이 유효한지 판별하라.
     */

    @Test
    public void test_isValid() {
        var given = "[]{}()";
        var actual = sut.isValid(given);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean isValid(String s) {
            var table = new HashMap<Character, Character>() {{
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }};
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);


                if (!table.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || table.get(c) != stack.pop()) {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
