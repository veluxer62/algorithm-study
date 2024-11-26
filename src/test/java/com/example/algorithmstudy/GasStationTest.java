package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GasStationTest {
    private final Solution sut = new Solution();

    /*
     * 원형으로 경로가 연결된 주유소 목록이 있다. 각 주유소는 gas[i]만큼의 기름을 보유하고 있으며, 다음 주유소로 이동하는데 cost[i]가 필요하다.
     * 기름이 부족하면 이동할 수 없다고 할 때 주유소를 방문할 수 있는 출발점의 인덱스를 출력하라.
     */

    @Test
    public void test_canCompleteCircuit() {
        var gas = new int[]{5, 1, 2, 3, 4};
        var cost = new int[]{4, 4, 1, 5, 1};

        var actual = sut.canCompleteCircuit(gas, cost);

        assertEquals(4, actual);
    }

    @Test
    public void test_canCompleteCircuit2() {
        var gas = new int[]{5, 1, 2, 3, 4};
        var cost = new int[]{4, 4, 1, 5, 1};

        var actual = sut.canCompleteCircuit2(gas, cost);

        assertEquals(4, actual);
    }

    private static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for (var start = 0; start < gas.length; start++) {
                var fuel = 0;
                var canTravel = true;

                for (var i = start; i < gas.length + start; i++) {
                    var index = i % gas.length;

                    if (fuel + gas[index] - cost[index] < 0) {
                        canTravel = false;
                        break;
                    } else {
                        fuel += gas[index] - cost[index];
                    }
                }

                if (canTravel) return start;
            }

            return -1;
        }

        public int canCompleteCircuit2(int[] gas, int[] cost) {
            if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
                return -1;

            int start = 0, fuel = 0;

            for (var i = 0; i < gas.length; i++) {
                if (fuel + gas[i] - cost[i] < 0) {
                    start = i + 1;
                    fuel = 0;
                } else {
                    fuel += gas[i] - cost[i];
                }
            }

            return start;
        }
    }
}
