package Level2;

public class Tilling {
    public static void main(String[] args) {
        /*
            3 x n 타일링

            문제 설명
            가로 길이가 2이고 세로의 길이가 1인 직사각형 모양의 타일이 있습니다.
            이 직사각형 타일을 이용하여 세로의 길이가 3이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다.
            타일을 채울 때는 다음과 같이 2가지 방법이 있습니다

            타일을 가로로 배치 하는 경우
            타일을 세로로 배치 하는 경우
            예를들어서 n이 8인 직사각형은 다음과 같이 채울 수 있습니다.

            Imgur

            직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.

            제한사항
            가로의 길이 n은 5,000이하의 자연수 입니다.
            경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

            입출력 예
            n	result
            4	  11

            입출력 예 설명
            입출력 예 #1
            다음과 같이 11가지 방법이 있다.
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
            Imgur
         */

        /* TC 1 result : 11 */
        int n = 4;

        /*
         문제 규칙 찾기 :
         n 값이 홀수일 경우 : 무조건 0이다.
         짝수일 경우 :
         n = 2 : 3
         n = 4 : 11
         n = 6 : 41
         n = 8 : 153
         f(n)=3f(n-2)+2f(n-4)+2*f(n-6)+....+f(2)+2
              = 4f(n-2) - f(n-4)
         ex) f(8) = 4f(6) - f(4)
             = 164 - 11
             = 153
        */

        if (n % 2 == 1) { // 홀수
            System.out.println(0);
        } else { // 짝수
            long[] till = new long[n+1];
            till[2] = 3;
            long sum = 0;

            for (int i = 4; i <= n; i += 2) {
                till[i] = (till[i-2] * 3 + (sum * 2 + 2)) % 1000000007L;
                sum += till[i-2] % 1000000007L;
            }

            System.out.println((int)till[n]);
        }
    }
}
