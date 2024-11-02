package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    private final Solution sut = new Solution();

    /*
     * 트리의 전위, 중위 순회 결과를 입력값으로 받아 이진 트리를 구축하라.
     */

    @Test
    public void test_buildTree() {
        var preorder = new int[]{1, 2, 4, 5, 3, 6, 7, 9, 8};
        var inorder = new int[]{4, 2, 5, 1, 7, 9, 6, 8, 3};
        var actual = sut.buildTree(preorder, inorder);
        assertEquals(
                TreeNode.of(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, null, null, 7, 8, null, null, null, null, null, null, null, null, null, null, null, 9}),
                actual
        );
    }

    @Test
    public void test_buildTree2() {
        var preorder = new int[]{1, 2, 4, 5, 3, 6, 7, 9, 8};
        var inorder = new int[]{4, 2, 5, 1, 7, 9, 6, 8, 3};
        var actual = sut.buildTree2(preorder, inorder);
        assertEquals(
                TreeNode.of(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, null, null, 7, 8, null, null, null, null, null, null, null, null, null, null, null, 9}),
                actual
        );
    }

    private static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode dfs(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preIndex > preorder.length - 1 || inStart > inEnd) return null;

            var inIndex = 0;
            for (var i = inStart; i <= inEnd; i++) {
                if (inorder[i] == preorder[preIndex]) {
                    inIndex = i;
                }
            }

            var node = new TreeNode(inorder[inIndex]);

            preIndex++;

            node.left = dfs(preIndex, inStart, inIndex - 1, preorder, inorder);
            node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

            return node;
        }

        public TreeNode buildTree2(int[] preorder, int[] inorder) {
            var preOrder = Arrays.stream(preorder).boxed().collect(Collectors.toList());
            var inOrder = Arrays.stream(inorder).boxed().collect(Collectors.toList());

            return dfs(preOrder, inOrder);
        }

        private TreeNode dfs(List<Integer> preOrder, List<Integer> inOrder) {
            if (inOrder.isEmpty()) return null;

            var inIndex = inOrder.indexOf(preOrder.get(0));
            var node = new TreeNode(inOrder.get(inIndex));

            node.left = dfs(preOrder.subList(1, inIndex + 1), inOrder.subList(0, inIndex));
            node.right = dfs(preOrder.subList(inIndex + 1, preOrder.size()), inOrder.subList(inIndex + 1, inOrder.size()));

            return node;
        }
    }
}
