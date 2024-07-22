package BackJoon.Bronze;

import java.util.Scanner;

public class MemorizeTriangles_10101 {
    public static void main(String[] args) {
        /*
            삼각형 외우기 (브론즈 4)

            문제
            창영이는 삼각형의 종류를 잘 구분하지 못한다.
            따라서 프로그램을 이용해 이를 외우려고 한다.

            삼각형의 세 각을 입력받은 다음,
            세 각의 크기가 모두 60이면, Equilateral
            세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
            세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
            세 각의 합이 180이 아닌 경우에는 Error
            를 출력하는 프로그램을 작성하시오.

            입력
            총 3개의 줄에 걸쳐 삼각형의 각의 크기가 주어진다.
            모든 정수는 0보다 크고, 180보다 작다.

            출력
            문제의 설명에 따라 Equilateral, Isosceles, Scalene, Error 중 하나를 출력한다.

            예제 입력 1
            60
            70
            50
            예제 출력 1
            Scalene
         */

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println(checkTriangle(a, b, c));
    }

    public static String checkTriangle(int a, int b, int c) {
        if (a + b + c == 180) {
            if (a == 60 && b == 60 && c == 60) return "Equilateral";
            else if (a == b || b == c || a == c) return "Isosceles";
            else return "Scalene";
        } else {
            return "Error";
        }
    }
}
