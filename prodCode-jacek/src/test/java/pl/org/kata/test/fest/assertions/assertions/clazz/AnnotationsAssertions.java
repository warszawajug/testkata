package pl.org.kata.test.fest.assertions.assertions.clazz;

import com.google.common.collect.Lists;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.List;
import org.fest.assertions.GenericAssert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base custom FEST assertions for dealing with annotations
 *
 * @author Mateusz Grzechociński <mateusz.grzechocinski@javart.eu>
 * @see SpringContextAssertions
 * @since 15/05/2012
 */
public abstract class AnnotationsAssertions<T extends AnnotatedElement> extends GenericAssert<AnnotationsAssertions, T> {

	protected static final Class<Autowired> ANNOTATION_AUTOWIRED = Autowired.class;

	protected static final String ANNOTATION_AUTOWIRED_NAME = ANNOTATION_AUTOWIRED.getSimpleName();


	public AnnotationsAssertions(Class selfType, T actual) {
		super(selfType, actual);
	}

	protected boolean hasAnnotationOnClass(Class annotationToBePresentOnClass) {
		return actual.isAnnotationPresent(annotationToBePresentOnClass);
	}

	protected <T extends Annotation> List<T> getAnnotationsIfExistsOnMethod(Class classUnderTest, Class<T> clazz) {
		List<T> beforeMethodsAnnotations = Lists.newArrayList();
		for (Method method : classUnderTest.getMethods()) {
			if (!method.isAnnotationPresent(clazz)) {
				continue;
			}
			T annotation = (T) method.getAnnotation(clazz);
			beforeMethodsAnnotations.add(annotation);
		}
		return beforeMethodsAnnotations;
	}
}
