package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.PriorityQueue

class KotlinTravelPathTest {
    /*
     * 티켓 정보를 받아 ICN 공항에서 출발해 모든 경로를 방문하는 여행 경로를 출력하라.
     */

    @Test
    fun test_findPath() {
        var tickets =
            arrayOf(
                arrayOf("ICN", "JFK"),
                arrayOf("HND", "IAD"),
                arrayOf("JFK", "HND"),
            )
        var actual = findPath(tickets)
        assertArrayEquals(
            arrayOf("ICN", "JFK", "HND", "IAD"),
            actual,
        )

        tickets =
            arrayOf(
                arrayOf("ICN", "SFO"),
                arrayOf("ICN", "ATL"),
                arrayOf("SFO", "ATL"),
                arrayOf("ATL", "ICN"),
                arrayOf("ATL", "SFO"),
            )
        actual = findPath(tickets)
        assertArrayEquals(
            arrayOf("ICN", "ATL", "ICN", "SFO", "ATL", "SFO"),
            actual,
        )
    }

    @Test
    fun test_findPath2() {
        var tickets =
            arrayOf(
                arrayOf("ICN", "JFK"),
                arrayOf("HND", "IAD"),
                arrayOf("JFK", "HND"),
            )
        var actual = findPath2(tickets)
        assertArrayEquals(
            arrayOf("ICN", "JFK", "HND", "IAD"),
            actual,
        )

        tickets =
            arrayOf(
                arrayOf("ICN", "SFO"),
                arrayOf("ICN", "ATL"),
                arrayOf("SFO", "ATL"),
                arrayOf("ATL", "ICN"),
                arrayOf("ATL", "SFO"),
            )
        actual = findPath2(tickets)
        assertArrayEquals(
            arrayOf("ICN", "ATL", "ICN", "SFO", "ATL", "SFO"),
            actual,
        )
    }

    private fun findPath(tickets: Array<Array<String>>): Array<String> {
        val fromToMap = mutableMapOf<String, PriorityQueue<String>>()
        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue())
            fromToMap[ticket[0]]?.add(ticket[1])
        }

        val results = LinkedList<String>()
        val stack = ArrayDeque<String>()

        stack.add("ICN")
        while (stack.isNotEmpty()) {
            while (fromToMap[stack.last()]?.isNotEmpty() == true) {
                stack.add(fromToMap[stack.last()]!!.poll())
            }
            results.add(0, stack.removeLast())
        }

        return results.toTypedArray()
    }

    private fun findPath2(tickets: Array<Array<String>>): Array<String> {
        val results = LinkedList<String>()

        val fromToMap = mutableMapOf<String, PriorityQueue<String>>()
        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue())
            fromToMap[ticket[0]]?.add(ticket[1])
        }

        fun dfs(path: String) {
            while (fromToMap[path]?.isNotEmpty() == true) {
                dfs(fromToMap[path]!!.poll())
            }

            results.add(0, path)
        }

        dfs("ICN")

        return results.toTypedArray()
    }
}
