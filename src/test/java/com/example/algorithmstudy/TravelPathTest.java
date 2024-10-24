package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TravelPathTest {
    private final Solution sut = new Solution();

    /*
     * 티켓 정보를 받아 ICN 공항에서 출발해 모든 경로를 방문하는 여행 경로를 출력하라.
     */

    @Test
    public void test_findPath() {
        var tickets = new String[][]{
                new String[]{"ICN", "JFK"},
                new String[]{"HND", "IAD"},
                new String[]{"JFK", "HND"}
        };
        var actual = sut.findPath(tickets);
        assertArrayEquals(
                new String[]{"ICN", "JFK", "HND", "IAD"},
                actual
        );

        tickets = new String[][]{
                new String[]{"ICN", "SFO"},
                new String[]{"ICN", "ATL"},
                new String[]{"SFO", "ATL"},
                new String[]{"ATL", "ICN"},
                new String[]{"ATL", "SFO"},
        };
        actual = sut.findPath(tickets);
        assertArrayEquals(
                new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
                actual
        );
    }

    @Test
    public void test_findPath2() {
        var tickets = new String[][]{
                new String[]{"ICN", "JFK"},
                new String[]{"HND", "IAD"},
                new String[]{"JFK", "HND"}
        };
        var actual = sut.findPath2(tickets);
        assertArrayEquals(
                new String[]{"ICN", "JFK", "HND", "IAD"},
                actual
        );

        tickets = new String[][]{
                new String[]{"ICN", "SFO"},
                new String[]{"ICN", "ATL"},
                new String[]{"SFO", "ATL"},
                new String[]{"ATL", "ICN"},
                new String[]{"ATL", "SFO"},
        };
        actual = sut.findPath2(tickets);
        assertArrayEquals(
                new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
                actual
        );
    }

    private static class Solution {
        public String[] findPath(String[][] tickets) {
            var fromToMap = new HashMap<String, PriorityQueue<String>>();

            for (var ticket : tickets) {
                fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
                fromToMap.get(ticket[0]).add(ticket[1]);
            }

            var results = new LinkedList<String>();
            var stack = new ArrayDeque<String>();

            stack.push("ICN");
            while (!stack.isEmpty()) {
                while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                    stack.push(fromToMap.get(stack.getFirst()).poll());
                }
                results.add(0, stack.pop());
            }

            return results.toArray(new String[0]);
        }

        public String[] findPath2(String[][] tickets) {
            var results = new LinkedList<String>();
            var fromToMap = new HashMap<String, PriorityQueue<String>>();

            for (var ticket : tickets) {
                fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
                fromToMap.get(ticket[0]).add(ticket[1]);
            }

            dfs(results, fromToMap, "ICN");

            return results.toArray(new String[0]);
        }

        private void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String path) {
            while (fromToMap.containsKey(path) && !fromToMap.get(path).isEmpty()) {
                dfs(results, fromToMap, fromToMap.get(path).poll());
            }
            results.add(0, path);
        }
    }
}
