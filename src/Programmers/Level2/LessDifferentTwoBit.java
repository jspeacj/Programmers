package Programmers.Level2;

import java.util.Arrays;

public class LessDifferentTwoBit {
    public static void main(String[] args) {
        /*
            2개 이하로 다른 비트
            문제 설명
            양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.

            x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
            예를 들어, f(2) = 3 입니다.
            다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
            수	비트	다른 비트의 개수
            2	000...0010
            3	000...0011	1
            f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.

            수	    비트	        다른 비트의 개수
            7	000...0111
            8	000...1000	         4
            9	000...1001	         3
            10	000...1010	         3
            11	000...1011	         2
            정수들이 담긴 배열 numbers가 매개변수로 주어집니다.
            numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ numbers의 길이 ≤ 100,000
            0 ≤ numbers의 모든 수 ≤ 1015

            입출력 예
            numbers	result
            [2,7]	[3,11]

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            바로 다음 값이 정답인 경우은 두가지 경우밖에 없다.
            i) 끝이 0일 경우 => 끝의 숫자만 변경되므로 무조건 다음 숫자는 2개이하로 다른 비트 수이다
            ii) 끝이 1이지만 마지막 두번째 값이 0일 경우 => 마지막 두번쨰 값이 0일 경우, 마지막 값이 1이더라도 마지막값과 마지막 두번째값만 변동되므로 2개이하 다른 비트수의 성립한다.

            위의 두 조건에 해당하지 않을 경우 아래 규칙을 따라야한다.
            11(3) => 101(5)
            111(7) => 1011(11)
            1111(15) => 10111(23)

            규칙 : 1. 제일 왼쪽에서 처음으로 1인 숫자가 0이된다.
                  2. 1에서 0이된 숫자 바로 왼쪽에 숫자 1이 추가된다.
                  3. 이후 오른쪽 나머지숫자들은 1이 된다. (기존에도 1이였으므로 그대로 냅두면 된다.)
            ex) 111(7) => 1011(11)

            1011 => 11
            1100(12) => 3개다름
            1101(13) => 2개다름

         */
        /* TC 1 answer : [3, 11] */
        long[] numbers = {2, 7};

        long[] answer = new long[numbers.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            sb.setLength(0);
            sb.append(Long.toBinaryString(numbers[i]));
            if (sb.length() <= 1) { // numbers = {0} , {1}일경우 다음 값이 없으므로 로직 다르게 흐르도록 조건문 추가
                answer[i] = numbers[i] + 1;
                continue;
            }

            boolean check1 = "0".equals(sb.substring(sb.length()-1, sb.length()));
            boolean check2 = "1".equals(sb.substring(sb.length()-1, sb.length())) && "0".equals(sb.substring(sb.length()-2, sb.length() - 1));

            if (check1 || check2) {
                answer[i] = numbers[i] + 1;
                continue;
            } else {
                char[] chars = sb.toString().toCharArray();
                for (int index = chars.length - 1; index >= 0; index--) {
                    if (index == 0) {
                        String str = "10" + sb.substring(index + 1);
                        answer[i] = Long.parseLong(str,2);
                    } else if (chars[index-1] == '0') {
                        String str = sb.substring(0, index-1)+ "10" + sb.substring(index + 1);
                        answer[i] = Long.parseLong(str,2);
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
