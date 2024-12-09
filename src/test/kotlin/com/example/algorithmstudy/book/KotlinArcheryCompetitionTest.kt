package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KotlinArcheryCompetitionTest {
    /*
     * 더 많은 화살을 k점에 맞힌 선수가 k점을 가져가는 양궁대회에서,
     * 어피치가 화살을 다 쏜 후 라이언이 가장 큰 점수 차이로 이기기 위해서는 어떤 과녁 점수에 맞혀야 하는지 출력하라.
     */

    @Test
    fun test_solution() {
        val n = 5
        val info = intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)
        val actual = solution(n, info)
        assertArrayEquals(
            intArrayOf(0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0),
            actual,
        )
    }

    private fun solution(
        n: Int,
        info: IntArray,
    ): IntArray? {
        var maxScore = 0
        val _info = info
        var answer = IntArray(11)

        fun calcScore(lion: IntArray): Int {
            var diff = 0
            for (i in 0..10) {
                if (lion[i] == 0 && _info[i] == 0) {
                    continue
                }

                diff =
                    if (lion[i] > _info[i]) {
                        diff + (10 - i)
                    } else {
                        diff - (10 - i)
                    }
            }

            return diff
        }

        fun dfs(
            index: Int,
            lion: IntArray,
            arrow: Int,
        ) {
            if (index == 11) {
                lion[10] = arrow
                val score = calcScore(lion)

                when {
                    score > maxScore -> {
                        maxScore = score
                        answer = lion.copyOf(lion.size)
                    }

                    score == maxScore -> {
                        for (i in 10 downTo 0) {
                            when {
                                lion[i] == answer[i] -> continue
                                lion[i] > answer[i] -> {
                                    answer = lion.copyOf(lion.size)
                                    break
                                }
                            }
                        }
                    }
                }
                return
            }

            if (_info[index] < arrow) {
                lion[index] = _info[index] + 1
                dfs(index + 1, lion, arrow - lion[index])
                lion[index] = 0
            }

            dfs(index + 1, lion, arrow)
        }

        dfs(0, IntArray(11), n)

        return if (maxScore == 0) {
            intArrayOf(-1)
        } else {
            answer
        }
    }
}
