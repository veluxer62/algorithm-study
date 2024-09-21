package com.example.algorithmstudy;

import java.util.logging.Logger;

@FunctionalInterface
public interface RunningTimeRecorder<T> {
    Logger logger = Logger.getLogger("RunningTimeRecorder");

    T process();

    default T record() {
        final long startTime = System.nanoTime();
        final var result = process();
        final long endTime = System.nanoTime();

        logger.info("runtime: " + formatTime(endTime - startTime));

        return result;
    }

    private String formatTime(long nanoTime) {
        long seconds = nanoTime / 1_000_000_000;
        nanoTime = nanoTime % 1_000_000_000;

        long milliseconds = nanoTime / 1_000_000;
        nanoTime = nanoTime % 1_000_000;

        long nanos = nanoTime;

        // 포맷된 문자열 반환
        return seconds + "sec " + milliseconds + "ms " + nanos + "nano";
    }
}
