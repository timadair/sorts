package sorts.efficient.merge;

import org.testng.annotations.Test;
import sorts.SortTest;

import java.util.function.Function;

import static org.testng.Assert.assertEquals;

public class MergeSortTest extends SortTest {

  @Override
  protected Function<String[], String[]> getSortingAlgorithm() {
    return new MergeSort()::sort;
  }

  @Override
  protected String getSortName() {
    return "MergeSort";
  }

  @Test
  public void shouldLeaveInputUnchanged() {
    String[] inputArray = {"B", "D", "A", "Z"};
    getSortingAlgorithm().apply(inputArray);
    assertEquals(inputArray, new String[]{"B", "D", "A", "Z"});
  }
}
