package sorts;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.testng.Assert.assertEquals;

/**
 * Created by timadair on 9/2/2017.
 */
public class SortTestHelper {

  private SortTestHelper() {}

  public static void assertEqualToJavaSort(String[] strings, Function<String[], String[]> sortFunction) {
    String[] sortedStrings = Arrays.copyOf(strings, strings.length);
    Arrays.sort(sortedStrings);
    assertEquals(sortFunction.apply(strings), sortedStrings, "Sorting error.\n" +
        "  For input array: " + Arrays.toString(strings) + "\n" +
        "  Expected output: " + Arrays.toString(sortedStrings) + "\n");
  }

  public static void assertSortingOfAllPermutations(Function<String[], String[]> sortFunction, List<String> itemsToSort, String sortName) {
    List<List<String>> permutations = PermutationHelper.allPermutations(itemsToSort);
    assertEquals(permutations.size(), CombinatoricsUtils.factorial(itemsToSort.size()));

    Instant start = Instant.now();
    permutations.forEach(p -> assertEqualToJavaSort(p.toArray(new String[p.size()]), sortFunction));
    Instant end = Instant.now();

    System.out.println("Successful sorting of all permutations of " + itemsToSort.size() + " unique items completed in " + Duration.between(start, end).toString() + " using " + sortName);
  }

}
