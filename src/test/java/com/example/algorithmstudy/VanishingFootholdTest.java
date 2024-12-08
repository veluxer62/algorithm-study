package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VanishingFootholdTest {
    private final Solution sut = new Solution();

    /*
     * 한 번 이동한 발판은 사라지는 보드가 있을 때 양쪽 모두 최적의 플레이를 펼칠 경우 이동 횟수의 합을 구하라.
     */

    @Test
    public void test_solution() {
        var board = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        var aloc = new int[]{1, 0};
        var bloc = new int[]{1, 2};

        var actual = sut.solution(board, aloc, bloc);

        assertEquals(5, actual);
    }

    private static class Solution {
        private int[][] board;
        private int N;
        private int M;
        private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int solution(int[][] board, int[] aloc, int[] bloc) {
            this.board = board;
            this.N = board.length;
            this.M = board[0].length;
            return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
        }

        private int dfs(int playerRow, int playerCol, int opponentRow, int opponentCol) {
            if (board[playerRow][playerCol] == 0) return 0;

            var result = 0;
            for (var direction : directions) {
                var playerNextRow = playerRow + direction[0];
                var playerNextCol = playerCol + direction[1];

                if (playerNextRow < 0 || playerNextRow >= N || playerNextCol < 0 || playerNextCol >= M || board[playerNextRow][playerNextCol] == 0)
                    continue;

                board[playerRow][playerCol] = 0;
                var moveCount = dfs(opponentRow, opponentCol, playerNextRow, playerNextCol) + 1;
                board[playerRow][playerCol] = 1;

                if (result % 2 == 0 && moveCount % 2 == 1) {
                    result = moveCount;
                } else if (result % 2 == 0 && moveCount % 2 == 0) {
                    result = Math.max(result, moveCount);
                } else if (result % 2 == 1 && moveCount % 2 == 1) {
                    result = Math.min(result, moveCount);
                }
            }

            return result;
        }
    }
}
