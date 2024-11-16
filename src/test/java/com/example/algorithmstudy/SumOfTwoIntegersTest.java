package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfTwoIntegersTest {
    private final Solution sut = new Solution();

    /*
     * 두 정수 a와 b의 합을 구하라. + 또는 - 연산자는 사용할 수 없다.
     */

    @Test
    public void test_sum() {
        var a = -3;
        var b = 2;
        var actual = sut.sum(a, b);
        assertEquals(-1, actual);
    }

    @Test
    public void test_sum2() {
        var a = -3;
        var b = 2;
        var actual = sut.sum2(a, b);
        assertEquals(-1, actual);
    }

    private static class Solution {
        public int sum(int a, int b) {
            var binA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
            var binB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');

            var result = new ArrayList<Character>();
            var carry = 0;
            var sum = 0;

            for (var i = 0; i < 32; i++) {
                var A = Character.getNumericValue(binA.charAt(31 - i));
                var B = Character.getNumericValue(binB.charAt(31 - i));

                var Q1 = A & B;
                var Q2 = A ^ B;
                var Q3 = Q2 & carry;
                sum = carry ^ Q2;
                carry = Q1 | Q3;

                result.add(0, Character.forDigit(sum, 2));
            }

            return Integer.parseUnsignedInt(
                    result.stream().map(String::valueOf).collect(Collectors.joining("")),
                    2
            );
        }

        public int sum2(int a, int b) {
            while (b != 0) {
                var carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }

            return a;
        }
    }
}
