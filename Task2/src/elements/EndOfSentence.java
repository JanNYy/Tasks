package courses.task2.elements;

import java.util.ArrayList;
import java.util.List;

public class EndOfSentence implements ElementOfSentence {

    private List<Symbol> content = new ArrayList<Symbol>();

    private void checkEnd(Symbol end) {
        if (end == null) throw new IllegalArgumentException("End of sentence is null");
    }

    public void addEndOfSentence(Symbol end) {
        checkEnd(end);
        content.add(end);
    }

    public String getEndOfSentence() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Symbol c : this.content) {
            result.append(c.toString());
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EndOfSentence)) return false;

        EndOfSentence that = (EndOfSentence) o;

        return !(content != null ? !content.equals(that.content) : that.content != null);
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
