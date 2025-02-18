package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoatLatinTest {
    private final Solution sut = new Solution();

    /*

    You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:

    If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
    For example, the word "apple" becomes "applema".
    If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".
    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
    Return the final sentence representing the conversion from sentence to Goat Latin.



    Example 1:

    Input: sentence = "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
    Example 2:

    Input: sentence = "The quick brown fox jumped over the lazy dog"
    Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


    Constraints:

    1 <= sentence.length <= 150
    sentence consists of English letters and spaces.
    sentence has no leading or trailing spaces.
    All the words in sentence are separated by a single space.

     */

    @Test
    public void test_toGoatLatin() {
        var sentence = "I speak Goat Latin";
        var actual = sut.toGoatLatin(sentence);
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", actual);

        sentence = "The quick brown fox jumped over the lazy dog";
        actual = sut.toGoatLatin(sentence);
        assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", actual);

        sentence = "Each word consists of lowercase and uppercase letters only";
        actual = sut.toGoatLatin(sentence);
        assertEquals("Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa", actual);
    }

    private static class Solution {

        public String toGoatLatin(String sentence) {
            var sb = new StringBuilder();

            var words = sentence.split(" ");
            for (var i = 0; i < words.length; i++) {
                var word = words[i];
                sb.append(changeWord(word, i));
                sb.append(' ');
            }

            return sb.toString().trim();
        }

        private String changeWord(String word, int idx) {
            var step1 = replaceConsonant(word);
            var step2 = appendMa(step1);
            return appendA(step2, idx);
        }

        private String appendA(String word, int idx) {
            return word + "a".repeat(idx + 1);
        }

        private String appendMa(String word) {
            return word + "ma";
        }

        private String replaceConsonant(String word) {
            var firstWord = word.charAt(0);

            String result;
            String vowels = "aeiouAEIOU";

            if (vowels.indexOf(firstWord) < 0) {
                result = word.substring(1) + firstWord;
            } else {
                result = word;
            }

            return result;
        }
    }
}
