package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.time.LocalTime
import kotlin.math.ceil

class KotlinCalculationOfParkingFeesTest {
    /*
     * 주차장의 요금표와 출차기록이 주어졌을 때, 차량별 주차 요금을 계산해 차량번호가 작은 순으로 출력하라.
     */

    @Test
    fun test_calculateParkingFees() {
        var fees = intArrayOf(180, 5000, 10, 600)
        var records =
            arrayOf(
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT",
            )
        var actual: IntArray = calculateParkingFees(fees, records)
        assertArrayEquals(
            intArrayOf(14600, 34400, 5000),
            actual,
        )

        fees = intArrayOf(120, 0, 60, 591)
        records =
            arrayOf(
                "16:00 3961 IN",
                "16:00 0202 IN",
                "18:00 3961 OUT",
                "18:00 0202 OUT",
                "23:58 3961 IN",
            )
        actual = calculateParkingFees(fees, records)
        assertArrayEquals(
            intArrayOf(0, 591),
            actual,
        )
    }

    private fun calculateParkingFees(
        fees: IntArray,
        records: Array<String>,
    ): IntArray {
        val logs = mutableMapOf<String, Int>()
        val times = mutableMapOf<String, Int>()

        for (record in records) {
            val log = record.split(" ")
            val time = LocalTime.parse("00:${log[0]}")

            if (log.last() == "IN") {
                logs[log[1]] = time.toSecondOfDay()
            } else {
                val elapsed = time.toSecondOfDay() - logs[log[1]]!!
                times[log[1]] = times.getOrDefault(log[1], 0) + elapsed
                logs.remove(log[1])
            }
        }

        for (log in logs) {
            times[log.key] = times.getOrDefault(log.key, 0) + 23 * 60 + 59 - log.value
        }

        val timeKeys = times.keys.sortedBy { it.toInt() }

        val answer = IntArray(timeKeys.size)
        for ((i, k) in timeKeys.withIndex()) {
            val fee =
                if (times[k]!! <= fees[0]) {
                    fees[1]
                } else {
                    fees[1] + ceil((times[k]!! - fees[0]) / fees[2].toDouble()).toInt() * fees[3]
                }

            answer[i] = fee
        }

        return answer
    }
}
