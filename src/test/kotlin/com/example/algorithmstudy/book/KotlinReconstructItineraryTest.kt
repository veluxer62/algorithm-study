package com.example.algorithmstudy.book

import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinReconstructItineraryTest {
    /*
     * [from, to]로 구성된 항공권 목록을 이용해 JFK에서 출발하는 여행 일정을 구성하라. 여러 일정이 있는 경우 사전 어휘순으로 방문한다.
     */

    @Test
    fun test_findItinerary() {
        val tickets =
            listOf(
                listOf("MUC", "ICN"),
                listOf("JFK", "MUC"),
                listOf("SFO", "SJC"),
                listOf("ICN", "SFO"),
            )
        val actual = record { findItinerary(tickets) }
        assertEquals(
            listOf("JFK", "MUC", "ICN", "SFO", "SJC"),
            actual,
        )

        val tickets2 =
            listOf(
                listOf("JFK", "ICN"),
                listOf("JFK", "ATL"),
                listOf("ICN", "ATL"),
                listOf("ATL", "ICN"),
                listOf("ATL", "JFK"),
            )
        val actual2 = record { findItinerary(tickets2) }
        assertEquals(
            listOf("JFK", "ATL", "ICN", "ATL", "JFK", "ICN"),
            actual2,
        )
    }

    @Test
    fun test_findItinerary2() {
        val tickets =
            listOf(
                listOf("MUC", "ICN"),
                listOf("JFK", "MUC"),
                listOf("SFO", "SJC"),
                listOf("ICN", "SFO"),
            )
        val actual = record { findItinerary2(tickets) }
        assertEquals(
            listOf("JFK", "MUC", "ICN", "SFO", "SJC"),
            actual,
        )

        val tickets2 =
            listOf(
                listOf("JFK", "ICN"),
                listOf("JFK", "ATL"),
                listOf("ICN", "ATL"),
                listOf("ATL", "ICN"),
                listOf("ATL", "JFK"),
            )
        val actual2 = record { findItinerary2(tickets2) }
        assertEquals(
            listOf("JFK", "ATL", "ICN", "ATL", "JFK", "ICN"),
            actual2,
        )
    }

    private fun findItinerary(tickets: List<List<String>>): List<String> {
        val results = mutableListOf<String>()
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

        dfs("JFK")

        return results
    }

    private fun findItinerary2(tickets: List<List<String>>): List<String> {
        val fromToMap = mutableMapOf<String, PriorityQueue<String>>()

        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue())
            fromToMap[ticket[0]]?.add(ticket[1])
        }

        val results = mutableListOf<String>()
        val stack = ArrayDeque<String>()

        stack.add("JFK")

        while (stack.isNotEmpty()) {
            while (fromToMap[stack.last()]?.isNotEmpty() == true) {
                stack.add(fromToMap[stack.last()]!!.poll())
            }
            results.add(0, stack.removeLast())
        }

        return results
    }
}
