package sorts.efficient.merge;

import sorts.Sort;

import java.util.Arrays;

/**
 * Created by timadair on 9/2/2017.
 */
public class MergeSortWithMinimalCopying implements Sort {
  @Override
  public String[] sort(String[] in) {
    String[] workingArray = Arrays.copyOf(in, in.length);
    sort(workingArray, 0, workingArray.length);
    return workingArray;
  }

  private void sort(String[] in, int low, int high) {
    int divisionSize = high - low;
    if (divisionSize <= 1) {
      return;
    }
    int splitIndex = low + (divisionSize / 2);
    sort(in, low, splitIndex);
    sort(in, splitIndex, high);

    String[] temp = new String[divisionSize];
    int lowMergeIndex = low;
    int highMergeIndex = splitIndex;
    for (int i = 0; i < divisionSize; i++) {
      if (lowMergeIndex == splitIndex) {
        temp[i] = in[highMergeIndex++];  // Low half finished, clear out the high half
      }
      else if (highMergeIndex == high) {
        temp[i] = in[lowMergeIndex++]; // High half finished, clear out low half
      }
      else if (in[lowMergeIndex].compareTo(in[highMergeIndex]) <= 0) {
        temp[i] = in[lowMergeIndex++];
      }
      else {
        temp[i] = in[highMergeIndex++];
      }
    }
    for (int i = 0; i < divisionSize; i++) {
      in[i + low] = temp[i];
    }
  }
}
