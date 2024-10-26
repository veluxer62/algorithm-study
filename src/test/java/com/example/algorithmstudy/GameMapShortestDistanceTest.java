package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMapShortestDistanceTest {
    private final Solution sut = new Solution();

    /*
     * 상대 팀 진영에 도착할 수 있는 최단 거리를 출력하라.
     */

    @Test
    public void test_shortestDistance() {
        var maps = new int[][]{
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 1, 1, 0, 1},
                new int[]{0, 0, 0, 0, 1},
        };
        var actual = sut.shortestDistance(maps);
        assertEquals(11, actual);

        maps = new int[][]{
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 1},
        };
        actual = sut.shortestDistance(maps);
        assertEquals(-1, actual);
    }

    private static class Solution {
        private final PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        public int shortestDistance(int[][] maps) {
            var dist = new LinkedHashMap<Integer, Position>();

            pq.add(new Position(0, 0, 1));
            while (!pq.isEmpty()) {
                var cur = pq.poll();

                if (!dist.containsKey(cur.key)) {
                    dist.put(cur.key, cur);

                    findPath(cur.y, cur.x + 1, cur.distance, maps);
                    findPath(cur.y, cur.x - 1, cur.distance, maps);
                    findPath(cur.y + 1, cur.x, cur.distance, maps);
                    findPath(cur.y - 1, cur.x, cur.distance, maps);
                }
            }

            if (dist.containsKey(((maps.length - 1) * 1000) + (maps[0].length - 1))) {
                return dist.get(((maps.length - 1) * 1000) + (maps[0].length - 1)).distance;
            }

            return -1;
        }

        private void findPath(int y, int x, int distance, int[][] maps) {
            if (y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
                maps[y][x] = 0;
                pq.add(new Position(y, x, distance + 1));
            }
        }

        private static class Position {
            final int y;
            final int x;
            final int distance;
            final int key;

            public Position(int y, int x, int distance) {
                this.y = y;
                this.x = x;
                this.distance = distance;
                this.key = y * 1000 + x;
            }
        }
    }
}
