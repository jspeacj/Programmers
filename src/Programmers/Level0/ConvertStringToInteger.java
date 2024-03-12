package Programmers.Level0;

public class ConvertStringToInteger {
    public static void main(String[] args) {
        /*
            문자열을 정수로 변환하기

            문제 설명
            숫자로만 이루어진 문자열 n_str이 주어질 때,
            n_str을 정수로 변환하여 return하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ n_str ≤ 5
            n_str은 0부터 9까지의 정수 문자로만 이루어져 있습니다.

            입출력 예
            n_str	result
            "10"	10
            "8542"	8542

            입출력 예 설명
            입출력 예 #1
            "10"을 정수로 바꾸면 10입니다.

            입출력 예 #2
            "8542"를 정수로 바꾸면 8542입니다.
         */

        /* TC 1 result : 10 */
        String n_str = "10";

        /* TC 2 result : 8542 */
        //String n_str = "8542";

        System.out.println(Integer.parseInt(n_str));
    }
}
