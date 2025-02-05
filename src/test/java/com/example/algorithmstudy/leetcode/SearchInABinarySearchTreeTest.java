package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SearchInABinarySearchTreeTest {
    private final Solution sut = new Solution();

    @Test
    public void test_searchBST() {
        var root = TreeNode.of(new Integer[]{4,2,7,1,3});
        var val = 2;
        var actual = sut.searchBST(root, val);
        assertEquals(
                TreeNode.of(new Integer[]{2,1,3}),
                actual
        );

        root = TreeNode.of(new Integer[]{4,2,7,1,3});
        val = 5;
        actual = sut.searchBST(root, val);
        assertNull(actual);
    }

    @Test
    public void test_searchBST2() {
        var root = TreeNode.of(new Integer[]{4,2,7,1,3});
        var val = 2;
        var actual = sut.searchBST2(root, val);
        assertEquals(
                TreeNode.of(new Integer[]{2,1,3}),
                actual
        );

        root = TreeNode.of(new Integer[]{4,2,7,1,3});
        val = 5;
        actual = sut.searchBST2(root, val);
        assertNull(actual);
    }

    private static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            var queue = new LinkedList<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                var curr = queue.poll();

                if (curr.val == val) return curr;

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            return null;
        }

        public TreeNode searchBST2(TreeNode root, int val) {
            while(root != null && root.val != val){
                root = val < root.val ? root.left : root.right;
            }
            return root;
        }
    }
}
