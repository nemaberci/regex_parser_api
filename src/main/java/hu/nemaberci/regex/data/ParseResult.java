package hu.nemaberci.regex.data;

import java.util.Collection;

public class ParseResult {

    private final boolean matching;
    private final Collection<ParseResultMatch> matches;

    public boolean isMatching() {
        return matching;
    }

    public Collection<ParseResultMatch> getMatches() {
        return matches;
    }

    public ParseResult(boolean matching) {
        this.matching = matching;
        this.matches = null;
    }

    public ParseResult(Collection<ParseResultMatch> matches) {
        this.matches = matches;
        this.matching = !matches.isEmpty();
    }
}
