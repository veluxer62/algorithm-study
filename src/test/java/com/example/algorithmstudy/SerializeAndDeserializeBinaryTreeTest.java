package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeAndDeserializeBinaryTreeTest {
    private final Solution sut = new Solution();

    /*
     * 이진 트리를 배열로 직렬화하고 반대로 역직렬화하는 기능을 구현하라.
     * 즉 오른쪽 그림과 같은 트리는 [1,2,3,4,null,null,5] 형태로 직렬화할 수 있다.
     */

    @Test
    public void serializeBinaryTree() {
        var node = TreeNode.of(new Integer[]{1, 2, 3, 4, null, null, 5});
        var serialized = sut.serialize(node);
        assertEquals(
                "#,1,2,3,4,#,#,5,#,#,#,#",
                serialized
        );

        var deserialized = sut.deserialize("#,1,2,3,4,#,#,5,#,#,#,#");
        assertEquals(
                TreeNode.of(new Integer[]{1, 2, 3, 4, null, null, 5}),
                deserialized
        );
    }

    private static class Solution {
        public String serialize(TreeNode root) {
            if (root == null) return "";

            var queue = new LinkedList<TreeNode>();
            queue.add(root);

            var sb = new StringBuilder();
            sb.append("#,").append(root.val);

            while (!queue.isEmpty()) {
                var node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                    sb.append(",").append(node.left.val);
                } else {
                    sb.append(",#");
                }

                if (node.right != null) {
                    queue.add(node.right);
                    sb.append(",").append(node.right.val);
                } else {
                    sb.append(",#");
                }
            }

            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;

            var nodes = data.split(",");

            var root = new TreeNode(Integer.parseInt(nodes[1]));

            var queue = new LinkedList<TreeNode>();
            queue.add(root);

            var index = 2;

            while(!queue.isEmpty()) {
                var node = queue.poll();

                if (!nodes[index].equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(node.left);
                }

                index++;

                if (!nodes[index].equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(node.right);
                }

                index++;
            }


            return root;
        }
    }
}
