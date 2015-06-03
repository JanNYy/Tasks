package courses.task2.elements;

import java.util.ArrayList;
import java.util.List;

public class Word implements ElementOfSentence {

    private List<Symbol> content = new ArrayList<Symbol>();

    private void checkElement(Symbol element) {
        if (element == null) throw new IllegalArgumentException("Element of word is null");
    }

    private void checkIndex(int index) {
        if (index >= getWordLength()) throw  new IllegalArgumentException("Index is greater than number of elements");
    }

    private void checkWord() {
        if (content.isEmpty()) throw new IllegalArgumentException("Word is empty");
    }

    public void addElementOfWord(Symbol element) {
        checkElement(element);
        content.add(element);
    }

    public String getWord() {
        return toString();
    }

    public int getWordLength() {
        return content.size();
    }

    public int getIndexOfSymbol(char symbol) {
        Symbol symbolInWord = new Symbol(symbol);
        checkElement(symbolInWord);
        return content.indexOf(symbolInWord);
    }

    public char getSymbolAtIndex(int index) {
        checkIndex(index);
        return content.get(index).getSymbol();
    }

    public char getFirstSymbol() {
        checkWord();
        return content.get(0).getSymbol();
    }

    public char getLastSymbol() {
        checkWord();
        return content.get(content.size()-1).getSymbol();
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
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return !(content != null ? !content.equals(word.content) : word.content != null);
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
