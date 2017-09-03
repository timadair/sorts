package sorts.efficient.merge;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.testng.annotations.Test;
import sorts.PermutationHelper;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.testng.Assert.assertEquals;

/**
 * Created by timadair on 9/2/2017.
 */
public class MergeSortTest {

  private static final Function<String[], String[]> SORT_FUNCTION = MergeSort::sort;

  private void assertEqualToJavaSort(String[] strings, Function<String[], String[]> sortFunction) {
    String[] sortedStrings = Arrays.copyOf(strings, strings.length);
    Arrays.sort(sortedStrings);
    assertEquals(sortFunction.apply(strings), sortedStrings, "Sorting error.\n" +
        "  For input array: " + Arrays.toString(strings) + "\n" +
        "  Expected output: " + Arrays.toString(sortedStrings) + "\n");
  }

  private void assertSortingOfAllPermutations(Function<String[], String[]> sort, List<String> strings) {
    List<List<String>> permutations = PermutationHelper.allPermutations(strings);
    assertEquals(permutations.size(), ArithmeticUtils.factorial(strings.size()));
    permutations.forEach(p -> {
      assertEqualToJavaSort(p.toArray(new String[p.size()]), sort);
    });
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

  private Function<String[], String[]> getSortingAlgorithm() {
    return SORT_FUNCTION;
  }
}
