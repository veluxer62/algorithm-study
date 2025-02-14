package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueMorseCodeWordsTest {
    private final Solution sut = new Solution();

    /*

    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

    'a' maps to ".-",
    'b' maps to "-...",
    'c' maps to "-.-.", and so on.
    For convenience, the full table for the 26 letters of the English alphabet is given below:

    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

    For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
    Return the number of different transformations among all words we have.



    Example 1:

    Input: words = ["gin","zen","gig","msg"]
    Output: 2
    Explanation: The transformation of each word is:
    "gin" -> "--...-."
    "zen" -> "--...-."
    "gig" -> "--...--."
    "msg" -> "--...--."
    There are 2 different transformations: "--...-." and "--...--.".
    Example 2:

    Input: words = ["a"]
    Output: 1


    Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 12
    words[i] consists of lowercase English letters.

     */

    @Test
    public void test_uniqueMorseRepresentations() {
        var words = new String[]{"gin","zen","gig","msg"};
        var actual = sut.uniqueMorseRepresentations(words);
        assertEquals(2, actual);

        words = new String[]{"a"};
        actual = sut.uniqueMorseRepresentations(words);
        assertEquals(1, actual);
    }

    @Test
    public void test_uniqueMorseRepresentations2() {
        var words = new String[]{"gin","zen","gig","msg"};
        var actual = sut.uniqueMorseRepresentations2(words);
        assertEquals(2, actual);

        words = new String[]{"a"};
        actual = sut.uniqueMorseRepresentations2(words);
        assertEquals(1, actual);
    }

    private static class Solution {
        private Map<Character, String> morseMap = new HashMap<>() {{
            put('a', ".-");
            put('b', "-...");
            put('c', "-.-.");
            put('d', "-..");
            put('e', ".");
            put('f', "..-.");
            put('g', "--.");
            put('h', "....");
            put('i', "..");
            put('j', ".---");
            put('k', "-.-");
            put('l', ".-..");
            put('m', "--");
            put('n', "-.");
            put('o', "---");
            put('p', ".--.");
            put('q', "--.-");
            put('r', ".-.");
            put('s', "...");
            put('t', "-");
            put('u', "..-");
            put('v', "...-");
            put('w', ".--");
            put('x', "-..-");
            put('y', "-.--");
            put('z', "--..");
        }};

        public int uniqueMorseRepresentations(String[] words) {
            var result = new HashSet<String>();

            for (String word : words) {
                var sb = new StringBuilder();
                for (char c : word.toCharArray()) {
                    sb.append(morseMap.get(c));
                }
                result.add(sb.toString());
            }

            return result.size();
        }

        public int uniqueMorseRepresentations2(String[] words) {
            String[] morseCode = {
                    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                    "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                    "..-", "...-", ".--", "-..-", "-.--", "--.."
            };

            var uniqueMorse = new HashSet<>();

            for (String word : words) {
                StringBuilder morseRepresentation = new StringBuilder();
                for (char c : word.toCharArray()) {
                    morseRepresentation.append(morseCode[c - 'a']);
                }
                uniqueMorse.add(morseRepresentation.toString());
            }

            return uniqueMorse.size();
        }
    }
}
