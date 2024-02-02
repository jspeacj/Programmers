package Programmers.Level2;

public class FindDecimals {
    public static void main(String[] args) {
        /*
            k진수에서 소수 개수 구하기

            문제 설명
            양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때,
            변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.

            0P0처럼 소수 양쪽에 0이 있는 경우
            P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
            0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
            P처럼 소수 양쪽에 아무것도 없는 경우
            단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.

            예를 들어, 101은 P가 될 수 없습니다.
            예를 들어, 437674을 3진수로 바꾸면 211020101011입니다.
            여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다.
            (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.)
            211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.

            정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때,
            변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            1 ≤ n ≤ 1,000,000
            3 ≤ k ≤ 10

            입출력 예
              n	    k	result
            437674	3	  3
            110011	10	  2

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            110011을 10진수로 바꾸면 110011입니다.
            여기서 찾을 수 있는 조건에 맞는 소수는 11, 11 2개입니다.
            이와 같이, 중복되는 소수를 발견하더라도 모두 따로 세어야 합니다.

         */

        /*
          문제 이해 및 풀이하기
          1. 주어진 정수 값 n을 k진수로 변환한다. (k진수로 변환하는 함수 개발) => ★Integer.toString(n, k)로 형변환 함수가 이미 제공되고 있다.★
          2. 조건에 맞는 소수는 0을 포함하면 안되므로, 0을 기준으로 변환한 값을 배열로 쪼갠다. (split함수 이용하기)
          3. 해당 배열을 반복문을 이용하여 소수인지 아닌지 검토하고, 소수일 경우 리턴할 값 answer의 값을 증가(+)시킨다.
             (소수 검토 함수 개발. 공백이 존재할 수 있어서 trim()함수 이용하기)
         */

        /* TC 1 result : 3 */
        int n = 437674;
        int k = 3;

        /* TC 2 result : 2 */
        //int n = 110011;
        //int k = 10;

        String[] convertArrays = antilogarithmConversion(n, k).split("0"); // 정수 범위 값을 초과하는 경우가 존재하여 문자열로 받는다.
        System.out.println(findDecimal(convertArrays));
    }

    public static String antilogarithmConversion (int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }

        return sb.toString();
    }

    public static int findDecimal (String[] convertArrays) {
        int answer = 0;

        for (String s : convertArrays) {
            long num = s.trim().length() > 0 ? Long.parseLong(s.trim()) : 0;

            if (num == 1 || num == 0) continue;
            for (int index = 2; index <= (int)Math.sqrt(num); index++){
                if (num % index == 0) {
                    answer--;
                    break;
                }
            }

            answer++;
        }

        return answer;
    }
}
