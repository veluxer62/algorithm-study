package com.example.algorithmstudy.book

import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinMostCommonWordTest {
    /*
     * 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않으며, 구두점(마침표, 쉼표 등) 또한 무시한다.
     */

    @Test
    fun test_mostCommonWord() {
        val paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit."
        val banned = arrayOf("hit")
        val actual =
            record {
                mostCommonWord(paragraph, banned)
            }
        Assertions.assertEquals("ball", actual)
    }

    private fun mostCommonWord(
        paragraph: String,
        banned: Array<String>,
    ): String {
        val words = paragraph.replace("\\W+".toRegex(), " ").lowercase().split(" ")
        val counts = mutableMapOf<String, Int>()
        for (word in words) {
            if (!banned.contains(word)) {
                counts[word] = counts.getOrDefault(word, 0) + 1
            }
        }

        return counts.maxBy { it.value }.key
    }
}
