package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArcheryCompetitionTest {
    private final Solution sut = new Solution();

    /*
     * 더 많은 화살을 k점에 맞힌 선수가 k점을 가져가는 양궁대회에서,
     * 어피치가 화살을 다 쏜 후 라이언이 가장 큰 점수 차이로 이기기 위해서는 어떤 과녁 점수에 맞혀야 하는지 출력하라.
     */

    @Test
    public void test_solution() {
        var n = 5;
        var info = new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        var actual = sut.solution(n, info);
        assertArrayEquals(
                new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0},
                actual
        );
    }

    private static class Solution {
        private int maxScore = 0;
        private int[] info;
        private int[] answer = new int[11];

        public int[] solution(int n, int[] info) {
            this.info = info;

            dfs(0, new int[11], n);

            if (maxScore == 0)
                return new int[]{-1};

            return answer;
        }

        private void dfs(int index, int[] lion, int arrow) {
            if (index == 11) {
                lion[10] = arrow;

                int score = calcScore(lion);

                if (score > maxScore) {
                    maxScore = score;
                    answer = Arrays.copyOf(lion, lion.length);
                } else if (score == maxScore) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] == answer[i]) continue;

                        if (lion[i] > answer[i]) {
                            answer = Arrays.copyOf(lion, lion.length);
                            break;
                        }
                    }
                }

                return;
            }

            if (info[index] < arrow) {
                lion[index] = info[index] + 1;
                dfs(index + 1, lion, arrow - lion[index]);
                lion[index] = 0;
            }

            dfs(index + 1, lion, arrow);
        }

        private int calcScore(int[] lion) {
            var diff = 0;
            for (var i = 0; i <= 10; i++) {
                if (lion[i] == 0 && info[i] == 0) continue;

                diff = (lion[i] > info[i]) ? diff + (10 - i) : diff - (10 - i);
            }

            return diff;
        }
    }
}
