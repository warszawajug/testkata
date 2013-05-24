package pl.testkata.marekk;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class LegacyJunitTest {

	@Test
	public void junitTestShouldBeInvoked() {
       assertThat("ok").isNotEmpty();
	}
}
