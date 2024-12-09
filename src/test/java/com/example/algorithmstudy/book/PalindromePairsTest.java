package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromePairsTest {
    private final Solution sut = new Solution();

    /*
     * 단어 리스트에서 words[i] + words[j]가 팰린드롬이 되는 모든 인덱스 조합 (i, j)를 구하라
     */

    @Test
    public void test_palindromePairs() {
        var words = new String[]{"d", "cbbcd", "dcbb", "dcbc", "cbbc", "bbcd"};
        var actual = sut.palindromePairs(words);
        assertEquals(
                List.of(
                        List.of(0, 1),
                        List.of(1, 4),
                        List.of(2, 1),
                        List.of(2, 5),
                        List.of(3, 0),
                        List.of(5, 2)
                ),
                actual
        );
    }

    @Test
    public void test_palindromePairs2() {
        var words = new String[]{"d", "cbbcd", "dcbb", "dcbc", "cbbc", "bbcd"};
        var actual = sut.palindromePairs2(words);
        assertEquals(
                List.of(
                        List.of(0, 1),
                        List.of(1, 4),
                        List.of(2, 5),
                        List.of(2, 1),
                        List.of(3, 0),
                        List.of(5, 2)
                ),
                actual
        );
    }

    private static class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            var results = new ArrayList<List<Integer>>();

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i == j) continue;

                    if (isPalindrome(words[i] + words[j])) {
                        var result = new ArrayList<Integer>();
                        result.add(i);
                        result.add(j);
                        results.add(result);
                    }
                }
            }

            return results;
        }

        private boolean isPalindrome(String s) {
            var filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            var reversed = new StringBuilder(filtered).reverse().toString();
            return filtered.equals(reversed);
        }

        public List<List<Integer>> palindromePairs2(String[] words) {
            var t = new Trie();
            var results = new ArrayList<List<Integer>>();

            for (int i = 0; i < words.length; i++) {
                t.insert(i, words[i]);
            }

            for (int i = 0; i < words.length; i++) {
                results.addAll(t.search(i, words[i]));
            }

            return results;
        }

        private static class Trie {
            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public boolean isPalindrome(String str, int start, int end) {
                while (start < end) {
                    if (str.charAt(start++) != str.charAt(end--)) return false;
                }

                return true;
            }

            public void insert(int index, String word) {
                var current = root;

                for (int i = word.length() - 1; i >= 0; i--) {
                    var c = word.charAt(i);

                    if (isPalindrome(word, 0, i)) {
                        current.palindromeWordIds.add(index);
                    }

                    if (current.children[c - 'a'] == null) {
                        current.children[c - 'a'] = new TrieNode();
                    }

                    current = current.children[c - 'a'];
                }

                current.wordId = index;
            }

            public List<List<Integer>> search(int index, String word) {
                var current = root;
                var results = new ArrayList<List<Integer>>();

                for (int j = 0; j < word.length(); j++) {
                    if (current.wordId >= 0 && isPalindrome(word, j, word.length() - 1)) {
                        results.add(List.of(index, current.wordId));
                    }

                    if (current.children[word.charAt(j) - 'a'] == null) {
                        return results;
                    }

                    current = current.children[word.charAt(j) - 'a'];
                }

                if (current.wordId >=0 && current.wordId != index){
                    results.add(List.of(index, current.wordId));
                }

                for (var palindromeWordId : current.palindromeWordIds) {
                    results.add(List.of(index, palindromeWordId));
                }

                return results;
            }

            private static class TrieNode {
                int wordId;
                TrieNode[] children;
                List<Integer> palindromeWordIds;

                public TrieNode() {
                    wordId = -1;
                    children = new TrieNode[26];
                    palindromeWordIds = new ArrayList<>();
                }
            }
        }

    }
}
