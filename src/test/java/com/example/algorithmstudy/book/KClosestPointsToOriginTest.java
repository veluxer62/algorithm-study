package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KClosestPointsToOriginTest {
    private final Solution sut = new Solution();

    /*
     * 평면상에 points 목록이 있을 때, 원점 (0, 0)에서 가장 가까운 k개의 점 목록을 순서대로 출력하라.
     * 평면상에 있는 두 점의 거리는 유클리드 거리로 한다.
     */

    @Test
    public void test_kClosest() {
        var points = new int[][]{{3, 3}, {6, -1}, {-2, 4}};
        var actual = sut.kClosest(points, 2);
        assertArrayEquals(
                new int[][]{{3, 3}, {-2, 4}},
                actual
        );
    }

    @Test
    public void test_kClosest2() {
        var points = new int[][]{{3, 3}, {6, -1}, {-2, 4}};
        var actual = sut.kClosest2(points, 2);
        assertArrayEquals(
                new int[][]{{3, 3}, {-2, 4}},
                actual
        );
    }

    private static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            var pq = new PriorityQueue<Point>(Comparator.comparingDouble(a -> a.distance));

            for (int[] point : points) {
                var distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
                pq.add(new Point(distance, point));
            }

            var results = new int[k][2];
            for (int i = 0; i < k; i++) {
                results[i] = pq.poll().point;
            }

            return results;
        }

        public int[][] kClosest2(int[][] points, int k) {
            var pq = new PriorityQueue<Point2>(Comparator.comparingLong(a -> a.distance));

            for (int[] point : points) {
                var distance = (long) point[0] * point[0] + (long) point[1] * point[1];
                pq.add(new Point2(distance, point));
            }

            var results = new int[k][2];
            for (int i = 0; i < k; i++) {
                results[i] = pq.poll().point;
            }

            return results;
        }

        private static class Point {
            double distance;
            int[] point;

            public Point(double distance, int[] point) {
                this.distance = distance;
                this.point = point;
            }
        }

        private static class Point2 {
            long distance;
            int[] point;

            public Point2(long distance, int[] point) {
                this.distance = distance;
                this.point = point;
            }
        }
    }
}
