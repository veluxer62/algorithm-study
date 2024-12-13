package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {
    private final Solution sut = new Solution();

    /*

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"

    Output: true

    Example 2:

    Input: s = "()[]{}"

    Output: true

    Example 3:

    Input: s = "(]"

    Output: false

    Example 4:

    Input: s = "([])"

    Output: true



    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

     */

    @Test
    public void test_isValid() {
        var s = "()";
        var actual = sut.isValid(s);
        assertTrue(actual);

        s = "()[]{}";
        actual = sut.isValid(s);
        assertTrue(actual);

        s = "(]";
        actual = sut.isValid(s);
        assertFalse(actual);

        s = "([])";
        actual = sut.isValid(s);
        assertTrue(actual);

        s = "[";
        actual = sut.isValid(s);
        assertFalse(actual);

        s = "){";
        actual = sut.isValid(s);
        assertFalse(actual);

        s = "(){}}{";
        actual = sut.isValid(s);
        assertFalse(actual);

        s = "]";
        actual = sut.isValid(s);
        assertFalse(actual);

        s = ")(){}";
        actual = sut.isValid(s);
        assertFalse(actual);

        s = "))";
        actual = sut.isValid(s);
        assertFalse(actual);
    }

    private static class Solution {
        private Map<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        public boolean isValid(String s) {
            var stack = new ArrayDeque<Character>();

            for (var c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    var v = '#';
                    if (!stack.isEmpty()) {
                        v = stack.pop();
                    }

                    if (map.get(c) != v) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
}
