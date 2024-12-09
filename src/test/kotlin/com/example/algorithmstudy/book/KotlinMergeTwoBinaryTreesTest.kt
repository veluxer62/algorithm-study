package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinMergeTwoBinaryTreesTest {
    /*
     * 두 이진 트리를 병합하라. 중복되는 노드는 값을 합산한다.
     */

    @Test
    fun test_mergeTrees() {
        val t1 = TreeNode.of(arrayOf(1, 4, 2, 5, null, null, null))
        val t2 = TreeNode.of(arrayOf(2, 1, 3, null, 4, null, 7))
        val actual = mergeTrees(t1, t2)
        Assertions.assertEquals(
            TreeNode.of(arrayOf(3, 5, 5, 5, 4, null, 7)),
            actual,
        )
    }

    private fun mergeTrees(
        t1: TreeNode?,
        t2: TreeNode?,
    ): TreeNode? {
        if (t1 == null) return t2
        if (t2 == null) return t1

        val node = TreeNode(t1.`val` + t2.`val`)
        node.left = mergeTrees(t1.left, t2.left)
        node.right = mergeTrees(t1.right, t2.right)

        return node
    }
}
