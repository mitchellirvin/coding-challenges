import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  public static void main() {
    Result result = JUnitCore.runClasses(MainTest.class);

    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    System.out.println("Test cases passed: " + result.wasSuccessful());
  }
}
