package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinCourseScheduleTest {
    /*
     * 0을 완료하기 위해서는 1을 끝내야 한다는 것을 [0,1] 쌍으로 표현하는 n개의 코스가 있다.
     * 코스 개수 n과 이 쌍들을 입력으로 받았을 때 모든 코스가 완료 가능한지 판별하라.
     */

    @Test
    fun test_canFinish() {
        var numCourses = 3
        var prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1))
        var actual: Boolean = canFinish(numCourses, prerequisites)
        assertTrue(actual)

        numCourses = 2
        prerequisites = arrayOf(intArrayOf(2, 1), intArrayOf(1, 2))
        actual = canFinish(numCourses, prerequisites)
        assertFalse(actual)
    }

    @Test
    fun test_canFinish2() {
        var numCourses = 3
        var prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1))
        var actual: Boolean = canFinish2(numCourses, prerequisites)
        assertTrue(actual)

        numCourses = 2
        prerequisites = arrayOf(intArrayOf(2, 1), intArrayOf(1, 2))
        actual = canFinish2(numCourses, prerequisites)
        assertFalse(actual)
    }

    private fun canFinish(
        numCourses: Int,
        prerequisites: Array<IntArray>,
    ): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (p in prerequisites) {
            map.putIfAbsent(p[0], mutableListOf())
            map[p[0]]?.add(p[1])
        }

        val takes = mutableListOf<Int>()

        fun dfs(k: Int): Boolean {
            if (takes.contains(k)) return false

            if (map.containsKey(k)) {
                takes.add(k)
                for (p in map[k]!!) {
                    if (!dfs(p)) return false
                }
                takes.remove(k)
            }

            return true
        }

        for (k in map.keys) {
            if (!dfs(k)) return false
        }

        return true
    }

    private fun canFinish2(
        numCourses: Int,
        prerequisites: Array<IntArray>,
    ): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (p in prerequisites) {
            map.putIfAbsent(p[0], mutableListOf())
            map[p[0]]?.add(p[1])
        }

        val takes = mutableListOf<Int>()
        val taken = mutableListOf<Int>()

        fun dfs(k: Int): Boolean {
            if (takes.contains(k)) return false
            if (taken.contains(k)) return true

            if (map.containsKey(k)) {
                takes.add(k)
                for (p in map[k]!!) {
                    if (!dfs(p)) return false
                }
                takes.remove(k)
                taken.add(k)
            }

            return true
        }

        for (k in map.keys) {
            if (!dfs(k)) return false
        }

        return true
    }
}
