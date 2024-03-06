package Programmers.Level0;

public class ReturnDefValDependOddEven {
    public static void main(String[] args) {
        /*
            홀짝에 따라 다른 값 반환하기

            문제 설명
            양의 정수 n이 매개변수로 주어질 때, n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
            n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.

            제한사항
            1 ≤ n ≤ 100

            입출력 예
            n	result
            7	16
            10	220

            입출력 예 설명
            입출력 예 #1
            예제 1번의 n은 7로 홀수입니다. 7 이하의 모든 양의 홀수는 1, 3, 5, 7이고 이들의 합인 1 + 3 + 5 + 7 = 16을 return 합니다.

            입출력 예 #2
            예제 2번의 n은 10으로 짝수입니다. 10 이하의 모든 양의 짝수는 2, 4, 6, 8, 10이고 이들의 제곱의 합인 2(2) + 4(2) + 6(2) + 8(2) + 10(2) = 4 + 16 + 36 + 64 + 100 = 220을 return 합니다.
         */

        /* TC 1 result : 16 */
        //int n = 7;

        /* TC 2 result : 220 */
        int n = 10;

        System.out.println(n % 2 == 0 ? sumEven(n) : sumOdd(n));
    }

    public static int sumEven(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += (i * i);
        }

        return sum;
    }

    public static int sumOdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }

        return sum;
    }
}
