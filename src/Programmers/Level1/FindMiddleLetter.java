package Programmers.Level1;

public class FindMiddleLetter {
    public static void main(String[] args) {
        //가운데 글자 가져오기
        /*
            문제 설명
            단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

            재한사항
            s는 길이가 1 이상, 100이하인 스트링입니다.
            입출력 예
            s	return
            "abcde"	"c"
            "qwer"	"we"
         */

        String s = "abcde";

        System.out.println(s.length() % 2 == 0 ? even(s) : odd(s));
    }

    // 입력받은 문자열의 자리수가 홀수일 경우 (한글자 반환)
    public static String odd(String s) {
        int index = s.length() / 2;
        return s.substring(index, index + 1);
    }

    // 입력받은 문자열의 자리수가 짝수일 경우 (두글자 반환)
    public static String even(String s) {
        int index = s.length() / 2;
        return s.substring(index - 1, index + 1);
    }
}
