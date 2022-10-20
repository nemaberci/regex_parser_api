package hu.nemaberci.regex.api;

import hu.nemaberci.regex.data.ParseResult;

public interface RegexParser {

    ParseResult findMatches(String str);
    boolean matches(String str);

}
