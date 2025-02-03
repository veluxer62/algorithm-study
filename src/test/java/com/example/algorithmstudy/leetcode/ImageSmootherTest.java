package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ImageSmootherTest {
    private final Solution sut = new Solution();

    /*

    An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).


    Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.



    Example 1:


    Input: img = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[0,0,0],[0,0,0],[0,0,0]]
    Explanation:
    For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
    For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
    For the point (1,1): floor(8/9) = floor(0.88888889) = 0
    Example 2:


    Input: img = [[100,200,100],[200,50,200],[100,200,100]]
    Output: [[137,141,137],[141,138,141],[137,141,137]]
    Explanation:
    For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
    For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
    For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138


    Constraints:

    m == img.length
    n == img[i].length
    1 <= m, n <= 200
    0 <= img[i][j] <= 255

     */

    @Test
    public void test_imageSmoother() {
        var img = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        var actual = sut.imageSmoother(img);
        assertArrayEquals(new int[]{0, 0, 0}, actual[0]);
        assertArrayEquals(new int[]{0, 0, 0}, actual[1]);
        assertArrayEquals(new int[]{0, 0, 0}, actual[2]);

        img = new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        actual = sut.imageSmoother(img);
        assertArrayEquals(new int[]{137, 141, 137}, actual[0]);
        assertArrayEquals(new int[]{141, 138, 141}, actual[1]);
        assertArrayEquals(new int[]{137, 141, 137}, actual[2]);
    }

    private static class Solution {
        public int[][] imageSmoother(int[][] img) {
            var result = new int[img.length][img[0].length];

            for (var i = 0; i < img.length; i++) {
                System.out.println("====");
                for (var j = 0; j < img[0].length; j++) {
                    var sum = 0;
                    var count = 0;
                    sum += img[i][j];
                    count++;

                    if (i > 0) {
                        sum += img[i - 1][j];
                        count++;
                    }
                    if (j > 0) {
                        sum += img[i][j - 1];
                        count++;
                    }
                    if (i > 0 && j > 0) {
                        sum += img[i - 1][j - 1];
                        count++;
                    }
                    if (i < img.length - 1) {
                        sum += img[i + 1][j];
                        count++;
                    }
                    if (j < img[0].length - 1) {
                        sum += img[i][j + 1];
                        count++;
                    }
                    if (i < img.length - 1 && j < img[0].length - 1) {
                        sum += img[i + 1][j + 1];
                        count++;
                    }
                    if (i < img.length - 1 && j > 0) {
                        sum += img[i + 1][j - 1];
                        count++;
                    }
                    if (i > 0 && j < img[0].length - 1) {
                        sum += img[i - 1][j + 1];
                        count++;
                    }

                    result[i][j] = sum / count;
                }
            }

            return result;
        }
    }
}
