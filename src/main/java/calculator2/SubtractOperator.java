package calculator2;

public class SubtractOperator<T extends Number> implements Operator<T> {

    @Override
    public double operate(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
