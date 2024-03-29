package Programmers.Level2;

public class NumbersOfOneTwoFourCountry {
    public static void main(String[] args) {
        /*
            124 나라의 숫자

            문제 설명
            124 나라가 있습니다.
            124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

            124 나라에는 자연수만 존재합니다.
            124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
            예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

            10진법	124 나라	 10진법	  124 나라
            1	       1	  6      	14
            2	       2	  7      	21
            3	       4	  8      	22
            4	       11	  9      	24
            5	       12	  10      	41

            자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            n은 50,000,000이하의 자연수 입니다.

            입출력 예
            n	result
            1	  1
            2	  2
            3	  4
            4	  11
         */

        int n = 4;

        /*

          1, 2, 4, 11, 12, 14, 21, 22, 24, 41, 42 ,44, 111
           1, 2, 7, 1, 2, 7, 1, 2, 17, 1, 2, 67
            n : 10 => 41
            n : 11 => 42
            n : 12 => 44

            n : 13 => 111
            n : 14 => 112
            n : 15 => 114

            n : 16 => 121
            n : 17 => 122
            n : 18 => 124
        * */
        StringBuilder sb = new StringBuilder();

        int remain = 0;
        while (n != 0) {
            remain = n % 3;
            n = n / 3;

            if(remain == 0){
                n = n - 1;
                remain = 4;
            }

            sb.insert(0, remain);
        }

        System.out.println(sb.toString());
    }
}
