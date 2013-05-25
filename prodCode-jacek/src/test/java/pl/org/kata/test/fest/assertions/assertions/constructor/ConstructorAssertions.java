package pl.org.kata.test.fest.assertions.assertions.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 22/08/2012
 */
public class ConstructorAssertions extends GenericAssert<ConstructorAssertions, Constructor> {

	private String simpleName;

	private ConstructorAssertions(Constructor actual) {
		super(ConstructorAssertions.class, actual);
		simpleName = actual.getDeclaringClass().getSimpleName();
	}

	public static ConstructorAssertions assertThat(Constructor actual) {
		return new ConstructorAssertions(actual);
	}

	public ConstructorAssertions isProtected() {
		Assertions.assertThat(Modifier.isProtected(actual.getModifiers())).as("@CGLIB constructor for [{}] is not 'protected' type").isTrue();
		return this;
	}
}
