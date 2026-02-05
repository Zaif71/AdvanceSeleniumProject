package utils;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class FailureClassifier {

    public static FailureType classify(Throwable e) {

        if (e instanceof TimeoutException) {
            return FailureType.APPLICATION;
        }

        if (e instanceof NoSuchElementException
                || e instanceof InvalidSelectorException) {
            return FailureType.SCRIPT;
        }

        if (e instanceof AssertionError) {
            return FailureType.ASSERTION;
        }

        return FailureType.ENVIRONMENT;
    }
}
