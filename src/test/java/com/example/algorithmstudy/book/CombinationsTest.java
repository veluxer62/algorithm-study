package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationsTest {
    private final Solution sut = new Solution();

    /*
     * 전체 수 n을 입력받아 k개의 조합을 리턴하라.
     */

    @Test
    public void test_combine() {
        var n = 5;
        var k = 3;
        var actual = sut.combine(n, k);
        assertEquals(
                List.of(
                        List.of(1, 2, 3),
                        List.of(1, 2, 4),
                        List.of(1, 2, 5),
                        List.of(1, 3, 4),
                        List.of(1, 3, 5),
                        List.of(1, 4, 5),
                        List.of(2, 3, 4),
                        List.of(2, 3, 5),
                        List.of(2, 4, 5),
                        List.of(3, 4, 5)
                ),
                actual
        );
    }

    public static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            var results = new ArrayList<List<Integer>>();
            dfs(results, new LinkedList<>(), n, 1, k);

            return results;
        }

        private void dfs(List<List<Integer>> results, LinkedList<Integer> elements, int n, int start, int k) {
            if (k == 0) {
                results.add(new ArrayList<>(elements));
                return;
            }

            for (int i = start; i <= n; i++) {
                elements.add(i);
                dfs(results, elements, n, i + 1, k - 1);
                elements.removeLast();
            }
        }

        /*
         * r=[]
         * e=[]
         * n=5
         * s=1
         * k=3
         *
         * i=1
         * e=[1]
         *      r=[]
         *      e=[1]
         *      n=5
         *      s=2
         *      k=2
         *
         *      i=2
         *      e=[1,2]
         *          r=[]
         *          e=[1,2]
         *          n=5
         *          s=3
         *          k=1
         *
         *          i=3
         *          e=[1,2,3]
         *              r=[]
         *              e=[1,2,3]
         *              n=5
         *              s=4
         *              k=0
         *                  r=[[1,2,3]]
         *              e[1,2]
         *          i=4
         *          e=[1,2,4]
         *              r=[[1,2,3]]
         *              e=[1,2,4]
         *              n=5
         *              s=4
         *              k=0
         *                  r=[[1,2,3],[1,2,4]]
         *              e=[1,2]
         *          i=5
         *          e=[1,2,5]
         *              r=[[1,2,3],[1,2,4]]
         *              e=[1,2,5]
         *              n=5
         *              s=4
         *              k=0
         *                  r=[[1,2,3],[1,2,4],[1,2,5]]
         *              e=[1,2]
         *          e=[1]
         *      i=3
         *      e=[1,3]
         *          r=[[1,2,3],[1,2,4],[1,2,5]]
         *          e=[1,3]
         *          n=5
         *          s=4
         *          k=1
         *
         *          i=4
         *          e=[1,3,4]
         *              r=[[1,2,3],[1,2,4],[1,2,5]]
         *              e=[1,3,4]
         *              n=5
         *              s=5
         *              k=0
         *                  r=[[1,2,3],[1,2,4],[1,2,5],[1,3,4]]
         *              e=[1,3]
         *          i=5
         *          e=[1,3,5]
         *              r=[[1,2,3],[1,2,4],[1,2,5],[1,3,4]]
         *              e=[1,3,5]
         *              n=5
         *              s=5
         *              k=0
         *                  r=[[1,2,3],[1,2,4],[1,2,5],[1,3,4],[1,3,5]]
         *              e=[1,3]
         *
         * ...
         */
    }
}
