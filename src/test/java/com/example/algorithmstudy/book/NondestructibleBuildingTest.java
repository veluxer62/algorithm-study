package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NondestructibleBuildingTest {
    private final Solution sut = new Solution();

    /*
     * N X M 크기의 행렬 모양 게임 맵에 공격과 회복을 반복할 때 파괴되지 않은 건물의 수를 구하라.
     */

    @Test
    public void test_solution() {
        var board = new int[][] {
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5}
        };
        var skill = new int[][] {
                {1,0,0,3,4,4},
                {1,2,0,2,3,2},
                {2,1,0,3,1,2},
                {1,0,1,3,3,1}
        };

        var actual = sut.solution(board, skill);

        assertEquals(10, actual);
    }

    private static class Solution {
        public int solution(int[][] board, int[][] skill) {
            var N = board.length;
            var M = board[0].length;
            var matrix = new int[N + 1][M + 1];

            for (var s : skill) {
                var degree = s[5] * (s[0] == 1 ? -1 : 1);

                matrix[s[1]][s[2]] += degree;
                matrix[s[1]][s[4] + 1] += degree * -1;
                matrix[s[3] + 1][s[2]] += degree * -1;
                matrix[s[3]][s[4] + 1] += degree;
            }

            for (var i = 0; i< N; i++) {
                for (var j = 1; j < M; j++) {
                    matrix[i][j] += matrix[i][j -1];
                }
            }

            for (var j = 0; j < M; j++) {
                for (var i = 1; i < N; i++) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            var answer = 0;
            for (var i = 0; i < N; i++) {
                for (var j = 0; j < M; j++) {
                    if (board[i][j] + matrix[i][j] > 0)
                        answer++;
                }
            }

            return answer;
        }
    }
}
