package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinVanishingFootholdTest {
    /*
     * 한 번 이동한 발판은 사라지는 보드가 있을 때 양쪽 모두 최적의 플레이를 펼칠 경우 이동 횟수의 합을 구하라.
     */

    @Test
    fun test_solution() {
        val board = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        val aloc = intArrayOf(1, 0)
        val bloc = intArrayOf(1, 2)

        val actual: Int = solution(board, aloc, bloc)

        assertEquals(5, actual)
    }

    private fun solution(
        board: Array<IntArray>,
        aloc: IntArray,
        bloc: IntArray,
    ): Int {
        val n = board.size
        val m = board.first().size
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        fun dfs(
            playerRow: Int,
            playerCol: Int,
            opponentRow: Int,
            opponentCol: Int,
        ): Int {
            if (board[playerRow][playerCol] == 0) return 0

            var result = 0
            for (direction in directions) {
                val playerNextRow = playerRow + direction[0]
                val playerNextCol = playerCol + direction[1]

                if (playerNextRow < 0 || playerNextRow >= n || playerNextCol < 0 || playerNextCol >= n || board[playerNextRow][playerNextCol] == 0) {
                    continue
                }

                board[playerRow][playerCol] = 0
                val moveCount = dfs(opponentRow, opponentCol, playerNextRow, playerNextCol) + 1
                board[playerRow][playerCol] = 1

                when {
                    result % 2 == 0 && moveCount % 2 == 1 -> result = moveCount
                    result % 2 == 0 && moveCount % 2 == 0 -> result = result.coerceAtLeast(moveCount)
                    result % 2 == 1 && moveCount % 2 == 1 -> result = result.coerceAtMost(moveCount)
                }
            }

            return result
        }

        return dfs(aloc.first(), aloc.last(), bloc.first(), bloc.last())
    }
}
