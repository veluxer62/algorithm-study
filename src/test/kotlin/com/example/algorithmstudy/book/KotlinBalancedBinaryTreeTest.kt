package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs

class KotlinBalancedBinaryTreeTest {
    /*
     * 이진 트리가 높이 균형인지 판단하라. 높이 균형은 모든 노드의 서브 트리 간의 높이 차이가 1 이하인 것을 말한다.
     */

    @Test
    fun test_isBalanced() {
        var root = TreeNode.of(arrayOf(1, 9, 20, null, null, 15, 7))
        var actual: Boolean = isBalanced(root)
        Assertions.assertTrue(actual)

        root = TreeNode.of(arrayOf(1, 2, 3, 4, 5, null, null, 6, 7))
        actual = isBalanced(root)
        Assertions.assertFalse(actual)
    }

    private fun isBalanced(root: TreeNode): Boolean {
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val left = dfs(node.left)
            val right = dfs(node.right)

            return if (left == -1 || right == -1 || abs(left - right) > 1) {
                -1
            } else {
                maxOf(left, right) + 1
            }
        }

        return dfs(root) != -1
    }
}
