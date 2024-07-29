package calculator2;

import java.util.HashMap;
import java.util.Map;

public class ArtimaticCalculator extends Calculator {
    private final Map<Character, Operator> operators = new HashMap<>();

    public ArtimaticCalculator() {
        operators.put('+', new AddOperator());
        operators.put('-', new SubtractOperator());
        operators.put('*', new MultiplyOperator());
        operators.put('/', new DivideOperator());
        operators.put('%', new ModOperator());
    }

    @Override
    public double calculate(int num1, int num2, char operator) throws BadException {
        Operator op = operators.get(operator);
        if (op == null) {
            throw new BadException("Unknown operator: " + operator);
        }
        double result = op.operate(num1, num2);
        list.add(result);
        return result;
    }

    @Override
    public double calculateCircleArea(double radius) throws BadException {
        throw new BadException("사칙연산 계산기에서는 원의 넓이를 계산할 수 없습니다.");
    }

}
