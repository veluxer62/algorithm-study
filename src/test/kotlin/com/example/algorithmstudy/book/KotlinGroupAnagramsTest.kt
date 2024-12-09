package com.example.algorithmstudy.book

import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinGroupAnagramsTest {
    /*
     * 문자열 배열을 받아 애너그램 단위로 그룹핑하라.
     */

    @Test
    fun test_groupAnagrams() {
        val arr = arrayOf("eat", "tea", "tan", "ate", "ant", "cat")
        val actual =
            record {
                groupAnagrams(arr)
            }
        Assertions.assertEquals(
            listOf(listOf("ate", "eat", "tea"), listOf("ant", "tan"), listOf("cat")),
            actual,
        )
    }

    private fun groupAnagrams(arr: Array<String>): List<List<String>> {
        val results = mutableMapOf<String, MutableList<String>>()

        for (str in arr) {
            val key = str.toCharArray().sorted().joinToString("")

            results.getOrPut(key) { mutableListOf() }
            results[key]!!.add(str)
        }

        results.forEach { (_, v) ->
            v.sort()
        }
        return results.values.toList()
    }
}
