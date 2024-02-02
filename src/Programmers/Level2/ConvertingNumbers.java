package Programmers.Level2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConvertingNumbers {
    public static void main(String[] args) {
        /*
            숫자 변환하기
            문제 설명
            자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

            x에 n을 더합니다
            x에 2를 곱합니다.
            x에 3을 곱합니다.

            자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
            이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

            제한사항
            1 ≤ x ≤ y ≤ 1,000,000
            1 ≤ n < y

            입출력 예
            x	y	n	result
            10	40	5	  2
            10	40	30	  1
            2	5	4	 -1

            입출력 예 설명
            입출력 예 #1
            x에 2를 2번 곱하면 40이 되고 이때가 최소 횟수입니다.

            입출력 예 #2
            x에 n인 30을 1번 더하면 40이 되고 이때가 최소 횟수입니다.

            입출력 예 #3
            x를 y로 변환할 수 없기 때문에 -1을 return합니다.
         */

        /* TC 1 result : 2 */
        //int x = 10;
        //int y = 40;
        //int n = 5;

        /* TC 2 result 1 */
        //int x = 10;
        //int y = 40;
        //int n = 30;

        /* TC 3 result -1 */
        int x = 2;
        int y = 5;
        int n = 4;

        int answer = 0;
        Set<Integer> set = new HashSet<>();
        set.add(x);

        while (!set.isEmpty()) {
            if (set.contains(y)) {
                System.out.println(answer);
                break;
            }

            Set<Integer> nextSet = new HashSet<>();
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (next + n <= y) nextSet.add(next + n);
                if (next * 2 <= y) nextSet.add(next * 2);
                if (next * 3 <= y) nextSet.add(next * 3);
            }
            set = nextSet;
            answer++;
        }

        System.out.println(-1);
    }
}
