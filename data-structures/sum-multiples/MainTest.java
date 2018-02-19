import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class MainTest {
  @Test
  public void testsMain() {

    Main main = new Main();
    assertEquals(0, main.basicFunction());
  }
}
