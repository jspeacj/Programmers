package Programmers.Level2;

public class FineSquare {
    public static void main(String[] args) {
        /*
            멀쩡한 사각형

            문제 설명

            가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다.
            종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며,
            모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데,
            누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다.
            그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다.
            새로운 종이를 구할 수 없는 상태이기 때문에,
            이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
            가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

            제한사항
            W, H : 1억 이하의 자연수

            입출력 예
            W	H	result
            8	12	 80

            입출력 예 설명
            입출력 예 #1
            가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다. 원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.
            (0,0), (
            (0,0), (2,2) => 4
            (0,0), (4,4) =>
            (0,0), (8,12) => 16
            (8,12) -> (4,6) -> (2,3)
            (2,3) -> 4
            (5,4) -> 8

            (5,5) => 25-5 =20 -5 => 15
            규칙 :
            1. 행,열이 짝수일 경우 : 해당 행,열을 각각 반으로 나눈 좌표 값을 기준으로 했을 떄 곱하기 2가 된다.
            2. 행,열 모두 홀수이면서 값이 같을 경우 : 해당 사용할수 없게되는 정사각형은 해당 홀수 값이다. (ex. (5,5)일 경우 사용할 수 없는 정사각형의 개수 : 5)
            3. 행,열이 홀수 및 짝수일 경우 : 행 또는 열 값 중 큰 값을 x라고 한다면,  ((x - 2) * 2 + 2) 값이 사용할 수 없는 정사각형의 개수이다.
              (행,열이 각각 홀수 및 짝수이면, 시작점과 종료점을 제외하고 정확하게 꼭지점으로 가는 경우의 수는 없기 떄문에, 항상 두개씩 사용할 수없는 정사각형이 된다.
              따라서 큰 값에서 시작좌표와 종료점을 제외한 값 (-2)을 뺴고, 항상 두개씩 사용할 수 없는 정사각형이므로 2를 곱한 다음, 시작점과 종료점에 각각 한개씩을 더해서 +2를 한다.)
            4. 행,열 모두 홀수이면서 같은 값이 아닌 경우 : 3번 규칙을 수행한 값이 해당 사용할 수 있는 정사각형이 된다.
         */ // (8,3) => (7,3) 12 + 3 -1 = 14

        //(4,6) (2,3) 4,, (1,3) +3,, 7 -1 =6 * 4 = 24
        /* TC 1 result : 80 */
        //int w = 8;
        //int h = 12;

        /* TC 2 result : 80 */
        //int w = 12;
        //int h = 8;

        /* TC 3 result : 2 */
        //int w = 2;
        //int h = 2;

        /* TC 4 result : 0 */
        //int w = 1;
        //int h = 10000;

        /* TC 5 result : 12 */
        //int w = 7;
        //int h = 3;

        /* TC 6 result : 14 */
        //int w = 8;
        //int h = 3;

        /* TC 7 result : 12 */
        //int w = 3;
        //int h = 7;

        /* TC 8 result : 8 */
        int w = 5;
        int h = 3;

        System.out.println(((long)w * h) - ((long)w + h - gcd(w, h)));
    }

    private static long gcd(long w, long h) {
        if (h == 0) return w;
        return gcd(h, w % h);
    }
}
