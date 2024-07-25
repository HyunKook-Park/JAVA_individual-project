package calculator2;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Double> list = new ArrayList<Double>();

    public double calculate(int num1, int num2, char method) throws BadException {
        double result = 0;
        switch (method) {
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
}
