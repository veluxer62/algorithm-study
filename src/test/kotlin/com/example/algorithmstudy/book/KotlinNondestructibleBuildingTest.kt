package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinNondestructibleBuildingTest {
    /*
     * N X M 크기의 행렬 모양 게임 맵에 공격과 회복을 반복할 때 파괴되지 않은 건물의 수를 구하라.
     */

    @Test
    fun test_solution() {
        val board =
            arrayOf(
                intArrayOf(5, 5, 5, 5, 5),
                intArrayOf(5, 5, 5, 5, 5),
                intArrayOf(5, 5, 5, 5, 5),
                intArrayOf(5, 5, 5, 5, 5),
            )
        val skill =
            arrayOf(
                intArrayOf(1, 0, 0, 3, 4, 4),
                intArrayOf(1, 2, 0, 2, 3, 2),
                intArrayOf(2, 1, 0, 3, 1, 2),
                intArrayOf(1, 0, 1, 3, 3, 1),
            )

        val actual: Int = solution(board, skill)

        assertEquals(10, actual)
    }

    private fun solution(
        board: Array<IntArray>,
        skill: Array<IntArray>,
    ): Int {
        val n = board.size
        val m = board.first().size
        val matrix = Array(n + 1) { IntArray(m + 1) }

        for (s in skill) {
            val degree = s[5] * if (s.first() == 1) -1 else 1

            matrix[s[1]][s[2]] += degree
            matrix[s[1]][s[4] + 1] += degree * -1
            matrix[s[3] + 1][s[2]] += degree * -1
            matrix[s[3] + 1][s[4] + 1] += degree
        }

        for (i in 0 until n) {
            for (j in 1 until m) {
                matrix[i][j] += matrix[i][j - 1]
            }
        }

        for (j in 0 until m) {
            for (i in 1 until n) {
                matrix[i][j] += matrix[i - 1][j]
            }
        }

        var answer = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] + matrix[i][j] > 0) {
                    answer++
                }
            }
        }

        return answer
    }
}
