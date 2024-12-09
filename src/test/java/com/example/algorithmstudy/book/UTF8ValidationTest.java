package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UTF8ValidationTest {
    private final Solution sut = new Solution();

    /*
     * 입력값이 UTF-8 문자열이 맞는지 검증하라.
     */

    @Test
    public void test_isValid() {
        var data = new int[] {197, 130, 2};
        var actual = sut.isValid(data);
        assertTrue(actual);

        data = new int[] {235, 140, 5};
        actual = sut.isValid(data);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isValid(int[] data) {
            var start = 0;

            while (start < data.length) {
                var first = data[start];

                if (first >> 3 == 0b11110 && check(data, start, 3)) {
                    start += 4;
                } else if (first >> 4 == 0b1110 && check(data, start, 2)) {
                    start += 3;
                } else if (first >> 5 == 0b110 && check(data, start, 1)) {
                    start += 2;
                } else if (first >> 7 == 0) {
                    start++;
                } else {
                    return false;
                }
            }

            return true;
        }

        private boolean check(int[] data, int start, int size) {
            for (int i = start + 1; i < start + size + 1; i++) {
                if (i >= data.length || data[i] >> 6 != 0b10) {
                    return false;
                }
            }

            return true;
        }
    }
}
