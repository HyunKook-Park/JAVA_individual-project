package calculator2;

public class DivideOperator<T extends Number> implements Operator<T>{
    @Override
    public double operate(T num1, T num2) throws BadException {
        if (num2.doubleValue() == 0) {
            throw new BadException("나눗셈 할 수 없음");
        } else {
            return num1.doubleValue() / num2.doubleValue();
        }
    }
}
