package Level2;

public class IntegerPairsBetweenTwoCircles {
    public static void main(String[] args) {
        /*
            두 원 사이의 정수 쌍

            문제 설명

            x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다.
            반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때,
            두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.

            ※ 각 원 위의 점도 포함하여 셉니다.

            제한 사항
            1 ≤ r1 < r2 ≤ 1,000,000

            입출력 예
            r1	r2	result
            2	3	  20

            입출력 예 설명
            입출력 예 설명.png

            그림과 같이 정수 쌍으로 이루어진 점은 총 20개 입니다.
         */

        /* TC 1 result : 20 */
        //int r1 = 2;
        //int r2 = 3;

        /* TC 2 result : 40 */
        //int r1 = 2;
        //int r2 = 4;

        /* TC 3 result : 1008 */
        //int r1 = 9;
        //int r2 = 20;

        /* TC 4 result : 952 */
        //int r1 = 10;
        //int r2 = 20;

        /* TC 5 result : 6281440 */
        int r1 = 999999;
        int r2 = 1000000;

        /* 문제에서 공식 찾기
          1. 1사분면을 기준으로 x축과 y축이 정수인 점의 개수를 구한다.
             => 반지름을 알고 있으므로 피타고라스의 정리(r^2 = x^2 + y^2)를 활용하여 x축을 기준으로 y축의 최대 값(정수)를 구한다.
          2. 4사분면만큼의 개수를 구해야 하므로, 1번의 개수를 구한뒤 곱하기 4를 한다.
        */

        long answer = 0;
        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);
        long side = 0;

        for(long i=0;i<=r2;i++){
            long y2 = (long)Math.sqrt(r2x-(long)Math.pow(i,2));
            long y1 = (long)Math.sqrt(r1x-(long)Math.pow(i,2));

            if(Math.sqrt((r1x-Math.pow(i,2)))%1==0){
                side++;
            }

            answer += (y2-y1) * 4;
        }

        answer += side * 4 - 4;

        System.out.println(answer);

    }
}
