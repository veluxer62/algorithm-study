package com.example.algorithmstudy

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinMaximumDepthOfBinaryTreeTest {
    /*
     * 이진 트리의 최대 깊이를 구하라.
     */

    @Test
    fun test_maxDepth() {
        val root = TreeNode.of(arrayOf(3, 9, 10, null, null, 15, 7))
        val actual: Int = maxDepth(root)
        Assertions.assertEquals(3, actual)
    }

    @Test
    fun test_maxDepth2() {
        val root = TreeNode.of(arrayOf(3, 9, 10, null, null, 15, 7))
        val actual: Int = maxDepth2(root)
        Assertions.assertEquals(3, actual)
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = LinkedList<TreeNode>()
        var depth = 0

        queue.add(root)
        while (queue.isNotEmpty()) {
            depth++

            for (i in 0 until queue.size) {
                val cur = queue.poll()
                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
            }
        }

        return depth
    }

    private fun maxDepth2(root: TreeNode?): Int {
        if (root == null) return 0

        val left = maxDepth2(root.left)
        val right = maxDepth2(root.right)

        return left.coerceAtLeast(right) + 1
    }
}
