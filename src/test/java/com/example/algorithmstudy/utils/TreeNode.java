package com.example.algorithmstudy.utils;

import java.util.List;

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
}
