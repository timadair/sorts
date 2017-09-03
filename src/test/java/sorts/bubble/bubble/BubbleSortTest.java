package sorts.bubble.bubble;

import sorts.SortTest;

import java.util.function.Function;

/**
 * Created by timadair on 9/2/2017.
 */
public class BubbleSortTest extends SortTest {
  @Override
  protected Function<String[], String[]> getSortingAlgorithm() {
    return new BubbleSort()::sort;
  }

  @Override
  protected String getSortName() {
    return null;
  }
}
