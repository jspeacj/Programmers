package Programmers.Level1;

public class SplitString {
    public static void main(String[] args) {
        /*
            문자열 나누기
            문제 설명
            문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.

            먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
            이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다.
            처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
            s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
            만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
            문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.

            제한사항
            1 ≤ s의 길이 ≤ 10,000
            s는 영어 소문자로만 이루어져 있습니다.
            입출력 예
                s	         result
            "banana"	       3
            "abracadabra"	   6
            "aaabbaccccabba"   3
            입출력 예 설명
            입출력 예 #1
            s="banana"인 경우 ba - na - na와 같이 분해됩니다.
            b : a => ba
            n : a => na
            n : a => na
            입출력 예 #2
            s="abracadabra"인 경우 ab - ra - ca - da - br - a와 같이 분해됩니다.
            a : b => ab
            r : a => ra
            c : a => ca
            d : a => da
            b : r => br
            a
            입출력 예 #3
            s="aaabbaccccabba"인 경우 aaabbacc - ccab - ba와 같이 분해됩니다.
            aaaa : bbcc
            cc : ab
            b : a
         */

        /* TC 1*/
        //String s = "banana"; //6 5, 6
        /* TC 2*/
        String s = "abracadabra";
        /* TC 3*/
        //String s = "aaabbaccccabba";

        StringBuilder sbX = new StringBuilder(); //x 문자를 담아둘 변수
        StringBuilder nextSbX = new StringBuilder(); //x 이외 문자를 담아둘 변수
        int reuslt = 0; // 결과 값

        for (int index = 0; index < s.length(); index++) {
            sbX.setLength(0); // 초기화
            nextSbX.setLength(0); // 초기화

            String str = s.substring(index, index + 1);
            sbX.append(str);

            while(true) {
                if (index + 2 > s.length()) { //마지막 문자까지 진행됐을 경우 바로 종료
                    index++;
                    break;
                }

                String nextStr = s.substring(index + 1, index + 2);

                if (str.equals(nextStr)) sbX.append(nextStr);
                else nextSbX.append(nextStr);

                if(sbX.length() == nextSbX.length() || (index + 2) >= s.length()) {
                    index++;
                    break;
                }

                index++;
            }

            reuslt++;
        }

        System.out.println(reuslt);
    }
}
