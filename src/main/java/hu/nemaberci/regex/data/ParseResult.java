package hu.nemaberci.regex.data;

public class ParseResult {

    private final boolean matching;

    public boolean isMatching() {
        return matching;
    }

    public ParseResult(boolean matching) {
        this.matching = matching;
    }
}
