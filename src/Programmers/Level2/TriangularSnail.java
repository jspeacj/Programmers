package Programmers.Level2;

import java.util.Arrays;

public class TriangularSnail {
    public static void main(String[] args) {
        /*
            삼각 달팽이

            문제 설명
            정수 n이 매개변수로 주어집니다.
            다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
            첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

            examples.png

            제한사항
            n은 1 이상 1,000 이하입니다.

            입출력 예
            n	result
            4	[1,2,9,3,10,8,4,5,6,7]
            5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
            6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            문제 예시와 같습니다.

            입출력 예 #3
            문제 예시와 같습니다.

            입출력 예
            n	result
            1   [1]
            2   [1,2]
            3   [1,2,3]
            4	[1,2, 9,3,10, 8,[4,5,6,7]]
            5	[1,2,12,3,13,11,4,14,15,10,[5,6,7,8,9]]
            6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,[6,7,8,9,10,11]]

            - 규칙 -
            1.result에서 n값이 나온 경우는 result의 부족한 자리수 만큼 순서대로 나열된다.
            2.result의 길이는 1부터 n까지의 합이다.
         */

        /* TC 1 result : [1,2,9,3,10,8,4,5,6,7]*/
        //int n = 4;

        /* TC 2 result : [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]*/
        //int n = 5;

        /* TC 3 result : [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]*/
        int n = 6;

        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        int[] answer = new int[sum];
        int index = 0;
        int[][] SnailArrays = new int[n][n];
        setSnailStepOne(0, 0, 1, sum+1, SnailArrays);

        for (int i = 0; i < SnailArrays.length; i++) {
            for (int j = 0; j < SnailArrays[0].length; j++) {
                if (SnailArrays[i][j] == 0) break;
                answer[index++] = SnailArrays[i][j];
            }
        }

        System.out.println(Arrays.toString(answer));
    }

    private static void setSnailStepOne(int row, int col, int num, int max, int[][] SnailArrays) {
        int nextRow = SnailArrays.length - 1;
        for (int i = row; i < SnailArrays.length; i++) {
            if (num >= max) break;
            if (SnailArrays[i][col] != 0) {
                nextRow = i - 1;
                break;
            }
            SnailArrays[i][col] = num++;
        }

        if (max > num) setSnailStepTwo(nextRow, col + 1, num, max, SnailArrays);
    }

    private static void setSnailStepTwo(int row, int col, int num, int max, int[][] SnailArrays) {
        int nextCol = SnailArrays[0].length - 1;
        for (int j = col; j < SnailArrays[0].length; j++) {
            if (num >= max) break;
            if (SnailArrays[row][j] != 0) {
                nextCol = j - 1;
                break;
            }
            SnailArrays[row][j] = num++;
        }

        if (max > num) setSnailStepThree(row, nextCol, num, max, SnailArrays);
    }

    private static void setSnailStepThree(int row, int col, int num, int max, int[][] SnailArrays) {
        while (row > 1) {
            row--;
            col--;
            if (num >= max) break;
            if (SnailArrays[row][col] != 0) {
                row++;
                col++;
                break;
            }

            SnailArrays[row][col] = num++;
        }

        if (max > num) setSnailStepOne(row + 1, col, num, max ,SnailArrays);
    }
}
