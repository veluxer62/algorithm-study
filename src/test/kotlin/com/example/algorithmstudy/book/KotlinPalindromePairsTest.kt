package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinPalindromePairsTest {
    /*
     * 단어 리스트에서 words[i] + words[j]가 팰린드롬이 되는 모든 인덱스 조합 (i, j)를 구하라
     */

    @Test
    fun test_palindromePairs() {
        val words = arrayOf("d", "cbbcd", "dcbb", "dcbc", "cbbc", "bbcd")
        val actual: List<List<Int>> = palindromePairs(words)
        Assertions.assertEquals(
            java.util.List.of(
                listOf(0, 1),
                listOf(1, 4),
                listOf(2, 1),
                listOf(2, 5),
                listOf(3, 0),
                listOf(5, 2),
            ),
            actual,
        )
    }

    @Test
    fun test_palindromePairs2() {
        val words = arrayOf("d", "cbbcd", "dcbb", "dcbc", "cbbc", "bbcd")
        val actual: List<List<Int>> = palindromePairs2(words)
        Assertions.assertEquals(
            java.util.List.of(
                listOf(0, 1),
                listOf(1, 4),
                listOf(2, 5),
                listOf(2, 1),
                listOf(3, 0),
                listOf(5, 2),
            ),
            actual,
        )
    }

    private fun palindromePairs(words: Array<String>): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        for (i in words.indices) {
            for (j in words.indices) {
                if (i == j) continue

                if (isPalindrome(words[i] + words[j])) {
                    results.add(listOf(i, j))
                }
            }
        }

        return results
    }

    private fun isPalindrome(s: String): Boolean {
        val filtered = s.replace(Regex("[^a-zA-z0-9]"), "").lowercase()
        val reversed = filtered.reversed()
        return filtered == reversed
    }

    private fun palindromePairs2(words: Array<String>): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        val t = Trie()
        for (i in words.indices) {
            t.insert(i, words[i])
        }

        for (i in words.indices) {
            results.addAll(t.search(i, words[i]))
        }

        return results
    }

    private class Trie {
        val root = TrieNode()

        private fun isPalindrome(
            word: String,
            start: Int,
            end: Int,
        ): Boolean {
            var s = start
            var e = end

            while (s < e) {
                if (word[s++] != word[e--]) return false
            }

            return true
        }

        fun insert(
            index: Int,
            word: String,
        ) {
            var current = root

            for (i in word.length - 1 downTo 0) {
                val c = word[i]

                if (isPalindrome(word, 0, i)) {
                    current.palindromeWordIds.add(index)
                }

                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = TrieNode()
                }

                current = current.children[c - 'a']!!
            }

            current.wordId = index
        }

        fun search(
            index: Int,
            word: String,
        ): List<List<Int>> {
            var current = root
            val results = mutableListOf<List<Int>>()

            for (i in word.indices) {
                if (current.wordId >= 0 && isPalindrome(word, i, word.length - 1)) {
                    results.add(listOf(index, current.wordId))
                }

                if (current.children[word[i] - 'a'] == null) {
                    return results
                }

                current = current.children[word[i] - 'a']!!
            }

            if (current.wordId >= 0 && current.wordId != index) {
                results.add(listOf(index, current.wordId))
            }

            for (pwi in current.palindromeWordIds) {
                results.add(listOf(index, pwi))
            }

            return results
        }

        private class TrieNode {
            var wordId = -1
            var children = arrayOfNulls<TrieNode>(26)
            var palindromeWordIds = mutableListOf<Int>()
        }
    }
}
