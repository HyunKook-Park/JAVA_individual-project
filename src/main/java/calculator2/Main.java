package calculator2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            double result = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                System.out.print("사칙연산 할 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);
                try {
                    result = calc.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                    list.add(result);
                    break; // 정상적으로 계산되면 내부 while 루프 종료
                } catch (BadException e) {
                    System.out.println(e.getMessage());
                    if (e.getMessage().contains("나눗셈 할 수 없음")) {
                        System.out.println("다시 시도해주세요.");
                    } else {
                        break; // 잘못된 연산자 입력 등의 경우 외부 while 루프 종료
                    }
                }
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("remove")) {
                if (!list.isEmpty()) {
                    list.remove(0);
                    System.out.println("가장 먼저 저장된 연산 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.next();
            if (inquiry.equals("inquiry")) {
                int a = 1;
                for (double i : list) {
                    System.out.println(a + "에 저장된 연산결과 : " + i);
                    a++;
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String op = sc.next();
            if (op.equals("exit")) {
                break;
            }
        }
        sc.close();
    }
}
