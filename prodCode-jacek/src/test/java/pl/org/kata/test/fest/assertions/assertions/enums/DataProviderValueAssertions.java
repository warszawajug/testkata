package pl.org.kata.test.fest.assertions.assertions.enums;

import static org.fest.assertions.Assertions.assertThat;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import org.fest.assertions.GenericAssert;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 30/08/2012
 */
public class DataProviderValueAssertions extends GenericAssert<DataProviderValueAssertions, Collection<Object>> {

	private DataProviderValueAssertions(Collection<Object> actual) {
		super(DataProviderValueAssertions.class, actual);
	}

	public static DataProviderValueAssertions assertThatValuesWithId(final Object[][] values, final int index) {
		assertThat(index).isGreaterThanOrEqualTo(0);

		final Collection<Object> valuesWithId = Collections2.transform(Lists.newArrayList(values), new Function<Object[], Object>() {
			@Override
			public Object apply(final Object[] input) {
				assertThat(input.length).isGreaterThan(index).as(String.format("Single case parameters list[%s], is shorter then expected [%s]", input, index));
				return input[index];
			}
		});
		return new DataProviderValueAssertions(valuesWithId);
	}

	public DataProviderValueAssertions allEnumsAreUsed(Class<? extends Enum<?>> enumToCheckClass) {
		assertThat(actual).containsOnly(enumToCheckClass.getEnumConstants()).as("Not all enums were used in DataProvider");
		return this;
	}
}
