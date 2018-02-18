import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
public class PossibilitiesTests {
  @Test
  public void aSingleSignal() {
    assertEquals(Arrays.asList("E"), Challenge.possibilities("."));
    assertEquals(Arrays.asList("A"), Challenge.possibilities(".-"));
  }
  @Test
  public void aWordWithASingleUnknownSignal() {
    assertEquals(Arrays.asList("E","T"), Challenge.possibilities("?"));
    assertEquals(Arrays.asList("I","N"), Challenge.possibilities("?."));
    assertEquals(Arrays.asList("I","A"), Challenge.possibilities(".?"));
  }
  @Test
  public void aWordWithTwoUnknownSignals() {
    assertEquals(Arrays.asList("R", "W", "G", "O"), Challenge.possibilities("?-?"));
  }
}
