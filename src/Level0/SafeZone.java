package Level0;

public class SafeZone {
    private static int DANGEROUS_ZONE = 9;
    public static void main(String[] args) {
        /*
            안전지대

            문제 설명
            다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.

            image.png

            지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
            지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

            제한사항
            board는 n * n 배열입니다.
            1 ≤ n ≤ 100
            지뢰는 1로 표시되어 있습니다.
            board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.

            입출력 예
            board	                                                                                                                    result
            [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	                                      16
            [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	                                      13
            [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	   0

            입출력 예 설명
            입출력 예 #1
            (3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다. 따라서 16을 return합니다.

            입출력 예 #2
            (3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다. 따라서 위험지역을 제외한 칸 수 13을 return합니다.

            입출력 예 #3
            모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return합니다.
         */

        /* TC 1 result  : 16 */
        //int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};

        /* TC 2 result  : 13 */
        //int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};

        /* TC 3 result  : 0 */
        int[][] board = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

        int answer = 0;
        checkLandMine(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) answer++;
            }
        }

        System.out.println(answer);
    }

    private static void checkLandMine(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == DANGEROUS_ZONE) continue;
                else if (board[i][j] == 1) setDangerousZone(board, i, j);
            }
        }
    }

    private static void setDangerousZone(int[][] board, int i, int j) {
        if (i < board.length - 1) {
            if (board[i + 1][j] != 1) board[i + 1][j] = DANGEROUS_ZONE;
        }

        if (i > 0) {
            if (board[i - 1][j] != 1) board[i - 1][j] = DANGEROUS_ZONE;
        }

        if (j < board[0].length - 1) {
            if (board[i][j + 1] != 1) board[i][j + 1] = DANGEROUS_ZONE;
        }

        if (j > 0) {
            if (board[i][j - 1] != 1) board[i][j - 1] = DANGEROUS_ZONE;
        }

        if (i > 0 && j > 0) {
            if (board[i - 1][j - 1] != 1) board[i - 1][j - 1] = DANGEROUS_ZONE;
        }

        if (i > 0 && j < board[0].length - 1) {
            if (board[i - 1][j + 1] != 1) board[i - 1][j + 1] = DANGEROUS_ZONE;
        }

        if (i < board.length - 1 && j > 0) {
            if (board[i + 1][j - 1] != 1) board[i + 1][j - 1] = DANGEROUS_ZONE;
        }

        if (i < board.length - 1 && j < board[0].length - 1) {
            if (board[i + 1][j + 1] != 1) board[i + 1][j + 1] = DANGEROUS_ZONE;
        }
    }
}
