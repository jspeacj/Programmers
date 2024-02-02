package Programmers.Level2;

public class MagicElevator {
    private static int answer = 0;
    public static void main(String[] args) {
        /*
            마법의 엘리베이터

            문제 설명

            마법의 세계에 사는 민수는 아주 높은 탑에 살고 있습니다.
            탑이 너무 높아서 걸어 다니기 힘든 민수는 마법의 엘리베이터를 만들었습니다.
            마법의 엘리베이터의 버튼은 특별합니다.
            마법의 엘리베이터에는 -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10(c) (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼이 있습니다.
            마법의 엘리베이터의 버튼을 누르면 현재 층 수에 버튼에 적혀 있는 값을 더한 층으로 이동하게 됩니다.
            단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않습니다.
            민수의 세계에서는 0층이 가장 아래층이며 엘리베이터는 현재 민수가 있는 층에 있습니다.

            마법의 엘리베이터를 움직이기 위해서 버튼 한 번당 마법의 돌 한 개를 사용하게 됩니다.
            예를 들어, 16층에 있는 민수가 0층으로 가려면 -1이 적힌 버튼을 6번, -10이 적힌 버튼을 1번 눌러 마법의 돌 7개를 소모하여 0층으로 갈 수 있습니다.
            하지만, +1이 적힌 버튼을 4번, -10이 적힌 버튼 2번을 누르면 마법의 돌 6개를 소모하여 0층으로 갈 수 있습니다.

            마법의 돌을 아끼기 위해 민수는 항상 최소한의 버튼을 눌러서 이동하려고 합니다.
            민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수를 알고 싶습니다.
            민수와 마법의 엘리베이터가 있는 층을 나타내는 정수 storey 가 주어졌을 때,
            0층으로 가기 위해 필요한 마법의 돌의 최소값을 return 하도록 solution 함수를 완성하세요.

            제한사항
            1 ≤ storey ≤ 100,000,000

            입출력 예
            storey	result
             16	      6
             2554	  16

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            -1, +100이 적힌 버튼을 4번, +10이 적힌 버튼을 5번, -1000이 적힌 버튼을 3번 누르면 0층에 도착 할 수 있습니다. 그러므로 16을 return 합니다.
         */

        /* TC 1 result : 6 */
        //int storey = 16;

        /* TC 2 result : 16 */
        //int storey = 2554;

        /* TC 3 result : 8 */
        int storey = 678;

        /*
          | 16 - 10 * 2 | = 4
          | 16 - 10 * 1 | = 6

          | 2554 - 1000 * 3 | = 446
          | 2554 - 1000 * 2 | = 554

          규칙 :
           1. 1의자리부터 작은건 뺴고, 큰건 더한다.
           2. 이떄, 5일 경우, 다음 숫자의 값이 4보다 작거나 같을 경우 뺴고, 4보다 클 경우 더한다.
           3. index의 값이 주어진 input값 storey 자리수와 동일할 경우 아래 규칙을 따른다.
              (1) 5보다 작을 경우 : 해당 첫번째 자리 값을 더한 뒤 종료한다.
              (2) 5보다 클 경우 : (10 - 해당 첫번째 자리 값) + 1(첫번째자리를 더해서 자리수가 늘어남에따라 1개 추가)
        * */

        dp(storey, 1);
        System.out.println(answer);
    }

    private static void dp(long storey, int index) {
        String str = String.valueOf(storey);
        int subNum = Integer.parseInt(str.substring(str.length() - index, str.length() - index + 1));

        if (str.length() == index) {
            if (subNum > 5) answer += (10 - subNum) + 1;
            else answer += subNum;
            return;
        }

        if (subNum <= 4) {
            answer += subNum;
        } else if (subNum > 5) {
            answer += (10 - subNum);
            storey += Math.pow(10, index);
        } else {
                answer += subNum;
                int nextNum = Integer.parseInt(str.substring(str.length() - index - 1, str.length() - index));
                if (nextNum > 4) storey += Math.pow(10, index);
        }

        dp(storey, ++index);
    }
}
