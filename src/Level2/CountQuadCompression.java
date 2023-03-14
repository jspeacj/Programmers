package Level2;

import java.util.Arrays;

public class CountQuadCompression {
    public static final int setNum = -1;
    public static void main(String[] args) {
        /*
            쿼드압축 후 개수 세기

            문제 설명
            0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다.
            당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.

            1.당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
            2.만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
            3.그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
            arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

            제한사항
            arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭 제곱수 형태를 하고 있습니다. 즉, arr의 행의 개수는 1, 2, 4, 8, ..., 1024 중 하나입니다.
            arr의 각 행의 길이는 arr의 행의 개수와 같습니다. 즉, arr은 정사각형 배열입니다.
            arr의 각 행에 있는 모든 값은 0 또는 1 입니다.

            입출력 예
                                                                        arr	                                                                                     result
                                                            [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	                                                        [4,9]
            [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]

            입출력 예 설명
            입출력 예 #1
            다음 그림은 주어진 arr을 압축하는 과정을 나타낸 것입니다.

            ex1.png

            최종 압축 결과에 0이 4개, 1이 9개 있으므로, [4,9]를 return 해야 합니다.

            입출력 예 #2
            다음 그림은 주어진 arr을 압축하는 과정을 나타낸 것입니다.

            ex2.png

            최종 압축 결과에 0이 10개, 1이 15개 있으므로, [10,15]를 return 해야 합니다.
         */

        /*
           - 문제 정리 -
           1. 행의 개수는 2의 제곱근 (1, 2, 4, 8, ..., 1024)로 이루어져 있다.
           2. 주어진 2차원 배열은 정사각형으로 이루어져 있다.

           - 구현에 앞서 이해하기 -
           1. 행의 개수가 2의 제곱근으므로 1를 제외한 행의 개수는 반으로 쪼개더라도 항상 짝수의 형태이다.
           2. 영역S에서 하나라도 다른 값이 존재 할 경우 해당 영역은 압축이 불가능하다.
           3. 특정 영역S가 압축됐을 경우, 해당 영역의 값을 반환 배열 값 answer 적용한다.
           4. 해당 영역의 인덱스 값들을 -1로 변경한다.
           (이후 -1인 인덱스 값들이 존재할 경우 해당 영역은 로직을 수행하지 않고 넘어간다.)
        * */

        /* TC 1 answer : [4, 9] */
        //int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        /* TC 2 answer : [10, 15] */
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }

        int[] answer = new int[2];

        firstCompression(arr, answer);

        if (answer[0] == 0 && answer[1] == 0) quadCompression(arr, answer, 0, arr.length / 2);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }

        /* ★★★최종적으로 -1이 아닌 값들을 더한다음에 반환하면됨!★★★*/
        System.out.println(Arrays.toString(answer));
    }

    private static void firstCompression(int[][] arr, int[] answer) {
        int checkNum = arr[0][0];
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (checkNum != arr[i][j]) {
                    flag = true;
                    break;
                }
                if (flag) break;
            }
        }

        if (!flag) {
            answer[checkNum]++;
            settingArray(arr, 0, arr.length, 0, arr[0].length);
        }
    }

    private static void settingArray(int[][] arr, int rowMin, int rowMax, int colMin, int colMax) {
            for (int i = rowMin; i < rowMax; i++) {
                for (int j = colMin; j < colMax; j++) {
                    arr[i][j] = setNum;
                }
            }
    }

    /*
            - 규칙 -

         max : 가운데 좌표 기준
         max : 2 => (행,열) +1씩 더해짐
         [0,0] => [1,1]
         [0,2] => [1,3]
         [2,0] => [3,1]
         [2,2] => [3,3]

         max : 4 => (행,열) +3씩 더해짐
         [0,0] => [3,3]
         [0,4] => [3,7]
         [4,0] => [7,3]
         [4,4] => [7,7]

         max : 8 => (행,열) + 7씩 더해짐
         [0,0] => [7,7]
         [0,8] => [7,15]

         => 최초 정사각형일 떄를 제외하고 위의 규칙대로 4번 수행
        * */
    private static void quadCompression(int[][] arr, int[] answer, int min, int length) {
        int rowMin = min;
        int rowMax = rowMin + length;
        int colMin = min;
        int colMax = colMin + length;
        compression(arr, answer, rowMin, rowMax, colMin, colMax);

        rowMin = min;
        rowMax = rowMin + length;
        colMin = length;
        colMax = colMin + length;
        compression(arr, answer, rowMin, rowMax, colMin, colMax);

        rowMin = length;
        rowMax = rowMin + length;
        colMin = min;
        colMax = colMin + length;
        compression(arr, answer, rowMin, rowMax, colMin, colMax);

        rowMin = length;
        rowMax = rowMin + length;
        colMin = length;
        colMax = colMin + length;
        compression(arr, answer, rowMin, rowMax, colMin, colMax);

        /*if (length > 2) {
            length /= 2;
            quadCompression(arr, answer, 0, length);
        }*/
    }

    private static void compression(int[][] arr, int[] answer, int rowMin, int rowMax, int colMin, int colMax) {
        // 문제점 : 쪼갠거에서 아래처럼 다시 쪼갤 수있는경우에도 다시 검토해야함!
        /*
             1  1  3  3  3  3  3  3
             0  1  3  3  3  3  3  3
             0  0  3  3  3  3  3  3
             0  1  3  3  3  3  3  3
             3  3  3  3  (0  0)  1  1
             3  3  3  3  (0  0)  0  1
             3  3  3  3  1  0  0  1
             3  3  3  3  1  1  1  1
        * */
        int checkNum = arr[rowMin][colMin];
        boolean flag = false;

        for (int i = rowMin; i < rowMax; i++) {
            for (int j = colMin; j < colMax; j++) {
                if (arr[i][j] == setNum || checkNum == setNum || checkNum != arr[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (!flag) {
            answer[checkNum]++;
            settingArray(arr, rowMin, rowMax, colMin, colMax);
        }

        if ((rowMax - rowMin) >= 4) quadCompression(arr, answer, rowMin,(rowMax - rowMin) / 2);
    }
}
