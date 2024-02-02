package Programmers.Level2;

public class CreateJadenCaseString {
    public static void main(String[] args) {
        /*
            JadenCase 문자열 만들기
            문제 설명
            JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
            단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
            문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

            제한 조건
            s는 길이 1 이상 200 이하인 문자열입니다.
            s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
            숫자는 단어의 첫 문자로만 나옵니다.
            숫자로만 이루어진 단어는 없습니다.
            공백문자가 연속해서 나올 수 있습니다.
            입출력 예
                        s	                        return
            "3people unFollowed me"	        "3people Unfollowed Me"
            "for the last week"	            "For The Last Week"
            ※ 공지 - 2022년 1월 14일 제한 조건과 테스트 케이스가 추가되었습니다.
         */

        /* TC 1 */
        //String s = "3people unFollowed me";

        /* TC 2 */
        String s = "for the last week";

        /* TC 3 => 공백이 여러개일 경우*/
        //String s = " for   the   last   week ";

        StringBuilder sb = new StringBuilder();
        String[] strArrays = s.split(" ");

        boolean flag = false; //양끝 공백이 존재할 경우 trim이용하기 위해 boolean 선언

        if (s.length() != s.trim().length()) flag = true;

        for (String str : strArrays) {
            if (!"".equals(str.trim())) { // 공백이 아닐 경우
                String s1 = str.toLowerCase();
                char c = s1.charAt(0);
                if (c >= 97 && c <= 122) { // 첫글자가 소문자 a ~ z일 경우
                    // 아스키 코드 a ~ z : 97 ~ 122, A ~ Z : 65 ~ 90
                    c -= 32;
                    sb.append(c);
                    sb.append(s1.substring(1));
                } else sb.append(s1);

                sb.append(" "); //문자 삽입 이후 공백(" ") 추가
            } else sb.append(" "); //문자 삽입 이후 공백(" ") 추가
        }

        if (flag) System.out.println(sb.toString());
        else System.out.println(sb.toString().trim());
    }
}
