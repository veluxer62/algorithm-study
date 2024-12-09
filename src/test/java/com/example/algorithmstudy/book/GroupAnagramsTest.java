package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupAnagramsTest {
    private final Solution sut = new Solution();

    /*
     * 문자열 배열을 받아 애너그램 단위로 그룹핑하라.
     */

    @Test
    public void test_groupAnagrams() {
        var arr = new String[]{"eat", "tea", "tan", "ate", "ant", "cat"};
        var actual = record(() ->sut.groupAnagrams(arr));
        assertEquals(
                List.of(List.of("ate", "eat", "tea"), List.of("ant", "tan"), List.of("cat")),
                actual
        );
    }

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] arr) {
            var results = new LinkedHashMap<String, List<String>>();

            for (String s : arr) {
                var chars = s.toCharArray();
                Arrays.sort(chars);

                var key = String.valueOf(chars);
                if (!results.containsKey(key)) {
                    results.put(key, new ArrayList<>());
                }
                results.get(key).add(s);
            }

            for (var entry : results.entrySet()) {
                Collections.sort(entry.getValue());
            }

            return new ArrayList<>(results.values());
        }
    }
}
