package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelfDividingNumbersTest {
    private final Solution sut = new Solution();

    /*

    A self-dividing number is a number that is divisible by every digit it contains.

    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    A self-dividing number is not allowed to contain the digit zero.

    Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).



    Example 1:

    Input: left = 1, right = 22
    Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
    Example 2:

    Input: left = 47, right = 85
    Output: [48,55,66,77]


    Constraints:

    1 <= left <= right <= 104

     */

    @Test
    public void test_selfDividingNumbers() {
        var left = 1;
        var right = 22;
        var actual = sut.selfDividingNumbers(left, right);
        assertEquals(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22),
                actual
        );

        left = 47;
        right = 85;
        actual = sut.selfDividingNumbers(left, right);
        assertEquals(
                List.of(48, 55, 66, 77),
                actual
        );
    }

    @Test
    public void test_selfDividingNumbers2() {
        var left = 1;
        var right = 22;
        var actual = sut.selfDividingNumbers2(left, right);
        assertEquals(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22),
                actual
        );

        left = 47;
        right = 85;
        actual = sut.selfDividingNumbers2(left, right);
        assertEquals(
                List.of(48, 55, 66, 77),
                actual
        );
    }

    private static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            var list = new ArrayList<Integer>();

            for (int i = left; i <= right; i++) {
                if (isSelfDividingNumber(i)) {
                    list.add(i);
                }
            }

            return list;
        }

        private boolean isSelfDividingNumber(int num) {
            var n = String.valueOf(num);
            for (var c : n.toCharArray()) {
                if (c - '0' == 0 || num % (c - '0') != 0) return false;
            }

            return true;
        }

        public List<Integer> selfDividingNumbers2(int left, int right) {
            List<Integer> list = new ArrayList<>();

            for(int number = left; number <= right; number++){
                if(isSelfDevide(number)) list.add(number);
            }
            return list;
        }
        private boolean isSelfDevide(int num){
            int ogNum = num;

            while(num > 0){
                int digit = num % 10;
                num /= 10;

                if(digit == 0 || ogNum % digit != 0)    return false;
            }

            return true;
        }
    }
}
