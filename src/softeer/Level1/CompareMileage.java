package softeer.Level1;

import java.util.Scanner;

public class CompareMileage {
    public static void main(String[] args) {
        /*
            주행거리 비교하기 (Level 1)
            현대자동차그룹의 연구원인 영호는 자동차의 주행거리를 비교하는 프로그램을 만들고 있다.
            두 차량 A와 B의 주행거리가 자연수로 주어졌을 때, 주행거리를 비교해서 어느 차량의 주행거리가 더 큰지 알아보자.

            제약조건
            0 ≤ A,B ≤ 100,000

            입력형식
            첫째줄에 두차량 A,B의 주행거리가 한칸의 공백을 두고 주어진다.

            출력형식
            주행거리를 비교해서 첫째줄에 아래의 글자를 출력한다.

            - A가 B 보다 큰 경우 A를 출력한다.
            - A가 B 보다 작은 경우 B를 출력한다.
            - A와 B의 주행거리가 같은 경우 same을 출력한다.

            입력예제1
            3500 2000
            출력예제1
            A

            입력예제2
            1500 1800
            출력예제2
            B

            입력예제3
            5000 5000
            출력예제3
            same
         */

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        if (a == b) System.out.println("same");
        else System.out.println(a > b ? "A" : "B");
    }
}
