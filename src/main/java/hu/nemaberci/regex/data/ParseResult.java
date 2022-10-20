package hu.nemaberci.regex.data;

import java.util.List;

public class ParseResult {

    private final boolean matching;
    private final List<ParseResultMatch> matches;

    public boolean isMatching() {
        return matching;
    }

    public List<ParseResultMatch> getMatches() {
        return matches;
    }

    public ParseResult(boolean matching) {
        this.matching = matching;
        this.matches = null;
    }

    public ParseResult(List<ParseResultMatch> matches) {
        this.matches = matches;
        this.matching = !matches.isEmpty();
    }
}
