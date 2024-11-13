package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchA2DMatrix2Test {
    private final Solution sut = new Solution();

    /*
     * m * n 행렬에서 값을 찾아내는 효율적인 알고리즘을 구현하라. 행렬은 왼쪽에서 오른쪽, 위에서 아래로 오름차순으로 정렬되어 있으며 다음과 같다.
     */

    @Test
    public void test_searchMatrix() {
        var matrix = new int[][]{
                {1, 4, 7, 11, 6},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 31},
        };
        var target = 5;
        var actual = sut.searchMatrix(matrix, target);
        assertTrue(actual);

        target = 20;
        actual = sut.searchMatrix(matrix, target);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            var row = 0;
            var col = matrix[0].length - 1;

            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }

            return false;
        }
    }
}
