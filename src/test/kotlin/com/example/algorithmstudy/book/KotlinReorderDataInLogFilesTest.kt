package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KotlinReorderDataInLogFilesTest {
    /*
     * 로그를 재정렬하라. 기준은 다음과 같다.
     * 1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않는다.
     * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
     * 3. 문자가 동일할 경우에는 식별자순으로 한다.
     * 4. 숫자 로그는 입력 순서대로 한다.
     */

    @Test
    fun test_reorderLogFiles() {
        val given = arrayOf("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero")
        val actual: Array<String> = reorderLogFiles(given)
        val expected = arrayOf("id2 art can", "id5 art zero", "id4 own kit dig", "id1 8 1 5 1", "id3 3 6")
        assertArrayEquals(expected, actual)
    }

    private fun reorderLogFiles(arr: Array<String>): Array<String> {
        val letterList = mutableListOf<LogData>()
        val digitList = mutableListOf<LogData>()

        for (item in arr) {
            val logData = LogData(item)
            if (Character.isDigit(logData.value[0])) {
                digitList.add(logData)
            } else {
                letterList.add(logData)
            }
        }

        letterList.sortWith(LogData::compareTo)

        return (letterList + digitList).map { it.origin }.toTypedArray()
    }

    class LogData(val origin: String) {
        val id = origin.substringBefore(' ')
        val value = origin.substringAfter(' ')

        fun compareTo(o: LogData): Int {
            val compared = value.compareTo(o.value)
            return if (compared == 0) id.compareTo(o.id) else compared
        }
    }
}
