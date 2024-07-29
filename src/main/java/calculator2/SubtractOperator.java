package calculator2;

public class SubtractOperator implements Operator {

    @Override
    public double operate(int num1, int num2) {
        return num1 - num2;
    }
}
