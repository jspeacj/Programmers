package Level2;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        /*
            행렬의 곱셈
            문제 설명
            2차원 행렬 arr1과 arr2를 입력받아,
            arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

            제한 조건
            행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
            행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
            곱할 수 있는 배열만 주어집니다.

            입출력 예
                      arr1	                            arr2                                    return
            [[1, 4], [3, 2], [4, 1]]	        [[3, 3], [3, 3]]	                [[15, 15], [15, 15], [15, 15]]
            [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
         */

        /*
          1   4      3    3         15     15
          3   2  *   3    3     =>  15     15
          4   1                     15     15
        * */

        /*
            2   3   2       5   4  3            22   22  11
            4   2   4   *   2   4  1    =>      36   28  18
            3   1   4       3   1  1            29   20  14
        * */

        /*
            a1 b1 c1        d1 e1 f1        (a1 * d1) + (b1 * d2) + (c1 * d3), (a1 * e1) + (b1 * e2) + (c1 * e3), (a1 * f1) + (b1 * f2) + (c1 * f3)
            a2 b2 c2    x   d2 e2 f2   =>                                       ...(생략)
            a3 b3 c3        d3 e3 f3                                            ...(생략)

            ※ 규칙
              1.행렬의 곱셈은 해당 행의 행들 * 해당 위치에 있는 열들이다.
              2.arr1의 열의 개수와 arr2의 행의 개수는 동일하다.
              3. arr1에 arr2를 곱한 결과 배열의 행의위치는 arr1의 행의위치와 동일하고, 열의 위치는 arr2의 열의 위치와 동일하다.
        */

        /* TC 1 */
        //int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        //int[][] arr2 = {{3, 3}, {3, 3}};

        /* TC 2 */
        //int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        //int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        /* TC 3 */
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4}, {2, 4}, {3, 1}};

        int[][] answer= new int[arr1.length][arr2[0].length];
        int sum = 0;
        int col = 0;

        for(int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                col = 0;
                sum = 0;
                while (col < arr1[0].length) {
                    sum += (arr1[i][col] * arr2[col][j]);
                    col++;
                }

                answer[i][j] = sum;
            }
        }

        // 실제 코딩테스트에서는 answer를 리턴하면 된다.
        for (int[] a : answer) {
            System.out.println(Arrays.toString(a));
        }
    }
}
