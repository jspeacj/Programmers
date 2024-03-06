package Programmers.Level0;

public class MultipleOfN {
    public static void main(String[] args) {
        /*
            n의 배수

            문제 설명
            정수 num과 n이 매개 변수로 주어질 때, num이 n의 배수이면 1을 return
            n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.

            제한사항
            2 ≤ num ≤ 100
            2 ≤ n ≤ 9

            입출력 예
            num	n	result
            98	2	  1
            34	3	  0

            입출력 예 설명
            입출력 예 #1
            98은 2의 배수이므로 1을 return합니다.

            입출력 예 #2
            32는 3의 배수가 아니므로 0을 return합니다.
         */

        /* TC 1 result : 1 */
        //int num = 98;
        //int n = 2;

        /* TC 2 result : 0 */
        int num = 34;
        int n = 3;

        System.out.println(num % n == 0 ? 1 : 0);
    }
}
