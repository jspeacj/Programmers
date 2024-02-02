package Programmers.Level2;

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

        int[] answer = new int[2];

        compression(0, 0, arr.length, arr, answer);
        System.out.println(Arrays.toString(answer));
    }

    private static void compression(int row, int col, int length, int[][] arr, int[] answer) {
        if (check(row, col, length, arr)) {
            answer[arr[row][col]]++;
            return;
        }

        length /= 2;

        compression(row, col, length, arr, answer);
        compression(row + length, col, length, arr, answer);
        compression(row, col + length, length, arr, answer);
        compression(row + length, col + length, length, arr, answer);
    }

    private static boolean check(int row, int col, int length, int[][] arr) {
        int val = arr[row][col];

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}
