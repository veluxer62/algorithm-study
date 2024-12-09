package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinDifferentWaysToAddParenthesesTest {
    /*
     * 숫자와 연산자를 입력받아 가능한 모든 조합의 결과를 출력하라.
     */

    @Test
    fun test_addParentheses() {
        val expression = "2*6-4*3"
        val actual = diffWaysToCompute(expression)

        assertEquals(
            listOf(-12, 12, 0, 12, 24),
            actual,
        )
    }

    private val memo = mutableMapOf<String, List<Int>>()

    private fun diffWaysToCompute(expression: String): List<Int> {
        val result = mutableListOf<Int>()

        if (memo.containsKey(expression)) {
            return memo[expression].orEmpty()
        }

        for (i in expression.indices) {
            val c = expression[i]

            if (c in "+-*") {
                val left = diffWaysToCompute(expression.substring(0, i))
                val right = diffWaysToCompute(expression.substring(i + 1))

                for (l in left) {
                    for (r in right) {
                        when (c) {
                            '+' -> result.add(l + r)
                            '-' -> result.add(l - r)
                            '*' -> result.add(l * r)
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(expression.toInt())
        }

        memo[expression] = result
        return result
    }
}
