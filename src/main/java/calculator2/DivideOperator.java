package calculator2;

public class DivideOperator implements Operator{
    @Override
    public double operate(int num1, int num2) throws BadException {
        if (num2 == 0) {
            throw new BadException("나눗셈 할 수 없음");
        } else {
            return num1 / (double) num2;
        }
    }
}
