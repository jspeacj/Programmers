package Programmers.Level1;

public class TernaryFlip {
    public static void main(String[] args) {
        /*
            3진법 뒤집기
            문제 설명
            자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

            제한사항
            n은 1 이상 100,000,000 이하인 자연수입니다.
            입출력 예
            n	result
            45	  7
            125	  229
            입출력 예 설명
            입출력 예 #1

            답을 도출하는 과정은 다음과 같습니다.
            n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
              45	       1200	        0021	        7
            따라서 7을 return 해야 합니다.
            입출력 예 #2

            답을 도출하는 과정은 다음과 같습니다.
            n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
            125	        11122	        22111	        229
            따라서 229를 return 해야 합니다.
         */
        int n = 45;

        String s = convertNotationReverse(n, 3);
        System.out.println(Integer.parseInt(s, 3)); //N진법 -> 10진법 변환 : Integer.parseInt(문자열, N);
    }

    public static String convertNotationReverse(int num, int notation) {
        StringBuffer sb = new StringBuffer();

        while (true) {
            if (num < notation) {
                sb.append(num);
                break;
            }

            sb.append(num % notation);
            num /= notation;
        }

        return sb.toString();
    }

    public static String convertNotation(int num, int notation) {
        StringBuffer sb = new StringBuffer();

        while (true) {
            if (num < notation) {
                sb.insert(0, num);
                break;
            }

            sb.insert(0, num % notation);
            num /= notation;
        }

        return sb.toString();
    }
}
