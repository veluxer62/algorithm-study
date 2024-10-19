package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinLetterCombinationsOfAPhoneNumberTest {
    /*
     * 2에서 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자를 출력하라.
     */

    @Test
    fun test_letterCombinations() {
        val digits = "24"
        val actual: List<String> = letterCombinations(digits)
        Assertions.assertEquals(
            listOf("ag", "ah", "ai", "bg", "bh", "bi", "cg", "ch", "ci"),
            actual,
        )
    }

    private fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()

        if (digits.isEmpty()) {
            return result
        }

        val dic =
            mapOf(
                '0' to listOf(),
                '1' to listOf(),
                '2' to listOf('a', 'b', 'c'),
                '3' to listOf('d', 'e', 'f'),
                '4' to listOf('g', 'h', 'i'),
                '5' to listOf('j', 'k', 'l'),
                '6' to listOf('m', 'n', 'o'),
                '7' to listOf('p', 'q', 'r', 's'),
                '8' to listOf('t', 'u', 'v'),
                '9' to listOf('w', 'x', 'y', 'z'),
            )

        fun dfs(
            index: Int,
            path: StringBuilder,
        ) {
            if (path.length == digits.length) {
                result.add(path.toString())
                return
            }

            for (c in dic[digits[index]]!!) {
                dfs(index + 1, StringBuilder(path).append(c))
            }
        }

        dfs(0, StringBuilder())

        return result
    }
}
