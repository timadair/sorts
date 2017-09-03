package sorts;

import java.util.*;

/**
 * Created by timadair on 9/2/2017.
 */
public class PermutationHelper {

  public static List<List<String>> allPermutations(List<String> arr){
    return permute(arr, 0);
  }

  private static List<List<String>> permute(List<String> arr, int k){
    ArrayList<List<String>> permutations = new ArrayList<>();

    for(int i = k; i < arr.size(); i++){
      Collections.swap(arr, i, k);
      permutations.addAll(permute(arr, k+1));
      Collections.swap(arr, k, i);
    }
    if (k == arr.size() -1){
      ArrayList<String> newPermutation = new ArrayList<>();
      newPermutation.addAll(arr);
      permutations.add(newPermutation);
    }
    return permutations;
  }

  private static List<String> copyOf(List<String> arr) {
    List<String> copy = new ArrayList<>(arr.size());
    copy.addAll(arr);
    return copy;
  }
}
