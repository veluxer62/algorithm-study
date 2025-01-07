package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelSheetColumnNumberTest {
    private final Solution sut = new Solution();

    /*

    Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...


    Example 1:

    Input: columnTitle = "A"
    Output: 1
    Example 2:

    Input: columnTitle = "AB"
    Output: 28
    Example 3:

    Input: columnTitle = "ZY"
    Output: 701


    Constraints:

    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].

     */

    @Test
    public void test_titleToNumber() {
        var columnTitle = "A";
        var actual = sut.titleToNumber(columnTitle);
        assertEquals(1, actual);

        columnTitle = "AB";
        actual = sut.titleToNumber(columnTitle);
        assertEquals(28, actual);

        columnTitle = "ZY";
        actual = sut.titleToNumber(columnTitle);
        assertEquals(701, actual);

        columnTitle = "FXSHRXW";
        actual = sut.titleToNumber(columnTitle);
        assertEquals(2147483647, actual);
    }

    private static class Solution {
        public int titleToNumber(String columnTitle) {
            var result = 0;

            for (var i = columnTitle.length() - 1; i >= 0; i--) {
                var num = columnTitle.charAt(i) - 'A' + 1;
                var s = columnTitle.length() - i - 1;
                result += num * (int) Math.pow(26, s);
            }

            return result;
        }
    }
}
