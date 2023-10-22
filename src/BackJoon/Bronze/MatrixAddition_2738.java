package BackJoon.Bronze;

import java.util.Scanner;

public class MatrixAddition_2738 {
    public static void main(String[] args) {
        /*
            행렬 덧셈 (브론즈 5)

            시간 제한	메모리 제한	   제출	       정답 	  맞힌 사람	정답 비율
                1 초	128 MB	      60789	      32317	   28367	54.062%

            문제
            N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

            입력
            첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
            이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다.
            N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

            출력
            첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.

            ex)
            3 3
            1 1 1                   4 4 4
            2 2 2                   6 6 6
            0 1 0               =>  5 6 100
            3 3 3
            4 4 4
            5 5 100
         */

        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();

        int[][] arr1 = new int[row][col];
        int[][] arr2 = new int[row][col];

        init(arr1, scan);
        init(arr2, scan);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (j != arr1[i].length - 1) System.out.print(arr1[i][j] + arr2[i][j] + " ");
                else System.out.print(arr1[i][j] + arr2[i][j]);
            }
            System.out.println();
        }
    }

    public static void init(int[][] arr, Scanner scan) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
    }
}
