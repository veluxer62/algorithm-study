package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KotlinReverseStringTest {
    /*
     * 문자열을 뒤집는 함수를 작성하라, 입력값은 문자 배열이며, 리턴 없이 입력 배열 내부를 직접 조작하라.
     */

    @Test
    fun test_reverseString() {
        var given = charArrayOf('r', 'a', 'c', 'e', 'c', 'a', 'r')
        reverseString(given)
        assertArrayEquals(charArrayOf('r', 'a', 'c', 'e', 'c', 'a', 'r'), given)

        given = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g')
        reverseString(given)
        assertArrayEquals(charArrayOf('g', 'f', 'e', 'd', 'c', 'b', 'a'), given)
    }

    private fun reverseString(arr: CharArray) {
        var start = 0
        var end = arr.size - 1

        while (start < end) {
//            val temp = arr[start]
//            arr[start] = arr[end]
//            arr[end] = temp

            arr[start] = arr[end].also { arr[end] = arr[start] }

            start++
            end--
        }
    }
}
