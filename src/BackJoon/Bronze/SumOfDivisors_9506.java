package BackJoon.Bronze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SumOfDivisors_9506 {
    public static void main(String[] args) {
        /*
            약수들의 합 (브론즈 1)

            문제
            어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.

            예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.

            n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

            입력
            입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)

            입력의 마지막엔 -1이 주어진다.

            출력
            테스트케이스 마다 한줄에 하나씩 출력해야 한다.

            n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).

            이때, 약수들은 오름차순으로 나열해야 한다.

            n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.

            예제 입력 1
            6
            12
            28
            -1

            예제 출력 1
            6 = 1 + 2 + 3
            12 is NOT perfect.
            28 = 1 + 2 + 4 + 7 + 14
         */

        Queue<Integer> queue = new LinkedList<>(); // 중간을 기점으로 앞의 약수 값들을 담아두기 위한 값
        Stack<Integer> stack = new Stack<>(); // 중간을 기점으로 뒤의 약수 값들을 담아두기 위한 값
        int middle = 0; // 중간 값을 담아두기 위한 변수

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        while (true) {
            flag = false;
            sb.setLength(0); // 초기화
            int sum = 0;
            int num = scan.nextInt();
            if (num == -1) break;

            sb.append(num + " = ");

            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                    if (i == (num / 2)) {
                        sb.append(i);
                    } else {
                        sb.append(i + " + ");
                    }
                }

                if (sum > num) {
                    flag = true;
                    break;
                }
            }

            if (sum < num) flag = true;

            if (flag) {
                System.out.println(num + " is NOT perfect.");
            } else {
                System.out.println(sb.toString());
            }
        }
    }
}
