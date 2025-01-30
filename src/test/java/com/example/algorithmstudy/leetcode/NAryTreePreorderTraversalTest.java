package com.example.algorithmstudy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversalTest {
    /*

    Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)



    Example 1:



    Input: root = [1,null,3,2,4,null,5,6]
    Output: [1,3,5,6,2,4]
    Example 2:



    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

     */

    private static class Solution {
        public List<Integer> preorder(Node root) {
            var result = new ArrayList<Integer>();
            search(root, result);
            return result;
        }

        private void search(Node root, List<Integer> list) {
            if (root == null) return;

            list.add(root.val);
            for (Node child : root.children) {
                search(child, list);
            }
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
