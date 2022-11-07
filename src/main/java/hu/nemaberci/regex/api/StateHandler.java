package hu.nemaberci.regex.api;

public interface StateHandler {

    void handle(char c, int[] state);

}
