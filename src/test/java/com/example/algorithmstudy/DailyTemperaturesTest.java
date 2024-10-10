package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DailyTemperaturesTest {
    private final Solution sut = new Solution();

    /*
     * 매일의 온도 리스트 temperatures를 입력받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는지를 출력하라.
     */

    @Test
    public void test_dailyTemperatures() {
        var t = new int[]{23, 24, 25, 21, 19, 22, 26, 23};
        var actual = sut.dailyTemperatures(t);
        assertArrayEquals(
                new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                actual
        );
    }

    private static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            var result = new int[temperatures.length];
            var stack = new ArrayDeque<Integer>();

            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    var last = stack.pop();
                    result[last] = i - last;
                }
                stack.push(i);
            }

            return result;
        }

        /*
         * temp=[23,24,25,21,19,22,26,23]
         * r=[]
         * s=[]
         *
         * i=0
         * false
         * s=[0]
         *
         * i=1
         * true && 24 > 23
         * l=0
         * s=[]
         * r=[1]
         * s=[1]
         *
         * i=2
         * true && 25 > 24
         * l=1
         * s=[]
         * r=[1,1]
         * s=[2]
         *
         * i=3
         * true && 21 > 25
         * s=[2,3]
         *
         * i=4
         * true && 19 > 21
         * s=[2,3,4]
         *
         * i=5
         * true && 22 > 19
         * l=4
         * s=[2,3]
         * r=[1,1,0,0,1]
         * true && 22 > 21
         * l=3
         * s=[2]
         * r=[1,1,0,2,1]
         * true && 22 > 25
         * s=[2,5]
         *
         * i=6
         * true && 26 > 22
         * l=5
         * s=[2]
         * r=[1,1,0,2,1,1]
         * true && 26 > 25
         * l=2
         * s=[]
         * r=[1,1,4,2,1,1,0,0]
         * s=[6]
         *
         * i=7
         * true && 23 > 26
         * s=[6,7]
         */
    }
}
