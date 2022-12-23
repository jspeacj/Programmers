package Level2;

import java.util.Arrays;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        /*
            N개의 최소공배수
            문제 설명
            두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
            예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
            n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

            제한 사항
            arr은 길이 1이상, 15이하인 배열입니다.
            arr의 원소는 100 이하인 자연수입니다.
            입출력 예
                arr	     result
            [2,6,8,14]	  168
            [1,2,3]	       6

            ★Tip★ :
            AB의 최대 공약수 * AB의 최소공배수 = A * B
            최대 공약수 구하는 법 : A (큰값), B(작은값)일 떄,
            ①) A % B == 0 일 경우 => B가 최대 공약수이다.
            ②) A % B = C != 0 일경우 =>
            B % C == 0 이 될때까지 반복 수행
         */

        /* TC 1 */
        //int[] arr = {2, 6, 8, 14};

        /* TC 2 */
        //int[] arr = {1,2,3};

        /* TC 3 */
        int[] arr = {12, 32, 45, 67, 72};

        int multiple = arr[0];
        int max = 0, min = 0;

        Arrays.sort(arr);

        if (arr.length > 1) {
            for (int index = 0; index < arr.length - 1; index++) {
                if (index == 0) {
                    max = Math.max(arr[index], arr[index + 1]);
                    min = Math.min(arr[index], arr[index + 1]);
                } else {
                    max = Math.max(multiple, arr[index + 1]);
                    min = Math.min(multiple, arr[index + 1]);
                }

                int r = division(max, min);

                multiple = (max * min) / r;
            }
        }

        System.out.println(multiple);
    }

    public static int division(int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        else return division(b, r);
    }
}
