package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionsOfLargeGroupsTest {
    private final Solution sut = new Solution();

    /*

    In a string s of lowercase letters, these letters form consecutive groups of the same character.

    For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

    A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

    A group is considered large if it has 3 or more characters.

    Return the intervals of every large group sorted in increasing order by start index.



    Example 1:

    Input: s = "abbxxxxzzy"
    Output: [[3,6]]
    Explanation: "xxxx" is the only large group with start index 3 and end index 6.
    Example 2:

    Input: s = "abc"
    Output: []
    Explanation: We have groups "a", "b", and "c", none of which are large groups.
    Example 3:

    Input: s = "abcdddeeeeaabbbcd"
    Output: [[3,5],[6,9],[12,14]]
    Explanation: The large groups are "ddd", "eeee", and "bbb".


    Constraints:

    1 <= s.length <= 1000
    s contains lowercase English letters only.

     */

    @Test
    public void test_largeGroupPositions() {
        var s = "abbxxxxzzy";
        var actual = sut.largeGroupPositions(s);
        assertEquals(
                List.of(
                        List.of(3, 6)
                ),
                actual
        );

        s = "abc";
        actual = sut.largeGroupPositions(s);
        assertEquals(
                List.of(),
                actual
        );

        s = "abcdddeeeeaabbbcd";
        actual = sut.largeGroupPositions(s);
        assertEquals(
                List.of(
                        List.of(3, 5),
                        List.of(6, 9),
                        List.of(12, 14)
                ),
                actual
        );
    }

    private static class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> ans = new ArrayList<>();
            int i = 0, N = S.length();
            for (int j = 0; j < N; ++j) {
                if (j == N - 1 || S.charAt(j) != S.charAt(j + 1)) {
                    if (j - i + 1 >= 3)
                        ans.add(List.of(i, j));
                    i = j + 1;
                }
            }

            return ans;
        }
    }
}
