package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReconstructItineraryTest {
    private final Solution sut = new Solution();

    /*
     * [from, to]로 구성된 항공권 목록을 이용해 JFK에서 출발하는 여행 일정을 구성하라. 여러 일정이 있는 경우 사전 어휘순으로 방문한다.
     */

    @Test
    public void test_findItinerary() {
        var tickets = List.of(
                List.of("MUC", "ICN"),
                List.of("JFK", "MUC"),
                List.of("SFO", "SJC"),
                List.of("ICN", "SFO")
        );
        var actual = record(() -> sut.findItinerary(tickets));
        assertEquals(
                List.of("JFK", "MUC", "ICN", "SFO", "SJC"),
                actual
        );

        var tickets2 = List.of(
                List.of("JFK", "ICN"),
                List.of("JFK", "ATL"),
                List.of("ICN", "ATL"),
                List.of("ATL", "ICN"),
                List.of("ATL", "JFK")
        );
        actual = record(() -> sut.findItinerary(tickets2));
        assertEquals(
                List.of("JFK", "ATL", "ICN", "ATL", "JFK", "ICN"),
                actual
        );
    }

    @Test
    public void test_findItinerary2() {
        var tickets = List.of(
                List.of("MUC", "ICN"),
                List.of("JFK", "MUC"),
                List.of("SFO", "SJC"),
                List.of("ICN", "SFO")
        );
        var actual = record(() -> sut.findItinerary2(tickets));
        assertEquals(
                List.of("JFK", "MUC", "ICN", "SFO", "SJC"),
                actual
        );

        var tickets2 = List.of(
                List.of("JFK", "ICN"),
                List.of("JFK", "ATL"),
                List.of("ICN", "ATL"),
                List.of("ATL", "ICN"),
                List.of("ATL", "JFK")
        );
        actual = record(() -> sut.findItinerary2(tickets2));
        assertEquals(
                List.of("JFK", "ATL", "ICN", "ATL", "JFK", "ICN"),
                actual
        );
    }


    private static class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            var results = new LinkedList<String>();
            var fromToMap = new HashMap<String, PriorityQueue<String>>();

            for (var ticket: tickets) {
                fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                fromToMap.get(ticket.get(0)).add(ticket.get(1));
            }

            dfs(results, fromToMap, "JFK");

            return results;
        }

        private void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {
            while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
                dfs(results, fromToMap, fromToMap.get(from).poll());
            }

            results.add(0, from);
        }

        /*
         * 1.
         * r=[]
         * m={
         *      "MUC"=["ICN"],
         *      "JFK"=["MUC"],
         *      "SFO"=["SJC"],
         *      "ICN"=["SFO"]
         * }
         * f="JFK"
         *      m={
         *          "MUC"=["ICN"],
         *          "JFK"=[],
         *          "SFO"=["SJC"],
         *          "ICN"=["SFO"]
         *      }
         *      f="MUC"
         *          m={
         *              "MUC"=[],
         *              "JFK"=[],
         *              "SFO"=["SJC"],
         *              "ICN"=["SFO"]
         *          }
         *          f="ICN"
         *              m={
         *                  "MUC"=[],
         *                  "JFK"=[],
         *                  "SFO"=["SJC"],
         *                  "ICN"=[]
         *              }
         *              f="SFO"
         *                  m={
         *                      "MUC"=[],
         *                      "JFK"=[],
         *                      "SFO"=[],
         *                      "ICN"=[]
         *                  }
         *                  f="SJC"
         *
         *                  r=["SJC"]
         *              r=["SFO", "SJC"]
         *          r=["ICN", "SFO", "SJC"]
         *      r=["MUC", "ICN", "SFO", "SJC"]
         * r=["JFK", "MUC", "ICN", "SFO", "SJC"]
         *
         * 2.
         * r=[]
         * m={
         *      "JFK"=["ATL", "ICN"],
         *      "ICN"=["ATL"],
         *      "ATL"=["ICN", "JFK"]
         * }
         * f="JFK"
         *      m={
         *          "JFK"=["ICN"],
         *          "ICN"=["ATL"],
         *          "ATL"=["ICN", "JFK"]
         *      }
         *      f="ATL"
         *          m={
         *              "JFK"=["ICN"],
         *              "ICN"=["ATL"],
         *              "ATL"=["JFK"]
         *          }
         *          f="ICN"
         *              m={
         *                  "JFK"=["ICN"],
         *                  "ICN"=[],
         *                  "ATL"=["JFK"]
         *              }
         *              f="ATL"
         *                  m={
         *                      "JFK"=["ICN"],
         *                      "ICN"=[],
         *                      "ATL"=[]
         *                  }
         *                  f="JFK"
         *                      m={
         *                          "JFK"=[],
         *                          "ICN"=[],
         *                          "ATL"=[]
         *                      }
         *                      f="ICN"
         *                      r=["ICN"]
         *                  r=["JFK", "ICN"]
         *              r=["ATL", "JFK", "ICN"]
         *          r=["ICN", "ATL", "JFK", "ICN"]
         *      r=["ATL", "ICN", "ATL", "JFK", "ICN"]
         * r=["JFK", "ATL", "ICN", "ATL", "JFK", "ICN"]
         */

        public List<String> findItinerary2(List<List<String>> tickets) {
            var fromToMap = new HashMap<String, PriorityQueue<String>>();

            for (var ticket: tickets) {
                fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                fromToMap.get(ticket.get(0)).add(ticket.get(1));
            }

            var results = new LinkedList<String>();
            var stack = new ArrayDeque<String>();

            stack.push("JFK");
            while (!stack.isEmpty()) {
                while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                    stack.push(fromToMap.get(stack.getFirst()).poll());
                }

                results.add(0, stack.pop());
            }

            return results;
        }
    }
}
