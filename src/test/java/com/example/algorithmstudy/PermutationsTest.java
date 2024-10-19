package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsTest {
    private final Solution sut = new Solution();

    /*
     * 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라.
     */

    @Test
    public void test_permuteUnique() {
        var nums = new int[]{1, 2, 4};
        var actual = sut.permuteUnique(nums);
        assertEquals(
                List.of(
                        List.of(1, 2, 4),
                        List.of(1, 4, 2),
                        List.of(2, 1, 4),
                        List.of(2, 4, 1),
                        List.of(4, 1, 2),
                        List.of(4, 2, 1)
                ),
                actual
        );
    }

    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            var results = new ArrayList<List<Integer>>();
            var numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            dfs(results, new ArrayList<>(), numList);
            return results;
        }

        private void dfs(ArrayList<List<Integer>> results, ArrayList<Integer> prevElements, List<Integer> elements) {
            if (elements.isEmpty()) {
                results.add(new ArrayList<>(prevElements));
            }

            for (var e : elements) {
                var next = new ArrayList<>(elements);
                next.remove(e);

                prevElements.add(e);
                dfs(results, prevElements, next);
                prevElements.remove(e);
            }
        }

        /*
         * r=[]
         * p=[]
         * el=[1,2,4]
         *
         * ===
         * r=[]
         * p=[]
         * el=[1,2,4]
         *
         * e=1
         * n=[1,2,4]
         * n=[2,4]
         * p=[1]
         *      r=[]
         *      p=[1]
         *      el=[2,4]
         *
         *      e=2
         *      n=[2,4]
         *      n=[4]
         *      p=[1,2]
         *          r=[]
         *          p=[1,2]
         *          el=[4]
         *
         *          e=4
         *          n=[4]
         *          n=[]
         *          p=[1,2,4]
         *              r=[[1,2,4]]
         *          p=[1,2]
         *      e=4
         *      n=[2,4]
         *      n=[2]
         *      p=[1,4]
         *          r=[[1,2,4]]
         *          p=[1,4]
         *          el=[2]
         *
         *          e=2
         *          n=[2]
         *          n=[]
         *          p=[1,4,2]
         *              r=[[1,2,4],[1,4,2]]
         *          p=[1,4]
         *      p=[1]
         * p=[]
         *
         * e=2
         * n=[1,2,4]
         * n=[1,4]
         * p=[2]
         *      r=[[1,2,4],[1,4,2]]
         *      p=[2]
         *      el=[1,4]
         *
         *      e=1
         *      n=[1,4]
         *      n=[4]
         *      p=[2,1]
         *          r=[[1,2,4],[1,4,2]]
         *          p=[2,1]
         *          el=[4]
         *
         *          e=4
         *          n=[4]
         *          n=[]
         *          p=[2,1,4]
         *              r=[[1,2,4],[1,4,2],[2,1,4]]
         *          p=[2,1]
         *      p=[2]
         *
         *      e=4
         *      n=[1,4]
         *      n=[1]
         *      p=[2,4]
         *          r=[[1,2,4],[1,4,2],[2,1,4]]
         *          p=[2,4]
         *          el=[1]
         *
         *          e=1
         *          n=[1]
         *          n=[]
         *          p=[2,4,1]
         *              r=[[1,2,4],[1,4,2],[2,1,4],[2,4,1]]
         *          p=[2,4]
         *      p=[2]
         * p=[]
         *
         * e=4
         * n=[1,2,4]
         * n=[1,2]
         * p=[4]
         *      r=[[1,2,4],[1,4,2],[2,1,4],[2,4,1]]
         *      p=[4]
         *      el=[1,2]
         *
         *      e=1
         *      n=[1,2]
         *      n=[2]
         *      p=[4,1]
         *          r=[[1,2,4],[1,4,2],[2,1,4],[2,4,1]]
         *          p=[4,1]
         *          el=[2]
         *
         *          e=2
         *          n=[2]
         *          n=[]
         *          p=[4,1,2]
         *              r=[[1,2,4],[1,4,2],[2,1,4],[2,4,1],[4,1,2]]
         *          p=[4,1]
         *      p=[4]
         *
         *      e=2
         *      n=[1,2]
         *      n=[1]
         *      p=[4,2]
         *          r=[[1,2,4],[1,4,2],[2,1,4],[2,4,1],[4,1,2]]
         *          p=[4,2]
         *          el=[1]
         *
         *          e=1
         *          n=[1]
         *          n=[]
         *          p=[4,2,1]
         *              r=[[1,2,4],[1,4,2],[2,1,4],[2,4,1],[4,1,2],[4,2,1]]
         *          p=[4,2]
         *      p=[4]
         * p=[]
         */
    }
}
