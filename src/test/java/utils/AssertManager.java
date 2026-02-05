package utils;

import org.testng.Assert;

public class AssertManager {

    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {

            FailureLogger.logFailure(
                    FailureType.ASSERTION,
                    message,
                    e
            );

            throw e; // fail test
        }
    }
}
