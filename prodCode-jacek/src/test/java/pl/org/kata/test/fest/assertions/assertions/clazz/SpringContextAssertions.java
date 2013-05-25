package pl.org.kata.test.fest.assertions.assertions.clazz;

import static pl.org.kata.test.fest.sample.StringUtils.interpolate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.fest.assertions.Assertions;
import org.fest.util.Arrays;
import org.springframework.stereotype.Component;

/**
 * @author Mateusz Grzechociński <mateusz.grzechocinski@javart.eu>
 * @since 09/05/2012
 */
public class SpringContextAssertions extends AnnotationsAssertions<Class> {

	private final Constructor[] constructors;

	private final String actualSimpleName;

	public SpringContextAssertions(Class actual) {
		super(SpringContextAssertions.class, actual);
		constructors = actual.getDeclaredConstructors();
		actualSimpleName = actual.getSimpleName();
	}

	public static SpringContextAssertions assertThat(Class typeToCheck) {
		return new SpringContextAssertions(typeToCheck);
	}

	/**
	 * Verifies whether given class:
	 * <ul>
	 * <li>Is a Spring Component (@Component or derived from it)</li>
	 * <li>Has at least Has non empty constructor. If has, checks whether it is {@link @Autowired}</li>
	 * <li>Is proxied ({@code @Transactional} or {@code @Secured} annotations are present). If yes, check by what mechanism it will be proxied</li>
	 * <li>If CGLIB (no interfaces on class), checks whether class has empty constructor with {@code @CGLIB} annotation</li>
	 * <li>If dynamic-proxy (interfaces are present), checks whether class has excessive empty constructor
	 * </ul>
	 */
	public SpringContextAssertions hasContextValidAnnotations() {
		isSpringComponent();
		hasAutowiredNonEmptyConstructor();
		return this;
	}

	public SpringContextAssertions isSpringComponent() {
		if (!hasAnnotationInHierarchy(Component.class)) {
			fail(interpolate("Class [{}] is not a Spring Component", actualSimpleName));
		}
		return this;
	}

	private boolean hasAnnotationInHierarchy(Class<? extends Annotation> desiredAnnotation) {
		return AnnotationUtils.isAnnotationOrHasItInHierarchy(actual, desiredAnnotation);
	}

	private SpringContextAssertions hasAutowiredNonEmptyConstructor() {
		for (Constructor constructor : constructors) {
			if (isEmptyConstructor(constructor)) {
				continue;
			}
			Assertions.assertThat(constructor.isAnnotationPresent(ANNOTATION_AUTOWIRED))
					.overridingErrorMessage(
							interpolate("Non empty constructor for class [{}] is not annotated with @{}", actualSimpleName, ANNOTATION_AUTOWIRED_NAME))
					.isTrue();
		}
		return this;
	}

	private boolean isEmptyConstructor(Constructor constructor) {
		Class[] parameters = constructor.getParameterTypes();
		return Arrays.isEmpty(parameters);
	}


}
