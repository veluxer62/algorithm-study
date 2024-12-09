package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinSearchA2DMatrix2Test {
    /*
     * m * n 행렬에서 값을 찾아내는 효율적인 알고리즘을 구현하라. 행렬은 왼쪽에서 오른쪽, 위에서 아래로 오름차순으로 정렬되어 있으며 다음과 같다.
     */

    @Test
    fun test_searchMatrix() {
        val matrix =
            arrayOf(
                intArrayOf(1, 4, 7, 11, 6),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 31),
            )
        var target = 5
        var actual = searchMatrix(matrix, target)
        assertTrue(actual)

        target = 20
        actual = searchMatrix(matrix, target)
        assertFalse(actual)
    }

    private fun searchMatrix(
        matrix: Array<IntArray>,
        target: Int,
    ): Boolean {
        var row = 0
        var col = matrix[0].size - 1

        while (row < matrix.size && col >= 0) {
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] > target -> col--
                else -> row++
            }
        }

        return false
    }
}
