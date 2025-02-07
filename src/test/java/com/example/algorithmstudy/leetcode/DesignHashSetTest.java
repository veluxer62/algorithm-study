package com.example.algorithmstudy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignHashSetTest {
    /*

    Design a HashSet without using any built-in hash table libraries.

    Implement MyHashSet class:

    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


    Example 1:

    Input
    ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
    [[], [1], [2], [1], [3], [2], [2], [2], [2]]
    Output
    [null, null, null, true, false, null, true, null, false]

    Explanation
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);      // set = [1]
    myHashSet.add(2);      // set = [1, 2]
    myHashSet.contains(1); // return True
    myHashSet.contains(3); // return False, (not found)
    myHashSet.add(2);      // set = [1, 2]
    myHashSet.contains(2); // return True
    myHashSet.remove(2);   // set = [1]
    myHashSet.contains(2); // return False, (already removed)


    Constraints:

    0 <= key <= 106
    At most 104 calls will be made to add, remove, and contains.

     */

    private static class MyHashSet {
        int n = 10000;
        List<Integer>[] arr;

        public MyHashSet() {
            arr = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new ArrayList<>();
            }
        }

        public void add(int key) {
            int idx = key % n;
            if (!arr[idx].contains(key)) {
                arr[idx].add(key);
            }
        }

        public void remove(int key) {
            int idx = key % n;
            arr[idx].remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int idx = key % n;
            return arr[idx].contains(key);
        }
    }
}
