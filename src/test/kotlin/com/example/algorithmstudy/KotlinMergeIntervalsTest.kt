package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Comparator

class KotlinMergeIntervalsTest {
    /*
     * 겹치는 구간을 병합하라.
     */

    @Test
    fun test_merge() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(8, 11), intArrayOf(2, 6), intArrayOf(15, 18))
        val actual: Array<IntArray> = merge(intervals)
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(1, 6), intArrayOf(8, 11), intArrayOf(15, 18)),
            actual,
        )
    }

    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged = mutableListOf<IntArray>()

        intervals.sortWith(Comparator.comparingInt { a -> a[0] })

        for (interval in intervals) {
            if (merged.isNotEmpty() && interval[0] < merged.last().last()) {
                merged.last()[1] = maxOf(merged.last().last(), interval.last())
            } else {
                merged.add(interval)
            }
        }

        return merged.toTypedArray()
    }
}
