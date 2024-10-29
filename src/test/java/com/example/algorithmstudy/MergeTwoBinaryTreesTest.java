package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoBinaryTreesTest {
    private final Solution sut = new Solution();

    /*
     * 두 이진 트리를 병합하라. 중복되는 노드는 값을 합산한다.
     */

    @Test
    public void test_mergeTrees() {
        var t1 = TreeNode.of(new Integer[]{1, 4, 2, 5, null, null, null});
        var t2 = TreeNode.of(new Integer[]{2, 1, 3, null, 4, null, 7});
        var actual = sut.mergeTrees(t1, t2);
        assertEquals(
                TreeNode.of(new Integer[]{3, 5, 5, 5, 4, null, 7}),
                actual
        );
    }

    private static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) return t2;
            if (t2 == null) return t1;

            var node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);

            return node;
        }
    }
}
