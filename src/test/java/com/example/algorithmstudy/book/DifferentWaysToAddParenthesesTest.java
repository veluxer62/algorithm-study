package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferentWaysToAddParenthesesTest {
    private final Solution sut = new Solution();

    /*
     * 숫자와 연산자를 입력받아 가능한 모든 조합의 결과를 출력하라.
     */

    @Test
    public void test_addParentheses() {
        var expression = "2*6-4*3";
        var actual = sut.diffWaysToCompute(expression);

        assertEquals(
                List.of(-12, 12, 0, 12, 24),
                actual
        );
    }

    @Test
    public void test_addParentheses2() {
        var expression = "2*6-4*3";
        var actual = sut.diffWaysToCompute2(expression);

        assertEquals(
                List.of(-12, 12, 0, 12, 24),
                actual
        );
    }

    private static class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            var result = new ArrayList<Integer>();

            for (var i = 0; i < expression.length(); i++) {
                var c = expression.charAt(i);

                if (c == '+' || c == '-' || c == '*') {
                    var left = diffWaysToCompute(expression.substring(0, i));
                    var right = diffWaysToCompute(expression.substring(i + 1));

                    for (var l : left) {
                        for (var r : right) {
                            if (c == '+') {
                                result.add(l + r);
                            } else if (c == '-') {
                                result.add(l - r);
                            } else if (c == '*') {
                                result.add(l * r);
                            }
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                result.add(Integer.parseInt(expression));
            }

            return result;
        }

        private final HashMap<String, List<Integer>> memo = new HashMap<>();

        public List<Integer> diffWaysToCompute2(String expression) {
            var result = new ArrayList<Integer>();

            if (memo.containsKey(expression)) {
                return memo.get(expression);
            }

            for (var i = 0; i < expression.length(); i++) {
                var c = expression.charAt(i);

                if (c == '+' || c == '-' || c == '*') {
                    var left = diffWaysToCompute2(expression.substring(0, i));
                    var right = diffWaysToCompute2(expression.substring(i + 1));

                    for (var l : left) {
                        for (var r : right) {
                            if (c == '+') {
                                result.add(l + r);
                            } else if (c == '-') {
                                result.add(l - r);
                            } else if (c == '*') {
                                result.add(l * r);
                            }
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                result.add(Integer.parseInt(expression));
            }

            memo.put(expression, result);
            return result;
        }
    }
}
