package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTest {
    private final Solution sut = new Solution();

    /*
     * 문자열을 뒤집는 함수를 작성하라, 입력값은 문자 배열이며, 리턴 없이 입력 배열 내부를 직접 조작하라.
     */

    @Test
    public void test_reverseString() {
        char[] given = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        sut.reverseString(given);
        assertArrayEquals(new char[]{'r', 'a', 'c', 'e', 'c', 'a', 'r'}, given);

        given = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        sut.reverseString(given);
        assertArrayEquals(new char[]{'g', 'f', 'e', 'd', 'c', 'b', 'a'}, given);
    }

    static class Solution {
        public void reverseString(char[] arr) {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }
    }
}
