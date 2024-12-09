package com.example.algorithmstudy.book

import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinValidPalindromeTest {
    /*
     * 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영숫자(영문자와 숫자)만을 대상으로 한다.
     */

    @Test
    fun test_validPalindrome() {
        var actual =
            record {
                isPalindrome("Do geese see God?")
            }
        assertTrue(actual)

        actual =
            record {
                isPalindrome("This is test string.")
            }
        assertFalse(actual)

        actual =
            record {
                isPalindrome("a".repeat(999999999))
            }
        assertTrue(actual)
    }

    @Test
    fun test_validPalindrome2() {
        var actual =
            record {
                isPalindrome2("Do geese see God?")
            }
        assertTrue(actual)

        actual =
            record {
                isPalindrome2("This is test string.")
            }
        assertFalse(actual)

        actual =
            record {
                isPalindrome2("a".repeat(999999999))
            }
        assertTrue(actual)
    }

    private fun isPalindrome(str: String): Boolean {
        var start = 0
        var end = str.length - 1

        while (start < end) {
            when {
                !Character.isLetterOrDigit(str[start]) -> start++
                !Character.isLetterOrDigit(str[end]) -> end--
                Character.toLowerCase(str[start]) != Character.toLowerCase(str[end]) -> return false
                else -> {
                    start++
                    end--
                }
            }
        }

        return true
    }

    private fun isPalindrome2(str: String): Boolean {
        val filtered = str.replace(Regex("[^a-zA-Z0-9]"), "").lowercase()
        val reversed = filtered.reversed()
        return reversed == filtered
    }
}
