package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TictactoesAlon {
    public static String[] nowBoard = new String[3]; // 현재 진행된 게임판
    public static char nextPlayer = 'O'; // 진행할 순서
    public static Node[] oNodeArr; // 선공(O) 좌표
    public static Node[] xNodeArr; // 후공(X) 좌표
    private static boolean[] ovisit;
    private static boolean[] xvisit;
    private static int answer = 0;
    public static void main(String[] args) {
        /*
            혼자서 하는 틱택토

            문제 설명
            틱택토는 두 사람이 하는 게임으로 처음에 3x3의 빈칸으로 이루어진 게임판에 선공이 "O", 후공이 "X"를 번갈아가면서 빈칸에 표시하는 게임입니다.
            가로, 세로, 대각선으로 3개가 같은 표시가 만들어지면 같은 표시를 만든 사람이 승리하고 게임이 종료되며 9칸이 모두 차서 더 이상 표시를 할 수 없는 경우에는 무승부로 게임이 종료됩니다.

            할 일이 없어 한가한 머쓱이는 두 사람이 하는 게임인 틱택토를 다음과 같이 혼자서 하려고 합니다.

            혼자서 선공과 후공을 둘 다 맡는다.
            틱택토 게임을 시작한 후 "O"와 "X"를 혼자서 번갈아 가면서 표시를 하면서 진행한다.
            틱택토는 단순한 규칙으로 게임이 금방 끝나기에 머쓱이는 한 게임이 종료되면 다시 3x3 빈칸을 그린 뒤 다시 게임을 반복했습니다.
            그렇게 틱택토 수 십 판을 했더니 머쓱이는 게임 도중에 다음과 같이 규칙을 어기는 실수를 했을 수도 있습니다.

            "O"를 표시할 차례인데 "X"를 표시하거나 반대로 "X"를 표시할 차례인데 "O"를 표시한다.
            선공이나 후공이 승리해서 게임이 종료되었음에도 그 게임을 진행한다.
            게임 도중 게임판을 본 어느 순간 머쓱이는 본인이 실수를 했는지 의문이 생겼습니다.
            혼자서 틱택토를 했기에 게임하는 과정을 지켜본 사람이 없어 이를 알 수는 없습니다.
            그러나 게임판만 봤을 때 실제로 틱택토 규칙을 지켜서 진행했을 때 나올 수 있는 상황인지는 판단할 수 있을 것 같고 문제가 없다면 게임을 이어서 하려고 합니다.

            머쓱이가 혼자서 게임을 진행하다 의문이 생긴 틱택토 게임판의 정보를 담고 있는 문자열 배열 board가 매개변수로 주어질 때,
            이 게임판이 규칙을 지켜서 틱택토를 진행했을 때 나올 수 있는 게임 상황이면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.

            제한사항
            board의 길이 = board[i]의 길이 = 3
            board의 원소는 모두 "O", "X", "."으로만 이루어져 있습니다.
            board[i][j]는 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
            "."은 빈칸을, "O"와 "X"는 해당 문자로 칸이 표시되어 있다는 의미입니다.

            입출력 예
                    board	      result
            ["O.X", ".O.", "..X"]	1
            ["OOO", "...", "XXX"]	0
            ["...", ".X.", "..."]	0
            ["...", "...", "..."]	1

            입출력 예 설명
            입출력 예 #1
            예제 1번의 게임판은 다음과 같습니다.
            O.X
            .O.
            ..X
            선공 후공이 번갈아가면서 다음과 같이 놓았을 때 이러한 게임판이 나올 수 있습니다.
            1행 1열 → 1행 3열 → 2행 2열 → 3행 3열
            1행 1열 → 3행 3열 → 2행 2열 → 1행 3열
            2행 2열 → 1행 3열 → 1행 1열 → 3행 3열
            2행 2열 → 3행 3열 → 1행 1열 → 1행 3열
            물론 위와 다르게 머쓱이가 2행 2열에 O, 3행 3열에 X, 1행 3열에 X, 1행 1열에 O 순서로 표시를 해서 실수를 했을 가능성도 있지만
            "실수를 했을 가능성이 있는가"를 묻는 게 아닌 "이 게임판이 규칙을 지켜서 진행한 틱택토에서 나올 수 있는 상황인가"를 묻는 문제라는 것에 유의해주세요.
            따라서 1을 return 합니다.

            입출력 예 #2
            예제 2번의 게임판은 다음과 같습니다.
            OOO
            ...
            XXX
            규칙을 지켜서 진행한 틱택토라면 선공과 후공이 번갈아가면서 각각 1행, 3행 중 두 칸씩에 표시를 한 뒤
            5번째 차례에 선공이 1행에 가로로 3개의 O를 완성했을 때 종료되므로 적어도 머쓱이가 게임이 종료된 후에도 계속 진행하는 실수를 했다는 것을 추론해 볼 수 있고,
            정상적인 틱택토에서는 이러한 상황이 나올 수 없습니다. 따라서 0을 return 합니다.

            입출력 예 #3
            예제 3번은 2행 2열에만 X가 표시가 되어있습니다.
            선공 O 표시가 없이 X만 있으므로 머쓱이가 O를 표시해야 할 때 X를 표시하는 실수를 했다는 것을 추론해 볼 수 있고,
            규칙을 지켜서 진행했을 때는 이러한 상황이 나올 수 없습니다. 따라서 0을 return 합니다.

            입출력 예 #4
            예제 4번은 빈 3x3 게임판입니다. 선공이 아직 빈칸에 표시하기 전에 이러한 상황이 나올 수 있습니다. 따라서 1을 return 합니다.
         */

        /* TC 1 result : 1 */
        String[] board = {"O.X", ".O.", "..X"};

        /* TC 2 result : 0 */
        //String[] board = {"OOO", "...", "XXX"};

        /* TC 3 result : 0 */
        //String[] board = {"...", ".X.", "..."};

        /* TC 4 result : 1 */ 
        //String[] board = {"...", "...", "..."};

        /*
          정상적으로 틱택토를 했을 때 진행가능한 경우의 수가 하나라도 존재할 경우 1 반환,
          경우의 수가 아예 존재하지 않을 경우 0 반환

          체크해야하는 경우(1) :
          1. X(후공)이 O(선공)보다 개수가 많을 경우
          2. O(선공)이 X(후공)보다 개수가 두개 이상 많을 경우
          3. 반복문을 수행해서 해당 좌표에 O(선공) X(후공)이 존재할 경우, 해당 좌표를 기준으로 가로, 세로, 대각선에 같은 표시가 있는 경우(승리조건)을 찾는다.
            (승리조건이 있을 경우 따로 체크해둔다.)
            => 승리 조건이 O(선공)과 X(후공) 둘다 존재할 경우
          4. 이미 승리했는데 계속 진행하는 경우 =>  성공 조건이 두개 이상일 경우
           (단, 아래와 같은 케이스일때 마지막 O(선공)이 넣을 경우 예외가 존재함.
             O  .  O
             X  O  X
             X  O  X

        체크해야하는 경우(2) : (1)케이스에서 특정 테스트 케이스일 떄, 예외 케이스가 존재하여 다른 경우의 방식으로 생각한 방법. (완전 탐색)
            1. O(선공)이 먼저하고, 그다음에 X(후공)이 먼저해야하기 떄문에, 순서 여부를 위해 char 타입 nextPlayer을 선언한다. (O, X)
            2. 게임판에서 O(선공)과 X(후공)으로 되어 있는 좌표를 선언해둔 클래스 Node에 담아둔뒤 각 배열에 저장한다. (OArray, XArray)
            3. 너비 우선 탐색 기법(BFS) 및 boolean타입 배열 visit과 순서 nextPlayer를 이용하여 모든 경우의 수를 구한다.
            4. 정상적인 틱택토 순서로 진행된 경우의 수가 하나라도 존재할 경우 완전 탐색 기법을 종료하고 1을 반환한다. (마지막까지 존재하지 않을 경우 0을 반환한다.)
         */

        for (String str : board) {
            for (char c : str.toCharArray()) {
                System.out.print(" " + c + " ");
            }
            System.out.println();
        }

        setList(board);

        for (int i = 0; i < board.length; i++) {
            if (answer == 1) break;
            Arrays.fill(nowBoard, "...");
            nextPlayer = 'O';
            bfs();
        }
        System.out.println(answer);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void setList(String[] board) {
        List<Node> oList = new ArrayList<>();
        List<Node> xList = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            char[] charArr = board[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == 'O') oList.add(new Node(i, j));
                else if (charArr[j] == 'X') xList.add(new Node(i, j));
            }
        }

        oNodeArr = oList.toArray(new Node[oList.size()]);
        xNodeArr = xList.toArray(new Node[xList.size()]);
        ovisit = new boolean[oNodeArr.length];
        xvisit = new boolean[xNodeArr.length];
    }

    public static void bfs() {
        if (answer == 1) return;
        if (checkFinish()) {
            answer = 1;
            return;
        }

        if (nextPlayer == 'O') {
            for (int i = 0; i < oNodeArr.length; i++) {
                if (ovisit[i]) continue;

                Node node = oNodeArr[i];
                String str = "";
                for (int k = 0; k < 3; k++) {
                    if (k == node.y) str += "O";
                    else str += str.charAt(k);
                }

                nowBoard[node.x] = str;

                checkWin();
                ovisit[i] = true;
                nextPlayer = 'X';
                bfs();
                ovisit[i] = false;
                nextPlayer = 'O';
            }
        } else {
            for (int i = 0; i < xNodeArr.length; i++) {
                if (xvisit[i]) continue;

                checkWin();
                xvisit[i] = true;
                nextPlayer = 'O';
                bfs();
                xvisit[i] = false;
                nextPlayer = 'X';
            }
        }
    }

    public static boolean checkFinish() {
        for (int i = 0; i < ovisit.length; i++) {
            if (!ovisit[i]) return false;
        }

        for (int j = 0; j < ovisit.length; j++) {
            if (!xvisit[j]) return false;
        }

        return true;
    }

    public static boolean checkWin() {
        for (int i = 0; i < nowBoard.length; i++) {
            char[] charArr = nowBoard[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {

            }
        }

        return true;
    }
}
