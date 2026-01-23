package utils;

import org.slf4j.MDC;
import java.util.UUID;

public class LogContext {

    public static void init(String scenarioName) {
        MDC.put("requestId", UUID.randomUUID().toString());
        MDC.put("testId", sanitize(scenarioName));
    }

    public static void clear() {
        MDC.clear();
    }

    private static String sanitize(String name) {
        return name.replaceAll("\\s+", "_");
    }
}
