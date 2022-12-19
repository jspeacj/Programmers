package Level2;

public class FibonacciNumbers {
    public static void main(String[] args) {
        /*
            피보나치 수
            문제 설명
            피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

            예를들어
            F(2) = F(0) + F(1) = 0 + 1 = 1
            F(3) = F(1) + F(2) = 1 + 1 = 2
            F(4) = F(2) + F(3) = 1 + 2 = 3
            F(5) = F(3) + F(4) = 2 + 3 = 5
            와 같이 이어집니다.

            2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

            제한 사항
            n은 2 이상 100,000 이하인 자연수입니다.

            입출력 예
            n	return
            3	2
            5	5

            입출력 예 설명
            피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
         */

        int n = 5;

        // F(6) = F(4) + F(5) = 3 + 5 = 8
        // F(7) = F(5) + F(6) = 5 + 8 = 13
        System.out.println(fibonacciFuntion(n));
    }

    /* Case 1 : 일정 수를 넘는 인풋 값이 들어올 경우 시간 초과 발생*/
    /*
    public static int fibonacciFuntion(int n) {
        int sum = 0;

        if (n == 1) return 1;
        if (n == 0) return 0;

        if (n >= 2) sum += fibonacciFuntion(n-1) +fibonacciFuntion(n-2);
        return sum;
    }
    */

    /* Case 2 : F(n) = F(n-2) + F(n+1)이므로 반복문을 이용하여 순차적으로 n까지 값을 구하기 */
    public static int fibonacciFuntion(int n) {
        int num1 = 0; // F(0) 초기 값 세팅 : F(n-2)
        int num2 = 1; // F(1) 초기 값 세팅 : F(n-1)
        int temp; // 값을 담아둘 변수 세팅
        int sum = 0; // 반환할 변수 선언

        for (int i = 2; i <= n; i++) {
            if (i == n) sum = (num1 + num2) % 1234567;
            temp = (num1 + num2) % 1234567; // 값이 int 범위를 벗어나면 안되므로 계산식에서 미리 나머지만 받도록 계산하기
            num1 = num2;
            num2 = temp;
        }

        return sum;
    }
}
