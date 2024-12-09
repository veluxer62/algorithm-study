package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    /*
     * 트리의 전위, 중위 순회 결과를 입력값으로 받아 이진 트리를 구축하라.
     */

    @Test
    fun test_buildTree() {
        val preorder = intArrayOf(1, 2, 4, 5, 3, 6, 7, 9, 8)
        val inorder = intArrayOf(4, 2, 5, 1, 7, 9, 6, 8, 3)
        val actual = buildTree(preorder, inorder)
        assertEquals(
            TreeNode.of(
                arrayOf(
                    1,
                    2,
                    3,
                    4,
                    5,
                    6,
                    null,
                    null,
                    null,
                    null,
                    null,
                    7,
                    8,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    9,
                ),
            ),
            actual,
        )
    }

    private fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
    ): TreeNode? {
        if (inorder.isEmpty()) return null

        val inIndex = inorder.indexOf(preorder.first())
        val node = TreeNode(inorder[inIndex])

        node.left = buildTree(preorder.copyOfRange(1, inIndex + 1), inorder.copyOfRange(0, inIndex))
        node.right = buildTree(preorder.copyOfRange(inIndex + 1, preorder.size), inorder.copyOfRange(inIndex + 1, inorder.size))

        return node
    }
}
