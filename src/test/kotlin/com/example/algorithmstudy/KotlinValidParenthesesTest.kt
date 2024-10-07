package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinValidParenthesesTest {
    /*
     * 대중소 세 종류 괄호로 된 입력값이 유효한지 판별하라.
     */

    @Test
    fun test_isValid() {
        val given = "[]{}()"
        val actual: Boolean = isValid(given)
        Assertions.assertTrue(actual)
    }

    private fun isValid(s: String): Boolean {
        val table =
            mapOf(
                ']' to '[',
                '}' to '{',
                ')' to '(',
            )

        val stack = ArrayDeque<Char>()

        for (c in s) {
            if (!table.containsKey(c)) {
                stack.add(c)
            } else if (stack.isEmpty() || table[c] != stack.removeLast()) {
                return false
            }
        }

        return stack.isEmpty()
    }
}
