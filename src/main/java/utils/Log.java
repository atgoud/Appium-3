package utils;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Assert;

public class Log {

  public static void log(final String textToLog) {
    System.out.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" INFO: ").append(textToLog).toString());
  }

  public static void logError(final String textToLog) {
    System.err.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" ERROR: ").append(textToLog).toString());
  }

  public static void logFail(final String textToLog) {
    System.err.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" FAIL: ").append(textToLog).toString());
    Assert.fail(textToLog);
  }

  public static void logFail(final String textToLog, final Throwable exception) {
    System.err.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" FAIL: ").append(textToLog).toString());
    exception.printStackTrace();
    Assert.fail(textToLog);
  }

  public static void logPass(final String textToLog) {
    System.out.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" PASS: ").append(textToLog).toString());
  }

  public static void logTestStep(final String textToLog) {
    System.out.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" TEST STEP: ").append(textToLog).toString());
  }

  public static void logWarning(final String textToLog) {
    System.out.println(new StringBuilder(new Timestamp(new Date().getTime())
        .toString()).append(" WARN: ").append(textToLog).toString());
  }

  public Log() {
  }
}