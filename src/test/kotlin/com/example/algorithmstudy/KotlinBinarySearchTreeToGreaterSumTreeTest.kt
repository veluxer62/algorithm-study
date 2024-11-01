package com.example.algorithmstudy

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinBinarySearchTreeToGreaterSumTreeTest {
    /*
     * BST의 각 노드를 자신과 자신보다 더 큰 값을 가진 모든 노드의 합으로 만들어라.
     */

    @Test
    fun test_sumTree() {
        val root = TreeNode.of(arrayOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 9))
        val actual = bstToGst(root)
        assertEquals(
            TreeNode.of(arrayOf(31, 37, 22, 37, 36, 27, 16, null, null, null, 34, null, null, null, 9)),
            actual,
        )
    }

    private var sum = 0

    private fun bstToGst(root: TreeNode?): TreeNode? {
        if (root != null) {
            bstToGst(root.right)
            sum += root.`val`
            root.`val` = sum
            bstToGst(root.left)
        }

        return root
    }
}
