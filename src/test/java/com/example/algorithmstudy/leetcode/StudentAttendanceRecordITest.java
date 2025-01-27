package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentAttendanceRecordITest {
    private final Solution sut = new Solution();

    /*

    You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

    'A': Absent.
    'L': Late.
    'P': Present.
    The student is eligible for an attendance award if they meet both of the following criteria:

    The student was absent ('A') for strictly fewer than 2 days total.
    The student was never late ('L') for 3 or more consecutive days.
    Return true if the student is eligible for an attendance award, or false otherwise.



    Example 1:

    Input: s = "PPALLP"
    Output: true
    Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
    Example 2:

    Input: s = "PPALLL"
    Output: false
    Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.


    Constraints:

    1 <= s.length <= 1000
    s[i] is either 'A', 'L', or 'P'.

     */

    @Test
    public void test_checkRecord() {
        var s = "PPALLP";
        var actual = sut.checkRecord(s);
        assertTrue(actual);

        s = "PPALLL";
        actual = sut.checkRecord(s);
        assertFalse(actual);

        s = "LALL";
        actual = sut.checkRecord(s);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean checkRecord(String s) {
            var aCount = 0;
            var lCount = 0;
            Character prev = null;

            for (char c : s.toCharArray()) {
                if (c == 'A') {
                    if (aCount == 1) return false;
                    aCount++;
                } else if (c == 'L') {
                    if (prev != null && prev == 'L') {
                        lCount++;
                    } else {
                        lCount = 0;
                    }
                    if (lCount == 2) return false;
                }
                prev = c;
            }

            return true;
        }
    }
}
