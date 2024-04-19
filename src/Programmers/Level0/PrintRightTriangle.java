package Programmers.Level0;

import java.util.Scanner;

public class PrintRightTriangle {
    public static void main(String[] args) {
        /*
            직각삼각형 출력하기

            문제 설명
            "*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다.
            정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.

            제한사항
            1 ≤ n ≤ 10

            입출력 예
            입력 #1
            3

            출력 #1
            *
            **
            ***

            입출력 예 설명
            입출력 예 #1

            n이 3이므로 첫째 줄에 * 1개, 둘째 줄에 * 2개, 셋째 줄에 * 3개를 출력합니다.
         */

        /* TC 1 result :
             *
             **
             ***
        */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= n; i++) print(i);
    }

    public static void print(int num) {
        for (int i = 0; i < num; i++) System.out.print("*");
        System.out.println();
    }
}
