package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KeyboardRowTest {
    private final Solution sut = new Solution();

    @Test
    public void test_findWords() {
        var words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        var actual = sut.findWords(words);
        assertArrayEquals(
                new String[]{"Alaska", "Dad"},
                actual
        );

        words = new String[]{"omk"};
        actual = sut.findWords(words);
        assertArrayEquals(
                new String[]{},
                actual
        );

        words = new String[]{"adsdf", "sfd"};
        actual = sut.findWords(words);
        assertArrayEquals(
                new String[]{"adsdf", "sfd"},
                actual
        );
    }

    private static class Solution {
        Set<Character> row1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        Set<Character> row2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        Set<Character> row3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

        public String[] findWords(String[] words) {
            var result = new ArrayList<String>();

            for (var word : words) {
                var set = new HashSet<Character>();
                for (var w : word.toLowerCase().toCharArray()) {
                    set.add(w);
                }

                if (contains(row1, set) || contains(row2, set) || contains(row3, set)) {
                    result.add(word);
                }
            }

            return result.toArray(new String[0]);
        }

        private boolean contains(Set<Character> keyboard, Set<Character> words) {
            for (var w : words) {
                if (!keyboard.contains(w)) return false;
            }

            return true;
        }
    }
}
