package pl.org.kata.test.festhamcrest.isthisfast;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * User: Michał Lewandowski
 * Date: 22.05.2013
 * Time: 19:12
 */
public class HamcrestBenchmark extends SimpleBenchmark{
    public void timeIsNumberEqual(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(0, equalTo(0));
        }
    }

    public void timeIsNumberGreaterThan(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(1, greaterThan(0));
        }
    }

    public void timeIsNumberLessThan(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(0, lessThan(1));
        }
    }

    public void timeIsStringEqual(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat("WJUG", equalTo("WJUG"));
        }
    }

    public void timeIsStringEqualIgnoringCase(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat("WJUG", equalToIgnoringCase("WJUG"));
        }
    }

    public void timeIsListContains(int reps) {
        for (int i = 0; i < reps; ++i) {
            assertThat(Arrays.asList("a", "b", "c"), hasItem("a"));
        }
    }

    public void timeIsMapContains(int reps) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{ put("Shakespeare", 431);  put("Tolkien", 0); }};
        for (int i = 0; i < reps; ++i) {
            assertThat(map, hasEntry("Shakespeare", 431));
        }
    }

    public static void main(String[] args) {
        Runner.main(HamcrestBenchmark.class, args);
    }
}
