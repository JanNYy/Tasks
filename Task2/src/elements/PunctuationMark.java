package courses.task2.elements;

public class PunctuationMark implements ElementOfSentence {

    private char punctuationMark;

    public PunctuationMark(char mark) {
        punctuationMark = mark;
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }

    @Override
    public String toString() {
        return Character.toString(punctuationMark);
    }

}
