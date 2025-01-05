package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PascalsTriangleIITest {
    private final Solution sut = new Solution();

    /*

    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




    Example 1:

    Input: rowIndex = 3
    Output: [1,3,3,1]
    Example 2:

    Input: rowIndex = 0
    Output: [1]
    Example 3:

    Input: rowIndex = 1
    Output: [1,1]


    Constraints:

    0 <= rowIndex <= 33


     */

    @Test
    public void test_getRow() {
        var rowIndex = 3;
        var actual = sut.getRow(rowIndex);
        assertEquals(
                List.of(1, 3, 3, 1),
                actual
        );

        rowIndex = 0;
        actual = sut.getRow(rowIndex);
        assertEquals(
                List.of(1),
                actual
        );

        rowIndex = 1;
        actual = sut.getRow(rowIndex);
        assertEquals(
                List.of(1, 1),
                actual
        );
    }

    private static class Solution {
        public List<Integer> getRow(int rowIndex) {
            var currentRow = new ArrayList<Integer>();
            var prevRow = List.of(1);
            if (rowIndex == 0) return prevRow;

            for (int i = 1; i <= rowIndex; i++) {
                currentRow = new ArrayList<>();
                currentRow.add(1);
                for (int j = 1; j < i; j++) {
                    currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                currentRow.add(1);

                prevRow = currentRow;
            }

            return currentRow;
        }
    }
}
