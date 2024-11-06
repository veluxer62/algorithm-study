package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementTrieTest {
    /*
     * 트라이의 insert, search, startsWith 메소드를 구현하라.
     */

    @Test
    public void test_trie() {
        var trie = new Trie();

        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
        assertFalse(trie.search("appear"));
    }

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            var cur = root;

            for (var c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }

            cur.word = true;
        }
        public boolean search(String word) {
            var cur = root;

            for (var c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }

            return cur.word;
        }
        public boolean startWith(String word) {
            var cur = root;

            for (var c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }

            return true;
        }
    }

    private static class TrieNode {
        boolean word;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
            word = false;
        }
    }
}
