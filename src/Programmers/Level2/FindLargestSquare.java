package Programmers.Level2;

public class FindLargestSquare {
    private static int answer = 0;
    public static void main(String[] args) {
        /*
            가장 큰 정사각형 찾기

            문제 설명
            1와 0로 채워진 표(board)가 있습니다.
            표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
            표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
            (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

            예를 들어
            1	2	3	4
            0	1	1	1
            1	1	1	1
            1	1	1	1
            0	0	1	0

            가 있다면 가장 큰 정사각형은

            1	2	3	4
            0	1	1	1
            1	1	1	1
            1	1	1	1
            0	0	1	0

            가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

            제한사항
            표(board)는 2차원 배열로 주어집니다.
            표(board)의 행(row)의 크기 : 1,000 이하의 자연수
            표(board)의 열(column)의 크기 : 1,000 이하의 자연수
            표(board)의 값은 1또는 0으로만 이루어져 있습니다.

            입출력 예
                            board	                    answer
            [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	  9
            [[0,0,1,1],[1,1,1,1]]	                      4

            입출력 예 설명
            입출력 예 #1
            위의 예시와 같습니다.

            입출력 예 #2
            | 0 | 0 | 1 | 1 |
            | 1 | 1 | 1 | 1 |
            로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.
         */

        /* TC 1 answer : 9 */
        //int[][] board = {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};

        /* TC 2 answer : 4 */
        int[][] board = {{0,0,1,1}, {1,1,1,1}};

        /* Try 1 : 단순 반복문
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int nextRow = i + 1;
                    int nextCol = j + 1;
                    if (answer == 0) answer = 1;
                    while (true) {
                        int num = 0;
                        boolean flag = true;
                        if (nextRow == board.length) break;
                        else if (nextCol == board[0].length) break;

                        if (board[nextRow][nextCol] == 1) {
                            for (int r = i; r <= nextRow; r++) {
                                for (int c = j; c <= nextCol; c++) {
                                    if (board[r][c] != 1) {
                                        flag = false;
                                        break;
                                    } else {
                                        num++;
                                    }
                                }
                            }

                            if (flag && num > answer) answer = num;
                        } else {
                            break;
                        }

                        nextRow++;
                        nextCol++;
                    }
                }
            }
        }
        */

        /* Try 2 : DP => 정사각형이므로 정답 : 0, 1, 4, 9, 16, 25... 규칙 찾기! */
        int[][] dp = new int[1001][1001];

        int row = board.length;
        int col = board[0].length;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (board[i-1][j-1] != 0) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer * answer);
    }
}
