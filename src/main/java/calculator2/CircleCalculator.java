package calculator2;

public class CircleCalculator extends Calculator {

    private static final double PI = 3.141592653589793;  // 원주율 상수로 정의

    @Override
    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        list.add(area);
        return area;
    }

    @Override
    public double calculate(int num1, int num2, char method) throws BadException{
        throw new BadException("원 계산기에서는 사칙연산을 수행할 수 없습니다.");
    }


}
