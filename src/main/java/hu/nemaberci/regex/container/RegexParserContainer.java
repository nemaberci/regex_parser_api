package hu.nemaberci.regex.container;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RegexParserContainer {

    private RegexParserContainer() {
    }

    private static final Map<String, RegexParser> registeredParsers = new HashMap<>();

    public static void registerParser(String regex,
        RegexParser instance
    ) {
        if (registeredParsers.containsKey(regex)) {
            throw new IllegalArgumentException(
                "Implementation for regular expression " + regex
                    + " already exists in container!");
        }
        registeredParsers.put(regex, instance);
    }

    public static RegexParser getImplementation(Class<? extends RegexParser> className) {
        if (Arrays.stream(className.getAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(RegularExpression.class))) {
            var regexValue = ((RegularExpression) Arrays.stream(className.getAnnotations())
                .filter(annotation -> annotation.annotationType().equals(RegularExpression.class))
                .findFirst().get()).value();
            return registeredParsers.get(regexValue);
        } else {
            return null;
        }
    }

}
