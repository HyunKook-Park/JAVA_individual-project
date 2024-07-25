package calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    ArrayList<Double> list = new ArrayList<Double>();

    // 생성자를 통한 초기화 2-6
    public Calculator() {
        this.list = new ArrayList<Double>();  // 이를 통해 객체 생성 시 list는 'null'이 아닌 비어있는 'ArrayList'로 초기화 됨.
    }    // 기존 'null' 상태였을때는 list 변수가 어떤 유효한 객체도 참조하지 않고 있어서, 해당 변수로는 아무것도 할 수 없다.
         // 'null' 상태에서는 메서드를 호출하거나 해당 속성에 접근하려고 하면, 'NullpointException' 오류 발생.
         // 초기화된 필드는 적절한 값이나 객체를 참조하여, 메서드 호출이나 데이터 접근이 정상적으로 이루어짐

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

    public List<Double> inquiryResults(){
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
