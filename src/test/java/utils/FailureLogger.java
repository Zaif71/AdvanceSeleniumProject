package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailureLogger {

    private static final Logger log =
            LoggerFactory.getLogger("FAILURE");

    public static void logFailure(
            FailureType type,
            String reason,
            Throwable e   // 🔥 CHANGED
    ) {
        log.error("FAILURE_TYPE={} | REASON={}", type, reason);
        log.error("EXCEPTION={}", e.getClass().getSimpleName());
        log.error("MESSAGE={}", e.getMessage());
    }
}
