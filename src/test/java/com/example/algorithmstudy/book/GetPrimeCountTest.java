package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPrimeCountTest {
    private final Solution sut = new Solution();

    /*
     * 숫자를 k진수로 변환하고 0으로 구분했을 때 소수가 몇 개인지 출력하라.
     */

    @Test
    public void test_getPrimeCount() {
        var n = 437674;
        var k = 3;
        var actual = sut.getPrimeCount(n, k);
        assertEquals(3, actual);

        n = 110011;
        k = 10;
        actual = sut.getPrimeCount(n, k);
        assertEquals(2, actual);
    }

    @Test
    public void test_getPrimeCount2() {
        var n = 437674;
        var k = 3;
        var actual = sut.getPrimeCount2(n, k);
        assertEquals(3, actual);

        n = 110011;
        k = 10;
        actual = sut.getPrimeCount2(n, k);
        assertEquals(2, actual);
    }

    @Test
    public void test_getPrimeCount3() {
        var n = 437674;
        var k = 3;
        var actual = sut.getPrimeCount3(n, k);
        assertEquals(3, actual);

        n = 110011;
        k = 10;
        actual = sut.getPrimeCount3(n, k);
        assertEquals(2, actual);
    }

    @Test
    public void test_getPrimeCount4() {
        var n = 437674;
        var k = 3;
        var actual = sut.getPrimeCount4(n, k);
        assertEquals(3, actual);

        n = 110011;
        k = 10;
        actual = sut.getPrimeCount4(n, k);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int getPrimeCount(int n, int k) {
            var stack = new ArrayDeque<Integer>();
            int remainder;

            while (n != 0) {
                remainder = n % k;
                n /= k;
                stack.push(remainder);
            }

            var sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            var answer = 0;
            for (var s : sb.toString().split("0")) {
                if (s.isEmpty()) continue;

                if (isPrime(Integer.parseInt(s))) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean isPrime(int num) {
            if (num == 1) return false;

            for (int i = 3; i < num; i++) {
                if (num % i == 0) return false;
            }

            return true;
        }

        public int getPrimeCount2(int n, int k) {
            var stack = new ArrayDeque<Integer>();
            int remainder;
            while (n != 0) {
                remainder = n % k;
                n /= k;
                stack.push(remainder);
            }

            var sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            var answer = 0;
            for (var s : sb.toString().split("0")) {
                if (s.isEmpty()) continue;

                if (isPrime2(Long.parseLong(s))) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean isPrime2(long num) {
            if (num == 1) return false;

            for (int i = 3; i < num; i++) {
                if (num % i == 0) return false;
            }

            return true;
        }

        public int getPrimeCount3(int n, int k) {
            var stack = new ArrayDeque<Integer>();
            int remainder;
            while (n != 0) {
                remainder = n % k;
                n /= k;
                stack.push(remainder);
            }

            var sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            var answer = 0;
            for (var s : sb.toString().split("0")) {
                if (s.isEmpty()) continue;

                if (isPrime3(Long.parseLong(s))) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean isPrime3(long num) {
            if (num == 1) return false;
            if (num > 2 && num % 2 == 0) return false;

            for (int i = 3; i < (int) Math.sqrt(num); i+=2) {
                if (num % i == 0) return false;
            }

            return true;
        }

        public int getPrimeCount4(int n, int k) {
            var str = Integer.toString(n, k);

            var answer = 0;
            for (var s : str.split("0")) {
                if (s.isEmpty()) continue;

                if (isPrime3(Long.parseLong(s))) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
