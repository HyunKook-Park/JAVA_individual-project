package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.println("사칙연산 할 기호를 입력하세요");
            char operator = sc.next().charAt(0);

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
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        System.out.println("두번째 숫자를 다시 입력하세요.");
                        num2=sc.nextInt();
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("올바른 기호를 입력해주세요.");
                    continue;
            }
            System.out.println(result);
            System.out.println("더 계산하시겠습니까? (eixt 입력 시 종료)");
            String op = sc.next();
            if(op.equals("exit")) {
                break;
            }
        }
    }
}