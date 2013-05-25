package pl.wjug.testkata.caliper;

import com.google.caliper.Benchmark;
import com.google.caliper.runner.CaliperMain;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-05-23
 */
@SuppressWarnings("UnusedDeclaration")
public class FirstBenchmark extends Benchmark {
  private final int[] array = new int[100000];

  public void timeArrayIterationSimple(long reps) {
    for (long i = 0; i < reps; i++) {
      for (int j : array) {
      }
    }
  }

  public int timeArrayIterationFixed(long reps) {
    int sum = 0;
    for (long i = 0; i < reps; i++) {
      for (int j : array) {
        sum += j;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    CaliperMain.main(FirstBenchmark.class, args);
  }
}
