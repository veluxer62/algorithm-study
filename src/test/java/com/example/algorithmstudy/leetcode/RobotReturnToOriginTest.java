package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotReturnToOriginTest {
    private final Solution sut = new Solution();

    /*

    There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

    You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).

    Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.

    Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.



    Example 1:

    Input: moves = "UD"
    Output: true
    Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
    Example 2:

    Input: moves = "LL"
    Output: false
    Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.


    Constraints:

    1 <= moves.length <= 2 * 104
    moves only contains the characters 'U', 'D', 'L' and 'R'.

     */

    @Test
    public void test_judgeCircle() {
        var moves = "UD";
        var actual = sut.judgeCircle(moves);
        assertTrue(actual);

        moves = "LL";
        actual = sut.judgeCircle(moves);
        assertFalse(actual);
    }

    @Test
    public void test_judgeCircle2() {
        var moves = "UD";
        var actual = sut.judgeCircle2(moves);
        assertTrue(actual);

        moves = "LL";
        actual = sut.judgeCircle2(moves);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean judgeCircle(String moves) {
            var countMap = new HashMap<Character, Integer>();
            for (var c : moves.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            var r = countMap.getOrDefault('R', 0);
            var l = countMap.getOrDefault('L', 0);
            var u = countMap.getOrDefault('U', 0);
            var d = countMap.getOrDefault('D', 0);

            return r.equals(l) && u.equals(d);
        }

        public boolean judgeCircle2(String moves) {
            int left = 0, right = 0, up = 0, down = 0;

            for (var c : moves.toCharArray()) {
                if (c == 'L') left++;
                else if (c == 'R') right++;
                else if (c == 'U') up++;
                else if (c == 'D') down++;
            }

            return left == right && up == down;
        }
    }
}
