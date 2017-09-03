package sorts.efficient.merge;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.testng.annotations.Test;
import sorts.PermutationHelper;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class MergeSortTest {

  private static final Function<String[], String[]> SORT_FUNCTION = MergeSort::sort;
  private static final String SORT_FUNCTION_NAME = "MergeSort";

  private void assertEqualToJavaSort(String[] strings, Function<String[], String[]> sortFunction) {
    String[] sortedStrings = Arrays.copyOf(strings, strings.length);
    Arrays.sort(sortedStrings);
    assertEquals(sortFunction.apply(strings), sortedStrings, "Sorting error.\n" +
        "  For input array: " + Arrays.toString(strings) + "\n" +
        "  Expected output: " + Arrays.toString(sortedStrings) + "\n");
  }

  private void assertSortingOfAllPermutations(Function<String[], String[]> sort, List<String> itemsToSort) {
    List<List<String>> permutations = PermutationHelper.allPermutations(itemsToSort);
    assertEquals(permutations.size(), CombinatoricsUtils.factorial(itemsToSort.size()));

    Instant start = Instant.now();
    permutations.forEach(p -> assertEqualToJavaSort(p.toArray(new String[p.size()]), sort));
    Instant end = Instant.now();

    System.out.println("Successful sorting of all permutations of " + itemsToSort.size() + " unique items completed in " + Duration.between(start, end).toString() + " using sort algorithm " + SORT_FUNCTION_NAME);
  }

  @Test
  public void shouldHandleEmptyInputs() {
    getSortingAlgorithm().apply(new String[0]);
  }

  @Test
  public void shouldSortOneItem() {
    assertEqualToJavaSort(new String[]{"A"}, getSortingAlgorithm());
  }

  @Test
  public void shouldSortTwoItems() {
    assertSortingOfAllPermutations(getSortingAlgorithm(), Arrays.asList("A", "B"));
  }

  @Test
  public void shouldSortThreeItems() {
    assertSortingOfAllPermutations(getSortingAlgorithm(), Arrays.asList("A", "B", "C"));
  }

  @Test
  public void shouldSortFourItems() {
    assertSortingOfAllPermutations(getSortingAlgorithm(), Arrays.asList("A", "B", "C", "D"));
  }

  @Test
  public void shouldSortTenItems() {
    List<String> itemsToSort = IntStream.rangeClosed(1, 10)
        .boxed()
        .map(i -> Integer.toString(i))
        .collect(Collectors.toList());
    assertSortingOfAllPermutations(getSortingAlgorithm(), itemsToSort);
  }

  @Test
  public void shouldLeaveInputUnchanged() {
    String[] inputArray = {"B", "D", "A", "Z"};
    getSortingAlgorithm().apply(inputArray);
    assertEquals(inputArray, new String[]{"B", "D", "A", "Z"});
  }

  private Function<String[], String[]> getSortingAlgorithm() {
    return SORT_FUNCTION;
  }
}
