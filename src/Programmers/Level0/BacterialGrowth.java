package Programmers.Level0;

public class BacterialGrowth {
    public static void main(String[] args) {
        /*
            세균 증식

            문제 설명
            어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
            처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ n ≤ 10
            1 ≤ t ≤ 15

            입출력 예
            n	t	result
            2	10	2048
            7	15	229,376

            입출력 예 설명
            입출력 예 #1
            처음엔 2마리, 1시간 후엔 4마리, 2시간 후엔 8마리, ..., 10시간 후엔 2048마리가 됩니다. 따라서 2048을 return합니다.

            입출력 예 #2
            처음엔 7마리, 1시간 후엔 14마리, 2시간 후엔 28마리, ..., 15시간 후엔 229376마리가 됩니다. 따라서 229,376을 return합니다.
         */

        /* TC 1 result : 2048 */
        int n = 2;
        int t = 10;

        /* TC 2 result : 229376 */
        //int n = 7;
        //int t = 15;

        long answer = n;
        for (int i = 0; i < t; i++) answer *= 2;
        System.out.println(answer);
    }
}
