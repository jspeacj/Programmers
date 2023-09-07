package Level2;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class KakaoFriendsColoringBook {
    private static int numberOfArea;
    private static int maxSizeOfOneArea;
    private static boolean[][] visited; // 방문한 곳은 체크하지 않기 위해 배열 선언
    private static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        /*
            카카오프렌즈 컬러링북

            문제 설명

            카카오 프렌즈 컬러링북
            출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다.
            여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다.
            (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

            그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

            alt text

            위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

            입력 형식
            입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

            1 <= m, n <= 100
            picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
            picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.

            출력 형식
            리턴 타입은 원소가 두 개인 정수 배열이다.
            그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

            예제 입출력
            m	n	                                    picture	                                            answer
            6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
            
            예제에 대한 설명
            예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 
            왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 
            가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.
         */
        
        /* TC 1 answer : [4, 5]*/
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        /*
            TC 1 2차원 배열
            1 1 1 0
            1 2 2 0
            1 0 0 1
            0 0 0 1
            0 0 0 3
            0 0 0 3
        * */

        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited = new boolean[m][n];

        bfs(picture, m, n); // 영역 탐색 수행
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(Arrays.toString(answer));
    }

    public static void bfs(int[][] picture, int m, int n) {
        for (int row = 0; row < picture.length; row++) {
            for (int col = 0; col < picture[row].length; col++) {
                if (picture[row][col] != 0 && !visited[row][col]) {
                    checkArea(picture, row, col); // 영역과 개수를 검토한다.
                }
            }
        }
    }

    public static void checkArea(int[][] picture, int row, int col) {
        numberOfArea++; // 새로운 영역이므로 개수를 하나 증가시킨다.
        int totalCnt = 1; // 해당 영역의 전체 개수를 세기위한 변수 선언 (현재 좌표부터 시작이기 떄문에 1로 선언)
        queue.clear(); // 새로운 영역이므로 기존 내역을 초기화한다.
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            totalCnt += checkPicture(picture, arr[0], arr[1]);
        }

        // 해당 영역의 개수가 더 많기 떄문에 해당 영역의 개수로 맥스 값 교체
        if (totalCnt > maxSizeOfOneArea) maxSizeOfOneArea = totalCnt;
    }

    public static int checkPicture(int[][] picture, int row, int col) {
        int cnt = 0; // 해당 좌표의 상하좌우에서 동일한 영역의 개수를 저장하기 위한 변수
        int num = picture[row][col]; // 해당 그림 숫자가 무엇인지 저장하기위한 변수
        visited[row][col] = true; // 해당 영역은 이미 방문했으므로 이후 재방문하지 않기 위해 true처리

        if (row > 0 && picture[row - 1][col] == num && !visited[row - 1][col]) {
            cnt++;
            queue.add(new int[]{row - 1, col});
            visited[row - 1][col] = true; // 해당 지점은 방문을 완료했으므로, 이후 재방문을 막기 위해 true 처리
        }

        if (row < picture.length - 1 && picture[row + 1][col] == num && !visited[row + 1][col]) {
            cnt++;
            queue.add(new int[]{row + 1, col});
            visited[row + 1][col] = true; // 해당 지점은 방문을 완료했으므로, 이후 재방문을 막기 위해 true 처리
        }

        if (col > 0 && picture[row][col - 1] == num && !visited[row][col - 1]) {
            cnt++;
            queue.add(new int[]{row, col - 1});
            visited[row][col - 1] = true; // 해당 지점은 방문을 완료했으므로, 이후 재방문을 막기 위해 true 처리
        }

        if (col < picture[row].length - 1 && picture[row][col + 1] == num && !visited[row][col + 1]) {
            cnt++;
            queue.add(new int[]{row, col + 1});
            visited[row][col + 1] = true; // 해당 지점은 방문을 완료했으므로, 이후 재방문을 막기 위해 true 처리
        }

        return cnt;
    }
}
