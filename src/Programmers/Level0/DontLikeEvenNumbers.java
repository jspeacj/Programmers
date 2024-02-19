package Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DontLikeEvenNumbers {
    public static void main(String[] args) {
        /*
            짝수는 싫어요

            문제 설명
            정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ n ≤ 100

            입출력 예
            n	result
            10	[1, 3, 5, 7, 9]
            15	[1, 3, 5, 7, 9, 11, 13, 15]

            입출력 예 설명
            입출력 #1
            10 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9]를 return합니다.

            입출력 #2
            15 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9, 11, 13, 15]를 return합니다.
         */

        /* TC 1 result : [1, 3, 5, 7, 9] */
        //int n = 10;

        /* TC 2 result : [1, 3, 5, 7, 9, 11, 13, 15] */
        int n = 15;

        List<Integer> list = new ArrayList<>();
        int num = 1;

        while (true) {
            list.add(num);
            num += 2;
            if (num > n) break;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        System.out.println(Arrays.toString(answer));
    }
}
