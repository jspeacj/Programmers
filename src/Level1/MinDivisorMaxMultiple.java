package Level1;

import java.util.*;

public class MinDivisorMaxMultiple {
    public static void main(String[] args) {
        /*
        ★★★★★★★★★★★★★★★★★★★★★★최대공약수와 최소공배수 (유클리드호제법 : A,b의최대공약수 * A,b의최소공배수 = A*B;★★★★★★★★★★★★★★★★★★★★★★
        문제 설명
        두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
        에를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

        제한 사항
        두 수는 1이상 1000000이하의 자연수입니다.
        입출력 예
        n	m	return
        3	12	[3, 12]
        2	5	[1, 10]
         */
        int n = 3;
        int m = 12;

        int[] answer = new int[2];

        for(int i = 1; i < n + m; i++) {
            if (n % i == 0 && m % i == 0) answer[0] = i;
        }

        answer[1] = (n * m) / answer[0];
        System.out.println(Arrays.toString(answer));
    }
}
