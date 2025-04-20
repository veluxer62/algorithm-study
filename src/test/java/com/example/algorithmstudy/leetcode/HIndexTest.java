package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HIndexTest {
    private final Solution sut = new Solution();

    /*

    Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.



    Example 1:

    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
    Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
    Example 2:

    Input: citations = [1,3,1]
    Output: 1


    Constraints:

    n == citations.length
    1 <= n <= 5000
    0 <= citations[i] <= 1000

     */

    @Test
    public void test_hIndex() {
        int[] citations = {3, 0, 6, 1, 5};
        var actual = sut.hIndex(citations);
        assertEquals(3, actual);

        citations = new int[]{1, 3, 1};
        actual = sut.hIndex(citations);
        assertEquals(1, actual);

        citations = new int[]{100};
        actual = sut.hIndex(citations);
        assertEquals(1, actual);

        citations = new int[]{0, 0, 2};
        actual = sut.hIndex(citations);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++) {
                int h = citations.length - i;
                if (citations[i] >= h) {
                    return h;
                }
            }

            return 0;
        }
    }
}
