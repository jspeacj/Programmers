package BackJoon.Bronze;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FourthPoint_3009 {
    public static void main(String[] args) {
        /*
            네번쨰 점 (브론즈 3)

            문제
            세 점이 주어졌을 때,
            축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

            입력
            세 점의 좌표가 한 줄에 하나씩 주어진다.
            좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

            출력
            직사각형의 네 번째 점의 좌표를 출력한다.

            예제 입력 1
            5 5
            5 7
            7 5
            예제 출력 1
            7 7

            예제 입력 2
            30 20
            10 10
            10 20
            예제 출력 2
            30 10
         */

        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        int x = 0;
        int y = 0;

        for (int i = 0; i < 3; i++) {
            int row = scan.nextInt();
            int col = scan.nextInt();

            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
        }

        x = findLocation(rowMap);
        y = findLocation(colMap);

        System.out.println(x + " " + y);
    }

    public static int findLocation (Map<Integer, Integer> map) {
        for (int num : map.keySet()) {
            if (map.get(num) == 1) return num;
        }
        return 0;
    }
}
