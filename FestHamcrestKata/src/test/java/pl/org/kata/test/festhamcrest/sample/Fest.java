package pl.org.kata.test.festhamcrest.sample;

import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: Michał Lewandowski
 * Date: 22.05.2013
 * Time: 18:57
 */
public class Fest {

    @Test
    public void basicAssertion() {
        assertThat("foo bar").isNotEmpty().isEqualTo("foo bar");
    }
}
