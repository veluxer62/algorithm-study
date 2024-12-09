package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumHeightTreesTest {
    private final Solution sut = new Solution();

    /*
     * 노드 개수와 무방향 그래프를 입력받아 트리가 최소 높이가 되는 루트의 목록을 리턴하라. 각 노드는 0부터 n - 1까지, n개만큼 존재한다.
     */

    @Test
    public void test_minHeightTrees() {
        var n = 7;
        var edges = new int[][]{new int[]{0, 3}, new int[]{1, 3}, new int[]{2, 3}, new int[]{4, 3}, new int[]{5, 3}, new int[]{6, 5}};
        var actual = sut.minHeightTrees(n, edges);
        assertEquals(
                List.of(3, 5),
                actual
        );

        n = 10;
        edges = new int[][]{new int[]{0, 2}, new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{3, 5}, new int[]{5, 9}, new int[]{4, 6}, new int[]{4, 7}, new int[]{7, 8}};
        actual = sut.minHeightTrees(n, edges);
        assertEquals(
                List.of(2),
                actual
        );
    }

    private static class Solution {
        public List<Integer> minHeightTrees(int n, int[][] edges) {
            if (n == 1) return List.of(0);

            var graph = new HashMap<Integer, List<Integer>>();
            for (int[] edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<>());
                graph.putIfAbsent(edge[1], new ArrayList<>());
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            var leaves = new ArrayList<Integer>();
            for (var i = 0; i < n; i++) {
                if (graph.get(i).size() == 1) leaves.add(i);
            }

            while (n > 2) {
                n -= leaves.size();

                var newLeaves = new ArrayList<Integer>();
                for (var leaf : leaves) {
                    var neighbor = graph.get(leaf).get(0);
                    graph.get(neighbor).remove(leaf);

                    if (graph.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }

                leaves = newLeaves;
            }

            return leaves;
        }
    }
}
