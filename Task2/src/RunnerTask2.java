package courses.task2;

// 2. Display all sentences in ascending order of the number of words in each of them.
public class RunnerTask2 {

    private final static String SYMBOLS_END_OF_SENTENCE = ".?!";
    private final static String SYMBOLS_IN_WORD = "'-";
    private final static String SYMBOLS_PUNCTUATION = ",:;\\-\\[\\]()<>\\{\\}\\";

    public static void main(String[] args) {

        String st2 = "Tra-la-la -  \"mimimi\":     hello& ?Ay, yyy  y,y - y, ya-hoo!! Something*& |||is2wrong ...with; this text - hi. Hi";

        Text parseText = StringParser.parseText(st2);
        System.out.println("Parsed text: "+parseText);
        System.out.println();
        System.out.println("Parsed sentences: ");
        for (int i = 0; i < parseText.getNumberOfSentences(); i++)
        {
            System.out.println("Sentence "+i+": "+parseText.getSentence(i));
            System.out.println("Number of words: "+parseText.getNumberOfWordsInSentence(i));
        }
        System.out.println();
        System.out.println("Number of sentences: " + parseText.getNumberOfSentences());

        System.out.println();
        System.out.println("Sorted text by number of words in sentences: ");
        parseText.sortAllSentencesNumberOfWords();
        for (int i = 0; i < parseText.getNumberOfSentences(); i++)
        {
            System.out.println(parseText.getSentence(i));
        }
        System.out.println();

    }

}
