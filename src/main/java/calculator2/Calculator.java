package calculator2;

import java.util.ArrayList;
import java.util.List;

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

    public List<Double> getResults(){
        return new ArrayList<>(list);
    }

    public void removeResult(){
        if(!list.isEmpty()){
            list.remove(0);
        }
    }

    public void setResult(int index, double value) throws BadException {
        if (index >= 0 && index < list.size()) {
            list.set(index, value);
        } else{
            throw new BadException("올바른 값이 아닙니다.");
        }
    }
}
