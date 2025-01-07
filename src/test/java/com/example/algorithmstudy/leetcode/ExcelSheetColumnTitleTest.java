package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelSheetColumnTitleTest {
    private final Solution sut = new Solution();

    /*

    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

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

    Input: columnNumber = 1
    Output: "A"
    Example 2:

    Input: columnNumber = 28
    Output: "AB"
    Example 3:

    Input: columnNumber = 701
    Output: "ZY"


    Constraints:

    1 <= columnNumber <= 231 - 1

     */

    @Test
    public void test_convertToTitle() {
        var columnNumber = 1;
        var actual = sut.convertToTitle(columnNumber);
        assertEquals("A", actual);

        columnNumber = 28;
        actual = sut.convertToTitle(columnNumber);
        assertEquals("AB", actual);

        columnNumber = 701;
        actual = sut.convertToTitle(columnNumber);
        assertEquals("ZY", actual);

        columnNumber = 260;
        actual = sut.convertToTitle(columnNumber);
        assertEquals("IZ", actual);
    }

    private static class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder columnTitle = new StringBuilder();

            while (columnNumber > 0) {
                columnNumber--;

                int remainder = columnNumber % 26;

                char letter = (char) (remainder + 'A');
                columnTitle.append(letter);

                columnNumber /= 26;
            }

            return columnTitle.reverse().toString();
        }
    }
}
