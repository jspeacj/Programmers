package Programmers.Level2;

import java.util.HashMap;
import java.util.Map;

public class NQueen {
    public static int answer = 0;
    public static int batchIndex = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        /*
            N-Queen

            문제 설명

            가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.
            예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.

            Imgur
            Imgur

            체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때,
            n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.

            제한사항
            퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
            n은 12이하의 자연수 입니다.

            입출력 예
            n	result
            4	  2

            입출력 예 설명
            입출력 예 #1
            문제의 예시와 같습니다.
         */

        /* TC 1 result : 2 */
        int n = 4;

        /*
          문제 이해하기
          1. 각 행과 열에는 하나의 퀸만 존재 할 수 있다.
          2. 즉 이전 행에서 정해진 좌표의 해당 열은 다른 행에서 Q를 배치하지 못한다.
          3. 맵을 이용하여 대각선 관련 조건을 해결한다.
          => Key : 배치한 Q의 열 인덱스, Value : 배치한 Q의 행 인덱스
          => key의 열인덱스 값을 기준으로 양옆에 value 만큼 떨어진 좌표는 배치가 불가능하다.
            (0보다 작거나 배열 행의 범위를 벗어나지 않도록 방어 로직 추가해야함)
          4. 배열과 재귀함수를 적절히 이용하여 문제를 풀이한다.

          알고리즘 구현 순서
          1. 배치된 큐의 인덱스 위치를 키 값으로한 맵과 행을 나타내는 배열을 선언한다.
          2. 깊이우선탐색기법을 이용한 재귀함수 dfs를 구현한다.
          3. 결과 값 answer를 반환한다.
        */

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            if (arr.length == 1) {
                answer++;
                break;
            }
            batchIndex = 0;
            map.clear();
            map.put(i, batchIndex++);
            dfs(map, n);
        }

        System.out.println(answer);
    }

    private static void dfs(Map<Integer, Integer> map, int n) {
        char[] arr = settingArr(map, n);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') continue;

            map.put(i, batchIndex++);
            if (batchIndex == arr.length) answer++;
            else dfs(map, n);

            map.remove(i);
            batchIndex--;
        }
    }

    private static char[] settingArr(Map<Integer, Integer> map, int n) {
        sb.setLength(0);
        int[] arr = new int[n];
        for (int num : map.keySet()) {
            int edge = batchIndex - map.get(num);
            arr[num] = 1;
            if (num - edge > -1) arr[num - edge] = 1;
            if (num + edge < n) arr[num + edge] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString().toCharArray();
    }
}
