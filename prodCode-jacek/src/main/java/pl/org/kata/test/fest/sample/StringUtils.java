package pl.org.kata.test.fest.sample;

public class StringUtils {

	private static final String ARG_INDICATOR = "\\{\\}";

	public static String interpolate(String template, Object... args) {
		if (args != null) {
			for (Object arg : args) {
				template = template.replaceFirst(ARG_INDICATOR, toString(arg));
			}
		}

		return template;
	}

	private static String toString(Object arg) {
		return arg != null ? arg.toString() : "null";
	}

}
