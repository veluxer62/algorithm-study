package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskSchedulerTest {
    private final Solution sut = new Solution();

    /*
     * A에서 Z로 표현된 태스크가 있다. 각 간격마다 CPU는 한번의 태스크만 실행할 수 있고, n번의 간격 내에는 동일한 태스크를 실행할 수 없다.
     * 더 이상 태스크를 실행할 수 없는 경우 아이들(idle) 상태가 된다. 모든 태스크를 실행하기 위한 최소 횟수를 출력하라.
     */

    @Test
    public void test_leastInterval() {
        var tasks = new char[] {'A', 'A', 'A', 'B', 'C', 'D'};
        var n = 2;

        var actual = sut.leastInterval(tasks, n);

        assertEquals(7, actual);
    }

    private static class Solution {
        public int leastInterval(char[] tasks, int n) {
            var freqs = new int[26];
            for (var c : tasks) {
                freqs[c - 'A']++;
            }

            var pq = new PriorityQueue<Integer>((a, b) -> b - a);
            for (var f : freqs) {
                if (f > 0) pq.add(f);
            }

            var result = 0;
            while (true) {
                var intervals = 0;
                var list = new ArrayList<Integer>();

                while (!pq.isEmpty()) {
                    var frequency = pq.poll();

                    if (intervals < n + 1) {
                        intervals++;
                        result++;

                        if (frequency > 1) {
                            list.add(frequency - 1);
                        }
                    } else {
                        list.add(frequency);
                    }
                }

                if (list.isEmpty()) break;

                pq.addAll(list);
                result += n + 1 - intervals;
            }

            return result;
        }
    }
}
