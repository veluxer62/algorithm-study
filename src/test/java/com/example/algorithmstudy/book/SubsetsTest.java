package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsetsTest {
    private final Solution sut = new Solution();

    /*
     * 모든 부분집합을 리턴하라.
     */

    @Test
    public void test_subsets() {
        var nums = new int[]{1, 2, 4};
        var actual = sut.subsets(nums);
        assertEquals(
                List.of(
                        List.of(),
                        List.of(1),
                        List.of(1, 2),
                        List.of(1, 2, 4),
                        List.of(1, 4),
                        List.of(2),
                        List.of(2, 4),
                        List.of(4)
                ),
                actual
        );
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            var results = new ArrayList<List<Integer>>();
            dfs(results, nums, 0, new ArrayDeque<>());
            return results;
        }

        private void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
            results.add(new ArrayList<>(path));

            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(results, nums, i + 1, path);
                path.removeLast();
            }
        }

        /*
         * r=[]
         * n=[1,2,4]
         * idx=0
         * p=[]
         * r=[[]]
         *
         * i=0
         * p=[1]
         *      r=[[]]
         *      n=[1,2,4]
         *      idx=1
         *      p=[1]
         *      r=[[],[1]]
         *
         *      i=1
         *      p=[1,2]
         *          r=[[],[1]]
         *          n=[1,2,4]
         *          idx=2
         *          p=[1,2]
         *          r=[[],[1],[1,2]]
         *
         *          i=2
         *          p=[1,2,4]
         *              r=[[],[1],[1,2]]
         *              n=[1,2,4]
         *              idx=3
         *              p=[1,2,4]
         *              r=[[],[1],[1,2],[1,2,4]]
         *          p=[1,2]
         *      p=[1]
         *
         *      i=2
         *      p=[1,4]
         *          r=[[],[1],[1,2],[1,2,4]]
         *          n=[1,2,4]
         *          idx=3
         *          p=[1,4]
         *          r=[[],[1],[1,2],[1,2,4],[1,4]]
         *      p=[1]
         * p=[]
         *
         * i=1
         * p=[2]
         *      r=[[],[1],[1,2],[1,2,4],[1,4]]
         *      n=[1,2,4]
         *      idx=2
         *      p=[2]
         *      r=[[],[1],[1,2],[1,2,4],[1,4],[2]]
         *
         *      i=2
         *      p=[2,4]
         *          r=[[],[1],[1,2],[1,2,4],[1,4],[2]]
         *          n=[1,2,4]
         *          idx=3
         *          p=[2,4]
         *          r=[[],[1],[1,2],[1,2,4],[1,4],[2],[2,4]]
         *      p=[2]
         * p=[]
         *
         * p=2
         * p=[4]
         *      r=[[],[1],[1,2],[1,2,4],[1,4],[2],[2,4]]
         *      n=[1,2,4]
         *      idx=3
         *      p=[4]
         *      r=[[],[1],[1,2],[1,2,4],[1,4],[2],[2,4],[4]]
         * p=[]
         *
         */
    }
}
