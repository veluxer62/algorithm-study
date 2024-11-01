package com.example.algorithmstudy.utils;

import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static TreeNode of(Integer[] arr) {
        return createTree(arr, 0);
    }

    private static TreeNode createTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = createTree(array, 2 * index + 1);
        node.right = createTree(array, 2 * index + 2);

        return node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TreeNode other = (TreeNode) obj;

        if (this.val != other.val) {
            return false;
        }

        if (this.left == null && other.left != null || this.left != null && !this.left.equals(other.left)) {
            return false;
        }

        if (this.right == null && other.right != null || this.right != null && !this.right.equals(other.right)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(this, sb, "", true);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb, String prefix, boolean isTail) {
        if (node != null) {
            sb.append(prefix)
                    .append(isTail ? "└── " : "├── ")
                    .append(node.val)
                    .append("\n");

            String childPrefix = prefix + (isTail ? "    " : "│   ");
            if (node.left != null || node.right != null) {
                buildString(node.left, sb, childPrefix, node.right == null);
                buildString(node.right, sb, childPrefix, true);
            }
        }
    }
}
