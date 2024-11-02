package com.example.algorithmstudy

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinMinimumDistanceBetweenBstNodesTest {
    /*
     * 두 노드 간 값의 차이 최솟값을 출력하라.
     */

    @Test
    fun test_minDistanceBST() {
        val root = TreeNode.of(arrayOf(10, 4, 16, 1, 8, null, 19, null, null, 7))
        val actual: Int = minDistanceBST(root)
        Assertions.assertEquals(1, actual)
    }

    @Test
    fun test_minDistanceBST2() {
        val root = TreeNode.of(arrayOf(10, 4, 16, 1, 8, null, 19, null, null, 7))
        val actual: Int = minDistanceBST2(root)
        Assertions.assertEquals(1, actual)
    }

    private var prev = Int.MIN_VALUE + 100000
    private var minDiff = Int.MAX_VALUE

    private fun minDistanceBST(root: TreeNode?): Int {
        if (root?.left != null) minDistanceBST(root.left)

        minDiff = minOf(minDiff, root!!.`val` - prev)
        prev = root.`val`

        if (root.right != null) minDistanceBST(root.right)

        return minDiff
    }

    private fun minDistanceBST2(root: TreeNode): Int {
        var prev = Int.MIN_VALUE + 100000
        var minDiff = Int.MAX_VALUE

        val stack = ArrayDeque<TreeNode>()
        var node: TreeNode? = root

        while (stack.isNotEmpty() || node != null) {
            while (node != null) {
                stack.add(node)
                node = node.left
            }

            node = stack.removeLast()

            minDiff = minOf(minDiff, node.`val` - prev)
            prev = node.`val`

            node = node.right
        }

        return minDiff
    }
}
