package calculator2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ArtimaticCalculator<T extends Number> extends Calculator<T> {
    private final Map<OperatorType, Operator<T>> operators = new HashMap<>();

    public ArtimaticCalculator() {
        operators.put(OperatorType.ADD, new AddOperator<>());
        operators.put(OperatorType.SUBTRACT, new SubtractOperator<>());
        operators.put(OperatorType.MULTIPLY, new MultiplyOperator<>());
        operators.put(OperatorType.DIVIDE, new DivideOperator<>());
        operators.put(OperatorType.MOD, new ModOperator<>());
    }

    @Override
    public double calculate(T num1, T num2, char operatorSymbol) throws BadException {
        OperatorType operatorType;
        try {
            operatorType = OperatorType.fromSymbol(operatorSymbol);
        } catch (IllegalArgumentException e) {
            throw new BadException(e.getMessage());
        }

        Operator<T> operator = operators.get(operatorType);
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
    // 저장된 연산 결과들 중 특정 값보다 큰 결과 값을 조회하는 메서드
    public List<Double> getResultsGreaterThan(double value) {
        return list.stream().filter(result -> result > value).collect(Collectors.toList());
    }
}
