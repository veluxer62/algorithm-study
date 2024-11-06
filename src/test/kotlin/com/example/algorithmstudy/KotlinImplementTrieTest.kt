package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinImplementTrieTest {
    /*
     * 트라이의 insert, search, startsWith 메소드를 구현하라.
     */

    @Test
    fun test_trie() {
        val trie = Trie()

        trie.insert("apple")
        Assertions.assertTrue(trie.search("apple"))
        Assertions.assertFalse(trie.search("app"))
        Assertions.assertTrue(trie.startWith("app"))
        trie.insert("app")
        Assertions.assertTrue(trie.search("app"))
        Assertions.assertFalse(trie.search("appear"))
    }

    private class Trie {
        private val root = TrieNode()

        fun insert(word: String) {
            var cur = root

            for (c in word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = TrieNode()
                }
                cur = cur.children[c - 'a']!!
            }

            cur.word = true
        }

        fun search(word: String): Boolean {
            var cur = root

            for (c in word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false
                }
                cur = cur.children[c - 'a']!!
            }

            return cur.word
        }

        fun startWith(word: String): Boolean {
            var cur = root

            for (c in word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false
                }
                cur = cur.children[c - 'a']!!
            }

            return true
        }

        private class TrieNode {
            var word: Boolean = false
            val children: Array<TrieNode?> = arrayOfNulls(26)
        }
    }
}
