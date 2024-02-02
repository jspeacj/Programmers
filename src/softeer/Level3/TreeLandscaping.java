package softeer.Level3;

import java.util.Scanner;

public class TreeLandscaping {
    public static int[][] arr;
    public static boolean[][] visited;
    public static void main(String[] args) {
        /*

            남우는 우후죽순으로 자라 있는 나무들을 잘 정리하여 정원을 가꾸려고 합니다. 정원은 n × n 격자 모양으로 이루어져 있으며,
            각 칸에는 하나의 나무가 심어져 있습니다. 상하좌우로 맞닿아 있는 경우를 인접한 경우라고 했을 때,
            남우는 최대 4번 인접해 있는 두 나무를 묶는 것을 진행하려고 합니다. 이때 묶은 나무끼리는 서로 겹쳐서는 안 되며,
            두 나무가 묶였을 때 얻을 수 있는 아름다움은 두 나무의 키의 합과 동일하다고 합니다. 이러한 상황에서 묶인 쌍의 아름다움의 합을 최대로 만들어보려고 합니다.

            예를 들어 n = 4 일 때 다음과 같이 정원 정보가 주어진 경우를 생각해보겠습니다. 각 격자 칸에 적혀있는 숫자는 각 칸에 있는 나무들의 키를 의미합니다.
            이때 다음과 같이 나무들을 묶게 되면 서로 묶은 쌍끼리 겹치지 않되 얻을 수 있는 아름다움의 합이 25(=7+6+7+5)로 최대가 됩니다.
            초기 격자의 상태가 주어졌을 때 최대 4개의 쌍을 겹치지 않게 잘 골라 얻을 수 있는 아름다움의 총 합을 최대로 하는 프로그램을 작성해보세요.
            본 문제의 저작권은 (주)브랜치앤바운드에 있으며, 저작자의 동의 없이 무단 전재/복제/배포를 금지합니다.

            제약조건
            2 ≤ n ≤ 4
            1 ≤ 나무의 키 ≤ 10
            입력형식
            첫 번째 줄에는 격자의 크기를 나타내는 n이 주어집니다.
            두 번째 줄부터는 n개의 줄에 걸쳐 각 행에 해당하는 나무의 키 정보 n개가 공백을 사이에 두고 주어집니다.

            출력형식
            첫 번째 줄에 최대 4개의 쌍을 서로 겹치지 않게 묶어 얻을 수 있는 최대 아름다움의 합을 출력합니다. 꼭 4쌍을 전부 골라도 되지 않음에 유의합니다.

            입력예제1
            4
            2 1 3 3
            5 1 2 1
            2 1 2 3
            5 1 1 1
            출력예제1
            25

            입력예제2
            2
            1 2
            3 4
            출력예제2
            10

            입력예제3
            3
            7 4 5
            7 3 5
            4 6 6
            출력예제3
            44
         */

        /*
            풀이 방법 :
            1. boolean[][] visited 배열을 선언한다.
            2. 상하좌우로 체크했을 떄 가장 값이 큰 좌표를 찾는다.
            3. 선언한 visited 좌표에 true를 넣는다.
            4. 총4번을 반복할때 visited값이 true인 곳은 패스한다.

            ※ 예상 문제점 : 가장 값이 큰 좌표가 n건의 케이스가 존재할 떄, 어떤 좌표를 지정해야할지 고민해야함.
            해결방안 : 속도가 괜찮을지 모르곘으나, 해당 경우의 수가 존재하는 경우 모든 경우의 수를 구하기
            (또는 해당 경우의수가 존재하는 케이스들의 인접한 값이 최대 값이 더 큰 경우를 제외하고 더 작은 경우로 채용)
        */
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        arr = new int[index][index];
        visited = new boolean[index][index];
        int sum = 0;

        // 2차원 기준으로 지정된 나무 키 할당
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            sum += findMaxValue();
        }

        System.out.println(sum);
    }

    public static int findMaxValue() {
        int max = 0;
        int x = 0;
        int y = 0;
        int nearX = 0;
        int nearY = 0;
        int index = arr.length;
        int[] nearArr = new int[3]; //[0] : value, [1] : row, [2] : col

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (visited[i][j]) continue; // 현재 나무가 이미 묶음으로 묶여있을 경우 다음으로 넘어가기

                checkMaxValue(nearArr, i ,j);
                if (nearArr[0] > max) {
                    max = nearArr[0];
                    x = i;
                    y = j;
                    nearX = nearArr[1];
                    nearY = nearArr[2];
                }
            }
        }

        if (max > 0) { // 묶여있는 부분이 존재할 경우, 해당 두 인접한 나무는 더 이상 사용 못하도록 처리
            visited[x][y] = true;
            visited[nearX][nearY] = true;
        }

        System.out.println("최대값 : " + max + " , 현재좌표 [x,y] : [" + x + ","  + y + "], 인접좌표 [x,y] : [" + nearX + ","  + nearY + "]");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        return max;
    }

    public static void checkMaxValue(int[] nearArr, int i, int j) {
        nearArr[0] = 0; // 최대 값
        nearArr[1] = 0; // x 좌표
        nearArr[2] = 0; // y 좌표
        int sum = 0;

        if (i > 0 && !visited[i-1][j]) {
            sum = arr[i][j] + arr[i-1][j];
            if (sum > nearArr[0]) {
                nearArr[0] = sum;
                nearArr[1] = i-1;
                nearArr[2] = j;
            }
        }

        if (i < arr.length - 1 && !visited[i+1][j]) {
            sum = arr[i][j] + arr[i+1][j];
            if (sum > nearArr[0]) {
                nearArr[0] = sum;
                nearArr[1] = i+1;
                nearArr[2] = j;
            }
        }

        if (j > 0 && !visited[i][j-1]) {
            sum = arr[i][j] + arr[i][j-1];
            if (sum > nearArr[0]) {
                nearArr[0] = sum;
                nearArr[1] = i;
                nearArr[2] = j-1;
            }
        }

        if (j < arr.length - 1 && !visited[i][j+1]) {
            sum = arr[i][j] + arr[i][j+1];
            if (sum > nearArr[0]) {
                nearArr[0] = sum;
                nearArr[1] = i;
                nearArr[2] = j+1;
            }
        }
    }
}
