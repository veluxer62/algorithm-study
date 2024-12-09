package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWaterTest {
    private final Solution sut = new Solution();

    /*
     * 높이를 입력받아 비온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
     */

    @Test
    public void test_trap() {
        var heights = new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        var actual = record(() -> sut.trap(heights));
        assertEquals(6, actual);
    }

    @Test
    public void test_trap2() {
        var heights = new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        var actual = record(() -> sut.trap2(heights));
        assertEquals(6, actual);
    }

    private static class Solution {
        public int trap(int[] height) {
            var volume = 0;
            var left = 0;
            var right = height.length - 1;
            var leftMax = height[left];
            var rightMax = height[right];

            while (left < right) {
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);

                if (leftMax <= rightMax) {
                    volume += leftMax - height[left];
                    left++;
                } else {
                    volume += rightMax - height[right];
                    right--;
                }
            }

            return volume;
        }
        /*
        volume=0
        left=0
        right=11
        leftMax=1
        rightMax=1


        1
        --
        0 < 11
        leftMax = 1,1 = 1
        rightMax = 1,1 = 1

        1 <= 1
        volume=0 (0 + 1 - 1)
        left=1


        2
        --
        1 < 11
        lm = 1,1 = 1
        rm = 1,1 = 1

        1 <= 1
        v=0 (0 + 1 -1)
        l=2


        3
        --
        2 < 11
        lm = 0,1 = 1
        rm = 1,1 = 1

        1 <= 1
        v = 1 (0 + 1 - 0)
        l=3


        4
        --
        3 < 11
        lm = 2,1 = 2
        rm = 1,1 = 1

        2 <= 1
        v = 1 (1 + 1 - 1)
        r=10


        5
        --
        3 < 10
        lm = 2,2 = 2
        rm = 2,1 = 2

        2 <= 2
        v = 1 + 2 - 2 = 1
        l = 4


        6
        --
        4 < 10
        lm = 1,2 = 2
        rm = 2,2 = 2

        2 <= 2
        v = 1 + 2 - 1 = 2
        l = 5


        7
        --
        5 < 10
        lm = 0,2 = 2
        rm = 2,2 = 2

        2 <= 2
        v = 2 + 2 - 0 = 4
        l = 6


        8
        --
        6 < 10
        lm = 1,2 = 2
        rm = 2,2 = 2

        2 <= 2
        v = 4 + 2 - 1 = 5
        l = 7


        9
        --
        7 < 10
        lm = 3,2 = 3
        rm = 2,2 = 2

        3 <= 2
        v = 5 + 2 - 2 = 5
        r = 9


        10
        --
        7 < 9
        lm = 3,3 = 3
        rm = 1,2 = 2

        3 <= 2
        v = 5 + 2 - 1 = 6
        r = 8


        11
        --
        7 < 8
        lm = 3,3 = 3
        rm = 2,2 = 2

        3 <= 2
        v = 6 + 2 - 2
        r = 7
         */

        public int trap2(int[] height) {
            var stack = new ArrayDeque<Integer>();
            var volume = 0;

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    var top = stack.pop();

                    if (stack.isEmpty()) break;

                    var distance = i - stack.peek() - 1;
                    var waters = Math.min(height[i], height[stack.peek()] - height[top]);

                    volume += distance * waters;
                }

                stack.push(i);
            }

            return volume;
        }

        /*
        s = []
        v = 0

        i = 0
        --
        s = [0]


        i = 1
        --
        1 > 1
        s = [0,1]


        i = 2
        --
        0 > 1
        s = [0,1,2]


        i = 3
        --
        2 > 0
        t = 2
        s = [0,1]
        d = 3 - 1 - 1 = 1
        w = 2,1-0 = 1
        v = 0 + 1 * 1 = 1

        --
        2 > 1
        t = 1
        s = [0]
        d = 3 - 1 - 1 = 1
        w = 2,1-1 = 0
        v = 1 + 1 * 0 = 1

        --
        2 > 1
        t = 0
        s = []
        s = [3]


        i = 4
        --
        1 > 3
        s = [3,4]


        i = 5
        --
        0 > 1
        s = [3,4,5]


        i = 6
        --
        1 > 0
        t = 5
        s = [3,4]
        d = 6 - 4 - 1 = 1
        w = 1,1-0 = 1
        v = 1 + 1*1 = 2

        --
        1 > 1
        s = [3,4,6]


        i = 7
        --
        3 > 1
        t = 6
        s = [3,4]
        d = 7 - 4 - 1 = 2
        w = 3,1-1 = 0
        v = 2 + 2 * 0 = 2

        --
        3 > 1
        t = 4
        s = [3]
        d = 7 - 3 - 1 = 3
        w = 3,2-1 = 1
        v = 2 + 3 * 1 = 5

        --
        3 > 2
        t = 3
        s = []
        s = [7]


        i = 8
        --
        2 > 3
        s = [7,8]


        i = 9
        --
        1 > 2
        s = [7,8,9]


        i = 10
        --
        2 > 1
        t = 9
        s = [7,8]
        d = 10 - 8 - 1 = 1
        w = 2,2-1 = 1
        v = 5 + 1 * 1 = 6

        --
        2 > 2
        s = [7,8,10]


        i = 11
        --
        1 > 2
        s = [7,8,10,11]
         */
    }
}
