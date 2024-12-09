package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SheepAndWolvesTest {
    private final Solution sut = new Solution();

    /*
     * 양의 수가 늑대와 같거나 적으면 잡아먹힌다.
     * 잡아먹히지 않도록 하면서 최대한 많은 수의 양을 모아 루트로 돌아온다고 할 때 모을 수 있는 양의 최댓값을 출력하라.
     */

    @Test
    public void test_solution() {
        var info = new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        var edged = new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        var actual = sut.solution(info, edged);

        assertEquals(5, actual);
    }

    private static class Solution {
        private Map<Integer, List<Integer>> graph = new HashMap<>();
        private int answer = 1;

        private static class Node {
            int index;
            int sheep;
            int wolves;
            List<Integer> nodes;

            Node(int index, int sheep, int wolves, List<Integer> nodes) {
                this.index = index;
                this.sheep = sheep;
                this.wolves = wolves;
                this.nodes = nodes;
            }
        }

        public int solution(int[] info, int[][] edges) {
            for (var edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<>());
                graph.get(edge[0]).add(edge[1]);
            }

            var queue = new LinkedList<Node>();
            queue.offer(new Node(0, 1, 0, graph.get(0)));

            while (!queue.isEmpty()) {
                var node = queue.poll();

                for (var nextNode : node.nodes) {
                    var nextSheep = info[nextNode] == 0 ? node.sheep + 1 : node.sheep;
                    var nextWolves = info[nextNode] == 1 ? node.wolves + 1 : node.wolves;

                    if (nextSheep > nextWolves) {
                        answer = Math.max(answer, nextSheep);

                        var candidateNodes = new ArrayList<>(node.nodes);
                        candidateNodes.remove(nextNode);

                        if (graph.get(nextNode) != null) {
                            candidateNodes.addAll(graph.get(nextNode));
                        }

                        queue.offer(new Node(nextNode, nextSheep, nextWolves, candidateNodes));
                    }
                }
            }

            return answer;
        }
    }
}
