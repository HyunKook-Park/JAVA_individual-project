package calculator2;

public class CircleCalculator<T extends Number> extends Calculator<T> {

    private static final double PI = 3.141592653589793;  // 원주율 상수로 정의

    @Override
    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        System.out.println("원의 넓이: " + area);
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        return area;
    }

    @Override
    public double calculate(T num1, T num2, char method) throws BadException{
        throw new BadException("원 계산기에서는 사칙연산을 수행할 수 없습니다.");
    }


}
