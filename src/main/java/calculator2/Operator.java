package calculator2;

public interface Operator<T extends Number> {
    double operate(T num1, T num2) throws BadException;
}



