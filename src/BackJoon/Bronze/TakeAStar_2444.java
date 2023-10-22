package BackJoon.Bronze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TakeAStar_2444 {
    public static void main(String[] args) {
        /*
            별찍기 - 7 (브론즈 3)
            문제
            예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

            입력
            첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

            출력
            첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

            5 =>        *
                       ***
                      *****
                     *******
                    *********
                     *******
                      *****
                       ***
                        *
         */

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        int index = scan.nextInt();
        String middle = findMiddle(sb, index);
        int cnt = 0;
        for (int i = index - 1; i > 0; i--) {
            sb = sb.replace(cnt, cnt + 1, " ");
            sb = sb.replace(sb.length()-1, sb.length(), "");
            stack.add(sb.toString()); // 앞부분(LIFO)
            queue.add(sb.toString()); // 뒷부분(FIFO)
            cnt++;
        }

        while(!stack.isEmpty()) { // 앞부분
            System.out.println(stack.pop());
        }

        System.out.println(middle); // 중간부분

        while(!queue.isEmpty()) { // 뒷부분
            System.out.println(queue.poll());
        }
    }

    public static String findMiddle(StringBuilder sb, int index) {
        sb.append("*");
        for (int i = 0; i < index - 1; i++) {
            sb.append("**"); // 주어진 개수 만큼 채우기 (최종적으로 가운데 값이 됨)
        }

        return sb.toString();
    }
}