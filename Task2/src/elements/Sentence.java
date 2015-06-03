package courses.task2.elements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private List<ElementOfSentence> content = new ArrayList<ElementOfSentence>();

    public void addElementOfSentence(ElementOfSentence part) {
        content.add(part);
    }

    private void checkIndex(int index) {
        if (index >= getNumberOfElements()) throw new IllegalArgumentException("Index is is greater than number of elements");
    }

    private void checkSentence() {
        if (content.isEmpty()) throw new IllegalArgumentException("Sentence is empty");
    }

    public String getElementAtIndex(int index) {
        checkIndex(index);
        return content.get(index).toString();
    }

    public String getWordAtIndex(int index) {
        checkIndex(index);
        ElementOfSentence element;
        int wordCount = 0;
        for (int i = 0; i < getNumberOfElements(); i++)
        {
            element = content.get(i);
            if (element instanceof Word)
            {
                if (index == wordCount)
                    return content.get(i).toString();
                wordCount += 1;
            }
        }
        throw new IllegalArgumentException("There are no word at this index");
    }

    private Word getWordAtIndexInWord(int index) {
        checkIndex(index);
        ElementOfSentence element;
        int wordCount = 0;
        for (int i = 0; i < getNumberOfElements(); i++)
        {
            element = content.get(i);
            if (element instanceof Word)
            {
                if (index == wordCount)
                    return (Word)content.get(i);
                wordCount += 1;
            }
        }
        throw new IllegalArgumentException("There are no word at this index");
    }

    public char getFirstSymbolInWord(int indexWord) {
        return getWordAtIndexInWord(indexWord).getFirstSymbol();
    }

    public char getLastSymbolInWord(int indexWord) {
        return getWordAtIndexInWord(indexWord).getLastSymbol();
    }

    public char getSymbolAtIndexInWord(int indexSymbol, int indexWord) {
        return getWordAtIndexInWord(indexWord).getSymbolAtIndex(indexSymbol);
    }

    public int getIndexOfWord(String word) {
        ElementOfSentence element;
        for (int i = 0; i < getNumberOfElements(); i++)
        {
            element = content.get(i);
            if (element instanceof Word)
            {
                if (word.equals(((Word)element).toString()))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public String getFirstWord() {
        checkSentence();
        for (ElementOfSentence word : content)
        {
            if (word instanceof Word) return word.toString();
        }
        return "";
    }

    private Word getFirstWordInWord() {
        checkSentence();
        for (ElementOfSentence word : content)
        {
            if (word instanceof Word) return (Word)word;
        }
        throw new IllegalArgumentException("There are no word in sentence");
    }

    public char getFirstSymbolInFirstWord() {
        return getFirstWordInWord().getFirstSymbol();
    }

    public char getLastSymbolInFirstWord() {
        return getFirstWordInWord().getLastSymbol();
    }

    public char getSymbolAtIndexInFirstWord(int index) {
        return getFirstWordInWord().getSymbolAtIndex(index);
    }

    public String getLastWord() {
        checkSentence();
        ElementOfSentence word;
        for (int i = content.size(); i >= 0; i--)
        {
            word = content.get(i);
            if (word instanceof Word) return word.toString();
        }
        return "";
    }

    private Word getLastWordInWord() {
        checkSentence();
        ElementOfSentence word;
        for (int i = content.size(); i >= 0; i--)
        {
            word = content.get(i);
            if (word instanceof Word) return (Word)word;
        }
        throw new IllegalArgumentException("There are no word in sentence");
    }

    public char getFirstSymbolInLastWord() {
        return getLastWordInWord().getFirstSymbol();
    }

    public char getLastSymbolInLastWord() {
        return getLastWordInWord().getLastSymbol();
    }

    public char getSymbolAtIndexInLastWord(int index) {
        return getLastWordInWord().getSymbolAtIndex(index);
    }

    public String getEndOfSentence() {
        checkSentence();
        ElementOfSentence end = content.get(content.size()-1);
        if (end instanceof EndOfSentence)
            return end.toString();
        else
            return "";
    }

    public int getNumberOfWords() {
        checkSentence();
        int numberOfWords = 0;
        for (ElementOfSentence element : content)
        {
            if (element instanceof Word)
                numberOfWords += 1;
        }
        return numberOfWords;
    }

    public int getNumberOfElements() {
        checkSentence();
        int numberOfWords = 0;
        for (ElementOfSentence element : content)
        {
                numberOfWords += 1;
        }
        return numberOfWords;
    }

    public int getNumberOfPunctuation() {
        checkSentence();
        int numberOfPunctuation = 0;
        for (ElementOfSentence element : content)
        {
            if (element instanceof PunctuationMark)
                numberOfPunctuation += 1;
        }
        return numberOfPunctuation;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ElementOfSentence part : content)
        {
            result.append(part.toString());
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        return !(content != null ? !content.equals(sentence.content) : sentence.content != null);
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
