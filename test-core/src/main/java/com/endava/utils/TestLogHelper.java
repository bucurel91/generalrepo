package com.endava.utils;

import org.slf4j.MDC;

public class TestLogHelper {
    private static final String TEST_NAME = "scenarioname";

    public static void startTestLogging(String scenarioName) {
        MDC.put(TEST_NAME, scenarioName);
    }

    public static void stopTestLogging() {
        MDC.remove(TEST_NAME);
    }
}
