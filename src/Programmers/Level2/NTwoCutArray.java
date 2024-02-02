package Programmers.Level2;

import java.util.Arrays;

public class NTwoCutArray {
    public static void main(String[] args) {
        /*
            n^2 배열 자르기
            문제 설명
            정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.

            n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
            i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
            1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
            1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
            새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
            정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ n ≤ 10(7)
            0 ≤ left ≤ right < n(2)
            right - left < 105
            입출력 예
            n	    left	right	    result
            3	     2	      5	       [3,2,2,3]
            4	     7	      14	[4,3,3,3,4,4,4,4]
         */

        /*
            n : 1     1


            n : 2     1   2
                      2   2

            n : 3     1   2   3  =>   arr : [1, 2, 3, 2, 2, 3, 3, 3, 3]  : arr[2] ~ arr[5] => [3, 2, 2, 3]
                      2   2   3
                      3   3   3

                      1 2 3 4
            n : 4     2 2 3 4
                      3 3 3 4
                      4 4 4 4

        * */
        
        /*
        *  규칙 :
        *  1. 해당 2차원 배열의 첫번째 시작값은 행의 인덱스 + 1과 같다.
        *  2. left / n : 시작 행의 좌표
        *  3. (left % n : 시작 열의 좌표(0일 경우 값은 n이다.)
        *  4. x의 좌표 / y의 좌표 중 큰 값 +1이 원하는 결과 값이다.
        * */


        /* TC 1  result : [3,2,2,3] */
        //int n = 3;
        //long left = 2;
        //long right = 5;

        /* TC 2  result : [4,3,3,3,4,4,4,4] */
        int n = 4;
        long left = 7;
        long right = 14;

        int[] result = new int[(int)(right - left) + 1];
        //int strRow = (int)(left / n);
        //int strCol = (int)(left % n) == 0 ? n : (int)(left % n);

        for (int index = 0; index < result.length; index++) {
            /* 채점 시 1,2번만 실패 (실패하는 원인을 모르겠음...)
            int value = strRow > strCol ? strRow + 1 : strCol + 1;
            result[index] = value;

            if (strCol + 1 >= n) {
                strRow++;
                strCol = 0;
            } else strCol++;
            */

            int strRow = (int)(left / n + 1);
            int strCol = (int)(left % n + 1);
            result[index] = Math.max(strRow,strCol);
            left++;

        }

        System.out.println(Arrays.toString(result));
    }
}
