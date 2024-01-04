package BackJoon.Silver;

import java.util.Scanner;

/*
    색종이 (실버 5)
    가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
    이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
    예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.

    입력
    첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
    색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
    두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
    색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다

    출력
	첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.

	예제 입력 1
	3
	3 7
	15 7
	5 2

	예제 출력 1
	260

    풀이 : 2차원 배열로 검은색으로 칠해져 있는 부분을 기준으로 개수를 구한다.
 */

public class Confetti_2563 {
    public static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) {
                int answer = 0;
                Scanner scan = new Scanner(System.in);
                int cnt = scan.nextInt(); //nextInt값을 사용할 경우 정수 이후 EnterKey값이 그대로 남아 있어서 nextLine을 사용할 경우 빈값으로 바로 세팅되기떄문에 미리 EnterKey값을 뺴야한다.
                scan.nextLine(); // 이전 nextInt값으로 EnterKey 값이 남아있어서 해당 Enter키값을 빼기 위하여 호출

                for (int i = 0; i < cnt; i++) {
                    String[] arr = scan.nextLine().split(" ");
                    int x = Integer.parseInt(arr[0]);
                    int y = Integer.parseInt(arr[1]);

                    setMap(x, y);
                }

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j]) answer++;
                    }
                }

                System.out.println(answer);
            }

            public static void setMap(int x, int y) {
                for (int i = x; i < x + 10; i++) {
                    for (int j = y; j < y + 10; j++) {
                        map[i][j] = true;
                    }
                }
            }
}
