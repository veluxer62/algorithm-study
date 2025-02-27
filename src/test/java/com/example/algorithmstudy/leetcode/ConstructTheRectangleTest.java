package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConstructTheRectangleTest {
    private final Solution sut = new Solution();

    /*

    A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

    The area of the rectangular web page you designed must equal to the given target area.
    The width W should not be larger than the length L, which means L >= W.
    The difference between length L and width W should be as small as possible.
    Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.



    Example 1:

    Input: area = 4
    Output: [2,2]
    Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
    But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
    Example 2:

    Input: area = 37
    Output: [37,1]
    Example 3:

    Input: area = 122122
    Output: [427,286]


    Constraints:

    1 <= area <= 107

     */

    @Test
    public void test_constructRectangle() {
        var area = 4;
        var actual = sut.constructRectangle(area);
        assertArrayEquals(
                new int[]{2, 2},
                actual
        );

        area = 37;
        actual = sut.constructRectangle(area);
        assertArrayEquals(
                new int[]{37, 1},
                actual
        );

        area = 122122;
        actual = sut.constructRectangle(area);
        assertArrayEquals(
                new int[]{427, 286},
                actual
        );
    }

    private static class Solution {
        public int[] constructRectangle(int area) {
            var width = (int) Math.sqrt(area);

            while (area % width != 0) {
                width--;
            }

            var length = area / width;

            return new int[]{length, width};
        }
    }
}
