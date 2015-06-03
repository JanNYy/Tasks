package courses.task2.elements;

public class Symbol {

    private char symbol;

    public Symbol(char s) {
        symbol = s;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
