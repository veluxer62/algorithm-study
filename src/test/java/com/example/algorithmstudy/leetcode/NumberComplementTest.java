package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComplementTest {
    private final Solution sut = new Solution();

    @Test
    public void test_findComplement() {
        var num = 5;
        var actual = sut.findComplement(num);
        assertEquals(2, actual);

        num = 1;
        actual = sut.findComplement(num);
        assertEquals(0, actual);
    }

    @Test
    public void test_findComplement2() {
        var num = 5;
        var actual = sut.findComplement2(num);
        assertEquals(2, actual);

        num = 1;
        actual = sut.findComplement2(num);
        assertEquals(0, actual);
    }

    private static class Solution {
        public int findComplement(int num) {
            String str = Integer.toBinaryString(num);

            StringBuilder res = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    res.append('1');
                } else {
                    res.append('0');
                }
            }

            return Integer.parseInt(res.toString(), 2);
        }

        // 111 - 101 = 010
        public int findComplement2(int num) {
            int i = 0;
            int j = 0;

            while (i < num) {
                i += (int) Math.pow(2, j);
                System.out.println(Integer.toBinaryString(i) + ", i:" + i);
                j++;
            }

            return i - num;
        }
    }
}
