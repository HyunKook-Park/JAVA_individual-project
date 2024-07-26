package calculator2;

public class ArtimaticCalculator extends Calculator {

    @Override
    public double calculate(int num1, int num2, char operator) throws BadException {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new BadException("나눗셈 할 수 없음");
                } else {
                    result = num1 / (double) num2;
                }
                break;
            default:
                throw new BadException("입력 에러");
        }
        list.add(result);
        return result;
    }

    @Override
    public double calculateCircleArea(double radius) throws BadException {
        throw new BadException("사칙연산 계산기에서는 원의 넓이를 계산할 수 없습니다.");
    }

}
