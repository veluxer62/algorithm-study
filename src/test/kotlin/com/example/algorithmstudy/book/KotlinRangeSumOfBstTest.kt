package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinRangeSumOfBstTest {
    /*
     * 이진 탐색 트리(BST)가 주어졌을 때 low 이상 high 이하의 값을 지닌 노드의 합을 구하라.
     */

    @Test
    fun test_rangeSumBST() {
        val root = TreeNode.of(arrayOf(10, 5, 15, 3, 6, null, 18))
        val low = 6
        val high = 15
        val actual: Int = rangeSumBST(root, low, high)
        assertEquals(31, actual)
    }

    @Test
    fun test_rangeSumBST2() {
        val root = TreeNode.of(arrayOf(10, 5, 15, 3, 6, null, 18))
        val low = 6
        val high = 15
        val actual: Int = rangeSumBST2(root, low, high)
        assertEquals(31, actual)
    }

    @Test
    fun test_rangeSumBST3() {
        val root = TreeNode.of(arrayOf(10, 5, 15, 3, 6, null, 18))
        val low = 6
        val high = 15
        val actual: Int = rangeSumBST3(root, low, high)
        assertEquals(31, actual)
    }

    @Test
    fun test_rangeSumBST4() {
        val root = TreeNode.of(arrayOf(10, 5, 15, 3, 6, null, 18))
        val low = 6
        val high = 15
        val actual: Int = rangeSumBST4(root, low, high)
        assertEquals(31, actual)
    }

    private fun rangeSumBST(
        root: TreeNode?,
        low: Int,
        high: Int,
    ): Int {
        if (root == null) return 0

        var result = 0

        if (root.`val` in low..high) {
            result = root.`val`
        }

        result += rangeSumBST(root.left, low, high)
        result += rangeSumBST(root.right, low, high)

        return result
    }

    private fun rangeSumBST2(
        root: TreeNode?,
        low: Int,
        high: Int,
    ): Int {
        if (root == null) return 0

        if (root.`val` > high) {
            return rangeSumBST2(root.left, low, high)
        }

        if (root.`val` < low) {
            return rangeSumBST2(root.right, low, high)
        }

        return root.`val` + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high)
    }

    private fun rangeSumBST3(
        root: TreeNode,
        low: Int,
        high: Int,
    ): Int {
        val stack = ArrayDeque<TreeNode>()
        stack.add(root)

        var result = 0

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()

            if (node.`val` > low && node.left != null) {
                stack.add(node.left)
            }

            if (node.`val` < high && node.right != null) {
                stack.add(node.right)
            }

            if (node.`val` in low..high) {
                result += node.`val`
            }
        }

        return result
    }

    private fun rangeSumBST4(
        root: TreeNode,
        low: Int,
        high: Int,
    ): Int {
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        var result = 0

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.`val` > low && node.left != null) {
                queue.add(node.left)
            }

            if (node.`val` < high && node.right != null) {
                queue.add(node.right)
            }

            if (node.`val` in low..high) {
                result += node.`val`
            }
        }

        return result
    }
}
