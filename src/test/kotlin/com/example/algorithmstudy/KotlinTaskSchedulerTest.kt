package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinTaskSchedulerTest {
    /*
     * A에서 Z로 표현된 태스크가 있다. 각 간격마다 CPU는 한번의 태스크만 실행할 수 있고, n번의 간격 내에는 동일한 태스크를 실행할 수 없다.
     * 더 이상 태스크를 실행할 수 없는 경우 아이들(idle) 상태가 된다. 모든 태스크를 실행하기 위한 최소 횟수를 출력하라.
     */

    @Test
    fun test_leastInterval() {
        val tasks = charArrayOf('A', 'A', 'A', 'B', 'C', 'D')
        val n = 2

        val actual: Int = leastInterval(tasks, n)

        Assertions.assertEquals(7, actual)
    }

    private fun leastInterval(
        tasks: CharArray,
        n: Int,
    ): Int {
        val freqs = IntArray(26)
        for (c in tasks) {
            freqs[c - 'A']++
        }

        val pq = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        for (f in freqs) {
            if (f > 0) {
                pq.add(f)
            }
        }

        var result = 0
        while (true) {
            var intervals = 0
            val list = mutableListOf<Int>()

            while (pq.isNotEmpty()) {
                val frequency = pq.poll()

                if (intervals < n + 1) {
                    intervals++
                    result++

                    if (frequency > 1) {
                        list.add(frequency - 1)
                    }
                } else {
                    list.add(frequency)
                }
            }

            if (list.isEmpty()) break

            pq.addAll(list)

            result += n + 1 - intervals
        }

        return result
    }
}
