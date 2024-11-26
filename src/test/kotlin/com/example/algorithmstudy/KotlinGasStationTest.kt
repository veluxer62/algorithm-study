package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinGasStationTest {
    /*
     * 원형으로 경로가 연결된 주유소 목록이 있다. 각 주유소는 gas[i]만큼의 기름을 보유하고 있으며, 다음 주유소로 이동하는데 cost[i]가 필요하다.
     * 기름이 부족하면 이동할 수 없다고 할 때 주유소를 방문할 수 있는 출발점의 인덱스를 출력하라.
     */

    @Test
    fun test_canCompleteCircuit() {
        val gas = intArrayOf(5, 1, 2, 3, 4)
        val cost = intArrayOf(4, 4, 1, 5, 1)

        val actual: Int = canCompleteCircuit(gas, cost)

        assertEquals(4, actual)
    }

    @Test
    fun test_canCompleteCircuit2() {
        val gas = intArrayOf(5, 1, 2, 3, 4)
        val cost = intArrayOf(4, 4, 1, 5, 1)

        val actual: Int = canCompleteCircuit2(gas, cost)

        assertEquals(4, actual)
    }

    private fun canCompleteCircuit(
        gas: IntArray,
        cost: IntArray,
    ): Int {
        for (start in gas.indices) {
            var fuel = 0
            var canTravel = true

            for (i in start until gas.size + start) {
                val index = i % gas.size

                if (fuel + gas[index] < cost[index]) {
                    canTravel = false
                    break
                } else {
                    fuel += gas[index] - cost[index]
                }
            }

            if (canTravel) {
                return start
            }
        }

        return -1
    }

    private fun canCompleteCircuit2(
        gas: IntArray,
        cost: IntArray,
    ): Int {
        if (gas.sum() < cost.sum()) return -1

        var start = 0
        var fuel = 0

        for (i in gas.indices) {
            if (fuel + gas[i] < cost[i]) {
                start += i
                fuel = 0
            } else {
                fuel += gas[i] - cost[i]
            }
        }

        return start
    }
}
