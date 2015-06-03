package courses.task2;

import courses.task2.elements.Sentence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Text {

    private List<Sentence> content = new ArrayList<Sentence>();

    private void checkSentence(Sentence sentence) {
        if (sentence == null) throw new IllegalArgumentException("Sentence is null");
    }

    private void checkIndex(int index) {
        if (index >= getNumberOfSentences()) throw new IllegalArgumentException("Index is is greater than number of sentences");
    }

    private void checkText() {
        if (content.isEmpty()) throw new IllegalArgumentException("Text is empty");
    }

    public void addSentence(Sentence sentence) {
        checkSentence(sentence);
        content.add(sentence);
    }

    public int getNumberOfSentences() {
        return content.size();
    }

    public String getSentence(int index) {
        checkIndex(index);
        return content.get(index).toString();
    }

    public int getNumberOfWordsInSentence(int index) {
        checkIndex(index);
        return content.get(index).getNumberOfWords();
    }

    public String getElementAtIndexInSentence(int indexElement, int indexSentence) {
        checkIndex(indexSentence);
        return content.get(indexSentence).getElementAtIndex(indexElement);
    }

    public String getWordAtIndexInSentence(int indexElement, int indexSentence) {
        checkIndex(indexSentence);
        return content.get(indexSentence).getWordAtIndex(indexElement);
    }

    public String getFirstWordInSentence(int index) {
        checkIndex(index);
        return content.get(index).getFirstWord();
    }

    public String getLastWordInSentence(int index) {
        checkIndex(index);
        return content.get(index).getLastWord();
    }

    public char getSymbolAtIndexInWordAtIndexInSentence(int indexSymbol, int indexWord, int indexSentence) {
        checkIndex(indexSentence);
        return content.get(indexSentence).getSymbolAtIndexInWord(indexSymbol, indexWord);
    }

    public char getFirstSymbolInWordAtIndexInSentence(int indexWord, int indexSentence) {
        checkIndex(indexSentence);
        return content.get(indexSentence).getFirstSymbolInWord(indexWord);
    }

    public char getLastSymbolInWordAtIndexInSentence(int indexWord, int indexSentence) {
        checkIndex(indexSentence);
        return content.get(indexSentence).getLastSymbolInWord(indexWord);
    }

    public String getEndOFSentence(int index) {
        checkIndex(index);
        return content.get(index).getEndOfSentence();
    }

    // 2. Display all sentences in ascending order of the number of words in each of them.
    public void sortAllSentencesNumberOfWords() {
        Collections.sort(content, new Comparator<Sentence>()
        {
            @Override
            public int compare(Sentence o1, Sentence o2) {
                return o1.getNumberOfWords()-o2.getNumberOfWords();
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : content)
        {
            result.append(sentence.toString());
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return !(content != null ? !content.equals(text.content) : text.content != null);

    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
