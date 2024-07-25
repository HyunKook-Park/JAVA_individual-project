package calculator2;

public class BadException extends Exception {

    public BadException(String type) {
        super(type + "Is Bad Exception");
    }
}
