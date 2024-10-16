package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KotlinTopKFrequentElementsTest {
    /*
     * 빈도순으로 k개의 엘리먼트를 추출하라
     */

    @Test
    fun test_topKFrequent() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3, 4)
        val k = 2
        val actual: IntArray = topKFrequent(nums, k)
        Assertions.assertArrayEquals(
            intArrayOf(1, 2),
            actual,
        )
    }

    @Test
    fun test_topKFrequent2() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3, 4)
        val k = 2
        val actual: IntArray = topKFrequent2(nums, k)
        Assertions.assertArrayEquals(
            intArrayOf(1, 2),
            actual,
        )
    }

    private fun topKFrequent(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val bucket = mutableMapOf<Int, MutableList<Int>>()
        for (element in frequencyMap.keys) {
            val frequency = frequencyMap.getOrDefault(element, 0)
            val elements = bucket.getOrDefault(frequency, mutableListOf())
            elements.add(element)
            bucket[frequency] = elements
        }

        val result = IntArray(k)
        var index = 0
        for (frequency in nums.size downTo 0) {
            if (index >= k) break

            if (bucket.containsKey(frequency)) {
                for (element in bucket[frequency]!!) {
                    result[index] = element
                    index++
                }
            }
        }

        return result
    }

    private fun topKFrequent2(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val pq = PriorityQueue<IntArray> { a, b -> b[1] - a[1] }
        for (element in frequencyMap.keys) {
            val frequency = frequencyMap.getOrDefault(element, 0)
            pq.add(intArrayOf(element, frequency))
        }

        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = pq.poll()[0]
        }

        return result
    }
}
