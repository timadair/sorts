package sorts.efficient.merge;

import sorts.Sort;

import java.util.Arrays;

/**
 * Implements a mergeSort into a new array.  Leaves the original array untouched.
 * Created by timadair on 9/2/2017.
 */
public class MergeSort implements Sort {

  public String[] sort(String[] in) {
    String[] out = new String[in.length];

    if (in.length == 0) {
      return out;
    }
    if (in.length <= 1) {
      out[0] = in[0];
      return out;
    }
    int half = in.length / 2;

    String[] left = sort(Arrays.copyOfRange(in, 0, half));
    String[] right = sort(Arrays.copyOfRange(in, half, in.length));

    int leftIndex = 0;
    int rightIndex = 0;

    while(leftIndex < left.length && rightIndex < right.length) {
      if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
        out[leftIndex + rightIndex] = left[leftIndex];
        leftIndex++;
      }
      else {
        out[leftIndex + rightIndex] = right[rightIndex];
        rightIndex++;
      }
    }

    while (leftIndex < left.length) {
      out[leftIndex + rightIndex] = left[leftIndex];
      leftIndex++;
    }
    while (rightIndex < right.length) {
      out[leftIndex + rightIndex] = right[rightIndex];
      rightIndex++;
    }
    return out;
  }
}
