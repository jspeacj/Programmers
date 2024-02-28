package Programmers.Level0;

public class StringMultiplication {
    public static void main(String[] args) {
        /*
            문자열 곱하기

            문제 설명
            문자열 my_string과 정수 k가 주어질 때,
            my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.

            제한사항
            1 ≤ my_string의 길이 ≤ 100
            my_string은 영소문자로만 이루어져 있습니다.
            1 ≤ k ≤ 100

            입출력 예
            my_string	k	     result
            "string"	3	"stringstringstring"
            "love"	    10	"lovelovelovelovelovelovelovelovelovelove"

            입출력 예 설명
            입출력 예 #1
            예제 1번의 my_string은 "string"이고 이를 3번 반복한 문자열은 "stringstringstring"이므로 이를 return 합니다.

            입출력 예 #2
            예제 2번의 my_string은 "love"이고 이를 10번 반복한 문자열은 "lovelovelovelovelovelovelovelovelovelove"이므로 이를 return 합니다.
         */

        /* TC 1 result : stringstringstring */
        //String my_string = "string";
        //int k = 3;

        /* TC 2 result : lovelovelovelovelovelovelovelovelovelove */
        String my_string = "love";
        int k = 10;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(my_string);
        System.out.println(sb.toString());
    }
}
