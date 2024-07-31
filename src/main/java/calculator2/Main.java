package calculator2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BadException {
        Scanner sc = new Scanner(System.in);
        ArtimaticCalculator<Number> calc1 = new ArtimaticCalculator();
        Calculator<Double> calc2 = new CircleCalculator();

        String command="";
        while(!command.equals("exit")) {
            StartMessage(sc);
            command = sc.nextLine();

            if (command.equals("exit")) {
                break;
            }

            if (command.equals("1")) {
                while (true) {
                    double num1;   // 첫 번째 입력 숫자
                    double num2;   // 두 번째 입력 숫자
                    char operator;  // 사칙 연산 기호
                    double result;  // 연산

                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                    while (true) {
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        num2 = sc.nextInt();

                        System.out.print("사칙연산 할 기호를 입력하세요: ");
                        operator = sc.next().charAt(0);

                        try {
                            result = calc1.calculate(num1, num2, operator);
                            System.out.println("결과: " + result);
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

                    // 연산 종료 후 옵션
                    RemoveResult(sc, calc1);
                    InquiryOption(sc, calc1);
                    GraterThan(sc, calc1);
                    EditOption(sc, calc1);

                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    command = sc.next();
                    if (command.equals("exit")) {
                        break;
                    }
                }

            } else if (command.equals("2")) {
                while (true) {
                    System.out.println("원의 반지름을 입력하세요");
                    double radius = sc.nextDouble();
                    double area = calc2.calculateCircleArea(radius);
                    command = sc.next();
                    if (command.equals("exit")) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        sc.close();
    }

    private static void StartMessage(Scanner sc){
        System.out.println("어떤 것을 계산 할까요?");
        System.out.println("1. 사칙연산");
        System.out.println("2. 원의 넓이 계산");
        System.out.println("exit 입력 시 종료");

    }
    private static void RemoveResult(Scanner sc, Calculator<?> calc1){
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
        String remove = sc.next();
        if (remove.equals("remove")) {
            calc1.removeResult();
            System.out.println("가장 먼저 저장된 연산 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }
    private static void InquiryOption(Scanner sc, Calculator<?> calc1){
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
        String inquiry = sc.next();
        if (inquiry.equals("inquiry")) {
            List<Double> results = calc1.inquiryResults();
            int a = 1;
            for (double i : results) {
                System.out.println(a + "번째 연산에 저장된 연산결과 : " + i);
                a++;
            }
        }
    }
    private static void EditOption(Scanner sc, Calculator<?> calc1){
        System.out.println("저장된 연산 결과를 수정하시겠습니까? (yes 입력 시 수정)");
        String modify = sc.next();
        if (modify.equals("yes")) {
            System.out.println("수정할 인덱스를 입력하세요 (0부터 시작)");
            int index = sc.nextInt();
            System.out.println("새로운 값을 입력하세요: ");
            double newValue = sc.nextDouble();
            try {
                calc1.setResult(index, newValue);
                System.out.println("수정되었습니다.");
            } catch (BadException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void GraterThan(Scanner sc, ArtimaticCalculator<?> calc1){
        System.out.println("조회할 기준 값을 입력하세요 : ");
        double value = sc.nextDouble();
        List<Double> results = calc1.getResultsGreaterThan(value);
        System.out.println("기준 값보다 큰 결과 값들: " + results);
    }
}