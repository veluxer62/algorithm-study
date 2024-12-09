package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GetReportResultsTest {
    private final Solution sut = new Solution();

    /*
     * 신고 내역을 입력받아 신고당한 횟수가 K번 이상이면 신고자에게 안내 메일을 발송한다.
     * 각 신고자가 받는 메일 횟수를 출력하라.
     */

    @Test
    public void test_getReportResults() {
        var id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        var report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        var k = 2;

        var actual = sut.getReport(id_list, report, k);
        assertArrayEquals(
                new int[]{2, 1, 1, 0},
                actual
        );

        id_list = new String[]{"con", "ryan"};
        report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con", "ryan con"};
        k = 3;

        actual = sut.getReport(id_list, report, k);
        assertArrayEquals(
                new int[]{0, 0},
                actual
        );
    }

    private static class Solution {
        public int[] getReport(String[] id_list, String[] report, int k) {
            var reportSet = new HashSet<>(Arrays.asList(report));

            var reportLog = new HashMap<String, List<String>>();
            for (var set : reportSet) {
                var person = set.split(" ");
                var list = reportLog.getOrDefault(person[1], new ArrayList<>());
                list.add(person[0]);
                reportLog.put(person[1], list);
            }

            var mailCounts = new HashMap<String, Integer>();
            for (var log : reportLog.entrySet()) {
                if (log.getValue().size() >= k) {
                    for (var people : log.getValue()) {
                        mailCounts.put(people, mailCounts.getOrDefault(people, 0) + 1);
                    }
                }
            }

            return Arrays.stream(id_list)
                    .map(x -> mailCounts.getOrDefault(x, 0))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
    }
}
