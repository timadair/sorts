package sorts;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

/**
 * Created by timadair on 9/2/2017.
 */
public abstract class SortTest {

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

    System.out.println("Successful sorting of all permutations of " + itemsToSort.size() + " unique items completed in " + Duration.between(start, end).toString() + " using sort algorithm " + getSortName());
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

  protected abstract Function<String[],String[]> getSortingAlgorithm();
  protected abstract String getSortName();
}
