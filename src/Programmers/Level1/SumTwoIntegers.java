package Programmers.Level1;

public class SumTwoIntegers {
    public static void main(String[] args) {
        /*
        //두 정수사이의 합
        두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
        예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

        제한 조건
        a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
        a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
        a와 b의 대소관계는 정해져있지 않습니다.
         */
        long a = 3;
        long b = 6;

        long c = Math.min(a, b); // 작은 수
        long d = Math.max(a, b); // 큰 수
        long answer = 0;

        if (c > 0 && d > 0 && d % 2 == 0) {
            // 두 숫자가 양수이며 큰 수가 짝수 일 경우
            answer = (c + d) * (d / 2);
        } else {
            for (long index = c; index <= d; index++) {
                answer += index;
            }
        }

        System.out.println(answer);
    }
}
