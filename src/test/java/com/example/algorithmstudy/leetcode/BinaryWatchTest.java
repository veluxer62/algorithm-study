package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryWatchTest {
    private final Solution sut = new Solution();

    /*

    A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

    For example, the below binary watch reads "4:51".


    Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

    The hour must not contain a leading zero.

    For example, "01:00" is not valid. It should be "1:00".
    The minute must consist of two digits and may contain a leading zero.

    For example, "10:2" is not valid. It should be "10:02".


    Example 1:

    Input: turnedOn = 1
    Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
    Example 2:

    Input: turnedOn = 9
    Output: []


    Constraints:

    0 <= turnedOn <= 10

     */

    @Test
    public void test_readBinaryWatch() {
        var turnedOn = 1;
        var actual = sut.readBinaryWatch(turnedOn);
        assertEquals(
                List.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00"),
                actual
        );

        turnedOn = 9;
        actual = sut.readBinaryWatch(turnedOn);
        assertEquals(
                List.of(),
                actual
        );
    }

    private static class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> result = new ArrayList<>();

            for (int hour = 0; hour < 12; hour++) {
                for (int minute = 0; minute < 60; minute++) {
                    if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                        result.add(String.format("%d:%02d", hour, minute));
                    }
                }
            }

            return result;
        }
    }
}
