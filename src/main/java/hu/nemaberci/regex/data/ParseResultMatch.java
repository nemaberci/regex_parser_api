package hu.nemaberci.regex.data;

public class ParseResultMatch {
    private final int start;
    private final int end;
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public ParseResultMatch(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}
