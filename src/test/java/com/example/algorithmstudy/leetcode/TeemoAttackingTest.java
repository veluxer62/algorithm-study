package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeemoAttackingTest {
    private final Solution sut = new Solution();

    /*

    Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds after the new attack.

    You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.

    Return the total number of seconds that Ashe is poisoned.



    Example 1:

    Input: timeSeries = [1,4], duration = 2
    Output: 4
    Explanation: Teemo's attacks on Ashe go as follows:
    - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
    - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
    Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
    Example 2:

    Input: timeSeries = [1,2], duration = 2
    Output: 3
    Explanation: Teemo's attacks on Ashe go as follows:
    - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
    - At second 2 however, Teemo attacks again and resets the poison timer. Ashe is poisoned for seconds 2 and 3.
    Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.


    Constraints:

    1 <= timeSeries.length <= 104
    0 <= timeSeries[i], duration <= 107
    timeSeries is sorted in non-decreasing order.

     */

    @Test
    public void test_findPoisonedDuration() {
        var timeSeries = new int[]{1,4};
        var duration = 2;
        var actual = sut.findPoisonedDuration(timeSeries, duration);
        assertEquals(4, actual);

        timeSeries = new int[]{1,2};
        duration = 2;
        actual = sut.findPoisonedDuration(timeSeries, duration);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            var set = new HashSet<Integer>();

            for (int num : timeSeries) {
                for (var j = 0; j < duration; j++) {
                    set.add(num + j);
                }
            }

            return set.size();
        }

        public int findPoisonedDuration2(int[] timeSeries, int duration) {
            if (timeSeries.length == 0) {
                return 0;
            }

            int totalDuration = 0;

            for (int i = 0; i < timeSeries.length - 1; i++) {
                // 현재 공격과 다음 공격 사이의 시간 간격
                int interval = timeSeries[i + 1] - timeSeries[i];
                // 중첩되지 않은 부분은 interval만큼, 중첩된 부분은 duration만큼 더함
                totalDuration += Math.min(interval, duration);
            }

            // 마지막 공격은 중첩되지 않으므로 duration 전체를 더함
            totalDuration += duration;

            return totalDuration;
        }
    }
}
