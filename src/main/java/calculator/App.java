package calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        // int[] arr = new int[3];  // result 저장 변수
        int lastIndex = 0;  // result의 마지막 index 변수 선언
        ArrayList<Integer> list = new ArrayList<Integer>();
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
            System.out.println("결과"+result);
            list.add(result);

//            arr[lastIndex] = result;
//            ++ lastIndex;
//            if (lastIndex == arr.length - 1) {
//                System.out.println("저장 공간이 가득 찼으므로, 처음 입력했던 결과 값을 삭제하겠습니다.");
//<1-6>            for(int i=0; i<arr.length - 1; i++) {
//                    arr[i]+=1;
//                }
//                arr[arr.length-1] = result;
//            }
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();

            if(remove.equals("remove")) {
                list.remove(0);
            }
            System.out.println("더 계산하시겠습니까? (eixt 입력 시 종료)");
            String op = sc.next();
            if(op.equals("exit")) {
                break;
            }
        }
    }
}