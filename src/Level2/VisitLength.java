package Level2;

import java.util.Arrays;

public class VisitLength {
    private static int[][] firstVisit = new int[11][11];
    public static void main(String[] args) {
        /*
            방문 길이
            문제 설명
            게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

            U: 위쪽으로 한 칸 가기
            D: 아래쪽으로 한 칸 가기
            R: 오른쪽으로 한 칸 가기
            L: 왼쪽으로 한 칸 가기

            캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다.
            좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
            <사진>

            예를 들어, "ULURRDLLU"로 명령했다면

            <사진>

            1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.
            <사진>

            8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.
            <사진>

            이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다.
            예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
            (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)

            단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.

            예를 들어, "LULLLLLLU"로 명령했다면

            <사진>

            1번 명령어부터 6번 명령어대로 움직인 후, 7, 8번 명령어는 무시합니다. 다시 9번 명령어대로 움직입니다.
            <사진>

            이때 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
            명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.

            제한사항
            dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
            dirs의 길이는 500 이하의 자연수입니다.

            입출력 예
                dirs	answer
            "ULURRDLLU"	  7
            "LULLLLLLU"	  7

            입출력 예 설명
            입출력 예 #1
            문제의 예시와 같습니다.

            입출력 예 #2
            문제의 예시와 같습니다.
         */

        /* TC 1 result : 7 */
        String dirs = "ULURRDLLU";

        /* TC 2 result : 7 */
        //String dirs = "LULLLLLLU";

        class Location {
            private int x; // x 좌표
            private int y; // y 좌표

            Location(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX () {
                return x;
            }

            public int getY () {
                return y;
            }

            public void setX (int x) {
                this.x = x;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int maxX() {
                return 5;
            }

            public int minX() {
                return -5;
            }

            public int maxY() {
                return 5;
            }

            public int minY() {
                return -5;
            }

        }


        //x일떄, y일때 반대로 줘야함 출력하고 확인해보기!
        Location location = new Location(0, 0);

        int answer = 0;
        char[] chars = dirs.toCharArray();

        for (char c : chars) {
            int nowX = location.getX();
            int nowY = location.getY();
            System.out.println(c);
            switch (c) {
                case 'U' :
                    if (nowY + 1 > location.maxY()) break;
                    if (validationY(nowY, nowY + 1, nowX)) answer++;
                    location.setY(nowY + 1);
                    break;

                case 'D' :
                    if (nowY - 1 < location.minY()) break;
                    if (validationY(nowY, nowY - 1, nowX)) answer++;
                    location.setY(nowY - 1);
                    break;

                case 'L' :
                    if (nowX - 1 < location.minX()) break;
                    if (validationX(nowX, nowX - 1, nowY)) answer++;
                    location.setX(nowX - 1);
                    break;

                case 'R' :
                    if (nowX + 1 > location.maxX()) break;
                    if (validationX(nowX, nowX + 1, nowY)) answer++;
                    location.setX(nowX + 1);
                    break;
            }

            for (int i = 0; i < firstVisit.length; i++) {
                for (int j = 0; j < firstVisit[0].length; j++) {
                    System.out.print(firstVisit[i][j] + ", ");
                }
                System.out.println();
            }

            System.out.println(answer);
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }

        System.out.println(answer);

    }
    public static boolean validationX (int nowX, int nextX, int nowY) {
        System.out.println("validationX : " + (nowX+5) + ", " + (nextX + 5) + ", " + (nowY + 5));
        if (firstVisit[nowX + 5][nowY + 5] == 1 && firstVisit[nextX + 5][nowY + 5] == 1) {
            System.out.println(firstVisit[nowX + 5][nowY + 5] + ", " + firstVisit[nextX + 5][nowY + 5]);
            System.out.println("##############################################");
            return false;
        }
        else {
            firstVisit[nowX + 5][nowY + 5] = 1;
            firstVisit[nextX + 5][nowY + 5] = 1;
        }
        return true;
    }
    public static boolean validationY (int nowY, int nextY, int nowX) {
        System.out.println("validationY : " + (nowY+5) + ", " + (nextY + 5) + ", " + (nowX + 5));
        if (firstVisit[nowX + 5][nowY + 5] == 1 && firstVisit[nowX + 5][nextY + 5] == 1) {
            System.out.println(firstVisit[nowX + 5][nowY + 5] + ", " + firstVisit[nowX + 5][nextY + 5]);
            System.out.println("##############################################");
            return false;
        }
        else {
            firstVisit[nowX + 5][nowY + 5] = 1;
            firstVisit[nowX + 5][nextY + 5] = 1;
        }
        return true;
    }
}
