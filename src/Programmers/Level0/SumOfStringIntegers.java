package Programmers.Level0;

public class SumOfStringIntegers {
    public static void main(String[] args) {
        /*
            문자열 정수의 합

            문제 설명
            한 자리 정수로 이루어진 문자열 num_str이 주어질 때,
            각 자리수의 합을 return하도록 solution 함수를 완성해주세요.

            제한사항
            3 ≤ num_str ≤ 100

            입출력 예
            num_str	    result
            "123456789"	  45
            "1000000"	  1

            입출력 예 설명
            입출력 예 #1
            문자열 안의 모든 숫자를 더하면 45가 됩니다.

            입출력 예 #2
            문자열 안의 모든 숫자를 더하면 1이 됩니다.
         */

        /* TC 1 result : 45 */
        //String num_str = "123456789";

        /* TC 2 result : 1 */
        String num_str = "1000000";

        int total = 0;
        for (String str : num_str.split("")) total += Integer.parseInt(str);
        System.out.println(total);
    }
}
