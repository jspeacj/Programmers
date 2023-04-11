package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowToStandInLine {
    private static int index = 0;
    public static void main(String[] args) {
        /*
            줄 서는 방법

            문제 설명
            n명의 사람이 일렬로 줄을 서고 있습니다.
            n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
            n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.

            [1, 2, 3] 1/2 = 0, 1 % 2 !=0 => 1
            [1, 3, 2] 2/2 = 1, 2 % 2 == 0 => 1
            [2, 1, 3] 3/2 = 1, 3 % 2 != 0 1 => 2
            [2, 3, 1] 4/2 = 2, 4 % 2 == 0 => 2
            [3, 1, 2] 5/2 = 2, 5 % 2 != 0 => 3
            [3, 2, 1] 6/2 = 3, 6 % 2 == 0 => 3
[1,2,3,4]
[1,2,4,3]
[1,3,2,4]
[1,3,4,2]
[1,4,2,3]
[1,4,3,2] : (n-1)!
            사람의 수 n과, 자연수 k가 주어질 때,
            사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
            k번째 방법을 return하는 solution 함수를 완성해주세요.

            제한사항
            n은 20이하의 자연수 입니다.
            k는 n! 이하의 자연수 입니다.

            입출력 예
            n	k	result
            3	5	[3,1,2]

            입출력 예시 설명
            입출력 예 #1
            문제의 예시와 같습니다.
         */

        /* TC 1 result : [3, 1, 2] */
        int n = 3;
        long k = 5;

        /* 문제 이해하기
            [1, 2, 3] 1/2 = 0, 1 % 2 !=0 => 1
            [1, 3, 2] 2/2 = 1, 2 % 2 == 0 => 1
            [2, 1, 3] 3/2 = 1, 3 % 2 != 0 1 => 2
            [2, 3, 1] 4/2 = 2, 4 % 2 == 0 => 2
            [3, 1, 2] 5/2 = 2, 5 % 2 != 0 => 3
            [3, 2, 1] 6/2 = 3, 6 % 2 == 0 => 3
          1. 위 규칙에 따라서, 첫번쨰 인덱스의 값은 (k / (n-1)!) + ((k % (n-1)!) == 0 ? 0 : 1)이다.
        * */

        System.out.println(Arrays.toString(getKthMethod(n, k)));
    }

    public static int[] getKthMethod(int n, long k) {
        // Create a list of integers from 1 to n
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        // Calculate the factorial of n
        long factorial = 1;
        for (int i = 2; i <= n; i++) factorial *= i;

        // Create an array to store the kth method
        int[] result = new int[n];

        // Iterate over the elements in the result array
        for (int i = 0; i < n; i++) {
            // Calculate the index of the element to select
            factorial /= n - i;
            long index = (k - 1) / factorial;
            result[i] = list.get((int) index);
            list.remove((int)index);
            k -= index * factorial;
        }

        return result;
    }
}
