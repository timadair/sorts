package sorts.efficient.merge;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static sorts.SortTestHelper.assertEqualToJavaSort;
import static sorts.SortTestHelper.assertSortingOfAllPermutations;

public class MergeSortTest {

  private static final String MERGE_SORT_NAME = "MergeSort";

  @Test
  public void shouldHandleEmptyInputs() {
    new MergeSort().sort(new String[0]);
  }

  @Test
  public void shouldSortOneItem() {
    assertEqualToJavaSort(new String[]{"A"}, new MergeSort()::sort);
  }

  @Test
  public void shouldSortTwoItems() {
    assertSortingOfAllPermutations(new MergeSort()::sort, Arrays.asList("A", "B"), MERGE_SORT_NAME);
  }

  @Test
  public void shouldSortThreeItems() {
    assertSortingOfAllPermutations(new MergeSort()::sort, Arrays.asList("A", "B", "C"), MERGE_SORT_NAME);
  }

  @Test
  public void shouldSortFourItems() {
    assertSortingOfAllPermutations(new MergeSort()::sort, Arrays.asList("A", "B", "C", "D"), MERGE_SORT_NAME);
  }

  @Test
  public void shouldSortTenItems() {
    List<String> itemsToSort = IntStream.rangeClosed(1, 10)
        .boxed()
        .map(i -> Integer.toString(i))
        .collect(Collectors.toList());
    assertSortingOfAllPermutations(new MergeSort()::sort, itemsToSort, MERGE_SORT_NAME);
  }

  @Test
  public void shouldLeaveInputUnchanged() {
    String[] inputArray = {"B", "D", "A", "Z"};
    new MergeSort().sort(inputArray);
    assertEquals(inputArray, new String[]{"B", "D", "A", "Z"});
  }
}
