package sorts.efficient.merge;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static sorts.SortTestHelper.assertEqualToJavaSort;
import static sorts.SortTestHelper.assertSortingOfAllPermutations;

public class MergeSortWithMinimalCopyingTest {
  private static final String MERGE_SORT_NAME = "MergeSortTake2";

  @Test
  public void shouldHandleEmptyInputs() {
    new MergeSortWithMinimalCopying().sort(new String[0]);
  }

  @Test
  public void shouldSortOneItem() {
    assertEqualToJavaSort(new String[]{"A"}, new MergeSortWithMinimalCopying()::sort);
  }

  @Test
  public void shouldSortTwoItems() {
    assertSortingOfAllPermutations(new MergeSortWithMinimalCopying()::sort, Arrays.asList("A", "B"), MERGE_SORT_NAME);
  }

  @Test
  public void shouldSortThreeItems() {
    assertSortingOfAllPermutations(new MergeSortWithMinimalCopying()::sort, Arrays.asList("A", "B", "C"), MERGE_SORT_NAME);
  }

  @Test
  public void shouldSortFourItems() {
    assertSortingOfAllPermutations(new MergeSortWithMinimalCopying()::sort, Arrays.asList("A", "B", "C", "D"), MERGE_SORT_NAME);
  }

  @Test
  public void shouldSortTenItems() {
    List<String> itemsToSort = IntStream.rangeClosed(1, 10)
        .boxed()
        .map(i -> Integer.toString(i))
        .collect(Collectors.toList());
    assertSortingOfAllPermutations(new MergeSortWithMinimalCopying()::sort, itemsToSort, MERGE_SORT_NAME);
  }
}
