package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignHashMapTest {
    /*
     * 다음과 같은 기능을 제공하는 해시맵을 디자인하라.
     */

    @Test
    public void test_MyHashMap() {
        var map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        assertEquals(1, map.get(1));
        assertEquals(-1, map.get(3));
        assertEquals(2, map.get(2));
        map.put(2, 1);
        assertEquals(1, map.get(2));
        map.remove(2);
        assertEquals(-1, map.get(2));
    }

    private static class MyHashMap {
        private final Node[] nodes = new Node[1000000];

        public void put(int key, int val) {
            var index = key % nodes.length;
            var node = nodes[index];

            if (node == null) {
                nodes[index] = new Node(key, val);
                return;
            }

            while (true) {
                if (node.key == key) {
                    node.val = val;
                    return;
                }

                if (node.next == null) break;

                node = node.next;
            }

            node.next = new Node(key, val);
        }

        public int get(int key) {
            int index = key % nodes.length;
            var node = nodes[index];

            if (node == null) return -1;

            while (node != null) {
                if (node.key == key) {
                    return node.val;
                }

                node = node.next;
            }

            return -1;
        }

        public void remove(int key) {
            int index = key % nodes.length;
            var node = nodes[index];

            if (node == null) return;

            if (node.key == key) {
                if (node.next == null)
                    nodes[index] = null;
                else
                    nodes[index] = node.next;
            }

            var prev = node;
            while (node != null) {
                if (node.key == key) {
                    prev.next = node.next;
                    return;
                }

                prev = node;
                node = node.next;
            }
        }

        private static class Node {
            int key, val;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
