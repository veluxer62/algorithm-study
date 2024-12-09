package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkDelayTimeTest {
    private final Solution sut = new Solution();

    /*
     * k에서 출발해 모든 노드가 신호를 받을 수 있는 시간을 계산하라. 한 군데라도 노드에 도달할 수 없는 경우 -1을 리턴한다.
     * 입력값(u, v, w)는 각각 출발지, 도착지, 소요 시간으로 구성되며, 전체 노드의 개수는 n이다.
     */

    @Test
    public void test_networkDelayTime() {
        var times = new int[][]{
                new int[]{3, 1, 5},
                new int[]{3, 2, 2},
                new int[]{2, 1, 2},
                new int[]{3, 4, 1},
                new int[]{4, 5, 1},
                new int[]{5, 6, 1},
                new int[]{6, 7, 1},
                new int[]{7, 8, 1},
                new int[]{8, 1, 1},
        };
        var n = 8;
        var k = 3;
        var actual = sut.networkDelayTime(times, n, k);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            var graph = new HashMap<Integer, Map<Integer, Integer>>();
            for (var time : times) {
                graph.putIfAbsent(time[0], new HashMap<>());
                graph.get(time[0]).putIfAbsent(time[1], time[2]);
            }

            var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(Map.Entry.comparingByValue());
            pq.add(new AbstractMap.SimpleEntry<>(k, 0));

            var dist = new HashMap<Integer, Integer>();
            while (!pq.isEmpty()) {
                var cur = pq.poll();
                var u = cur.getKey();
                var dist_u = cur.getValue();

                if (!dist.containsKey(u)) {
                    dist.put(u, dist_u);

                    if (graph.containsKey(u)) {
                        for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                            var alt = dist_u + v.getValue();
                            pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                        }
                    }
                }
            }

            if (dist.size() == n) {
                return Collections.max(dist.values());
            }

            return -1;
        }

        /*
         * graph = {
         *      3={1=5},
         *      3={2=2},
         *      2={1=2},
         *      3={4=1},
         *      4={5=1},
         *      5={6=1},
         *      6={7=1},
         *      7={8=1},
         *      8={1=1},
         * }
         *
         * pq=[]
         * pq=[{3=0}]
         * dist={}
         *      ====
         *      cur={3=0}
         *      pq=[]
         *      u=3
         *      dist_u=0
         *      dist={3=0}
         *
         *      v={1,5}
         *      alt=0+5=5
         *      pq=[{1=5}]
         *
         *      v={2,2}
         *      alt=0+2=2
         *      pq=[{2=2},{1=5}]
         *
         *      v={4,1}
         *      alt=0+1=1
         *      pq=[{4=1},{2=2},{1=5}]
         *
         *      ====
         *      cur={4=1}
         *      pq=[{2=2},{1=5}]
         *      u=4
         *      dist_u=1
         *      dist={3=0,4=1}
         *
         *      v={5,1}
         *      alt=1+1=2
         *      pq=[{2=2},{5=2},{1=5}]
         *
         *      ====
         *      cur={2=2}
         *      pq=[{5=2},{1=5}]
         *      u=2
         *      dist_u=2
         *      dist={3=0,4=1,2=2}
         *
         *      v={1,2}
         *      alt=2+2=4
         *      pq=[{5=2},{1=4},{1=5}]
         *
         *      ====
         *      cur={5=2}
         *      pq=[{1=4},{1=5}]
         *      u=5
         *      dist_u=2
         *      dist={3=0,4=1,2=2,5=2}
         *
         *      v={6,1}
         *      alt=2+1=3
         *      pq=[{6=3},{1=4},{1=5}]
         *
         *      ====
         *      cur={6,3}
         *      pq=[{1=4},{1=5}]
         *      u=6
         *      dist_u=3
         *      dist={3=0,4=1,2=2,5=2,6=3}
         *
         *      v={7,1}
         *      alt=3+1=4
         *      pa=[{1=4},{7=4},{1=5}]
         *
         *      ====
         *      cur={1,4}
         *      pq=[{7=4},{1=5}]
         *      u=1
         *      dist_u=4
         *      dist={3=0,4=1,2=2,5=2,6=3,1=4}
         *
         *      ====
         *      cur={7,4}
         *      pq=[{1=5}]
         *      u=7
         *      dist_u=4
         *      dist={3=0,4=1,2=2,5=2,6=3,1=4,7=4}
         *
         *      v={8,1}
         *      alt=4+1=5
         *      pq=[{1=5},{8=5}]
         *
         *      ====
         *      cur={1,5}
         *      pq=[{8=5}]
         *      u=1
         *      dist_u=5
         *
         *      ====
         *      cur={8,5}
         *      pq=[]
         *      u=8
         *      dist_u=5
         *      dist={3=0,4=1,2=2,5=2,6=3,1=4,7=4,8=5}
         *
         *      v={1,1}
         *      alt=5+1=6
         *      pq=[{1=6}]
         *
         *      ====
         *      cur={1,6}
         *      pa=[]
         *      u=1
         *      dist_u=6
         */
    }
}
