package sorts.bubble.bubble;

import sorts.Sort;

/**
 * Created by timadair on 9/2/2017.
 */
public class BubbleSort implements Sort {
  @Override
  public String[] sort(String[] in) {


    boolean done = false;
    int numIterations = 0;
    while (!done) {
      boolean anySwaps = false;

      for (int i = 0; i < in.length - numIterations - 1; i++) {
        String second = in[i + 1];
        if (in[i].compareTo(second) > 0) {
          in[i + 1] = in[i];
          in[i] = second;
          anySwaps = true;
        }
      }

      done = !anySwaps;
      numIterations++;
    }

    return in;
  }
}
