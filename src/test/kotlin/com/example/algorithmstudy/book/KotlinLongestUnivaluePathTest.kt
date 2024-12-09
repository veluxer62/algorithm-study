package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinLongestUnivaluePathTest {
    /*
     * 동일한 값을 지닌 가장 긴 경로를 찾아라.
     */

    @Test
    fun test_longestUnivaluePath() {
        var root = TreeNode.of(arrayOf(3, 4, 3, 1, 1, null, 3))
        var actual: Int = longestUnivaluePath(root)
        Assertions.assertEquals(2, actual)

        root = TreeNode.of(arrayOf(1, 6, 5, 6, 6, null, 5))
        actual = longestUnivaluePath(root)
        Assertions.assertEquals(2, actual)
    }

    private fun longestUnivaluePath(root: TreeNode): Int {
        var result = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            var left = dfs(node.left)
            var right = dfs(node.right)

            if (node.left?.`val` == node.`val`) {
                left++
            } else {
                left = 0
            }

            if (node.right?.`val` == node.`val`) {
                right++
            } else {
                right = 0
            }

            result = maxOf(result, left + right)
            return maxOf(left, right)
        }

        dfs(root)
        return result
    }
}
