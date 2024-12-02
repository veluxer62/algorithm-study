package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KotlinGetReportResultsTest {
    /*
     * 신고 내역을 입력받아 신고당한 횟수가 K번 이상이면 신고자에게 안내 메일을 발송한다.
     * 각 신고자가 받는 메일 횟수를 출력하라.
     */

    @Test
    fun test_getReportResults() {
        var id_list = arrayOf("muzi", "frodo", "apeach", "neo")
        var report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
        var k = 2

        var actual = getReport(id_list, report, k)
        assertArrayEquals(
            intArrayOf(2, 1, 1, 0),
            actual,
        )

        id_list = arrayOf("con", "ryan")
        report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con", "ryan con")
        k = 3

        actual = getReport(id_list, report, k)
        assertArrayEquals(
            intArrayOf(0, 0),
            actual,
        )
    }

    private fun getReport(
        idList: Array<String>,
        report: Array<String>,
        k: Int,
    ): IntArray {
        val distinctReport = report.distinct()

        val log = mutableMapOf<String, MutableList<String>>()
        for (r in distinctReport) {
            val person = r.split(" ")
            val list = log.getOrDefault(person[1], mutableListOf())
            list.add(person[0])
            log[person[1]] = list
        }

        val mailCount = mutableMapOf<String, Int>()
        for (l in log) {
            if (l.value.size >= k) {
                for (x in l.value) {
                    mailCount[x] = mailCount.getOrDefault(x, 0) + 1
                }
            }
        }

        return idList.map { mailCount.getOrDefault(it, 0) }.toIntArray()
    }
}
