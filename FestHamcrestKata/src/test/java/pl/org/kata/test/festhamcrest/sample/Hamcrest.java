package pl.org.kata.test.festhamcrest.sample;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: Michał Lewandowski
 * Date: 22.05.2013
 * Time: 18:57
 */
public class Hamcrest {

    @Test
    public void basicAssertion(){
        assertThat("foo bar", equalTo("foo bar"));
    }
}
