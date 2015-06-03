package courses.task2.elements;

public class SplitterSymbol implements ElementOfSentence {

    private char splitter;

    public SplitterSymbol(char splitterSymbol) {
        splitter = splitterSymbol;
    }

    public char getSplitterSymbol() {
        return splitter;
    }

    public String toString() {
        return Character.toString(splitter);
    }
}
