package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HammingDistanceTest {
    private final Solution sut = new Solution();

    /*

    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, return the Hamming distance between them.



    Example 1:

    Input: x = 1, y = 4
    Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑
    The above arrows point to positions where the corresponding bits are different.
    Example 2:

    Input: x = 3, y = 1
    Output: 1


    Constraints:

    0 <= x, y <= 231 - 1


     */

    @Test
    public void test_hammingDistance() {
        var x = 1;
        var y = 4;
        var actual = sut.hammingDistance(x, y);
        assertEquals(2, actual);

        x = 3;
        y = 1;
        actual = sut.hammingDistance(x, y);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int hammingDistance(int x, int y) {
            // 두 수의 XOR 결과를 구함
            int xor = x ^ y;

            // XOR 결과에서 1의 개수를 세기 위한 변수
            int count = 0;

            // 1의 개수 세기
            while (xor != 0) {
                count += xor & 1; // 최하위 비트가 1인지 확인
                xor >>= 1;        // 오른쪽으로 비트를 이동
            }

            return count;
        }
    }
}
