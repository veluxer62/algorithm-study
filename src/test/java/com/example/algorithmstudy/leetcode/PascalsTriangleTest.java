package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PascalsTriangleTest {
    private final Solution sut = new Solution();

    /*

    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




    Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    Example 2:

    Input: numRows = 1
    Output: [[1]]


    Constraints:

    1 <= numRows <= 30

     */

    @Test
    public void test_generate() {
        var numRows = 5;
        var actual = sut.generate(numRows);
        assertEquals(
                List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1),
                        List.of(1, 4, 6, 4, 1)
                ),
                actual
        );

        numRows = 1;
        actual = sut.generate(numRows);
        assertEquals(
                List.of(
                        List.of(1)
                ),
                actual
        );
    }

    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            var result = new ArrayList<List<Integer>>();

            if (numRows >= 1) {
                result.add(new ArrayList<>());
                result.get(0).add(1);
            }

            for (int i = 1; i < numRows; i++) {
                var prev = result.get(i - 1);
                var row = new ArrayList<Integer>();

                row.add(1);

                for (int j = 1; j < i; j++) {
                    row.add(prev.get(j - 1) + prev.get(j));
                }

                row.add(1);

                result.add(row);
            }

            return result;
        }
    }
}
