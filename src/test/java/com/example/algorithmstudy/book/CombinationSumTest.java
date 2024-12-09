package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationSumTest {
    private final Solution sut = new Solution();

    /*
     * 숫자 집합 candidates를 조합하여 합이 target이 되는 엘리먼트를 나열하라. 각 숫자는 중복으로 나열 가능하다.
     */

    @Test
    public void test_combinationSum() {
        var candidates = new int[] {2, 3, 5, 8};
        var target = 8;
        var actual = sut.combinationSum(candidates, target);
        assertEquals(
                List.of(
                        List.of(2, 2, 2, 2),
                        List.of(2, 3, 3),
                        List.of(3, 5),
                        List.of(8)
                ),
                actual
        );
    }

    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            var result = new ArrayList<List<Integer>>();
            dfs(result, candidates, target, 0, new ArrayDeque<Integer>());
            return result;
        }

        private void dfs(List<List<Integer>> result, int[] candidates, int target, int index, Deque<Integer> path) {
            if (target < 0) return;

            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                path.add(candidates[i]);
                dfs(result, candidates, target - candidates[i], i, path);
                path.removeLast();
            }
        }

        /*
         * r=[]
         * c=[2,3,5,8]
         * t=8
         * idx=0
         * p=[]
         *
         * i=0
         * p=[2]
         *      r=[]
         *      c=[2,3,5,8]
         *      t=6
         *      idx=0
         *      p=[2]
         *
         *      i=0
         *      p=[2,2]
         *          r=[]
         *          c=[2,3,5,8]
         *          t=4
         *          idx=0
         *          p=[2,2]
         *
         *          i=0
         *          p=[2,2,2]
         *              r=[]
         *              c=[2,3,5,8]
         *              t=2
         *              idx=0
         *              p=[2,2,2]
         *
         *              i=0
         *              p=[2,2,2,2]
         *                  r=[[2,2,2,2]]
         *              p=[2,2,2]
         *
         *              i=1
         *              p=[2,2,2,3]
         *              p=[2,2,2]
         *
         *              i=2
         *              p=[2,2,2,5]
         *              p=[2,2,2]
         *
         *              i=3
         *              p=[2,2,2,8]
         *              p=[2,2,2]
         *          p=[2,2]
         *
         *          i=1
         *          p=[2,2,3]
         *              r=[[2,2,2,2]]
         *              c=[2,3,5,8]
         *              t=1
         *              idx=1
         *              p=[2,2,3]
         *
         *              i=1
         *              p=[2,2,3,3]
         *              p=[2,2,3]
         *
         *              i=2
         *              p=[2,2,3,5]
         *              p=[2,2,3]
         *
         *              i=3
         *              p=[2,2,3,8]
         *              p=[2,2,3]
         *          p=[2,2]
         *
         *          i=2
         *          p=[2,2,5]
         *          p=[2,2]
         *
         *          i=3
         *          p=[2,2,8]
         *          p=[2,2]
         *      p=[2]
         *
         *      i=1
         *      p=[2,3]
         *          r=[[2,2,2,2]]
         *          c=[2,3,5,8]
         *          t=3
         *          idx=1
         *          p=[2,3]
         *
         *          i=1
         *          p=[2,3,3]
         *              r=[[2,2,2,2],[2,3,3]]
         *          p=[2,3]
         *
         *          i=2
         *          p=[2,3,5]
         *          p=[2,3]
         *
         *          i=3
         *          p=[2,3,8]
         *          p=[2,3]
         * ....
         *
         */
    }
}
