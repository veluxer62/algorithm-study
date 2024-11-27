import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinMajorityElementTest {
    /*
     * 과반수를 차지하는(절반을 초과하는) 엘리먼트를 출력하라.
     */

    @Test
    fun test_majorityElement() {
        val nums = intArrayOf(2, 2, 1, 1, 3, 2, 2)
        val actual: Int = majorityElement(nums)
        Assertions.assertEquals(2, actual)
    }

    @Test
    fun test_majorityElement2() {
        val nums = intArrayOf(2, 2, 1, 1, 3, 2, 2)
        val actual: Int = majorityElement2(nums)
        Assertions.assertEquals(2, actual)
    }

    @Test
    fun test_majorityElement3() {
        val nums = intArrayOf(2, 2, 1, 1, 3, 2, 2)
        val actual: Int = majorityElement3(nums)
        Assertions.assertEquals(2, actual)
    }

    private fun majorityElement(nums: IntArray): Int {
        val countsMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            countsMap[num] = countsMap.getOrDefault(num, 0) + 1
        }

        val reversedSortedMap = mutableMapOf<Int, Int>()
        countsMap.entries
            .sortedByDescending { it.value }
            .forEachIndexed { _, it -> reversedSortedMap[it.key] = it.value }

        val first = reversedSortedMap.iterator().next()
        if (first.value > nums.size / 2) {
            return first.key
        }

        return -1
    }

    private fun majorityElement2(nums: IntArray): Int {
        fun majorityElement(
            left: Int,
            right: Int,
        ): Int {
            if (left == right) return nums[left]

            val mid = left + (right - left) / 2
            val a = majorityElement(left, mid)
            val b = majorityElement(mid + 1, right)

            var countA = 0
            for (i in left..right) {
                if (nums[i] == a) {
                    countA++
                }
            }

            return if (countA > nums.size / 2) a else b
        }

        return majorityElement(0, nums.size - 1)
    }

    private fun majorityElement3(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }
}
