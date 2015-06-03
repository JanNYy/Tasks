package courses.task2;

import courses.task2.elements.*;

public class StringParser {

    private final static String SYMBOLS_END_OF_SENTENCE = ".?!";
    private final static String SYMBOLS_PUNCTUATION_IN_WORD = "-_";
    private final static String SYMBOLS_PUNCTUATION = ",:;-\"\\[\\](){}<>";
    public final static char SPLITTER_SYMBOL = ' ';

    private static void checkText(String text) {
        if (text == null) throw new IllegalArgumentException("String is null");
    }

    public static Text parseText(String text) {
        checkText(text);
        Text generatedText = new Text();
        String clearedText = text.replaceAll("[\\s\t]+", " ");
        String[] obtainedSentences = clearedText.split("(?<=[" + SYMBOLS_END_OF_SENTENCE + "])\\s?+(?=[a-zA-Z])");
        for (String sentence : obtainedSentences)
        {
            generatedText.addSentence(parseSentence(sentence));
        }
        return generatedText;
    }

    private static boolean isSplitterSymbol(char symbol) {
        return symbol == SPLITTER_SYMBOL;
    }

    private static  boolean isEndSymbol(char symbol) {
        return SYMBOLS_END_OF_SENTENCE.contains(Character.toString(symbol));
    }

    private static  boolean isPunctuationSymbol(char symbol) {
        return SYMBOLS_PUNCTUATION.contains(Character.toString(symbol));
    }

    private static  boolean isPunctuationSymbolInWord(char symbol) {
        return SYMBOLS_PUNCTUATION_IN_WORD.contains(Character.toString(symbol));
    }

    private static SplitterSymbol createSplitterSymbol() {
        return new SplitterSymbol(SPLITTER_SYMBOL);
    }

    private static Symbol createSymbol(char symbol) {
        return new Symbol(symbol);
    }

    private static PunctuationMark createPunctuationMark(char symbol) {
        return new PunctuationMark(symbol);
    }

    private static EndOfSentence createEndOfSentence() {
        return new EndOfSentence();
    }

    private static Word createWord() {
        return new Word();
    }

    private static Sentence createSentence() {
        return new Sentence();
    }

    private static Sentence parseSentence(String sentence) {
        Sentence generatedSentence = createSentence();

        Word generatedWord = createWord();
        EndOfSentence generatedEnd = createEndOfSentence();

        boolean wordIsFormed = false;

        char verifiableSymbol;

        for (int i = 0; i < sentence.length(); i++)
        {
            verifiableSymbol = sentence.charAt(i);
            //if current symbol is splitter symbol
            if (isSplitterSymbol(verifiableSymbol))
            {

                if (wordIsFormed)
                {
                    generatedSentence.addElementOfSentence(generatedWord);
                    generatedWord = createWord();
                    wordIsFormed = false;
                }

                generatedSentence.addElementOfSentence(createSplitterSymbol());

            }
            else
            {
                //if current symbol is end of sentence symbol
                if (isEndSymbol(verifiableSymbol))
                {

                    if (wordIsFormed)
                    {
                        generatedSentence.addElementOfSentence(generatedWord);
                        generatedWord = createWord();
                        wordIsFormed = false;
                    }

                    generatedEnd.addEndOfSentence(createSymbol(verifiableSymbol));
                    if (i == sentence.length()-1)
                        generatedSentence.addElementOfSentence(generatedEnd);

                }
                else
                {
                    //if current symbol is punctuation symbol in word and the word is being formed now
                    if ( (wordIsFormed) && (isPunctuationSymbolInWord(verifiableSymbol)) )
                    {
                        generatedWord.addElementOfWord(createSymbol(verifiableSymbol));
                    }
                    else
                    {
                        //if current symbol is punctuation symbol
                        if (isPunctuationSymbol(verifiableSymbol))
                        {

                            if (wordIsFormed)
                            {
                                generatedSentence.addElementOfSentence(generatedWord);
                                generatedWord = createWord();
                                wordIsFormed = false;
                            }

                            generatedSentence.addElementOfSentence(createPunctuationMark(verifiableSymbol));

                        }
                        //it is symbol of word
                        else
                        {
                            wordIsFormed = true;
                            generatedWord.addElementOfWord(createSymbol(verifiableSymbol));
                            if (i == sentence.length()-1)
                            {
                                generatedSentence.addElementOfSentence(generatedWord);
                            }
                        }
                    }
                }
            }
        }

        return generatedSentence;
    }

}
