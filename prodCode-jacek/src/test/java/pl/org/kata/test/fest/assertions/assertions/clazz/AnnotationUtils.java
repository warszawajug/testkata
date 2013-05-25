package pl.org.kata.test.fest.assertions.assertions.clazz;

import com.google.common.collect.Sets;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 18/06/2012
 */
public class AnnotationUtils {

	public static boolean isAnnotationOrHasItInHierarchy(Class<? extends Annotation> classToCheck, Class<? extends Annotation> desiredAnnotationClass) {
		return isAnnotationOrHasItInHierarchy(classToCheck, desiredAnnotationClass, Sets.<Class<? extends Annotation>>newHashSet());
	}

	private static boolean isAnnotationOrHasItInHierarchy(Class<? extends Annotation> classToCheck, Class<? extends Annotation> desiredAnnotationClass,
														  Set<Class<? extends Annotation>> checkedAnnotations) {
		if (checkedAnnotations.contains(classToCheck)) {
			return false;
		}
		checkedAnnotations.add(classToCheck);
		if (desiredAnnotationClass.isAssignableFrom(classToCheck)) {
			return true;
		}
		Annotation[] annotations = classToCheck.getAnnotations();
		for (Annotation metaAnnotation : annotations) {
			Class<? extends Annotation> metaAnnotationClass = metaAnnotation.annotationType();
			if (isAnnotationOrHasItInHierarchy(metaAnnotationClass, desiredAnnotationClass, checkedAnnotations)) {
				return true;
			}
		}
		return false;
	}
}
