package com.example.algorithmstudy

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

class KotlinDiameterOfBinaryTreeTest {
    /*
     * 이진 트리에서 두 노드 간 가장 긴 경로의 길이를 출력하라.
     */

    @Test
    fun test_diameterOfBinaryTree() {
        val root = TreeNode.of(arrayOf(1, 2, 6, 4, 5, null, null))
        val actual: Int = diameterOfBinaryTree(root)
        Assertions.assertEquals(3, actual)
    }

    private fun diameterOfBinaryTree(root: TreeNode): Int {
        var longest = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return -1

            val left = dfs(node.left)
            val right = dfs(node.right)

            longest = max(longest, left + right + 2)
            return max(left, right) + 1
        }

        dfs(root)
        return longest
    }
}
