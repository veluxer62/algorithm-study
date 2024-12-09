package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.TreeSet

class KotlinRemoveDuplicateLettersTest {
    /*
     * 중복된 문자를 제외하고 사전식 순서로 나열하라.
     */

    @Test
    fun test_removeDuplicateLetters() {
        val s = "dbacdcdb"
        val actual: String = removeDuplicateLetters(s)
        Assertions.assertEquals("acdb", actual)
    }

    @Test
    fun test_removeDuplicateLetters2() {
        val s = "dbacdcdb"
        val actual: String = removeDuplicateLetters2(s)
        Assertions.assertEquals("acdb", actual)
    }

    private fun removeDuplicateLetters(s: String): String {
        for (c in toSortedSet(s)) {
            val suffix = s.substring(s.indexOf(c))
            if (toSortedSet(s) == toSortedSet(suffix)) {
                val replaced = suffix.replace(c.toString(), "")
                return c + removeDuplicateLetters(replaced)
            }
        }

        return ""
    }

    private fun toSortedSet(s: String): Set<Char> {
        val set = TreeSet<Char> { o1, o2 -> o1.compareTo(o2) }

        for (c in s) {
            set.add(c)
        }

        return set
    }

    private fun removeDuplicateLetters2(s: String): String {
        val counter = mutableMapOf<Char, Int>()
        val seen = mutableMapOf<Char, Boolean>()
        val stack = ArrayDeque<Char>()

        for (c in s) {
            counter[c] = counter.getOrDefault(c, 0) + 1
        }

        for (c in s) {
            counter[c] = counter.getOrDefault(c, 0) - 1

            if (seen[c] == true) {
                continue
            }

            while (stack.isNotEmpty() && stack.first() > c && counter[stack.first()]!! > 0) {
                seen[stack.removeFirst()] = false
            }

            stack.addFirst(c)
            seen[c] = true
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.removeLast())
        }
        return sb.toString()
    }
}
