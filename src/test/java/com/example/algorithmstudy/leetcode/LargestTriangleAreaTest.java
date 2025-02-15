package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestTriangleAreaTest {
    private final Solution sut = new Solution();

    /*

    Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.



    Example 1:


    Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
    Output: 2.00000
    Explanation: The five points are shown in the above figure. The red triangle is the largest.
    Example 2:

    Input: points = [[1,0],[0,0],[0,1]]
    Output: 0.50000


    Constraints:

    3 <= points.length <= 50
    -50 <= xi, yi <= 50
    All the given points are unique.

     */

    @Test
    public void test_largestTriangleArea() {
        var points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        var actual = sut.largestTriangleArea(points);
        assertEquals(2.00000, actual);

        points = new int[][]{{1, 0}, {0, 0}, {0, 1}};
        actual = sut.largestTriangleArea(points);
        assertEquals(0.50000, actual);

        points = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        actual = sut.largestTriangleArea(points);
        assertEquals(5.50000, actual);
    }

    private static class Solution {

        public double largestTriangleArea(int[][] points) {
            double ans = 0;
            int n = points.length;

            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    for (int k = j + 1; k < n; k++)
                        ans = Math.max(ans, Math.abs(area(points[i], points[j], points[k])));

            return ans;
        }

        // 삼각형 넓이=[x1(y2−y3)+x2(y3−y1)+x3(y1−y2)]/2
        public static double area(int[] x1, int[] x2, int[] x3) {
            int t1 = x1[0] * (x2[1] - x3[1]);
            int t2 = x2[0] * (x3[1] - x1[1]);
            int t3 = x3[0] * (x1[1] - x2[1]);
            return (double) (t1 + t2 + t3) / 2;
        }
    }
}
