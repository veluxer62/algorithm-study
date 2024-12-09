package com.example.algorithmstudy.book

import com.example.algorithmstudy.utils.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinSerializeAndDeserializeBinaryTreeTest {
    /*
     * 이진 트리를 배열로 직렬화하고 반대로 역직렬화하는 기능을 구현하라.
     * 즉 오른쪽 그림과 같은 트리는 [1,2,3,4,null,null,5] 형태로 직렬화할 수 있다.
     */

    @Test
    fun serializeBinaryTree() {
        val node = TreeNode.of(arrayOf(1, 2, 3, 4, null, null, 5))
        val serialized = serialize(node)
        Assertions.assertEquals(
            "#,1,2,3,4,#,#,5,#,#,#,#",
            serialized,
        )

        val deserialized = deserialize("#,1,2,3,4,#,#,5,#,#,#,#")
        Assertions.assertEquals(
            TreeNode.of(arrayOf(1, 2, 3, 4, null, null, 5)),
            deserialized,
        )
    }

    private fun serialize(root: TreeNode): String {
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        val sb = StringBuilder()
        sb.append("#,").append(root.`val`)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.left != null) {
                sb.append(",").append(node.left.`val`)
                queue.add(node.left)
            } else {
                sb.append(",#")
            }

            if (node.right != null) {
                sb.append(",").append(node.right.`val`)
                queue.add(node.right)
            } else {
                sb.append(",#")
            }
        }

        return sb.toString()
    }

    private fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val nodes = data.split(",")
        val root = TreeNode(nodes[1].toInt())
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        var index = 2
        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (nodes[index] != "#") {
                node.left = TreeNode(nodes[index].toInt())
                queue.add(node.left)
            }

            index++

            if (nodes[index] != "#") {
                node.right = TreeNode(nodes[index].toInt())
                queue.add(node.right)
            }

            index++
        }

        return root
    }
}
