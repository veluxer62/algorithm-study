package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestFlightsWithinKStopsTest {
    private final Solution sut = new Solution();

    /*
     * 시작점에서 도착점까지의 가장 저렴한 가격을 계산하되, k개의 경유지 이내에 도착하는 가격을 리턴하라. 경로가 존재하지 않을 경우 -1을 리턴한다.
     */

    @Test
    public void test_findCheapestPrice() {
        var n = 0;
        var flights = new int[][]{
                new int[]{0, 1, 100},
                new int[]{1, 2, 200},
                new int[]{0, 2, 500},
        };
        var src = 0;
        var dst = 2;
        var k = 0;
        var actual = sut.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(500, actual);
    }

    @Test
    public void test_findCheapestPrice2() {
        var n = 0;
        var flights = new int[][]{
                new int[]{0, 1, 100},
                new int[]{1, 2, 200},
                new int[]{0, 2, 500},
        };
        var src = 0;
        var dst = 2;
        var k = 0;
        var actual = sut.findCheapestPrice2(n, flights, src, dst, k);
        assertEquals(500, actual);
    }

    private static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            var graph = new HashMap<Integer, Map<Integer, Integer>>();
            for (var flight : flights) {
                graph.putIfAbsent(flight[0], new HashMap<>());
                graph.get(flight[0]).put(flight[1], flight[2]);
            }

            var pq = new PriorityQueue<List<Integer>>(Comparator.comparingInt(a -> a.get(1)));
            pq.add(List.of(src, 0, 0));

            while (!pq.isEmpty()) {
                var cur = pq.poll();
                var u = cur.get(0);
                var price = cur.get(1);
                var visited = cur.get(2);

                if (u == dst) return price;

                if (visited <= k) {
                    visited++;

                    if (graph.containsKey(u)) {
                        for (var v : graph.get(u).entrySet()) {
                            var alt = price + v.getValue();
                            pq.add(List.of(v.getKey(), alt, visited));
                        }
                    }
                }
            }

            return -1;
        }

        /*
         * graph={
         *      0={1=100,2=500},
         *      1={2=200}
         * }
         *
         * pq=[]
         * pq=[[0,0,0]]
         *
         * ===
         * cur=[0,0,0]
         * pq=[]
         * u=0
         * p=0
         * v=0
         * v=1
         *
         * vv={1,100}
         * alt=0+100=100
         * pq=[1,100,1]
         *
         * vv={2,500}
         * alt=0+500=500
         * pq=[[1,100,1],[2,500,1]]
         *
         * ===
         * cur=[1,100,1]
         * pq=[[2,500,1]]
         * u=1
         * p=100
         * v=1
         *
         * ===
         * cur=[2,500,1]
         * pq=[]
         * u=2
         * p=500
         * v=1
         */

        public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
            var graph = new HashMap<Integer, Map<Integer, Integer>>();
            for (var flight : flights) {
                graph.putIfAbsent(flight[0], new HashMap<>());
                graph.get(flight[0]).put(flight[1], flight[2]);
            }

            var pq = new PriorityQueue<List<Integer>>(Comparator.comparingInt(a -> a.get(1)));
            pq.add(List.of(src, 0, 0));

            var visited = new HashMap<Integer, Integer>();

            while (!pq.isEmpty()) {
                var cur = pq.poll();
                var u = cur.get(0);
                var price = cur.get(1);
                var kVisited = cur.get(2);

                if (dst == u) return price;

                visited.put(u, kVisited);

                if (kVisited <= k) {
                    kVisited++;

                    if (graph.containsKey(u)) {
                        for (var v : graph.get(u).entrySet()) {
                            if (!visited.containsKey(v.getKey()) || kVisited < visited.get(v.getKey())) {
                                var alt = price + v.getValue();
                                pq.add(List.of(v.getKey(), alt, kVisited));
                            }
                        }
                    }
                }
            }

            return -1;
        }
    }
}
