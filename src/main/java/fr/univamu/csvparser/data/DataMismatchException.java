package fr.univamu.csvparser.data;

public class DataMismatchException extends Exception{
    private final String expectedType;
    private final String input;

    public DataMismatchException(String expectedType, String input, Throwable cause) {
        super("Mismatch when reading a string,expecting " + expectedType + " but got " + (input.isEmpty() ? "<nothing>" : input), cause);
        this.expectedType = expectedType;
        this.input = input;
    }
    public String getExpectedType() {
        return expectedType;
    }
    public String getInput() {
        return input;
    }

    public String toString(){
        return ("Mismatch when reading a string, expecting " + expectedType + " but got " + (input.isEmpty() ? "<nothing>" : input));
    }
}
