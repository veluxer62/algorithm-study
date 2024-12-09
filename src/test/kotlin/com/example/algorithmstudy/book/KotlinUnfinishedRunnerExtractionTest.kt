package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinUnfinishedRunnerExtractionTest {
    /*
     * 마라톤에 참여한 선수 배열과 완주한 선수 배열을 입력받아 완주하지 못한 선수를 출력하라.
     */

    @Test
    fun test_extractUnfinished() {
        val participant = arrayOf("leo", "kiki", "eden")
        val completion = arrayOf("eden", "kiki")
        val actual: String = extractUnfinished(participant, completion)
        Assertions.assertEquals("leo", actual)
    }

    private fun extractUnfinished(
        participant: Array<String>,
        completion: Array<String>,
    ): String {
        val m = mutableMapOf<String, Int>()
        for (p in participant) {
            m[p] = m.getOrDefault(p, 0) + 1
        }

        for (c in completion) {
            val left = m[c] ?: continue

            if (left == 1) {
                m.remove(c)
            } else {
                m[c] = m.getOrDefault(c, 0) - 1
            }
        }

        return m.keys.first()
    }
}
