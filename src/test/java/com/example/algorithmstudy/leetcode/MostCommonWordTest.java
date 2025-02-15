package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostCommonWordTest {
    private final Solution sut = new Solution();

    /*

    Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

    The words in paragraph are case-insensitive and the answer should be returned in lowercase.



    Example 1:

    Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
    Output: "ball"
    Explanation:
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"),
    and that "hit" isn't the answer even though it occurs more because it is banned.
    Example 2:

    Input: paragraph = "a.", banned = []
    Output: "a"


    Constraints:

    1 <= paragraph.length <= 1000
    paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
    0 <= banned.length <= 100
    1 <= banned[i].length <= 10
    banned[i] consists of only lowercase English letters.

     */

    @Test
    public void test_mostCommonWord() {
        var paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        var banned = new String[]{"hit"};
        var actual = sut.mostCommonWord(paragraph, banned);
        assertEquals("ball", actual);

        paragraph = "a.";
        banned = new String[]{};
        actual = sut.mostCommonWord(paragraph, banned);
        assertEquals("a", actual);

        paragraph = "Bob!";
        banned = new String[]{"hit"};
        actual = sut.mostCommonWord(paragraph, banned);
        assertEquals("bob", actual);

        paragraph = "a, a, a, a, b,b,b,c, c";
        banned = new String[]{"a"};
        actual = sut.mostCommonWord(paragraph, banned);
        assertEquals("b", actual);
    }

    private static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            var words = paragraph.toLowerCase().split("\\W+");
            var countMap = new HashMap<String, Integer>();

            for (var word : words) {
                if (contain(banned, word)) continue;

                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }

            var max = 0;
            String result = null;

            for (var entry : countMap.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    result = entry.getKey();
                }
            }

            return result;
        }

        private boolean contain(String[] banned, String word) {
            for (String bannedWord : banned) {
                if (bannedWord.equals(word)) return true;
            }

            return false;
        }
    }
}
