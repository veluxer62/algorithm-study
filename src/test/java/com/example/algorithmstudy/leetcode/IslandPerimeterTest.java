package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandPerimeterTest {
    private final Solution sut = new Solution();

    /*

    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



    Example 1:


    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    Output: 16
    Explanation: The perimeter is the 16 yellow stripes in the image above.
    Example 2:

    Input: grid = [[1]]
    Output: 4
    Example 3:

    Input: grid = [[1,0]]
    Output: 4


    Constraints:

    row == grid.length
    col == grid[i].length
    1 <= row, col <= 100
    grid[i][j] is 0 or 1.
    There is exactly one island in grid.

     */

    @Test
    public void test_islandPerimeter() {
        var grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        var actual = sut.islandPerimeter(grid);
        assertEquals(16, actual);

        grid = new int[][]{{1}};
        actual = sut.islandPerimeter(grid);
        assertEquals(4, actual);

        grid = new int[][]{{1, 0}};
        actual = sut.islandPerimeter(grid);
        assertEquals(4, actual);
    }

    @Test
    public void test_islandPerimeter2() {
        var grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        var actual = sut.islandPerimeter2(grid);
        assertEquals(16, actual);

        grid = new int[][]{{1}};
        actual = sut.islandPerimeter2(grid);
        assertEquals(4, actual);

        grid = new int[][]{{1, 0}};
        actual = sut.islandPerimeter2(grid);
        assertEquals(4, actual);
    }

    private static class Solution {
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;

            int rows = grid.length;
            int cols = grid[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        if (i == 0 || grid[i - 1][j] == 0) {
                            perimeter++;
                        }

                        if (i == rows - 1 || grid[i + 1][j] == 0) {
                            perimeter++;
                        }

                        if (j == 0 || grid[i][j - 1] == 0) {
                            perimeter++;
                        }

                        if (j == cols - 1 || grid[i][j + 1] == 0) {
                            perimeter++;
                        }
                    }
                }
            }

            return perimeter;
        }

        public int islandPerimeter2(int[][] grid) {
            int ans = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1)
                        ans = bfs(grid, i, j);
                }
            }

            return ans;
        }

        private int bfs(int[][] grid, int i, int j) {
            int count = 0;

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                return 1;
            }

            if (grid[i][j] == -1) return 0;

            grid[i][j] = -1;
            count += bfs(grid, i - 1, j);
            count += bfs(grid, i + 1, j);
            count += bfs(grid, i, j - 1);
            count += bfs(grid, i, j + 1);

            return count;
        }
    }
}
