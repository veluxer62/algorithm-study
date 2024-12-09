package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinNumberOfIslandsTest {
    /*
     * 1을 육지로, 0을 물로 가정한 2차원 그리드 맵이 주어졌을 때, 섬의 개수를 계산하라(연결되어 있는 1의 덩어리 개수를 구하라)
     */

    @Test
    fun test_numIslands() {
        val grid =
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '1'),
            )
        val actual: Int = numIslands(grid)
        assertEquals(2, actual)
    }

    private fun numIslands(grid: Array<CharArray>): Int {
        fun grid(
            i: Int,
            j: Int,
        ) {
            when {
                i < 0 -> return
                i >= grid.size -> return
                j < 0 -> return
                j >= grid[0].size -> return
                grid[i][j] == '0' -> return
            }

            grid[i][j] = '0'

            grid(i, j + 1)
            grid(i, j - 1)
            grid(i + 1, j)
            grid(i - 1, j)
        }

        var count = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    grid(i, j)
                    count++
                }
            }
        }

        return count
    }
}
