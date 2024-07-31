package calculator2;

import java.util.HashMap;
import java.util.Map;

public class ArtimaticCalculator extends Calculator {
    private final Map<OperatorType, Operator> operators = new HashMap<>();

    public ArtimaticCalculator() {
        operators.put(OperatorType.ADD, new AddOperator());
        operators.put(OperatorType.SUBTRACT, new SubtractOperator());
        operators.put(OperatorType.MULTIPLY, new MultiplyOperator());
        operators.put(OperatorType.DIVIDE, new DivideOperator());
        operators.put(OperatorType.MOD, new ModOperator());
    }

    @Override
    public double calculate(int num1, int num2, char operatorSymbol) throws BadException {
        OperatorType operatorType;
        try {
            operatorType = OperatorType.fromSymbol(operatorSymbol);
        } catch (IllegalArgumentException e) {
            throw new BadException(e.getMessage());
        }

        Operator operator = operators.get(operatorType);
        if (operator == null) {
            throw new BadException("Unknown operator: " + operatorSymbol);
        }
        double result = operator.operate(num1, num2);
        list.add(result);
        return result;
    }

    @Override
    public double calculateCircleArea(double radius) throws BadException {
        throw new BadException("사칙연산 계산기에서는 원의 넓이를 계산할 수 없습니다.");
    }
}
