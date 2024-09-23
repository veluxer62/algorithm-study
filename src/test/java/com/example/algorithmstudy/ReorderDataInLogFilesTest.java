package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReorderDataInLogFilesTest {
    private final Solution sut = new Solution();

    /*
     * 로그를 재정렬하라. 기준은 다음과 같다.
     * 1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않는다.
     * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
     * 3. 문자가 동일할 경우에는 식별자순으로 한다.
     * 4. 숫자 로그는 입력 순서대로 한다.
     */

    @Test
    public void test_reorderLogFiles() {
        var given = new String[]{"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};
        var actual = sut.reorderLogFiles(given);
        var expected = new String[] {"id2 art can", "id5 art zero", "id4 own kit dig", "id1 8 1 5 1", "id3 3 6"};
        assertArrayEquals(expected, actual);
    }

    private static class Solution {
        public String[] reorderLogFiles(String[] logs) {
            var letterList = new ArrayList<LogData>();
            var digitList = new ArrayList<LogData>();

            for (String log : logs) {
                var split = log.split(" ");
                var id = split[0];
                var value = getValue(split);

                var data = new LogData();
                data.id = id;
                data.value = value;
                data.origin = log;

                if (Character.isDigit(data.value.charAt(0))) {
                    digitList.add(data);
                } else {
                    letterList.add(data);
                }
            }

            var sortedLetterList = letterList.stream().sorted(LogData::compareTo);

            return Stream.concat(sortedLetterList, digitList.stream()).map(it -> it.origin).toArray(String[]::new);
        }

        private String getValue(String[] str) {
            var result = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (i == 0) continue;
                result.append(str[i]).append(" ");
            }
            return result.toString().trim();
        }

        static class LogData {
            String id;
            String value;
            String origin;

            public int compareTo(LogData o) {
                var compared = value.compareTo(o.value);
                return compared == 0 ? id.compareTo(o.id) : compared;
            }
        }
    }
}
