package Programmers.Level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OilDrilling {
    public static int cnt = 0;
    public static Map<Integer,Integer> oilLump = new HashMap<>();
    public static void main(String[] args) {
        /*
            [PCCP 기출문제] 2번 / 석유 시추

            문제 설명
            [본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]

            세로길이가 n 가로길이가 m인 격자 모양의 땅 속에서 석유가 발견되었습니다. 석유는 여러 덩어리로 나누어 묻혀있습니다.
            당신이 시추관을 수직으로 단 하나만 뚫을 수 있을 때, 가장 많은 석유를 뽑을 수 있는 시추관의 위치를 찾으려고 합니다.
            시추관은 열 하나를 관통하는 형태여야 하며, 열과 열 사이에 시추관을 뚫을 수 없습니다.

            석유시추-1.drawio.png

            예를 들어 가로가 8, 세로가 5인 격자 모양의 땅 속에 위 그림처럼 석유가 발견되었다고 가정하겠습니다.
            상, 하, 좌, 우로 연결된 석유는 하나의 덩어리이며, 석유 덩어리의 크기는 덩어리에 포함된 칸의 수입니다.
            그림에서 석유 덩어리의 크기는 왼쪽부터 8, 7, 2입니다.

            석유시추-2.drawio.png

            시추관은 위 그림처럼 설치한 위치 아래로 끝까지 뻗어나갑니다.
            만약 시추관이 석유 덩어리의 일부를 지나면 해당 덩어리에 속한 모든 석유를 뽑을 수 있습니다.
            시추관이 뽑을 수 있는 석유량은 시추관이 지나는 석유 덩어리들의 크기를 모두 합한 값입니다.
            시추관을 설치한 위치에 따라 뽑을 수 있는 석유량은 다음과 같습니다.

            시추관의 위치	획득한 덩어리	총 석유량
                 1	         [8]	    8
                 2	         [8]	    8
                 3	         [8]	    8
                 4	         [7]	    7
                 5	         [7]	    7
                 6	         [7]	    7
                 7	         [7, 2]	    9
                 8	         [2]	    2
            오른쪽 그림처럼 7번 열에 시추관을 설치하면 크기가 7, 2인 덩어리의 석유를 얻어 뽑을 수 있는 석유량이 9로 가장 많습니다.

            석유가 묻힌 땅과 석유 덩어리를 나타내는 2차원 정수 배열 land가 매개변수로 주어집니다. 이때 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량을 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            1 ≤ land의 길이 = 땅의 세로길이 = n ≤ 500
            1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 500
            land[i][j]는 i+1행 j+1열 땅의 정보를 나타냅니다.
            land[i][j]는 0 또는 1입니다.
            land[i][j]가 0이면 빈 땅을, 1이면 석유가 있는 땅을 의미합니다.

            정확성 테스트 케이스 제한사항
            1 ≤ land의 길이 = 땅의 세로길이 = n ≤ 100
            1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 100
            효율성 테스트 케이스 제한사항
            주어진 조건 외 추가 제한사항 없습니다.
            입출력 예
                                                                        land	                                                                            result
            [[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]	              9
            [[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]	  16
            입출력 예 설명
            입출력 예 #1
            문제의 예시와 같습니다.

            입출력 예 #2
            석유시추-3.drawio.png

            시추관을 설치한 위치에 따라 뽑을 수 있는 석유는 다음과 같습니다.

            시추관의 위치	획득한 덩어리	     총 석유량
                  1	        [12]	        12
                  2	        [12]	        12
                  3	        [3, 12]	        15
                  4	        [2, 12]	        14
                  5	        [2, 12]	        14
                  6	        [2, 1, 1, 12]	16
            6번 열에 시추관을 설치하면 크기가 2, 1, 1, 12인 덩어리의 석유를 얻어 뽑을 수 있는 석유량이 16으로 가장 많습니다. 따라서 16을 return 해야 합니다.

            제한시간 안내
            정확성 테스트 : 10초
            효율성 테스트 : 언어별로 작성된 정답 코드의 실행 시간의 적정 배수
         */

        /* TC 1 result : 9 */
        //int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        
        /* TC 2 reuslt : 16*/
        int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};

        /* 문제 풀이 방안 :

        1. 행을 기준으로 반복문 수행(각 행마다 수직으로 시추관을 설치)
        2. 각행의 인덱스를 기준으로(1부터 시작) 설치한 시추관에 포함되어 있는 석유들의 인덱스(행,열)위치 값을 세팅한다.
        (인덱스 값을 기준으로 세팅하면 반복문 수행할 떄마다 배열을 초기화할 필요 X)
        3. 각 시추관에 포함되어 있는 석유의 총 석유량을 각각 구한다.
        (※현재 열의 석유와 다음 열의 석유가 서로 연결되어 있을 수 있기 떄문에 중복의 위험이 있다. 반복문을 수행하는 처음 부분에 해당 행,열 위치의 값이 해당 행 + 1 값일 경우 이미 석유량에 포함되어 있으므로 스킵한다.)
        4. 이전 총 석유량보다 현재 설치한 시추관 위치의 석유량이 더 클 경우 해당 석유량으로 대체한다.
        5. 모든 행에 시추관을 설치했을 떄 최대 석유량을 구한 뒤, 최대 값을 반환한다.
        */

        /* Try 1 정확성 9/9, 효율성 : 2/6 : 73.3 / 100
        각 열을 기준으로 이중 반복문을 이용하여 수행했으나, 효율성 측면에서 실패
        채점을 시작합니다.
        정확성  테스트
        테스트 1 〉	통과 (0.06ms, 72.7MB)
        테스트 2 〉	통과 (0.06ms, 76.8MB)
        테스트 3 〉	통과 (0.04ms, 77.9MB)
        테스트 4 〉	통과 (0.06ms, 73.1MB)
        테스트 5 〉	통과 (0.13ms, 70.2MB)
        테스트 6 〉	통과 (0.76ms, 72MB)
        테스트 7 〉	통과 (0.51ms, 72.1MB)
        테스트 8 〉	통과 (0.41ms, 78.1MB)
        테스트 9 〉	통과 (0.96ms, 81.8MB)
        효율성  테스트
        테스트 1 〉	실패 (시간 초과)
        테스트 2 〉	통과 (83.90ms, 65.5MB)
        테스트 3 〉	통과 (87.33ms, 65.5MB)
        테스트 4 〉	실패 (시간 초과)
        테스트 5 〉	실패 (시간 초과)
        테스트 6 〉	실패 (시간 초과)
        채점 결과
        정확성: 60.0
        효율성: 15.0
        합계: 73.3 / 100.0

        int[][] oilLand = new int[land.length][land[0].length];
        int max = 0; //최대 석유량
        int nowOil; // 현재 행 + 1 값을 가지는 변수 선언
        
        for (int col = 0; col < land[0].length; col++) { // 시추관은 수직(열)을 기준으로 설치가 되기 떄문에 반복문을 열(col) 기준으로 수행
            cnt = 0;
            nowOil = col + 1; // 이전 [행,열]기준으로 석유가 연결되어 있어 이미 포함되어 있는 경우 스킵 처리하기 위해 선언
            for (int row = 0; row < land.length; row++) {
                if (oilLand[row][col] == nowOil) continue; // 이미 이전 행,열와 석유가 연결되어 있어서 포함되어 있기 때문에 스킵

                if (land[row][col] == 1) {
                    settingOil(land, oilLand, nowOil, row, col); // 현재 위치의 오일 및 붙어있는 땅의 석유도 같이 세팅
                }
            }
            max = Math.max(max, cnt); // 이전 최대 석유량과 현재 개수를 비교하여 최대 석유량 설정
        }
        System.out.println(max);
         */

        /* Try 2 정확성 9/9, 효율성 : 6/6 : 100 / 100
         미리 각 오일의 덩어리 별로 Map에다가 담아둔 뒤, 이후 각 열을 기준으로 시추관을 설치할 떄, 오일 덩어리의 총합을 계산한다.

        채점을 시작합니다.
        정확성  테스트
        테스트 1 〉	통과 (0.12ms, 76.4MB)
        테스트 2 〉	통과 (0.22ms, 74.6MB)
        테스트 3 〉	통과 (0.16ms, 72.8MB)
        테스트 4 〉	통과 (0.16ms, 74.1MB)
        테스트 5 〉	통과 (0.14ms, 72.6MB)
        테스트 6 〉	통과 (0.58ms, 80.7MB)
        테스트 7 〉	통과 (1.35ms, 79.9MB)
        테스트 8 〉	통과 (0.45ms, 73.4MB)
        테스트 9 〉	통과 (2.02ms, 74.2MB)
        효율성  테스트
        테스트 1 〉	통과 (15.31ms, 62.2MB)
        테스트 2 〉	통과 (57.42ms, 67.7MB)
        테스트 3 〉	통과 (57.37ms, 67.4MB)
        테스트 4 〉	통과 (17.07ms, 62.6MB)
        테스트 5 〉	통과 (50.79ms, 74.6MB)
        테스트 6 〉	통과 (15.37ms, 62.8MB)
        채점 결과
        정확성: 60.0
        효율성: 40.0
        합계: 100.0 / 100.0
         */
        init(land);
        System.out.println(findMax(land));
    }

    public static void settingOil (int[][] land, int[][] oilLand, int nowOil, int row, int col) {
        if (land[row][col] != 1 || oilLand[row][col] == nowOil) return;

        oilLand[row][col] = nowOil;
        cnt++;
        if (row > 0) settingOil(land, oilLand, nowOil, row - 1, col);
        if (row < land.length - 1) settingOil(land, oilLand, nowOil, row + 1, col);
        if (col > 0) settingOil(land, oilLand, nowOil, row, col - 1);
        if (col < land[row].length - 1) settingOil(land, oilLand, nowOil, row, col + 1);
    }

    public static void init(int[][] land) {
        int lump = 10; // 현재 이차원 정수 배열 land 변수는 0(오일 X) 또는 1(오일 O)로 이루어져 있으므로 키 값을 10부터 시작
        for (int row = 0 ; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (land[row][col] != 1) continue;

                cnt = 0;
                settingOil(land, lump, row ,col);
                oilLump.put(lump, cnt); // 해당 오일 덩어리 개수를 저장
                lump++; // 다음 덩어리 명칭
            }
        }
    }

    public static void settingOil (int[][] land, int lump, int row, int col) {
        if (land[row][col] != 1) return;

        land[row][col] = lump;
        cnt++;
        if (row > 0) settingOil(land, lump, row - 1, col);
        if (row < land.length - 1) settingOil(land, lump, row + 1, col);
        if (col > 0) settingOil(land, lump, row, col - 1);
        if (col < land[row].length - 1) settingOil(land, lump, row, col + 1);
    }

    public static int findMax (int[][] land) {
        int max = 0;
        int sum = 0;
        Set<Integer> oilList = new HashSet<>(); // 중복을 제외한 오일 덩어리 그룹 번호를 저장하기 위한 변수 선언

        for (int col = 0; col < land[0].length; col++) {
            for (int row = 0; row < land.length; row++) {
                if (land[row][col] != 0) oilList.add(land[row][col]);
            }

            for (int num : oilList) sum += oilLump.get(num);
            max = Math.max(max, sum);
            sum = 0;
            oilList.clear(); // 다음 열로 시추관을 설치하기 전에 목록 초기화
        }

        return max;
    }
}