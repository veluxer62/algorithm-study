package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private final Solution sut = new Solution();

    /*

    Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.


    Example 1:

    Input: n = 3
    Output: ["1","2","Fizz"]
    Example 2:

    Input: n = 5
    Output: ["1","2","Fizz","4","Buzz"]
    Example 3:

    Input: n = 15
    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]


    Constraints:

    1 <= n <= 104

     */

    @Test
    public void test_fizzBuzz() {
        var n = 3;
        var actual = sut.fizzBuzz(n);
        assertEquals(
                List.of("1", "2", "Fizz"),
                actual
        );

        n = 5;
        actual = sut.fizzBuzz(n);
        assertEquals(
                List.of("1", "2", "Fizz", "4", "Buzz"),
                actual
        );

        n = 15;
        actual = sut.fizzBuzz(n);
        assertEquals(
                List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"),
                actual
        );
    }

    private static class Solution {
        public List<String> fizzBuzz(int n) {
            var result = new ArrayList<String>();

            for (int i = 1; i <= n; i++) {
                result.add(
                        i % 15 == 0 ? "FizzBuzz" :
                                i % 3 == 0 ? "Fizz" :
                                        i % 5 == 0 ? "Buzz" :
                                                String.valueOf(i)
                );
            }

            return result;
        }
    }
}
