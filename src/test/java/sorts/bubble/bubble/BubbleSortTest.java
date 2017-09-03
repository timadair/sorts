package sorts.bubble.bubble;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static sorts.SortTestHelper.assertEqualToJavaSort;
import static sorts.SortTestHelper.assertSortingOfAllPermutations;

/**
 * Created by timadair on 9/2/2017.
 */
public class BubbleSortTest {

  public static final String BUBBLE_SORT_NAME = "BubbleSort";

  @Test
  public void shouldHandleEmptyInputs() {
    new BubbleSort().sort(new String[0]);
  }

  @Test
  public void shouldSortOneItem() {
    assertEqualToJavaSort(new String[]{"A"}, new BubbleSort()::sort);
  }

  @Test
  public void shouldSortTwoItems() {
    assertSortingOfAllPermutations(new BubbleSort()::sort, Arrays.asList("A", "B"), BUBBLE_SORT_NAME);
  }

  @Test
  public void shouldSortThreeItems() {
    assertSortingOfAllPermutations(new BubbleSort()::sort, Arrays.asList("A", "B", "C"), BUBBLE_SORT_NAME);
  }

  @Test
  public void shouldSortFourItems() {
    assertSortingOfAllPermutations(new BubbleSort()::sort, Arrays.asList("A", "B", "C", "D"), BUBBLE_SORT_NAME);
  }

  @Test
  public void shouldSortTenItems() {
    List<String> itemsToSort = IntStream.rangeClosed(1, 10)
        .boxed()
        .map(i -> Integer.toString(i))
        .collect(Collectors.toList());
    assertSortingOfAllPermutations(new BubbleSort()::sort, itemsToSort, BUBBLE_SORT_NAME);
  }

  @Test
  public void shouldPerformInPlaceSort() {
    String[] inputArray = {"B", "D", "A", "Z"};
    String[] sorted = new BubbleSort().sort(inputArray);
    assertEquals(inputArray, sorted);
  }
}
