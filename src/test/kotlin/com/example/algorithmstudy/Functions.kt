package com.example.algorithmstudy

fun <T> record(fn: RunningTimeRecorder<T>): T {
    return fn.record()
}
