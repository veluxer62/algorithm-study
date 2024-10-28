package com.example.algorithmstudy

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinInvertBinaryTreeTest {
    /*
     * 이진 트리를 반전시켜라.
     */

    @Test
    fun test_invertTree() {
        val root = TreeNode.of(arrayOf(4, 5, 7, 1, 3, 6, 9))
        val actual = invertTree(root)
        Assertions.assertEquals(
            TreeNode.of(arrayOf(4, 7, 5, 9, 6, 3, 1)),
            actual,
        )
    }

    @Test
    fun test_invertTree2() {
        val root = TreeNode.of(arrayOf(4, 5, 7, 1, 3, 6, 9))
        val actual = invertTree2(root)
        Assertions.assertEquals(
            TreeNode.of(arrayOf(4, 7, 5, 9, 6, 3, 1)),
            actual,
        )
    }

    @Test
    fun test_invertTree3() {
        val root = TreeNode.of(arrayOf(4, 5, 7, 1, 3, 6, 9))
        val actual = invertTree3(root)
        Assertions.assertEquals(
            TreeNode.of(arrayOf(4, 7, 5, 9, 6, 3, 1)),
            actual,
        )
    }

    @Test
    fun test_invertTree4() {
        val root = TreeNode.of(arrayOf(4, 5, 7, 1, 3, 6, 9))
        val actual = invertTree4(root)
        Assertions.assertEquals(
            TreeNode.of(arrayOf(4, 7, 5, 9, 6, 3, 1)),
            actual,
        )
    }

    @Test
    fun test_invertTree5() {
        val root = TreeNode.of(arrayOf(4, 5, 7, 1, 3, 6, 9))
        val actual = invertTree5(root)
        Assertions.assertEquals(
            TreeNode.of(arrayOf(4, 7, 5, 9, 6, 3, 1)),
            actual,
        )
    }

    private fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val newNode = TreeNode(root.`val`)
        newNode.left = invertTree(root.right)
        newNode.right = invertTree(root.left)

        return newNode
    }

    private fun invertTree2(root: TreeNode?): TreeNode? {
        if (root != null) {
            root.left = root.right.also { root.right = root.left }

            invertTree2(root.left)
            invertTree2(root.right)
        }

        return root
    }

    private fun invertTree3(root: TreeNode?): TreeNode? {
        if (root != null) {
            invertTree2(root.left)
            invertTree2(root.right)

            root.left = root.right.also { root.right = root.left }
        }

        return root
    }

    private fun invertTree4(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val stack = ArrayDeque<TreeNode>()
        stack.add(root)

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()

            val temp = node.left
            node.left = node.right
            node.right = temp

            node.left?.let { stack.add(it) }
            node.right?.let { stack.add(it) }
        }

        return root
    }

    private fun invertTree5(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            node.left = node.right.also { node.right = node.left }

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        return root
    }
}
