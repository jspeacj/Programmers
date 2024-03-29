package Programmers.Level1;

public class CaesarCipher {
    public static void main(String[] args) {
    /*
        시저 암호
        문제 설명
        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
        예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
        문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

        제한 조건
        공백은 아무리 밀어도 공백입니다.
        s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
        s의 길이는 8000이하입니다.
        n은 1 이상, 25이하인 자연수입니다.
        입출력 예
        s	    n	result
        "AB"	1	"BC"
        "z"	    1	"a"
        "a B z"	4	"e F d"
     */

        //a의 아스키 코드값값
       String s = "a B z";
        int n = 4;

        //아스키코드 값 : a :97 z : 122 , A : 65, Z : 90
        char[] chars = s.toCharArray();
        String answer = "";

        for (char c : chars) {
            if ("".equals(String.valueOf(c).trim())) {
                answer += " ";
                continue;
            }
            int value = (int)c;
            int moveNum = value + n;
            if (value >= 65 && value <= 90 && moveNum > 90) { // A ~ Z이면서 Z아스키코드 값을 넘었을 경우
                moveNum = moveNum - 91 + 65;
            } else if (value >= 97 && value <= 122 && moveNum > 122){ // a ~ z이면서 z아스키코드 값을 넘었을 경우
                moveNum = moveNum - 123 + 97;
            }

            answer += String.valueOf((char)moveNum);
        }

        System.out.println(answer);
    }
}
