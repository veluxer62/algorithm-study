package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestCompletingWordTest {
    private final Solution sut = new Solution();

    /*

    Given a string licensePlate and an array of strings words, find the shortest completing word in words.

    A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

    For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".

    Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.



    Example 1:

    Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
    Output: "steps"
    Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
    "step" contains 't' and 'p', but only contains 1 's'.
    "steps" contains 't', 'p', and both 's' characters.
    "stripe" is missing an 's'.
    "stepple" is missing an 's'.
    Since "steps" is the only word containing all the letters, that is the answer.
    Example 2:

    Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
    Output: "pest"
    Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.


    Constraints:

    1 <= licensePlate.length <= 7
    licensePlate contains digits, letters (uppercase or lowercase), or space ' '.
    1 <= words.length <= 1000
    1 <= words[i].length <= 15
    words[i] consists of lower case English letters.

     */

    @Test
    public void test_shortestCompletingWord() {
        var licensePlate = "1s3 PSt";
        var words = new String[]{"step", "steps", "stripe", "stepple"};
        var actual = sut.shortestCompletingWord(licensePlate, words);
        assertEquals("steps", actual);

        licensePlate = "1s3 456";
        words = new String[]{"looks", "pest", "stew", "show"};
        actual = sut.shortestCompletingWord(licensePlate, words);
        assertEquals("pest", actual);

        licensePlate = "Ah71752";
        words = new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
        actual = sut.shortestCompletingWord(licensePlate, words);
        assertEquals("husband", actual);
    }

    private static class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            var plate = licensePlate.replaceAll("[^a-zA-Z]", "").toLowerCase();

            String shortest = null;
            for (var word : words) {
                if (containAll(plate, word)) {
                    if (shortest == null || shortest.length() > word.length()) {
                        shortest = word;
                    }
                }
            }

            return shortest;
        }

        private boolean containAll(String plate, String word) {
            for (var c : plate.toCharArray()) {
                if (word.lastIndexOf(c) > -1) {
                    word = word.replaceFirst(String.valueOf(c), "-");
                } else {
                    return false;
                }
            }

            return true;
        }

        private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        public String shortestCompletingWord2(String licensePlate, String[] words) {
            long charProduct = getCharProduct(licensePlate.toLowerCase());
            String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
            for(String word : words)
                if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                    shortest = word;
            return shortest;
        }

        private long getCharProduct(String plate) {
            long product = 1L;
            for(char c : plate.toCharArray()) {
                int index = c - 'a';
                if (0 <= index && index <= 25)
                    product *= primes[index];
            }
            return product;
        }
    }
}
