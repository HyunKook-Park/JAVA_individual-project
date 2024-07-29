package calculator2;

public class MultiplyOperator implements Operator {
    @Override
    public double operate(int num1, int num2) {
        return num1 * num2;
    }
}
