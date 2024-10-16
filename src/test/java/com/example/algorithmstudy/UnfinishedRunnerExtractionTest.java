package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnfinishedRunnerExtractionTest {
    private final Solution sut = new Solution();

    /*
     * 마라톤에 참여한 선수 배열과 완주한 선수 배열을 입력받아 완주하지 못한 선수를 출력하라.
     */

    @Test
    public void test_extractUnfinished() {
        var participant = new String[]{"leo", "kiki", "eden"};
        var completion = new String[]{"eden", "kiki"};
        var actual = sut.extractUnfinished(participant, completion);
        assertEquals("leo", actual);
    }

    private static class Solution {
        public String extractUnfinished(String[] participant, String[] completion) {
            var m = new HashMap<String, Integer>();
            for (var p : participant) {
                m.put(p, m.getOrDefault(p, 0) + 1);
            }

            for (var c : completion) {
                var left = m.get(c);

                if (left == null) continue;

                if (left == 1) {
                    m.remove(c);
                } else {
                    m.put(c, m.get(c) - 1);
                }
            }

            return m.keySet().iterator().next();
        }
    }
}
