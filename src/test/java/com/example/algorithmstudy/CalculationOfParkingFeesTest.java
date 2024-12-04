package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CalculationOfParkingFeesTest {
    private final Solution sut = new Solution();

    /*
     * 주차장의 요금표와 출차기록이 주어졌을 때, 차량별 주차 요금을 계산해 차량번호가 작은 순으로 출력하라.
     */

    @Test
    public void test_calculateParkingFees() {
        var fees = new int[]{180, 5000, 10, 600};
        var records = new String[]{
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        var actual = sut.calculateParkingFees(fees, records);
        assertArrayEquals(
                new int[]{14600, 34400, 5000},
                actual
        );

        fees = new int[]{120, 0, 60, 591};
        records = new String[]{
                "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"
        };
        actual = sut.calculateParkingFees(fees, records);
        assertArrayEquals(
                new int[]{0, 591},
                actual
        );
    }

    private static class Solution {
        public int[] calculateParkingFees(int[] fees, String[] records) {
            var parkingLogs = new HashMap<String, Integer>();
            var parkingTimes = new HashMap<String, Integer>();

            for (var record : records) {
                var log = record.split(" ");
                var time = log[0].split(":");
                if (log[2].equals("IN")) {
                    parkingLogs.put(log[1], Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
                } else {
                    var elapsedTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) - parkingLogs.get(log[1]);
                    parkingTimes.put(log[1], parkingTimes.getOrDefault(log[1], 0) + elapsedTime);
                    parkingLogs.remove(log[1]);
                }
            }

            for (var log : parkingLogs.entrySet()) {
                parkingTimes.put(
                        log.getKey(),
                        parkingTimes.getOrDefault(log.getKey(), 0) + 23 * 60 + 59 - log.getValue()
                );
            }

            var parkingTimesByKey = new ArrayList<>(parkingTimes.keySet());
            parkingTimesByKey.sort(Comparator.comparingInt(Integer::parseInt));

            var answer = new int[parkingTimesByKey.size()];
            var i = 0;
            for (var k : parkingTimesByKey) {
                int fee;

                if (parkingTimes.get(k) <= fees[0]) {
                    fee = fees[1];
                } else {
                    fee = fees[1] + (int) Math.ceil((float) (parkingTimes.get(k) - fees[0]) / fees[2]) * fees[3];
                }

                answer[i] = fee;
                i++;
            }

            return answer;
        }
    }
}
