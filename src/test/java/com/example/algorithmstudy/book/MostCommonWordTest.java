package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostCommonWordTest {
    private final Solution sut = new Solution();

    /*
     * 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않으며, 구두점(마침표, 쉼표 등) 또한 무시한다.
     */

    @Test
    public void test_mostCommonWord() {
        var paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};
        var actual = record(() -> sut.mostCommonWord(paragraph, banned));
        assertEquals("ball", actual);

        actual = record(() -> sut.mostCommonWord2(paragraph, banned));
        assertEquals("ball", actual);
    }

    private static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            var words = paragraph.split(" ");
            var box = new HashMap<String, Integer>();

            for (String word: words) {
                if (!contains(word, banned)) {
                    var key = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    box.put(key, box.getOrDefault(key, 0) + 1);
                }
            }

            var mostKey = "";
            var mostValue = 0;

            for (var key: box.keySet()) {
                Integer value = box.get(key);
                if (value > mostValue) {
                    mostKey = key;
                    mostValue = value;
                }
            }

            return mostKey;
        }

        public String mostCommonWord2(String paragraph, String[] banned) {
            var ban = new HashSet<>(Arrays.asList(banned));
            var words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
            var counts = new HashMap<String, Integer>();

            for (String w: words) {
                if (!ban.contains(w)) {
                    counts.put(w, counts.getOrDefault(w, 0) + 1);
                }
            }

            return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
        }

        private boolean contains(String word, String[] banned) {
            for (String bannedWord: banned) {
                if (word.equals(bannedWord)) return true;
            }

            return false;
        }
    }
}
