package info.solidsoft.testkata.mockito;

import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

@Test
public class PlaceholderTest {

    public void shouldPassOnProperDevelopmentEnvironmentConfiguration() {
        //given
        Placeholder placeholder = new Placeholder();
        //when
        String readValue = placeholder.getValue();
        //then
        assertThat(readValue).isEqualTo("value");
    }
}
