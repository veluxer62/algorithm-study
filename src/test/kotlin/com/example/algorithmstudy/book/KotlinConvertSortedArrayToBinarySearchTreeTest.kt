package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinConvertSortedArrayToBinarySearchTreeTest {
    /*
     * 정렬된 배열을 받아 높이 균형 이진 탐색 트리로 변환하라. 높이 균형이란 모든 노드의 두 서브 트리 간 깊이 차이가 1 이하인 것을 말한다.
     */

    @Test
    fun test_sortedArrayToBST() {
        val nums = intArrayOf(-10, -7, -3, 0, 5, 7, 9)
        val actual = sortedArrayToBST(nums)
        assertEquals(
            TreeNode.of(arrayOf(0, -7, 7, -10, -3, 5, 9)),
            actual,
        )
    }

    private fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null

        fun construct(
            lo: Int,
            hi: Int,
        ): TreeNode? {
            if (lo > hi) return null

            val mid = lo + (hi - lo) / 2

            val node = TreeNode(nums[mid])
            node.left = construct(lo, mid - 1)
            node.right = construct(mid + 1, hi)

            return node
        }

        return construct(0, nums.size - 1)
    }
}
