package sorts.bubble.bubble;

import org.testng.annotations.Test;
import sorts.SortTest;

import java.util.function.Function;

import static org.testng.Assert.assertEquals;

/**
 * Created by timadair on 9/2/2017.
 */
public class BubbleSortTest extends SortTest {

  @Test
  public void shouldPerformInPlaceSort() {
    String[] inputArray = {"B", "D", "A", "Z"};
    String[] sorted = getSortingAlgorithm().apply(inputArray);
    assertEquals(inputArray, sorted);
  }

  @Override
  protected Function<String[], String[]> getSortingAlgorithm() {
    return new BubbleSort()::sort;
  }

  @Override
  protected String getSortName() {
    return "BubbleSort";
  }
}
