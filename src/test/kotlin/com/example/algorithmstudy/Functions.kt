package com.example.algorithmstudy

import kotlin.random.Random

fun <T> record(fn: RunningTimeRecorder<T>): T {
    return fn.record()
}

fun <T> assertContains(
    expected: Collection<T>,
    actual: Collection<T>,
) {
    if (!expected.containsAll(actual)) {
        throw AssertionError("$expected are not contains $actual")
    }
}

fun generateIntArray(size: Int): IntArray {
    val randomArray = IntArray(size)

    for (i in 0 until size) {
        randomArray[i] = Random.nextInt()
    }

    return randomArray
}

fun generateList(size: Int): List<Int> {
    return List(size) { Random.nextInt() }
}
