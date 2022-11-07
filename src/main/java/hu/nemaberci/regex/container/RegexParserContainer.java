package hu.nemaberci.regex.container;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.annotation.RegularExpressionParserImplementation;
import hu.nemaberci.regex.api.RegexParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class RegexParserContainer {

    private RegexParserContainer() {
    }

    private static final Map<String, RegexParser> registeredParsers = new HashMap<>();

    private static void loadParsers() {
        ServiceLoader<RegexParser> serviceLoader = ServiceLoader.load(RegexParser.class);
        for (RegexParser regexParser : serviceLoader) {
            var regexValue = ((RegularExpressionParserImplementation) Arrays.stream(regexParser.getClass().getAnnotations())
                .filter(annotation -> annotation.annotationType().equals(RegularExpressionParserImplementation.class))
                .findFirst().orElseThrow(() -> new RuntimeException("Regex Parser implementation without annotation"))).value();
            registeredParsers.put(regexValue, regexParser);
        }
    }

    public static RegexParser getImplementation(Class<? extends RegexParser> className) {
        if (registeredParsers.isEmpty()) {
            loadParsers();
        }
        if (Arrays.stream(className.getAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(RegularExpression.class))) {
            var regexValue = ((RegularExpression) Arrays.stream(className.getAnnotations())
                .filter(annotation -> annotation.annotationType().equals(RegularExpression.class))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Provided class does not have @RegularExpression annotation"))).value();
            return registeredParsers.get(regexValue);
        } else {
            return null;
        }
    }

}
