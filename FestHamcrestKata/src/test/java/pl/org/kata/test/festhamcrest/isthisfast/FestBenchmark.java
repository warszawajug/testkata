package pl.org.kata.test.festhamcrest.isthisfast;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.data.MapEntry.entry;

/**
 * User: Michał Lewandowski
 * Date: 22.05.2013
 * Time: 19:12
 */
public class FestBenchmark extends SimpleBenchmark {
    public void timeIsNumberEqual(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(0).isEqualTo(0);
        }
    }

    public void timeIsNumberGreaterThan(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(1).isGreaterThan(0);
        }
    }

    public void timeIsNumberLessThan(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(0).isLessThan(1);
        }
    }

    public void timeIsStringEqual(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat("WJUG").isEqualTo("WJUG");
        }
    }

    public void timeIsStringEqualIgnoringCase(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat("WJUG").isEqualToIgnoringCase("WJUG");
        }
    }

    public void timeIsListContains(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(Arrays.asList("a", "b", "c")).contains("a");
        }
    }

    public void timeIsMapContains(int reps) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{ put("Shakespeare", 431);  put("Tolkien", 0); }};
        for (int i = 0; i < reps; ++i) {
            assertThat(map).contains(entry("Shakespeare", 431));
        }
    }

    public static void main(String[] args) {
        Runner.main(FestBenchmark.class, args);
    }
}
