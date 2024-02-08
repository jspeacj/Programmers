package Programmers.Level0;

public class FlipString {
    public static void main(String[] args) {
        /*
            문자열 뒤집기

            문제 설명
            문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ my_string의 길이 ≤ 1,000

            입출력 예
            my_string	return
            "jaron"	   "noraj"
            "bread"	   "daerb"

            입출력 예 설명
            입출력 예 #1
            my_string이 "jaron"이므로 거꾸로 뒤집은 "noraj"를 return합니다.

            입출력 예 #2
            my_string이 "bread"이므로 거꾸로 뒤집은 "daerb"를 return합니다.
         */
        /* TC 1 return : "noraj */
        //String my_string = "jaron";

        /* TC2 return : "daerb" */
        String my_string = "bread";

        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        System.out.println(sb.reverse().toString());
    }
}
